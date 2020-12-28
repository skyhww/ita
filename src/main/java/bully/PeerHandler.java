package bully;

import java.util.concurrent.TimeoutException;

public interface PeerHandler {
    boolean halt() throws TimeoutException;

    State getState() throws TimeoutException;

    Integer getId();

    void ping();

    boolean newCoordinator() throws TimeoutException;

    boolean ready() throws TimeoutException;
}
