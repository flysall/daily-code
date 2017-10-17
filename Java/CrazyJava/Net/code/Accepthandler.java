package Net;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;

public class AcceptHandler implements CompletionHandler<AsynchronousServerSocketChannel, Object> {
	private AsynchronousServerSocketChannel serverChannel;

	public AcceptHandler(AsynchronousServerSocketChannel sc){
		this.serverChannel = sc;
	}

	ByteBuffer buff = ByteBuffer.allocate(1024);
	@Override
	public void completed(final AsynchronousSocketChannel sc, Object attachment) {
		AIOServer.channelList.add(sc);
		serverChannel.accept();
		sc.read(buff, null, new CompletionHandler<Integer, Object>() 
		{
			@Override
			public void completed(Integer result, Object attachment) {
				buff.flip();
				String content = StandardCharsets.UTF_8.decode(buff).toString();
				for (AsynchronousSocketChannel c : AIOServer.channelList) {
					try {
						c.write(ByteBuffer.wrap(content.getBytes(AIOServer.UTF_8))).get();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				buff.clear();
				sc.read(buff, null, this);
			}

			@Override
			public void failed(Throwable exc, Object attachment) {
				System.out.println("it's failed to read data: " + exc);
				AIOServer.channelList.remove(ssc);
			}
		});		
	}
}
