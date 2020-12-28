package bully;

public class PeerNode {
    private Integer port;
    private String ip;
    private Integer id;

    public PeerNode(Integer port, String ip, Integer id) {
        this.port = port;
        this.ip = ip;
        this.id = id;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
