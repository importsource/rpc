package com.importsource.rpc.entity;
/**
 * 注册时用到的服务bean
 * 
 * @author Hezf
 *
 */
@SuppressWarnings("rawtypes")
public class ServiceInfo {
	
	private Class interfaceDefine;
	private Class implDefine;
    /**
     * 得到服务接口定义类
     * @return Class 服务接口定义类
     */
	public Class getInterfaceDefine() {
		return interfaceDefine;
	}
    
	/**
	 * 设置服务接口定义类
	 * @param interfaceDefine 服务接口定义类
	 */
	public void setInterfaceDefine(Class interfaceDefine) {
		this.interfaceDefine = interfaceDefine;
	}

	
	/**
	 * 得到服务实现定义类
	 * @return Class 服务实现定义类
	 */
	public Class getImplDefine() {
		return implDefine;
	}

	/**
	 * 设置服务实现定义类
	 * @param implDefine 服务实现定义类
	 */
	public void setImplDefine(Class implDefine) {
		this.implDefine = implDefine;
	}
}
