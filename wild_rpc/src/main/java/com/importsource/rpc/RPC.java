package com.importsource.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.importsource.rpc.common.excpetion.RegisterException;
import com.importsource.rpc.entity.ServiceInfo;
import com.importsource.rpc.protocol.Invocation;
import com.importsource.rpc.support.Client;
import com.importsource.rpc.support.Listener;
import com.importsource.rpc.support.Server;

/**
 * 代理类
 * @author Hezf
 *
 */
public class RPC {
	public static <T> T getProxy(final Class<T> clazz,String host,int port) {
		
		final Client client = new Client(host,port);
		InvocationHandler handler = new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Invocation invo = new Invocation();
				invo.setInterfaces(clazz);
				invo.setMethod(new com.importsource.rpc.protocol.Method(method.getName(),method.getParameterTypes()));
				invo.setParams(args);
				client.invoke(invo);
				return invo.getResult();
			}
		};
		T t = (T) Proxy.newProxyInstance(RPC.class.getClassLoader(), new Class[] {clazz}, handler);
		return t;
	}
	
	
	public static class RPCServer implements Server{
		private int port = 20382;
		private Listener listener; 
		private boolean isRuning = true;
		
		/**
		 * @param isRuning the isRuning to set
		 */
		public void setRuning(boolean isRuning) {
			this.isRuning = isRuning;
		}

		/**
		 * @return the port
		 */
		public int getPort() {
			return port;
		}

		/**
		 * @param port the port to set
		 */
		public void setPort(int port) {
			this.port = port;
		}

		private Map<String ,Object> serviceEngine = new HashMap<String, Object>();
		
		
		public void call(Invocation invo) {
			System.out.println(invo.getClass().getName());
			Object obj = serviceEngine.get(invo.getInterfaces().getName());
			if(obj!=null) {
				try {
					Method m = obj.getClass().getMethod(invo.getMethod().getMethodName(), invo.getMethod().getParams());
					Object result = m.invoke(obj, invo.getParams());
					invo.setResult(result);
				} catch (Throwable th) {
					th.printStackTrace();
				}
			} else {
				throw new IllegalArgumentException("has no these class");
			}
		}

		public void register(Class interfaceDefiner, Class impl) {
			try {
				this.serviceEngine.put(interfaceDefiner.getName(), impl.newInstance());
				System.out.println(serviceEngine);
			} catch (Throwable e) {
				throw new RegisterException(e.getMessage());
			} 
		}
		
		public  void register(List<ServiceInfo> serviceInfos) {
			for(int i=0;i<serviceInfos.size();i++){
				ServiceInfo serviceInfo=serviceInfos.get(i);
				Class interfaceDefiner=serviceInfo.getInterfaceDefine();
				Class implDefine=serviceInfo.getImplDefine();
				try {
					this.serviceEngine.put(interfaceDefiner.getName(), implDefine.newInstance());
					System.out.println(serviceEngine);
				} catch (Throwable e) {
					throw new RegisterException(e.getMessage());
				} 
			}
			
			
		}

		public void start() {
			System.out.println("start server");
			listener = new Listener(this);
			this.isRuning = true;
			listener.start();
		}

		public void stop() {
			this.setRuning(false);
		}

		public boolean isRunning() {
			return isRuning;
		}

		
		
	}
}
	



	
	
	

