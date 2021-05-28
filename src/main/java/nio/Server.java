package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {

    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(true);
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 9999));

            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
