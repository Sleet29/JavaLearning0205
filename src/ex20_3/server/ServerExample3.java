package ex20_3.server;

import java.net.*;
class ServerExample3 {
	public static void main(String args[]) {
		System.out.println("여기는 서버 입니다.~");
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9001);
			socket = serverSocket.accept();
			System.out.println("================= 접속 정보 =================");
			System.out.println(socket.getInetAddress().getHostAddress()+ "에서 접속하였습니다.");
			System.out.println("====================================");

			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);

			
			thread1.start();
			thread2.start();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/* SenderThread, ReciverThread에서 사용하는 socket을 닫아주면 안됩니다.
			try {
				socket.close(); // 소켓을 닫습니다.
			} catch (Exception ignored) {
				System.out.println("소켓 닫는 중 에러입니다.");
			}
			*/
			try {
				serverSocket.close(); // 서버 소켓을 닫습니다.
			} catch (Exception ignored) {
				System.out.println("서버 소켓 닫는 중 에러입니다.");
			}
		}
	}
}