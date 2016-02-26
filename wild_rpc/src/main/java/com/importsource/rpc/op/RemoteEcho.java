package com.importsource.rpc.op;

public class RemoteEcho implements Echo{
	public String echo(String echo) {
		return "from remote:"+echo;
	}
}
