package bully;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.TimeoutException;

/**
 * 信道，网络层代理
 *
 * @author hanweiwei
 */
public interface NetChannel extends Closeable {
    /**
     * 网络地址
     *
     * @return
     */
    InetAddress getAddress();

    /**
     * 端口
     *
     * @return
     */
    Integer getPort();

    /**
     * 发送报文
     *
     * @param pack
     * @return
     * @throws TimeoutException
     */
    Pack send(Pack pack) throws TimeoutException, ClosedChannelException;

    /**
     * 一个节点只会主动
     *
     * @throws IOException
     */
    void connect() throws IOException;

    class Pack {
        //1-byte 版本号
        private Integer version;
        //1-byte 报文类型
        private Integer type;
        //6-byte 数据包长度
        private Integer dataLength;
        //数据包
        private byte[] data;

        public static class PackBuilder {
            private Pack pack;

            public PackBuilder(Integer type) {
                pack = new Pack();
                pack.type = type;
            }

            public PackBuilder version(Integer version) {
                pack.version = version;
                return this;
            }

            public PackBuilder data(byte[] data) {
                pack.data = data;
                return this;
            }

            public Pack build() {
                if (pack.data == null) {
                    pack.dataLength = 0;
                } else {
                    pack.dataLength = pack.data.length;
                }
                if (pack.version == null) {
                    pack.version = 0;
                }
                return pack;
            }
        }
    }
}
