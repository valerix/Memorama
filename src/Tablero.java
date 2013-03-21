import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Tablero  extends Ventana implements ActionListener,Runnable{
	
	
	/*ImageIcon img;
	JButton btn;
	JLabel lblReloj;
	Thread crono;*/
	private JMenuBar dif;
	private JMenuItem facil, intermedio,avanzado;
	private int nivel;
	private JButton btn;
	private JButton tarjetas [][];
	private int tipo[][]= new int [6][6];
	private ImageIcon img;
	private boolean bandera=false;
	private String aux[];
	private Thread crono;
	
	private JLabel lblReloj;
	private Thread crono2;
	
	private JLabel mensaje;


	
	private Icon fondo;
	private JLabel img2;
	
	public Tablero(){
		this.setLayout(null);
		
		dif=new JMenuBar();
		this.setJMenuBar(dif);
		JMenu fileMenu=new JMenu("Dificultad");
		dif.add(fileMenu);
		
		lblReloj=new JLabel();
		lblReloj.setBounds(700, 20, 300, 50);
		Font fp1=new Font("Arial",Font.BOLD,30);
		lblReloj.setFont(fp1);
		this.add(lblReloj);
		
		crono2=new Thread(this);
		//crono2.start();
		
		mensaje=new JLabel("Escoja la dificultad");
		Font fp2=new Font("Arial",Font.BOLD,30);
		mensaje.setFont(fp2);
		mensaje.setForeground(Color.CYAN);
		mensaje.setBounds(200, 200, 300, 50);
		this.add(mensaje);
		
		fondo=new ImageIcon("img/fondomeme.jpg");
		img2=new JLabel(fondo);
		img2.setBounds(0, 0, 800, 700);
		this.add(img2);
		
		btn=new JButton("Iniciar");
		btn.setBounds(300, 300, 100, 40);
		Font fuenteBtn=new Font("Comic Sans MS",Font.BOLD,20);
		btn.setFont(fuenteBtn);
		btn.setForeground(new Color(0,185,233));
		this.add(btn);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn.setVisible(false);
				mensaje.setVisible(false);
				img2.setVisible(false);
				dif.setVisible(false);
				
				tipo=new int [6][6];
				
				crono2.start();
				
			
				
				for(int v=0; v<6; v++){
					for(int a=0; a<6; a++){
					
						tarjetas[v][a].setVisible(true);
						
					}
				}
				
				
				int difi=6;
				
				switch(nivel){
				case 1:
					difi=6;
					break;
				case 2:
					difi=4;
					break;
				case 3:
					difi=2;
					break;
				}
				for(int i=1; i<=36/difi;i++){
					Random r=new Random();
					for(int j=0; j<difi; j++){
					int q=r.nextInt(6);
					int w=r.nextInt(6);
					
					while(tipo[q][w]!=0){
						q=r.nextInt(6);
						w=r.nextInt(6);
					}
					tipo[q][w]=i;
					}
				}
			
			}
		});
		
		
		facil=fileMenu.add("Facil");
		facil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nivel=1;
				
			}
		});
		
		intermedio=fileMenu.add("Intermedio");
		intermedio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nivel=2;
			}
		});
		
		avanzado=fileMenu.add("Avanzado");
		avanzado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nivel=3;
			}
		});
		
		tarjetas=new JButton [6][6];
		int tam=100;
		int contx=10,conty=5;
		for(int v=0; v<6; v++){
			contx=10;
			for(int a=0; a<6; a++){
				tarjetas[v][a]=new JButton("?");
				tarjetas[v][a].setBounds(contx, conty, tam, tam);
				tarjetas[v][a].setVisible(false);
				this.add(tarjetas[v][a]);
				contx=contx+10+tam;
				tarjetas[v][a].setText(v+"-"+a);
				img=new ImageIcon("img/img0.jpg");
				Icon icono = new ImageIcon(img.getImage().getScaledInstance(tarjetas[v][a].getWidth(), tarjetas[v][a].getHeight(), Image.SCALE_DEFAULT));
				
				tarjetas[v][a].setIcon(icono);
				tarjetas[v][a].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					
						String[] valores= e.getActionCommand().split("-");
						//img=new ImageIcon("img/img2.jpg");
						switch(tipo[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])]){
						case 1:
							img=new ImageIcon("img/img1.jpg");
							break;
						case 2:
							img=new ImageIcon("img/img2.jpg");
							break;
						case 3:
							img=new ImageIcon("img/img3.jpg");
							break;
						case 4:
							img=new ImageIcon("img/img4.jpg");
							break;
						case 5:
							img=new ImageIcon("img/img5.jpg");
							break;
						case 6:
							img=new ImageIcon("img/img6.jpg");
							break;
						case 7:
							img=new ImageIcon("img/img7.jpg");
							break;
						case 8:
							img=new ImageIcon("img/img8.jpg");
							break;
						case 9:
							img=new ImageIcon("img/img9.jpg");
							break;
						case 10:
							img=new ImageIcon("img/img10.jpg");
							break;
						case 11:
							img=new ImageIcon("img/img11.jpg");
							break;
						case 12:
							img=new ImageIcon("img/img12.jpg");
							break;
						case 13:
							img=new ImageIcon("img/img13.jpg");
							break;
						case 14:
							img=new ImageIcon("img/img14.jpg");
							break;
						case 15:
							img=new ImageIcon("img/img15.jpg");
							break;
						case 16:
							img=new ImageIcon("img/img16.jpg");
							break;
						case 17:
							img=new ImageIcon("img/img17.jpg");
							break;
						case 18:
							img=new ImageIcon("img/img18.jpg");
							break;
						}
						
						Icon icono = new ImageIcon(img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
						tarjetas[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])].setIcon(icono);
						
						if(bandera==false){
							bandera=true;
							aux=valores;
						}else{
							if((aux[0]==valores[0]) && (aux[1]==valores[1])){
								bandera=true;

							}
							else if(tipo[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])]!=tipo[Integer.parseInt(aux[0])][Integer.parseInt(aux[1])]){
								JFrame frame=new JFrame();
								JOptionPane.showMessageDialog(frame,"sigue intentandolo");
								try {
									tarjetas[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])].setIcon(icono);
									tarjetas[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])].repaint();
									Thread.sleep(200);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								img=new ImageIcon("img/img0.jpg");
								icono = new ImageIcon(img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
								if(tipo[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])]!=-1)
								{
									tarjetas[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])].setIcon(icono);
								}
								
								if(tipo[Integer.parseInt(aux[0])][Integer.parseInt(aux[1])]!=-1)
								{
									tarjetas[Integer.parseInt(aux[0])][Integer.parseInt(aux[1])].setIcon(icono);
									
								}
								
								
								//JFrame frame=new JFrame();
								//JOptionPane.showMessageDialog(frame,"diferentes");
								
								bandera=false;

							}
							else{
								bandera=false;
								tipo[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])]=-1;
								tipo[Integer.parseInt(aux[0])][Integer.parseInt(aux[1])]=-1;
								
							}
						}
						
						boolean bandera2=true;
						for(int i=0; i<6; i++){
							for(int j=0; j<6; j++){
								if(tipo[i][j]!=-1){
									bandera2=false;
								}
							}
						}
						if(bandera2==true){
							JFrame frame=new JFrame();
							JOptionPane.showMessageDialog(frame,"GANASTE xD");
						}
						/*JFrame frame=new JFrame();
						JOptionPane.showMessageDialog(frame,tipo[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])]);*/
					}
				});
				
			}
			conty=conty+10+tam;
		}
	
		
		/*this.setLayout(null);
		btn=new JButton();
		img=new ImageIcon("img/gato.jpg");
		btn.setBounds(100, 100, 200, 200);
		btn.setIcon(img);
		this.add(btn);
		btn.addMouseListener(this);
		
		this.lblReloj=new JLabel("Hola");
		this.lblReloj.setBounds(10, 10, 300, 50);
		this.add(lblReloj);
		crono=new Thread(this);
		crono.start();*/
	}
	
	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	int minutos=0,segundos=0,horas=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			for(;;){
				if(segundos==59){segundos=0;minutos++;}
				if(minutos==59){minutos=0;horas++;}
				segundos++;
				this.lblReloj.setText(horas+":"+minutos+":"+segundos);
				crono2.sleep(1000);
				if(minutos>=1){
					
					JFrame frame=new JFrame();
					JOptionPane.showMessageDialog(frame,"Termino el tiempo");
					crono2.stop();
					for(int v=0; v<6; v++){
						for(int a=0; a<6; a++){
						
							tarjetas[v][a].setVisible(false);
							
						}
					}
					btn.setVisible(true);
					bandera=false;
					segundos=0;
					minutos=0;
					horas=0;
					//crono2.stop();
				}
			}
			
		}catch(InterruptedException e){
			System.out.println();
		}
	}
	 


	
	 
}
