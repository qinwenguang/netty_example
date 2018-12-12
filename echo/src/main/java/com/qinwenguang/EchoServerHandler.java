package com.qinwenguang;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

class EchoServerHandler extends ChannelInboundHandlerAdapter {

  //有数据读取的时候调用
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    ByteBuf in = (ByteBuf) msg;
    
    System.out.println("Server received: " + in.toString(CharsetUtil.UTF_8));

    ctx.channel().writeAndFlush(in);
  }
  //本次读取完成调用
  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) {
    ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
      .addListener(ChannelFutureListener.CLOSE);
  }
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx,
      Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }

}
