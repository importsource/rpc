package com.importsource.rpc;

import com.importsource.rpc.op.Echo;
import com.importsource.rpc.op.RemoteEcho;
import com.importsource.rpc.op.XService;
import com.importsource.rpc.op.XServiceImpl;
import com.importsource.rpc.support.Server;

public class Main {
	public static void main(String[] args) {
		Server server = new RPC.RPCServer();
		server.register(Echo.class, RemoteEcho.class);
		server.register(XService.class, XServiceImpl.class);
		server.start();
	}
}
