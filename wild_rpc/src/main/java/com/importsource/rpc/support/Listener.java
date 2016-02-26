package com.importsource.rpc.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

import com.importsource.rpc.protocal.Invocation;

public class Listener extends Thread {
	private ServerSocket socket;
	private Server server;

	public Listener(Server server) {
		this.server = server;
	}

	@Override
	public void run() {

		System.out.println("启动服务器中，打开端口" + server.getPort());
		try {
			socket = new ServerSocket(server.getPort());
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		while (server.isRunning()) {
			try {
				System.out.println("等待请求");
				Socket client = socket.accept();
				System.out.println("请求到来");
				ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
				Invocation invo = (Invocation) ois.readObject();
				System.out.println("远程调用:" + invo);

				server.call(invo);
				
				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				oos.writeObject(invo);
				oos.flush();
				oos.close();
				ois.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			if (socket != null && !socket.isClosed())
				socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
