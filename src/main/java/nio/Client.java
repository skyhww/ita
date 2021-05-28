package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Client {

    public static void main(String[] args) {

        try {
            SocketChannel socketChannel = SocketChannel.open();
            if (socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999))) {
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);
                byteBuffer.put("nihao".getBytes(StandardCharsets.UTF_8));
                byteBuffer.flip();
                if (!socketChannel.isConnected()) {
                    return;
                }
                while (byteBuffer.hasRemaining()) {

                    System.out.println(socketChannel.write(byteBuffer));
                }
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
