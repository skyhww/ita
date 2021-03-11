package bully;

import java.util.concurrent.TimeoutException;

public class BullyPeer implements Peer {
    private Integer id;

    public BullyPeer(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public NetChannel getChannel() {
        return null;
    }

    @Override
    public Node.State ping() throws TimeoutException {
        return null;
    }

    @Override
    public boolean halt() throws TimeoutException {
        return false;
    }

    @Override
    public boolean newCoordinator() throws TimeoutException {
        return false;
    }

    @Override
    public boolean ready() throws TimeoutException {
        return false;
    }
}
