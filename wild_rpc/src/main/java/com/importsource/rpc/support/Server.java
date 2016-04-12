package com.importsource.rpc.support;

import java.util.List;

import com.importsource.rpc.entity.ServiceInfo;
import com.importsource.rpc.protocol.Invocation;

public interface Server {
	public void stop();
	public void start();
	public void register(Class interfaceDefiner,Class impl);
	public <T> void register(List<ServiceInfo<T>> serviceInfos);
	public void call(Invocation invo);
	public boolean isRunning();
	public int getPort();
}
