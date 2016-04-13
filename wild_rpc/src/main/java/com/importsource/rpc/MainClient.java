package com.importsource.rpc;

import com.importsource.rpc.op.XService;

/**
 * rpc客户端启动器
 * 
 * @author Hezf
 *
 */
public class MainClient {
	public static void main(String[] args) {
			XService xService=RPC.getProxy(XService.class, "127.0.0.1", 20382);
			System.out.println(xService.getCpu());
	}
}
