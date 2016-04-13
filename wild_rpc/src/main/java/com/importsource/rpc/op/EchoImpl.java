package com.importsource.rpc.op;

public class EchoImpl implements Echo{
	public String echo(String echo) {
		return "from remote:"+echo;
	}
}
