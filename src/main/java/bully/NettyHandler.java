package bully;

import java.util.concurrent.TimeoutException;

public class NettyHandler implements PeerHandler {
    private BullyNode bullyNode;

    public NettyHandler(BullyNode bullyNode) {
        this.bullyNode = bullyNode;
    }

    @Override
    public boolean halt() throws TimeoutException {

        return false;
    }

    @Override
    public State getState() throws TimeoutException {
        return null;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void ping() {

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
