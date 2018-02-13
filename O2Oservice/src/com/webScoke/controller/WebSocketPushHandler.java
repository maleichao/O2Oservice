package com.webScoke.controller;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class WebSocketPushHandler implements WebSocketHandler {
   //private static WebSocketPushHandler webSocketPushHandler;
	private static final List<WebSocketSession> users = new ArrayList<WebSocketSession>();
	/*private WebSocketPushHandler(){
    	
    }*/
	/*public static WebSocketPushHandler getInstance() {  
        if (webSocketPushHandler == null) {    
            synchronized (WebSocketPushHandler.class) {    
               if (webSocketPushHandler == null) {    
            	   webSocketPushHandler = new WebSocketPushHandler();   
               }    
            }    
        }    
        return webSocketPushHandler;   
    } */ 
    // 用户进入系统监听
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("成功进入了系统a。。。");
        String ss=session.getUri().toString();
        String[] tokenArray=ss.split("\\?token=");
        Map map= session.getAttributes();
        map.put("token", tokenArray[1]);
        users.add(session);
        sendMessagesToUsers(new TextMessage("今天晚上服务器维护,请注意"));
    }

    //
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
       System.out.println("1234");
       System.out.println(session.getUri());
       JSONObject json=JSONObject.fromObject(message);
       System.out.println(json);
       sendMessageToUser("2452456", new TextMessage("{\"type\":1}"));;
    	// 将消息进行转化，因为是消息是json数据，可能里面包含了发送给某个人的信息，所以需要用json相关的工具类处理之后再封装成TextMessage，
        // 我这儿并没有做处理，消息的封装格式一般有{from:xxxx,to:xxxxx,msg:xxxxx}，来自哪里，发送给谁，什么消息等等
        // TextMessage msg = (TextMessage)message.getPayload();
        // 给所有用户群发消息
        //sendMessagesToUsers(msg);
        // 给指定用户群发消息
        //sendMessageToUser(userId, msg);
    	//System.out.println("ceshio");
    }

    // 后台错误信息处理方法
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    // 用户退出后的处理，不如退出之后，要将用户信息从websocket的session中remove掉，这样用户就处于离线状态了，也不会占用系统资源
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        users.remove(session);
        System.out.println("安全退出了系统");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有的用户发送消息
     */
    public void sendMessagesToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                // isOpen()在线就发送
            	Map map=user.getAttributes();
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送消息给指定的用户
     */
    public void sendMessageToUser(String userId, TextMessage message) {
        for (WebSocketSession user : users) {
            if (user.getAttributes().get("token").equals(userId)) {
                try {
                    // isOpen()在线就发送
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
            	if (user.isOpen()) {
                    //user.sendMessage(message);
            		System.out.println(user.getId());
            		System.out.println(user.getAttributes().get("token")+"true");
            		
                }else if(users.size()>0){
                	System.out.println(user.getAttributes().get("token")+"false");
                	users.remove(user);
                	//user.close();
                }
            }
        }
    }

	public static List<WebSocketSession> getUsers() {
		return users;
	}
    
}