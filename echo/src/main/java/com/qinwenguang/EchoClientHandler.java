package com.qinwenguang;

import java.io.UnsupportedEncodingException;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

@Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws UnsupportedEncodingException {
    ByteBuf buff = Unpooled.buffer();
    buff.writeBytes("Netty rocks!".getBytes("UTF-8"));
    ctx.writeAndFlush(buff);
  }
  
  @Override
  public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
    System.out.println( "Client received: " + in.toString(CharsetUtil.UTF_8));
  }
  
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx,
      Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }
}
