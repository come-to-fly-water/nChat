package View;


import javax.swing.JFrame;
import Interfaces.GameConstants;
import ServerController.Server;


public class MainFrame extends JFrame implements GameConstants {
	
	private Server server;
	
	public MainFrame(){	
		server = new Server();
	}
}
