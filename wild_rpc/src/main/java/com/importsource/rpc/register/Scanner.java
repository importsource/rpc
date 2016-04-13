package com.importsource.rpc.register;

import java.util.List;

import com.importsource.rpc.entity.ServiceInfo;

/**
 * 扫描接口
 * @author Hezf
 *
 */
public interface Scanner {
    public List<ServiceInfo> scan(String pack) throws ClassNotFoundException;
}
