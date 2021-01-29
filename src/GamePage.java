import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Font;

public class GamePage {
	 HomePage home=new HomePage();
	 gameBoard board = new gameBoard();
	 Image imgGold=new ImageIcon(this.getClass().getResource("/gold30.png")).getImage();
	 Image imgGold5=new ImageIcon(this.getClass().getResource("/gold30-5.png")).getImage();
	 Image imgGold10=new ImageIcon(this.getClass().getResource("/gold30-10.png")).getImage();
	 Image imgGold15=new ImageIcon(this.getClass().getResource("/gold30-15.png")).getImage();
	 Image imgGold20=new ImageIcon(this.getClass().getResource("/gold30-20.png")).getImage();
	 Image imgSecretGold5=new ImageIcon(this.getClass().getResource("/goldSecret30-5.png")).getImage();
	 Image imgSecretGold10=new ImageIcon(this.getClass().getResource("/goldSecret30-10.png")).getImage();
	 Image imgSecretGold15=new ImageIcon(this.getClass().getResource("/goldSecret30-15.png")).getImage();
	 Image imgSecretGold20=new ImageIcon(this.getClass().getResource("/goldSecret30-20.png")).getImage();	 
	 Image imgSecretGold=new ImageIcon(this.getClass().getResource("/goldSecret30.png")).getImage();
	 Image imgBos=new ImageIcon(this.getClass().getResource("/bos.jpg")).getImage();
	 Image img1=new ImageIcon(this.getClass().getResource("/player130.png")).getImage();
	 Image img2=new ImageIcon(this.getClass().getResource("/player230.png")).getImage();
	 Image img3=new ImageIcon(this.getClass().getResource("/player330.png")).getImage();
	 Image img4=new ImageIcon(this.getClass().getResource("/player430.png")).getImage();
	 Image goldBos=new ImageIcon(this.getClass().getResource("/goldBos.png")).getImage(); 
	 
	int satir=home.satir;
	int sutun=home.sutun;
	int timer=home.timer*10;
	int hamleSayisi=HomePage.hamleSayisi;
	int hareketPuani=HomePage.hareketPuani;
	int order = 1;
	int aStep=0,bStep=0,cStep=0,dStep=0;
	boolean hasGold=true;
	boolean gizliGoster=home.gizliGoster;	
  public static JLabel buton[][];
  public static JLabel goldvalue[][];
  FileWriter fwA,fwB,fwC,fwD;
	
	int playerTotalGold=board.getPlayerA().totalBalance+board.getPlayerB().totalBalance+board.getPlayerC().totalBalance+board.getPlayerD().totalBalance;

	JFrame gamePage;	
	private JFrame frameGame;
	public  void  clearButon(int x, int y) {
		 
		 buton[x][y].setIcon(new ImageIcon(imgBos));
		}
		public void  setButon(int x, int y,int p) {
			
			if(p==1) {
			
	        buton[x][y].setIcon(new ImageIcon(img1));
			}
			if(p==2) {
				buton[x][y].setIcon(new ImageIcon(img2));
		         
				}
			if(p==3) {
				buton[x][y].setIcon(new ImageIcon(img3));
		        
				}
			if(p==4) {
				buton[x][y].setIcon(new ImageIcon(img4));
				}
		}
		void printBoard(gameBoard board)
		{
	    	for(int i=0; i<board.width; i++) 
	    	{
	    		System.out.print("Row {"+i+"}: [");
	    		for(int j=0; j<board.height; j++)
	    		{	
	    			if(board.getMapMatrix()[i][j]%13 == 0)
	    				System.out.print(" "+board.getMapMatrix()[i][j]/13+" : N ");
	    			else if (board.getMapMatrix()[i][j]%17 == 0)
	    				System.out.print(" "+(board.getMapMatrix()[i][j]/17)+" : S ");
	    			else
	    				System.out.print(" "+board.getMapMatrix()[i][j]);
	    		}
	    		System.out.println(" ]");
	    	}
		}

