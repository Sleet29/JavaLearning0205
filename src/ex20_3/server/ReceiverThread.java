package ex20_3.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverThread extends Thread {
	private Socket socket;
	
	ReceiverThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			while (!socket.isClosed()) {
				
				String str = reader.readLine();

				 //소켓의 연결이 끊어지면 null을 리턴합니다.
				if(str == null)
					break;
				// 수신된 메시지를 모니터로 출력합니다.
				System.out.println("수신>" + str);
			}
		} catch (Exception e) {			
			System.out.println(e.getMessage());
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
