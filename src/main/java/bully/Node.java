package bully;

import java.util.List;

public interface Node {
    Integer getNumber();

    List<PeerHandler> getPeerHandler();

    State getState();

    void start();

    void election();
}
