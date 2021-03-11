package bully;

public interface Peer extends PeerStub {
    Integer getId();

    NetChannel getChannel();
}
