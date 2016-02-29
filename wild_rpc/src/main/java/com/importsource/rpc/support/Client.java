package com.importsource.rpc.support;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.importsource.rpc.protocol.Invocation;

public class Client {
	private String host;
	private int port;
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

	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void init() throws UnknownHostException, IOException {
		socket = new Socket(host, port);
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
