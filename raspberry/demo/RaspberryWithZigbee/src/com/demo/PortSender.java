package port;

import java.io.IOException;
import java.io.OutputStream;

import main.Message;
import main.MessageSender;

/*
 * port�ͻ��˷��ͽ�����
 */

public class PortSender implements MessageSender {

	private OutputStream outputStream;
	
	public PortSender(OutputStream outputStream){
		this.outputStream = outputStream;
	}
	
	@Override
	public boolean send(final Message message){
		try {
			outputStream.write(message.getMsg().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
}