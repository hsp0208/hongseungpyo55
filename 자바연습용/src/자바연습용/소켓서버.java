package 자바연습용;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
 
public class 소켓서버 {
  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    try {
      // 서버소켓을 생성하고 5000번 포트와 결합(bind) 시킨다.
      serverSocket = new ServerSocket(5000);
      System.out.println(getTime() + " 서버가 준비되었습니다.");
    } catch (IOException e) {
      e.printStackTrace();
    } // try - catch
     
    while (true) {
      try {
        System.out.println(getTime() + " 연결요청을 기다립니다.");
        // 서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.
        // 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        DataInputStream dis = new DataInputStream(in);
        System.out.println(getTime() + socket.getInetAddress() + " 로부터 연결요청이 들어왔습니다.");
        
        List<String> responsePacketList = Arrays.asList(dis.readUTF().split("\\$"));
        // 패킷을 스플릿했다.
        for(int ii = 0; ii<responsePacketList.size(); ii++) {
        	responsePacketList.set(ii, responsePacketList.get(ii).replace("#", ""));
        }
        
        System.out.println("클라이언트 -> 서버 패킷 : " + responsePacketList.toString());
        
        List<String> resultPacketList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int ii = 0; ii<responsePacketList.size(); ii++) {
        	if(responsePacketList.get(ii).equals("25019990003                     1050423456789   01011112222                                                                1")) {
        		resultPacketList.add("#35019990003                   001050423456789   01011112222                                                                1$");
        	}
        	else if ( responsePacketList.get(ii).equals("25029990004                     1050434567890   12345678       01234567                                                    1") ) {
        		resultPacketList.add("#35029990004                   001050434567890   12345678       01234567                                                    1$");
        	}
        	sb.append(resultPacketList.get(ii));
        }
        
        // 소켓의 출력스트림을 얻는다.
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out); // 기본형 단위로 처리하는 보조스트림
        
        System.out.println("서버가 보내는 메세지 : " + sb.toString());
         
        // 원격 소켓(remote socket)에 데이터를 보낸다.
        dos.writeUTF(sb.toString());
        System.out.println(getTime() + " 데이터를 전송했습니다.");
         
        // 스트림과 소켓을 달아준다.
        dos.close();
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      } // try - catch
    } // while
  } // main
   
  static String getTime() {
    SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
    return f.format(new Date());
  } // getTime
} // TcpServerTest
