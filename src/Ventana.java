import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Ventana extends JFrame {

	
	
	public Ventana(){
		this.setSize(800,720);
		this.setTitle("Tablero");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		//this.setVisible(true);
	}

	
	

}
