package com.importsource.rpc.support;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.importsource.rpc.protocol.Invocation;

/**
 * rpc 客户端
 * @author Hezf
 *
 */
public class Client {
	private String host;
	private int port;
	private int soTimeOut=-1;
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public int getSoTimeOut() {
		return soTimeOut;
	}

	public void setSoTimeOut(int soTimeOut) {
		this.soTimeOut = soTimeOut;
	}
    
	/**
	 * 实例化客户端（超时时间采用默认）
	 * @param host 主机
	 * @param port 端口
	 */
	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	/**
	 * 实例化客户端，增加超时时间
	 * @param host 主机
	 * @param port 端口
	 * @param soTimeOut 超时时间
	 */
	public Client(String host, int port,int soTimeOut) {
		this.host = host;
		this.port = port;
		this.soTimeOut=soTimeOut;
	}

	public void init() throws UnknownHostException, IOException {
		socket = new Socket(host, port);
		if(soTimeOut!=-1){
			socket.setSoTimeout(soTimeOut);
		}
		oos = new ObjectOutputStream(socket.getOutputStream());
	}

	public void invoke(Invocation invo) throws UnknownHostException, IOException, ClassNotFoundException {
		init();
		System.out.println("写入数据");
		oos.writeObject(invo);
		oos.flush();
		ois = new ObjectInputStream(socket.getInputStream());
		
		Invocation result = (Invocation) ois.readObject();
		
		invo.setResult(result.getResult());
	}


	

}
