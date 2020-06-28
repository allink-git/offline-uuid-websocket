package me.allink;

import java.net.InetSocketAddress;
import java.util.UUID;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class Main extends WebSocketServer {
	
	public Main(InetSocketAddress inetSocketAddress) {
		super(inetSocketAddress);
	}

	@Override
	public void onClose(WebSocket arg0, int arg1, String arg2, boolean arg3) {
	}

	@Override
	public void onError(WebSocket arg0, Exception arg1) {
	}

	@Override
	public void onMessage(WebSocket arg0, String arg1) {
		arg0.send(UUID.nameUUIDFromBytes(("OfflinePlayer:" + arg1).getBytes()).toString());
	}

	@Override
	public void onOpen(WebSocket arg0, ClientHandshake arg1) {
	}

	@Override
	public void onStart() {
	}

	
	public static void main(String[] args) {
		String host = "localhost";
		int port = 6000;
		WebSocketServer server = new Main(new InetSocketAddress(host,port));
		server.run();
	}
}
