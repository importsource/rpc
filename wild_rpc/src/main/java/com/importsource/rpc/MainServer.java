package com.importsource.rpc;

import java.util.List;

import com.importsource.rpc.entity.ServiceInfo;
import com.importsource.rpc.register.DefaultScannerUtil;
import com.importsource.rpc.support.Server;

/**
 * 
 * rpc 服务启动器
 * @author Hezf
 *
 */
public class MainServer {
	public static void main(String[] args) {
		Server server = new RPC.RPCServer();
		List<ServiceInfo> services=DefaultScannerUtil.scan();
		server.register(services);
		server.start();
	}
}
