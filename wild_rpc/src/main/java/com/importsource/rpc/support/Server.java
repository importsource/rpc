package com.importsource.rpc.support;

import java.util.List;

import com.importsource.rpc.entity.ServiceInfo;
import com.importsource.rpc.protocol.Invocation;

/**
 * 服务端接口
 * @author Hezf
 *
 */
public interface Server {
	/**
	 * 停止
	 */
	public void stop();
	/**
	 * 开启
	 */
	public void start();
	/**
	 * 注册服务（单个）
	 * @param interfaceDefiner 接口定义
	 * @param impl 实现定义
	 */
	public void register(Class interfaceDefiner,Class impl);
	/**
	 * 注册服务（多个）
	 * @param serviceInfos 服务列表
	 */
	public void register(List<ServiceInfo> serviceInfos);
	/**
	 * 回调
	 * @param invo
	 */
	public void call(Invocation invo);
	/**
	 * 是否在运行
	 * @return boolean 是否在运行
	 */
	public boolean isRunning();
	
	/**
	 * 得到端口
	 * @return int 端口
	 */
	public int getPort();
    /**
     * 设置端口
     * @param port 端口
     */
	public void setPort(int port);
}
