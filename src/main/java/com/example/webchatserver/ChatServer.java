package com.example.webchatserver;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * This class represents a web socket server, a new connection is created and it receives a roomID as a parameter
 **/
@ServerEndpoint(value="/ws/{roomID}")
public class ChatServer {

    // contains a static List of ChatRoom used to control the existing rooms and their users
    private static List<ChatRoom> chatRooms = new ArrayList<>();

    // you may add other attributes as you see fit


    @OnOpen
    public void open(@PathParam("roomID") String roomID, Session session) throws IOException, EncodeException {

        // accessing the roomID parameter
        System.out.println("New connection to room: " + roomID);

        // create a new chat room if it doesn't exist
        ChatRoom chatRoom = getChatRoom(roomID);
        if (chatRoom == null) {
            chatRoom = new ChatRoom(roomID, session.getId());
            ChatRoom.add(chatRoom);
        } else {
            chatRoom.addUser(session.getId(), "", session);
        }

        // send welcome message to user
        session.getBasicRemote().sendText("Welcome to room: " + roomID);
    }

    @OnClose
    public void close(Session session) throws IOException, EncodeException {
        String userId = session.getId();
        // remove user from all chat rooms
        for (ChatRoom chatRoom : chatRooms) {
            chatRoom.removeUser(userId);
        }
    }

    @OnMessage
    public void handleMessage(String message, Session session) throws IOException, EncodeException {
        // get user ID of sender
        String userId = session.getId();

        // get chat room for user
        ChatRoom chatRoom = getChatRoomForUser(userId);
        if (chatRoom == null) {
            session.getBasicRemote().sendText("You are not in a chat room!");
            return;
        }

        // parse JSON message from client
        JSONObject jsonMessage = new JSONObject(message);
        String messageType = jsonMessage.getString("type");

        switch (messageType) {
            case "join":
                String username = jsonMessage.getString("username");
                chatRoom.addUser(userId, username, session);
                break;
            case "message":
                String chatMessage = jsonMessage.getString("message");
                String senderUsername = chatRoom.getUsers().get(userId);
                if (senderUsername == null || senderUsername.isEmpty()) {
                    senderUsername = "Anonymous";
                }
                String formattedMessage = senderUsername + ": " + chatMessage;
                List<Session> sessions = chatRoom.getSessions();
                for (Session s : sessions) {
                    s.getBasicRemote().sendText(formattedMessage);
                }
                break;
            default:
                session.getBasicRemote().sendText("Invalid message type!");
                break;
        }
    }

    private ChatRoom getChatRoom(String roomID) {
        for (ChatRoom chatRoom : chatRooms) {
            if (chatRoom.getCode().equals(roomID)) {
                return chatRoom;
            }
        }
        return null;
    }

    private ChatRoom getChatRoomForUser(String userId) {
        for (ChatRoom chatRoom : chatRooms) {
            if (chatRoom.inRoom(userId)) {
                return chatRoom;
            }
        }
        return null;
    }

}
