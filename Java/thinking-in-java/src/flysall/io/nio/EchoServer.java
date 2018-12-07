package flysall.io.nio;

// Not belong to ThinkingInJava
import static net.mindview.util.Print.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.net.*;
import java.util.*;

public class EchoServer {
    public static SelectorLoop connectionBell;
    public static SelectorLoop readBell;
    public boolean isReadBellRunning = false;

    // 启动服务器
    public void startServer() throws IOException {
        connectionBell = new SelectorLoop();
        readBell = new SelectorLoop();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ServerSocket socket = ssc.socket();
        socket.bind(new InetSocketAddress("localhost", 7878));
        ssc.register(connectionBell.getSelector(), SelectionKey.OP_ACCEPT);
        new Thread(connectionBell).start();
    }

    public static void main(String[] args) throws IOException {
        new EchoServer().startServer();
    }

    class SelectorLoop implements Runnable{
        private Selector selector;
        private ByteBuffer temp = ByteBuffer.allocate(1024);

        public SelectorLoop() throws IOException {
            this.selector = Selector.open();
        }

        public Selector getSelector() {
            return selector;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    // 如果没有事件注册，会造成阻塞
                    selector.select();
                    Set<SelectionKey> selectKeys = selector.selectedKeys();
                    Iterator<SelectionKey> it = selectKeys.iterator();
                    // 相当于事件轮询
                    while(it.hasNext()) {
                        SelectionKey key = it.next();
                        it.remove();
                        dispatch(key);
                    }
                } catch(IOException e) {
                    e.printStackTrace();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void dispatch(SelectionKey key) throws IOException, InterruptedException {
            // accept事件
           if(key.isAcceptable()) {
                // 该事件注册在serversocketchannel
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                // 接受一个连接
                SocketChannel sc = ssc.accept();
                // 设置为非阻塞
                sc.configureBlocking(false);
                sc.register(readBell.getSelector(), SelectionKey.OP_READ);
                synchronized(EchoServer.this) {
                    if(!EchoServer.this.isReadBellRunning) {
                        EchoServer.this.isReadBellRunning = true;
                        new Thread(readBell).start();
                    }
                }
            }
            // read 事件
            else if(key.isReadable()) {
                SocketChannel sc = (SocketChannel) key.channel();
                // 将数据写到buffer
                int count = sc.read(temp);
                // 没有从channel读取到字节流
                if(count < 0) {
                    key.cancel();   // 断开连接
                    sc.close();
                    return;
                }
                temp.flip();
                String msg = Charset.forName("UTF-8").decode(temp).toString();
                print("Server received [" + msg + "] from client address:" + sc.getRemoteAddress());
                Thread.sleep(1000);
                // 回显
                sc.write(ByteBuffer.wrap(msg.getBytes(Charset.forName("UTF-8"))));
                temp.clear();
            }
        }
    }
}
