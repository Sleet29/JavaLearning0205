package ex20_3.server;
import java.net.*;
public class ClientExample3 {
// Client 클래스(1:1채팅이기에 Clinet, Server 각각 한명씩 실행해야 한다.)
	public static void main(String[] args) {
		System.out.println("여기는 클라이언트 입니다.");
		Socket socket = null;
		try {
			socket = new Socket("192.168.0.20", 9001); // 본인의 PC IP(cmd - ipconfig로 확인 가능)
			// 연결할 서버쪽의 아이피를 작성해줘야 한다.
			Thread thread1 = new SenderThread(socket); 
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}