package com.importsource.rpc;

import com.importsource.rpc.op.XService;

public class MainClient {
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			//Echo echo = RPC.getProxy(Echo.class, "127.0.0.1", 20382);
			XService xService=RPC.getProxy(XService.class, "127.0.0.1", 20382);
			//System.out.println(echo.echo("hello,hello"));
			System.out.println(xService.getCpu());
		}
		
	}
}
