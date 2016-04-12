package com.importsource.rpc.entity;
/**
 * 注册时用到的服务类
 * @author Hezf
 *
 * @param <T>
 */
public class ServiceInfo<T> {
	private Class<T> interfaceDefine;
	private Class<T> implDefine;

	public Class<T> getInterfaceDefine() {
		return interfaceDefine;
	}

	public void setInterfaceDefine(Class<T> interfaceDefine) {
		this.interfaceDefine = interfaceDefine;
	}

	public Class<T> getImplDefine() {
		return implDefine;
	}

	public void setImplDefine(Class<T> implDefine) {
		this.implDefine = implDefine;
	}
}
