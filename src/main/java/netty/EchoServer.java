package netty;

import bully.BullyCodec;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.concurrent.locks.LockSupport;

public class EchoServer {
    public static void main(String[] args) {
        ServerBootstrap s = new ServerBootstrap();
        EventLoopGroup workerGroup2 = new NioEventLoopGroup(2);
        s.group(workerGroup2, workerGroup2);
        s.channel(NioServerSocketChannel.class);
        s.childHandler(new ChannelInboundHandlerAdapter() {
            @Override
            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                System.out.println(msg);
            }

            @Override
            public boolean isSharable() {
                return true;
            }
        });
        s.handler(new ChannelInitializer<NioServerSocketChannel>(){

            @Override
            protected void initChannel(NioServerSocketChannel ch) throws Exception {
                ch.pipeline().addFirst(new BullyCodec());
            }
        });
        try {
            s.bind(9999).addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    System.out.println("operationComplete");
                }
            }).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.park();
    }
}
