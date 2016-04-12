package com.importsource.rpc;

import java.util.ArrayList;
import java.util.List;

import com.importsource.rpc.entity.ServiceInfo;
import com.importsource.rpc.op.Echo;
import com.importsource.rpc.op.RemoteEcho;
import com.importsource.rpc.op.XService;
import com.importsource.rpc.op.XServiceImpl;
import com.importsource.rpc.support.Server;

public class BatchMain {
	public static void main(String[] args) {
		Server server = new RPC.RPCServer();
		List<ServiceInfo> serviceInfos=new ArrayList<ServiceInfo>();
		ServiceInfo echo=new ServiceInfo();
		echo.setInterfaceDefine(Echo.class);
		echo.setImplDefine(RemoteEcho.class);
		ServiceInfo xService=new ServiceInfo();
		xService.setInterfaceDefine(XService.class);
		xService.setImplDefine(XServiceImpl.class);
		
		serviceInfos.add(echo);
		serviceInfos.add(xService);
		
		server.register(serviceInfos);
		
		server.start();
	}
}
