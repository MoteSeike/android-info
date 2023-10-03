package com.example.todotasktvview;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class MyWebSocketClient extends WebSocketClient {

    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        // WebSocket connection is established
    }

    @Override
    public void onMessage(String message) {
        // Handle incoming WebSocket messages
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        // WebSocket is closed
    }

    @Override
    public void onError(Exception ex) {
        // Handle connection error
    }
}
