package com.importsource.rpc.entity;
/**
 * 注册时用到的服务类
 * @author Hezf
 *
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public class ServiceInfo {
	
	private Class interfaceDefine;
	private Class implDefine;

	public Class getInterfaceDefine() {
		return interfaceDefine;
	}

	public void setInterfaceDefine(Class interfaceDefine) {
		this.interfaceDefine = interfaceDefine;
	}

	public Class getImplDefine() {
		return implDefine;
	}

	public void setImplDefine(Class implDefine) {
		this.implDefine = implDefine;
	}
}
