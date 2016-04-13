package com.importsource.rpc.register;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.importsource.rpc.common.excpetion.ServiceNotFoundException;
import com.importsource.rpc.entity.ServiceInfo;
/**
 * 默认服务扫描器。通过类型特征来扫描
 * 
 * @author Hezf
 *
 */
public class DefaultServiceScanner implements Scanner {
	
	public static void main(String[] args) {
		DefaultServiceScanner scanner = new DefaultServiceScanner();
		try {
			List<ServiceInfo> services = scanner.scan("com.importsource.yarn.rpc.service");
			for (int i = 0; i < services.size(); i++) {
				ServiceInfo serviceInfo = services.get(i);
				System.out.println(
						"interface:" + serviceInfo.getInterfaceDefine() + ",impl:" + serviceInfo.getImplDefine());
			}
		} catch (ClassNotFoundException e) {
			throw new ServiceNotFoundException();
		}
	}

	public List<ServiceInfo> scan(String pack) throws ClassNotFoundException {
		Set<Class<?>> set = ScannerUtil.getClasses(pack);
		List<ServiceInfo> serviceInfos = new ArrayList<ServiceInfo>();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Class<?> class1 = (Class<?>) iterator.next();
			String className = class1.getName();
			System.out.println(className);
			if (className.endsWith("Impl")) {
				ServiceInfo serviceInfo = new ServiceInfo();
				serviceInfo.setImplDefine(Class.forName(className));
				String interfaceName = className.replace("Impl", "");
				serviceInfo.setInterfaceDefine(Class.forName(interfaceName));
				serviceInfos.add(serviceInfo);
			}
		}
		return serviceInfos;
	}
}
