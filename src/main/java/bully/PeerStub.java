package bully;

import java.util.concurrent.TimeoutException;

/**
 * 对端stub，工作在应用层
 */
public interface PeerStub {

    Node.State ping() throws TimeoutException;

    boolean halt() throws TimeoutException;

    boolean newCoordinator() throws TimeoutException;

    boolean ready() throws TimeoutException;

}
