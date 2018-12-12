package com.qinwenguang;

import java.net.InetSocketAddress;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

  private int port;
  
  public EchoServer(int port) {
    super();
    this.port = port;
  }
  
  //程序主要启动流程
  public void start() throws InterruptedException {
    final EchoServerHandler handler = new EchoServerHandler();
    EventLoopGroup group = new NioEventLoopGroup();
    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(group).channel(NioServerSocketChannel.class)
        .localAddress(new InetSocketAddress(port))
        .childHandler(new ChannelInitializer<SocketChannel>() {
          @Override
          public void initChannel(SocketChannel ch) throws Exception {
            //绑定入站事件
            ch.pipeline().addLast(handler);
          }
        });
      ChannelFuture future = b.bind().sync();
      System.out.println("start on port: " + port);
      future.channel().closeFuture().sync();
    } finally {
      group.shutdownGracefully().sync();
    }
  }
  public static void main(String[] args) {
    try {
      new EchoServer(17746).start();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
