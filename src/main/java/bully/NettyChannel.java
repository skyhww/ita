package bully;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.TimeoutException;

public class NettyChannel implements NetChannel {
    
    @Override
    public InetAddress getAddress() {
        return null;
    }

    @Override
    public Integer getPort() {
        return null;
    }

    @Override
    public Pack send(Pack pack) throws TimeoutException, ClosedChannelException {
        return null;
    }

    @Override
    public void connect() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }
}
