package com.demo;

import java.io.IOException;
import java.io.OutputStream;

/*
 * port客户端发送接收器
 */

public class PortSender{

	private OutputStream outputStream;
	
	public PortSender(OutputStream outputStream){
		this.outputStream = outputStream;
	}
	
	public boolean send(final byte[] bs){
		try {
			outputStream.write(bs);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
}
