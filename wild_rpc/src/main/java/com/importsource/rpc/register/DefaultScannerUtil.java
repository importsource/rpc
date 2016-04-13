package com.importsource.rpc.register;

import java.util.List;

import com.importsource.rpc.common.excpetion.ServiceNotFoundException;
import com.importsource.rpc.entity.ServiceInfo;

/**
 * 默认的扫描工具使用类
 * 
 * @author Hezf
 *
 */
public class DefaultScannerUtil {
	//默认包
	private static final String default_pack = "com.importsource.rpc.op";

	/**
	 * 返回默认包下的服务列表
	 * @return List<ServiceInfo> 服务列表
	 */
	public static List<ServiceInfo> scan(){
		Scanner scanner=new DefaultServiceScanner();
		try {
			return scanner.scan(default_pack);
		} catch (ClassNotFoundException e) {
			throw new ServiceNotFoundException(e.getMessage());
		}
	}

}
