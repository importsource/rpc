# rpc

一个rpc框架。现在主要用于importsource-yarn上。

## 1、启动rpc server
###（1）单个注册
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

###（2）自动扫描注册
```java
Server server = new RPC.RPCServer();
		List<ServiceInfo> services=DefaultScannerUtil.scan();
		server.register(services);
		server.start();
```

## 2、启动client
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

<hr>

###maven 使用
```xml
<dependency>
   <groupId>com.importsource.rpc</groupId>
   <artifactId>wild_rpc</artifactId>
   <version>0.0.1-SNAPSHOT</version>
</dependency>
```

###建议你写一个这样工具类，为你的具体项目或组件
```java
public class DefaultScannerUtil {
	//默认包
	private static final String default_pack = "com.importsource.rpc.op";

	/**
	 * 返回默认包下的服务列表
	 * @return List<ServiceInfo> 服务列表
	 */
	public static List<ServiceInfo> scan(){
		Scanner scanner=new DefaultServiceScanner();
		try {
			return scanner.scan(default_pack);
		} catch (ClassNotFoundException e) {
			throw new ServiceNotFoundException(e.getMessage());
		}
	}

}
```
