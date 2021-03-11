package bully;

import java.util.List;

public interface Node {
    Integer getId();

    /**
     * 选举
     */
    void election();

    State getState();

    List<PeerStub> peerHandlers();

    enum State {
        Down, Reorganization, Normal
    }
}
