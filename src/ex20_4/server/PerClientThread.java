package ex20_4.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerClientThread extends Thread {
	// ArrayList 객체를 여러 스레드가 동시에 사용하게 되면 
	// 문제가 발생할 수 있어 안전하게 공유할 수 있는 동기화된 리스트로 작성
    // 동기화된 리스트 작성 위해 java.util.Collections 클래스의 synchronized 메서드 이용

    private static List < PrintWriter > list = Collections.synchronizedList(new ArrayList < PrintWriter > ()); //내부적으로 알아서 동기화 시켜주기때문에 따로 동기화시킬 필요없음

    Socket socket;
    PrintWriter writer;

    PerClientThread(Socket socket) {

        this.socket = socket;

        try {
            writer = new PrintWriter(socket.getOutputStream());
            list.add(writer);
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
    }

    public void run() {
        String name = null;
        BufferedReader reader = null;
        try {
               reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));            
           
            //수신된 첫번째 문자열을 대화명으로 사용하기 위해 저장합니다.
            name = reader.readLine();           
            sendAll("#" + name + "님이 들어오셨습니다");
            
             while (!socket.isClosed()) {
                String str = reader.readLine();
               
                //소켓의 연결이 끊어지면 null을 리턴합니다.
                if (str == null)
                    break;
               
                //수신된 메시지 앞에 대화명을 붙여서 모든 클라이언트로 송신합니다.
                sendAll(name + ">" + str);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            // ?
            //사용자가 채팅을 종료했다는 메시지를 모든 클라이언트로 보냅니다.
            sendAll(" # " + name + " 님이 채팅방을 나감");
           
            try {
                reader.close();
            }catch (Exception ignored) {
            	System.out.println("소켓 닫는 중에 에러 발생했습니다.");
            }
        }
    }


    //각 클라이언트에게 메세지를 보내는 역할을 하는 메서드
    synchronized private void sendAll(String str) {

    
        for (PrintWriter writer: list) {
            writer.println(str);
            writer.flush();
        }
        System.out.println(str);
    }

}