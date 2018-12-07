package flysall.io.nio;

import static net.mindview.util.Print.*;
import java.util.*;
import java.nio.channels.*;
import java.nio.*;
import java.nio.charset.*;
import java.io.*;
import java.net.*;

public class Client implements Runnable {
    // 空闲计数器，空闲超过十次，检测server是否中断
    private static int idleCounter = 0;
    private Selector selector;
    private SocketChannel socketChannel;
    private ByteBuffer temp = ByteBuffer.allocate(1024);

    public Client() throws IOException {
        this.selector = Selector.open();

        // 远程连接server
        socketChannel =  SocketChannel.open();
        //
        Boolean isConnected = socketChannel.connect(new InetSocketAddress("localhost", 7878));
        socketChannel.configureBlocking(false);
        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ);
        if(isConnected) {
            sendFirstMsg();
        } else {
            key.interestOps(SelectionKey.OP_CONNECT);
        }
    }

    public void sendFirstMsg() throws IOException {
        String msg = "Hello NIO.";
        socketChannel.write(ByteBuffer.wrap(msg.getBytes(Charset.forName("UTF-8"))));
    }

    @Override
    public void run() {
        while(true) {
            try {
                // 阻塞，等待事件发生或者1秒超时，num为事件数量
                int num = selector.select(1000);
                if(num == 0) {
                    idleCounter++;
                    if(idleCounter > 10) {
                        try {
                           sendFirstMsg();
                        } catch(ClosedChannelException e) {
                            e.printStackTrace();
                            socketChannel.close();
                            return;
                        }
                    }
                    continue;
                } else {
                    idleCounter = 0;
                }
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while(it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    if(key.isConnectable()) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        if(sc.isConnectionPending()) {
                            sc.finishConnect();
                        }
                        sendFirstMsg();
                    }
                    if(key.isReadable()) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        temp = ByteBuffer.allocate(1024);
                        int count = sc.read(temp);
                        if(count < 0) {
                            sc.close();
                            continue;
                        }
                        temp.flip();
                        String msg = Charset.forName("UTF-8").decode(temp).toString();
                        print("Client received [" + msg + "] from server address:" + sc.getRemoteAddress());
                        Thread.sleep(1000);
                        // 回显
                        sc.write(ByteBuffer.wrap(msg.getBytes(Charset.forName("UTF-8"))));
                        temp.clear();
                    }
                }
            } catch(IOException e) {
                e.printStackTrace();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        new Thread(client).start();
    }
}
