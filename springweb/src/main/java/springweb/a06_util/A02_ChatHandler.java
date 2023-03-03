package springweb.a06_util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
// 컨테이너에 자동등록 A02_ChatHandler
@Component("chatHandler")
public class A02_ChatHandler extends TextWebSocketHandler {

	// 서버로 접속한 계정의 session을 저장하는 필드 선언(누적 접속자)
	private Map<String, WebSocketSession> users =
				new ConcurrentHashMap();
	// 중복되지 않게 접속 아이디 저장
	private Map<String, String> ids = new ConcurrentHashMap();
	
	// 접속시, 기능메서드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 클라이언트에서 접속할 때, 추가 등록
		users.put(session.getId(),session);
		System.out.println("[핸들러메서드:접속]"+session.getId()
		+"님 접속합니다. 현재 서버에 접속자 수:"+users.size());
	}

	// 메시지 전송시(client에 의해 전달되어 온 메시지 다른 클라이언트에 전송처리)
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// 받은 메시지
		String msg = (String)message.getPayload();
		String []msgArry = msg.split(":");
		/* 홍길동:연결 접속했습니다.
		/* 홍길동:안녕하세요
		// 연결을 종료하였습니다.
		// 연결 접속했습니다.
		 * 
		 * 서버의 접속아이디와 클라이언트에서 입력한 접속자를 쌍으로 map에서 저장
		 * */
		if( msgArry[1].equals("연결 접속했습니다.") ) {
			ids.put(session.getId(), msgArry[0]);
		} 
		/*
		if( msgArry[1].equals("연결을 종료하였습니다.") ) {
			ids.remove(session.getId());
		}		
		*/
		System.out.println("#[핸들러메서드:메시지]"+msg);
		//System.out.println("#[핸들러메서드:접속자]"+memStr);
		// 전달할 클라이언트에게 전달.
		System.out.println("\t 메시지 전달 대상자:");
		for(WebSocketSession ws:users.values()) {
			
			ws.sendMessage(message);

			System.out.print(ws.getId()+", ");
		}
		System.out.println();
	}
	// 종료시
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 등록된 사용자에서 제거 처리
		// 브라우저를 통해서 닫거나 버튼을 통해서 접속종료 둘다 처리...
		byte[] payload = (ids.get(session.getId())+":연결을 종료하였습니다.").getBytes();
		users.remove(session.getId());
		WebSocketMessage<?> message = new TextMessage(payload);
		
		for(WebSocketSession ws:users.values()) {
			ws.sendMessage(message);
			System.out.print(ws.getId()+", ");
		}		
		
		ids.remove(session.getId());
		
		System.out.println("#[핸들러메서드:접속종료]"+session.getId());
	}
	// 예외 처리
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println("#[핸들러메서드:에러발생]"+
				session.getId()+":"+exception.getMessage());
		
	}
	public List<String> getIdx(){
		// 접속자 명단(클라이언트에서 입력한) 리턴 처리..
		List<String> list = new ArrayList<String>();
		for(String id:ids.keySet()) {
			list.add(ids.get(id));
		}
		
		return list;
	}

	
	
}