	/**
	 * Launch the application.
	 */
		
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePage window = new GamePage();
					window.frameGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GamePage() {
		initialize();
		
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		 gamePage=new JFrame("Altýn Oyunu");
		 gamePage.setSize(satir*30+250,sutun*30+250);
		 //gamePage.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		 //gamePage.setUndecorated(true);
		 gamePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 gamePage.getContentPane().setLayout(null);
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setBounds(0, 0, satir*30, sutun*30);
		 gamePage.getContentPane().add(panel_1);
		 panel_1.setLayout(null);
		 
		 JPanel panel = new JPanel();
		 panel.setBounds( satir*30, 0, 234, 297);
		 gamePage.getContentPane().add(panel);
		 panel.setLayout(null);
		 
		 JLabel lblNewLabel_1 = new JLabel();
		 lblNewLabel_1.setBounds(10, 46, 50, 50);
		 lblNewLabel_1.setIcon(new ImageIcon(img1));
		 panel.add(lblNewLabel_1);
		 
		
		 
		 JLabel lblNewLabel_1_1 = new JLabel();
		 lblNewLabel_1_1.setBounds(70, 46, 50, 50);
		 lblNewLabel_1_1.setIcon(new ImageIcon(img2));
		 panel.add(lblNewLabel_1_1);
		 
		 JLabel lblNewLabel_1_2 = new JLabel();
		 lblNewLabel_1_2.setBounds(130, 46, 50, 50);
		 lblNewLabel_1_2.setIcon(new ImageIcon(img3));
		 panel.add(lblNewLabel_1_2);
		 
		 JLabel lblNewLabel_1_3 = new JLabel();
		 lblNewLabel_1_3.setBounds(183, 45,50, 50);
		 lblNewLabel_1_3.setIcon(new ImageIcon(img4));
		 panel.add(lblNewLabel_1_3);
		 JLabel lblNewLabel = new JLabel("Oyun Ak\u0131\u015F\u0131");
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		 lblNewLabel.setBounds(25, 11, 87, 14);
		 panel.add(lblNewLabel);
		 
		 JLabel lblAGold = new JLabel("200");
		 lblAGold.setBounds(27, 104, 22, 14);
		 panel.add(lblAGold);
		 
		 JLabel lblBGold = new JLabel("200");
		 lblBGold.setBounds(84, 105, 26, 14);
		 panel.add(lblBGold);
		 
		 JLabel lblCGold = new JLabel("200");
		 lblCGold.setBounds(146, 105, 26, 14);
		 panel.add(lblCGold);
		 
		 JLabel lblDGold = new JLabel("200");
		 lblDGold.setBounds(199, 106, 26, 14);
		 panel.add(lblDGold);
		 
		 JLabel txtBos1 = new JLabel();
		 txtBos1.setBounds(10, 88, 50, 50);
		 txtBos1.setIcon(new ImageIcon(goldBos));
		 panel.add(txtBos1);
		 
		 JLabel txtBos2 = new JLabel();
		 txtBos2.setBounds(69, 90, 50, 50);
		 txtBos2.setIcon(new ImageIcon(goldBos));
		 panel.add(txtBos2);
		 
		 JLabel txtBos3 = new JLabel();
		 txtBos3.setBounds(130, 88, 50, 50);
		 txtBos3.setIcon(new ImageIcon(goldBos));
		 panel.add(txtBos3);
		 
		 JLabel txtBos4 = new JLabel();
		 txtBos4.setBounds(183, 89, 50, 50);
		 txtBos4.setIcon(new ImageIcon(goldBos));
		 panel.add(txtBos4);
		 
		 JLabel lblNewLabel_2 = new JLabel("Oyun Ad\u0131mlar\u0131");
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		 lblNewLabel_2.setBounds(25, 144, 87, 14);
		 panel.add(lblNewLabel_2);
		 
		 JTextArea textPane = new JTextArea();
		 textPane.setEnabled(false);
		 textPane.setEditable(false);
		 textPane.setFont(new Font("Monospaced", Font.BOLD, 12));
		 textPane.setTabSize(10);
		 textPane.setBounds(22, 166, 108, 96);
		 panel.add(textPane);
		
		
		 gamePage.setVisible(true);
		 gamePage.setLocationRelativeTo(null);
		
		
		 //dosya islemleri baslangic
		
		 File fileA=new File("PlayerAMove.txt");
		 File fileB=new File("PlayerBMove.txt");
		 File fileC=new File("PlayerCMove.txt");
		 File fileD=new File("PlayerDMove.txt");
		 try {
		 if(!fileA.exists()) 
			 fileA.createNewFile();		 
		 if(!fileB.exists())
			 fileB.createNewFile();
		 if(!fileC.exists())
			 fileC.createNewFile();
		 if(!fileD.exists())
			 fileD.createNewFile();
		  fwA=new FileWriter(fileA,false);
		  fwB=new FileWriter(fileB,false);
		  fwC=new FileWriter(fileC,false);
		  fwD=new FileWriter(fileD,false);
		 }catch(IOException e) {
			 System.out.println(e.getMessage());
		 }
		 
		 BufferedWriter bwA=new BufferedWriter(fwA);
		 BufferedWriter bwB=new BufferedWriter(fwB);
		 BufferedWriter bwC=new BufferedWriter(fwC);
		 BufferedWriter bwD=new BufferedWriter(fwD);
		 
		//dosya islemleri bitis
		 
		// board = new gameBoard();
		 
		
		 buton = new JLabel[satir][sutun];
		 goldvalue = new JLabel[satir][sutun];
		 Border blackline = BorderFactory.createLineBorder(Color.black);
		  for(int i=0;i<satir;i++){
	            for(int j=0;j<sutun;j++){			                  
	                
	               buton[i][j] = new JLabel();  
	               
	               buton[i][j].setIcon(new ImageIcon(imgBos));
	              
	               //buton[i][j].setBackground(Color.lightGray);
	               buton[i][j].setBounds(i*30,j*30,30,30);
	               
	               
	               buton[i][j].setBorder(blackline);
	               
	              // buton[i][j].setText(String.valueOf(board.mapMatrix[i][j]));
	               
	               if((board.getMapMatrix()[i][j])!=0 && (board.getMapMatrix()[i][j])%17==0) {
	            	   if(gizliGoster) {
	            	   switch(board.getMapMatrix()[i][j]/17) {
	            	   case 5:
	            		   
	            		   buton[i][j].setIcon(new ImageIcon(imgSecretGold5));
	            		   break;
	            	   case 10:
	            		   
	            		   buton[i][j].setIcon(new ImageIcon(imgSecretGold10));
	            		   break;
	            	   case 15:
	            		   
	            		   buton[i][j].setIcon(new ImageIcon(imgSecretGold15));
	            		   break;
	            	   case 20:
	            		   
	            		   buton[i][j].setIcon(new ImageIcon(imgSecretGold20));
	            		   break;
	            	  
	            	   }
	            	   }
	            	 
	               }
	               else if((board.getMapMatrix()[i][j])!=0 && (board.getMapMatrix()[i][j])%13==0) {
	            	   switch(board.getMapMatrix()[i][j]/13) {
	            	   case 5:
	            		   
	            		   buton[i][j].setIcon(new ImageIcon(imgGold5));
	            		   break;
	            	   case 10:
	            		  
	            		   buton[i][j].setIcon(new ImageIcon(imgGold10));
	            		   break;
	            	   case 15:
	            		  
	            		   buton[i][j].setIcon(new ImageIcon(imgGold15));
	            		   break;
	            	   case 20:
	            		  
	            		   buton[i][j].setIcon(new ImageIcon(imgGold20));
	            		   break;
	            	  
	            	   }
	            	
	               }	               
	            
	               panel_1.add(buton[i][j]);              
	              
	                 
	            }
	            
	           
	    }
		    buton[0][0].setIcon(new ImageIcon(img1));	      
	        buton[0][satir-1].setIcon(new ImageIcon(img2));	        
	        buton[satir-1][0].setIcon(new ImageIcon(img4));	        
	        buton[satir-1][sutun-1].setIcon(new ImageIcon(img3));
	       
		  
		 
			
		 
			
			
				
				for(int i=0; i<board.width; i++) 
		    	{
		    		System.out.print("Row {"+i+"}: [");
		    		for(int j=0; j<board.height; j++)
		    		{	
		    			if(board.getMapMatrix()[i][j]%13 == 0) {
		    				System.out.print(" "+board.getMapMatrix()[i][j]/13);
		    				
		    			}
		    			else if (board.getMapMatrix()[i][j]%17 == 0)
		    				System.out.print(" "+(board.getMapMatrix()[i][j]/17)+1);
		    			else
		    				System.out.print(" "+board.getMapMatrix()[i][j]);
		    		}
		    		System.out.println(" ]");
		    	}
			
				
		    	
			
				printBoard(board);
				
			    	for(int i=0; i<board.width; i++) 
			    	{
			    		System.out.print("Row {"+i+"}: [");
			    		for(int j=0; j<board.height; j++)
			    		{	
			    			if(board.getMapMatrix()[i][j]%13 == 0)
			    				System.out.print(" "+board.getMapMatrix()[i][j]/13+" N"+j+" |");
			    			else if (board.getMapMatrix()[i][j]%17 == 0)
			    				System.out.print(" "+(board.getMapMatrix()[i][j]/17)+" : S"+j+" |");
			    			else
			    				System.out.print(" "+board.getMapMatrix()[i][j]);
			    		}
			    		System.out.println(" ]");
			    	}
				
			    	
			    		Timer myTimer = new Timer();
						TimerTask gorev=new TimerTask() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								
								if(hasGold && playerTotalGold>0)
								{
									System.out.println("Order : "+order);
								
									switch(order)
									{
									
									case 1: 
										
										if(board.getPlayerA().totalBalance>0)
										{
											textPane.setText("");
											board.getPlayerA().readMap(board.getMapMatrix());
											board.getPlayerA().setHasTarget();
											
											boolean hasTargetA = board.getPlayerA().hasTarget();
											if(hasTargetA)
											{
												clearButon(board.getPlayerA().posX,board.getPlayerA().posY);
												int move[]=board.getPlayerA().moveToGold(board.getPlayerA().posX,board.getPlayerA().posY);
												board.getPlayerA().setPos(move[0], move[1]);
												
												int playerX,playerY,goldX,goldY;
												playerX=board.getPlayerA().posX;
												playerY=board.getPlayerA().posY;
												goldX=board.getPlayerA().bestGoldX;
												goldY=board.getPlayerA().bestGoldY;
												
												if(playerX==goldX && playerY==goldY)
													board.setMapMatrix(board.getPlayerA().getGold(goldX, goldY));	
												setButon(board.getPlayerA().posX,board.getPlayerA().posY,1);
												lblAGold.setText(""+board.getPlayerA().totalBalance);
												
												textPane.setText(textPane.getText()+"A"+"i="+board.getPlayerA().posX+"j="+board.getPlayerA().posY+"\n");
												
											}
											else
											{
												clearButon(board.getPlayerA().posX,board.getPlayerA().posY);
												board.getPlayerA().findTarget();
												
												int move[]=	board.getPlayerA().moveToGold(board.getPlayerA().posX,board.getPlayerA().posY);
												board.getPlayerA().setPos(move[0], move[1]);
												clearButon(board.getPlayerA().posX,board.getPlayerA().posY);
												int playerX,playerY,goldX,goldY;
												playerX=board.getPlayerA().posX;
												playerY=board.getPlayerA().posY;
												goldX=board.getPlayerA().bestGoldX;
												goldY=board.getPlayerA().bestGoldY;
												
												if(playerX==goldX && playerY==goldY)
													board.setMapMatrix(board.getPlayerA().getGold(goldX, goldY));
												setButon(board.getPlayerA().posX,board.getPlayerA().posY,1);
												lblAGold.setText(""+board.getPlayerA().totalBalance);
												textPane.setText(textPane.getText()+"A"+"i="+board.getPlayerA().posX+"j="+board.getPlayerA().posY+"\n");
												
												
											}
											try {
												aStep++;
												bwA.append("A"+"i="+board.getPlayerA().posX+"j="+board.getPlayerA().posY+"\n");
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										break;
									case 2: //B
										if(board.getPlayerB().totalBalance>0)
										{
											
											board.getPlayerB().readMap(board.getMapMatrix());
											board.getPlayerB().setHasTarget();
											
											boolean hasTargetB = board.getPlayerB().hasTarget();
											if(hasTargetB)
											{
												clearButon(board.getPlayerB().posX,board.getPlayerB().posY);
												int move[]=	board.getPlayerB().moveToGold(board.getPlayerB().posX,board.getPlayerB().posY);
												board.getPlayerB().setPos(move[0], move[1]);
												
												int playerX,playerY,goldX,goldY;
												playerX=board.getPlayerB().posX;
												playerY=board.getPlayerB().posY;
												goldX=board.getPlayerB().bestGoldX;
												goldY=board.getPlayerB().bestGoldY;
												
												if(playerX==goldX && playerY==goldY)
													board.setMapMatrix(board.getPlayerB().getGold(goldX, goldY));	
												setButon(board.getPlayerB().posX,board.getPlayerB().posY,2);
												lblBGold.setText(""+board.getPlayerB().totalBalance);
												textPane.setText(textPane.getText()+"B"+"i="+board.getPlayerB().posX+"j="+board.getPlayerB().posY+"\n");
												
											}
											else
											{
												clearButon(board.getPlayerB().posX,board.getPlayerB().posY);
												board.getPlayerB().findTarget();
												
												int move[]=	board.getPlayerB().moveToGold(board.getPlayerB().posX,board.getPlayerB().posY);
												board.getPlayerB().setPos(move[0], move[1]);
												
												int playerX,playerY,goldX,goldY;
												playerX=board.getPlayerB().posX;
												playerY=board.getPlayerB().posY;	
												goldX=board.getPlayerB().bestGoldX;
												goldY=board.getPlayerB().bestGoldY;
														
												if(playerX==goldX && playerY==goldY)
													board.setMapMatrix(board.getPlayerB().getGold(goldX, goldY));
												setButon(board.getPlayerB().posX,board.getPlayerB().posY,2);
												lblBGold.setText(""+board.getPlayerB().totalBalance);
												textPane.setText(textPane.getText()+"B"+"i="+board.getPlayerB().posX+"j="+board.getPlayerB().posY+"\n");
											}try {
												bStep++;
												bwB.append("B"+"i="+board.getPlayerB().posX+"j="+board.getPlayerB().posY+"\n");
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											
										}		
										break;
									case 3: //C
										if(board.getPlayerC().totalBalance>0)
										{
											board.getPlayerC().readMap(board.getMapMatrix());
											board.getPlayerC().findSecretGold();
											board.setMapMatrix(board.getPlayerC().openSecretGold());
											board.getPlayerC().readMap(board.getMapMatrix());
											board.getPlayerC().setHasTarget();
																	
											boolean hasTargetC = board.getPlayerC().hasTarget();				
											if(hasTargetC)
											{
												clearButon(board.getPlayerC().posX,board.getPlayerC().posY);
												int move[]=	board.getPlayerC().moveToGold(board.getPlayerC().posX,board.getPlayerC().posY);
												board.getPlayerC().setPos(move[0], move[1]);
												
												int playerX,playerY,goldX,goldY;
												playerX=board.getPlayerC().posX;
												playerY=board.getPlayerC().posY;
												goldX=board.getPlayerC().bestGoldX;
												goldY=board.getPlayerC().bestGoldY;
												
												if(playerX==goldX && playerY==goldY)
													board.setMapMatrix(board.getPlayerC().getGold(goldX, goldY));
												setButon(board.getPlayerC().posX,board.getPlayerC().posY,3);
												lblCGold.setText(""+board.getPlayerC().totalBalance);
												textPane.setText(textPane.getText()+"C"+"i="+board.getPlayerC().posX+"j="+board.getPlayerC().posY+"\n");
											}
											else
											{
												clearButon(board.getPlayerC().posX,board.getPlayerC().posY);
												board.getPlayerC().findTarget();
												
												int move[]=	board.getPlayerC().moveToGold(board.getPlayerC().posX,board.getPlayerC().posY);
												board.getPlayerC().setPos(move[0], move[1]);
												clearButon(board.getPlayerC().posX,board.getPlayerC().posY);
												int playerX,playerY,goldX,goldY;
												playerX=board.getPlayerC().posX;
												playerY=board.getPlayerC().posY;	
												goldX=board.getPlayerC().bestGoldX;
												goldY=board.getPlayerC().bestGoldY;
															
												if(playerX==goldX && playerY==goldY)
													board.setMapMatrix(board.getPlayerC().getGold(goldX, goldY));
												setButon(board.getPlayerC().posX,board.getPlayerC().posY,3);
												lblCGold.setText(""+board.getPlayerC().totalBalance);
												textPane.setText(textPane.getText()+"C"+"i="+board.getPlayerC().posX+"j="+board.getPlayerC().posY+"\n");
											} try {
												cStep++;
												bwC.append("C"+"i="+board.getPlayerC().posX+"j="+board.getPlayerC().posY+"\n");
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();															
										}
											
										}
										break;
									case 4 :
											
										if(board.getPlayerD().totalBalance>0)
										{
											board.getPlayerD().readMap(board.getMapMatrix());
											board.getPlayerD().readMap(board.getMapMatrix());
											board.getPlayerD().setHasTarget();
														
											int playerInfo[][] = new int[3][4];
											
												playerInfo[0][0]=board.getPlayerA().posX;
												playerInfo[0][1]=board.getPlayerA().posY;
												playerInfo[0][2]=board.getPlayerA().bestGoldX;
												playerInfo[0][3]=board.getPlayerA().bestGoldY;
												
												playerInfo[1][0]=board.getPlayerB().posX;
												playerInfo[1][1]=board.getPlayerB().posY;
												playerInfo[1][2]=board.getPlayerB().bestGoldX;
												playerInfo[1][3]=board.getPlayerB().bestGoldY;
												
												playerInfo[2][0]=board.getPlayerC().posX;
												playerInfo[2][1]=board.getPlayerC().posY;
												playerInfo[2][2]=board.getPlayerC().bestGoldX;
												playerInfo[2][3]=board.getPlayerC().bestGoldY;
											
											boolean hasTargetD = board.getPlayerD().hasTarget();
											if(board.getPlayerD().canReach(playerInfo) && !hasTargetD)
											{
												board.getPlayerD().setTarget(playerInfo);
											}
											if(hasTargetD)
											{
												clearButon(board.getPlayerD().posX,board.getPlayerD().posY);
												int move[]=	board.getPlayerD().moveToGold(board.getPlayerD().posX,board.getPlayerD().posY);
												board.getPlayerD().setPos(move[0], move[1]);
												
												int playerX,playerY,goldX,goldY;
												playerX=board.getPlayerD().posX;
												playerY=board.getPlayerD().posY;					
												goldX=board.getPlayerD().bestGoldX;
												goldY=board.getPlayerD().bestGoldY;
												
												if(playerX==goldX && playerY==goldY)					
														board.setMapMatrix(board.getPlayerD().getGold(goldX, goldY));
												setButon(board.getPlayerD().posX,board.getPlayerD().posY,4);
												lblDGold.setText(""+board.getPlayerD().totalBalance);
												textPane.setText(textPane.getText()+"D"+"i="+board.getPlayerD().posX+"j="+board.getPlayerD().posY+"\n");
											}
											else
											{
												clearButon(board.getPlayerD().posX,board.getPlayerD().posY);
												board.getPlayerD().findTarget();
												int move[]=	board.getPlayerD().moveToGold(board.getPlayerD().posX,board.getPlayerD().posY);
												board.getPlayerD().setPos(move[0], move[1]);
												
												int playerX,playerY,goldX,goldY;
												playerX=board.getPlayerD().posX;
												playerY=board.getPlayerD().posY;	
												goldX=board.getPlayerD().bestGoldX;
												goldY=board.getPlayerD().bestGoldY;
												
												if(playerX==goldX && playerY==goldY)
													board.setMapMatrix(board.getPlayerD().getGold(goldX, goldY));
												setButon(board.getPlayerD().posX,board.getPlayerD().posY,4);
												lblDGold.setText(""+board.getPlayerD().totalBalance);
												textPane.setText(textPane.getText()+"D"+"i="+board.getPlayerD().posX+"j="+board.getPlayerD().posY+"\n");
											}try {
												dStep++;
												bwD.append("D"+"i="+board.getPlayerD().posX+"j="+board.getPlayerD().posY+"\n");
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
															
										}	
											
										}
										break;
									}
									if(order==4)
										order=1;
									else
										order++;
									hasGold=board.hasGold();
									playerTotalGold=board.getPlayerA().totalBalance+board.getPlayerB().totalBalance+board.getPlayerC().totalBalance+board.getPlayerD().totalBalance;
								}else {
									myTimer.cancel();
									
									//JOptionPane.showMessageDialog(frameGame, "Oyun Bitti Sonuçlar \n Altýnlar:"+ "\nA="+board.getPlayerA().totalBalance+"\nB="+board.getPlayerB().totalBalance+"\nC="+board.getPlayerC().totalBalance+"\nD="+board.getPlayerD().totalBalance);
									JOptionPane.showMessageDialog(frameGame, "Oyun Bitti\n Atýlan Adýmlar "+" |  Harcanan Altýn Miktarý  "+ "|  Kasadaki Altýn Miktarý  "+"|  Toplanan Altýn Miktarý"+
											"\n 1. Oyuncu = "+aStep+"                   "+aStep*5+"           "+"                               "+board.getPlayerA().totalBalance+"                              "+(aStep*5-200+board.getPlayerA().totalBalance)+
											"\n 2. Oyuncu = "+bStep+"                   "+bStep*10+"           "+"                               "+board.getPlayerB().totalBalance+"                              "+(bStep*10-200+board.getPlayerB().totalBalance)+
											"\n 3. Oyuncu = "+cStep+"                   "+cStep*15+"           "+"                               "+board.getPlayerC().totalBalance+"                              "+(cStep*15-200+board.getPlayerC().totalBalance)+
											"\n 4. Oyuncu = "+dStep+"                   "+dStep*20+"           "+"                               "+board.getPlayerD().totalBalance+"                              "+(dStep*20-200+board.getPlayerD().totalBalance));
									
										try {
											bwA.close();
											bwB.close();
											bwC.close();
											bwD.close();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									
									
									gamePage.setVisible(false);
								}
								
								//printBoard(board);
							
							}
					
				};
				myTimer.schedule(gorev, 3000,timer);
				
				
		  
		 
	}
	
	
	public void removeButton() {
		int i,j;
		for(i=0;i<satir;i++) {
			for(j=0;j<sutun;j++) {
				gamePage.remove(board.getMapMatrix()[i][j]);
				gamePage.revalidate();
				gamePage.repaint();
			}
		}
	}
}
