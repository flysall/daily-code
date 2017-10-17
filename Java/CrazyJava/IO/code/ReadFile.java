import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
	public static void main(String[] arg) throws IOException {
		try (FileInputStream fis = new FileInputStream("ReadFile.java"); FileChannel fcin = fis.getChannel()) {
			ByteBuffer bbuf = ByteBuffer.allocate(256);
			while (fcin.read(bbuf) != -1) {
				bbuf.flip();
				Charset charset = Charset.forName("GBK");
				CharsetDecoder decoder = charset.newDecoder();
				CharBuffer cbuff = decoder.decode(bbuf);
				System.out.print(cbuff);
				bbuf.clear();
			}
		}
	}
}
