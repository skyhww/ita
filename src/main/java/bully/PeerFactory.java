package bully;

import java.util.List;
import java.util.Properties;

public interface PeerFactory {
    List<Peer> create(Properties properties);
}
