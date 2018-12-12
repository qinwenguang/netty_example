软件版本
  maven 3.5以上
  netty 4.1.0
  JDK   1.8
注: 软件尽量按照这些版本来做


# mvn 直接运行

  1. 编译客户端和服务端
    mvn compile
  
  2. 运行
    服务端:
      mvn exec:java -Dexec.mainClass="com.qinwenguang.EchoServer"
   客户端
      mvn exec:java -Dexec.mainClass="com.qinwenguang.EchoClient"


# 使用eclipse导入运行

  1. eclipse 需要先配置JDK 和 maven 

  2. 导入：

  因为没有.project文件和classpath文件，不能直接使用General的导入项目

  File -> import -> Maven(Existing Maven Projects)
  ![eclipse]{http://60.205.208.120:17755/image/eclipse_import_1.PNG}

  导入后需要下载JAR包,等待一会即可

  3. server和client中有main,直接右键运行即可


注：若最后搞了半天运行不起来，加本人微信13453314174


