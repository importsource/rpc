# rpc

一个rpc框架。现在主要用于importsource-yarn上。

##启动rpc server
###单个注册
```java
public class Main {
	public static void main(String[] args) {
		Server server = new RPC.RPCServer();
		server.register(Echo.class, RemoteEcho.class);
		server.register(XService.class, XServiceImpl.class);
		server.start();
	}
}



```

###自动扫描注册
```java
Server server = new RPC.RPCServer();
		List<ServiceInfo> services=DefaultScannerUtil.scan();
		server.register(services);
		server.start();
```

##启动client
```java
public class MainClient {
	public static void main(String[] args) {
		//for(int i=0;i<100;i++){
			//Echo echo = RPC.getProxy(Echo.class, "127.0.0.1", 20382);
			XService xService=RPC.getProxy(XService.class, "127.0.0.1", 20382);
			//System.out.println(echo.echo("hello,hello"));
			System.out.println(xService.getCpu());
			System.out.println(xService.getMemory());
		//}
		
	}
}

```
