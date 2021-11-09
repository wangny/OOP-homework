import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	private ServerSocket serverSocket;
	private List<ConnectionThread> connections = new ArrayList<ConnectionThread>();
	private String ans1, ans2;
	
	
	public ChatServer(int portNum) {
		
		ans1=null;
		ans2=null;
		try {
			this.serverSocket = new ServerSocket(portNum);
			System.out.printf("Server starts listening on port %d.\n", portNum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void runForever() {
		System.out.println("Server starts waiting for client.");
		while(true){
			try {
				Socket connecto = this.serverSocket.accept();
				System.out.println("Get connectio from client."+ connecto.getInetAddress()+":"+connecto.getPort());
				ConnectionThread conthread = new ConnectionThread(connecto);
				conthread.start();
				connections.add(conthread);
				if( connections.size()>1 )  this.broadcast(2);	///game start if both client in connected
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	private void broadcast(int message) {	///broadcast message
		for (ConnectionThread connection: connections) {
			connection.sendMessage(message);
		}
	}
	
	// Define an inner class (class name should be ConnectionThread)
	class ConnectionThread extends Thread{
		private BufferedReader reader;
		private Socket socket;
		private PrintWriter writer;
		
		public ConnectionThread(Socket socket) {
			this.socket = socket;
			
			try {
				this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				this.writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void sendMessage(int message) {	/// broadcast the result 
			this.writer.print(message);
			//System.out.println(message);
			this.writer.flush();
			// TODO Auto-generated method stub
			
		}
		public void run(){
			while(true){
				try {
					String line = this.reader.readLine();
					if(ans1==null) ans1 = line;		///save both answer from clients
					else if(ans2==null){
						ans2=line;
						if(ans1.equals(ans2)){	///broadcast 3 if the answer is same
							ChatServer.this.broadcast(3);
							ans1 = null;	///clear answer we save afterwards
							ans2 = null;
						}else{
							ChatServer.this.broadcast(1);	///broadcast 1 if answers differs 
							ans1 = null;
							ans2 = null;
						}
					}
					
					//System.out.println(line);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	

	public static void main(String[] args) {
		
		ChatServer server = new ChatServer(8000);
		server.runForever();

	}

}
