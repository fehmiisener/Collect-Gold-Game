import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;


public class HomePage {

	private JFrame frmAltnOyunu;
	private JTextField textSutun;
	private JTextField textSatir;
	public static int satir=20;
	public static int sutun=20;
	public static int timer=1;
	public static int hareketPuani=5;
	public static int hamleSayisi=3;
	public static boolean gizliGoster=false;
	
	JButton buton[][];
	private JTextField textTimer;
	private JTextField textHareketP;
	private JTextField textHamleSay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmAltnOyunu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltnOyunu = new JFrame();
		frmAltnOyunu.setTitle("Alt\u0131n Oyunu");
		frmAltnOyunu.setResizable(false);
		
		frmAltnOyunu.setBounds(100, 100, 500, 500);
		frmAltnOyunu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltnOyunu.getContentPane().setLayout(null);
		frmAltnOyunu.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1, 1);
		frmAltnOyunu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JCheckBox chckbxGizliGoster = new JCheckBox("Gizli Alt\u0131nlar\u0131 G\u00F6ster");
		chckbxGizliGoster.setBackground(Color.LIGHT_GRAY);
		
		chckbxGizliGoster.setBounds(180, 297, 144, 23);
		frmAltnOyunu.getContentPane().add(chckbxGizliGoster);
		
		textHamleSay = new JTextField();
		textHamleSay.setText("3");
		textHamleSay.setColumns(10);
		textHamleSay.setBounds(234, 230, 29, 20);
		frmAltnOyunu.getContentPane().add(textHamleSay);
		
		JLabel lblHamleSay = new JLabel("Hamle Say\u0131s\u0131");
		lblHamleSay.setForeground(Color.YELLOW);
		lblHamleSay.setBounds(80, 229, 124, 14);
		frmAltnOyunu.getContentPane().add(lblHamleSay);
		
		textHareketP = new JTextField();
		textHareketP.setText("5");
		textHareketP.setColumns(10);
		textHareketP.setBounds(234, 206, 29, 20);
		frmAltnOyunu.getContentPane().add(textHareketP);
		
		JLabel lblHareketP = new JLabel("Hareket Puan\u0131");
		lblHareketP.setForeground(Color.YELLOW);
		lblHareketP.setBounds(80, 208, 124, 14);
		frmAltnOyunu.getContentPane().add(lblHareketP);
		
		JLabel lblNewLabel_1 = new JLabel("Oyun Sahas\u0131n\u0131 Ayarla:");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(80, 175, 144, 21);
		frmAltnOyunu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblX = new JLabel("X");
		lblX.setForeground(Color.WHITE);
		lblX.setBounds(273, 175, 17, 14);
		frmAltnOyunu.getContentPane().add(lblX);
		
		textSutun = new JTextField();
		textSutun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textSutun.setText("");
			}
		});
		
		JLabel lblOyunHznBelirle = new JLabel("Oyun H\u0131z\u0131n\u0131 Belirle:");
		lblOyunHznBelirle.setForeground(Color.YELLOW);
		lblOyunHznBelirle.setBounds(80, 264, 124, 14);
		frmAltnOyunu.getContentPane().add(lblOyunHznBelirle);
		
		textTimer = new JTextField();		
		textTimer.setText("1");
		textTimer.setColumns(10);
		textTimer.setBounds(234, 258, 29, 20);
		frmAltnOyunu.getContentPane().add(textTimer);
		
		textSutun.setText("20");
		textSutun.setColumns(10);
		textSutun.setBounds(288, 176, 27, 20);
		frmAltnOyunu.getContentPane().add(textSutun);
		
		textSatir = new JTextField();
		textSatir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textSatir.setText("");
			}
		});
		textSatir.setText("20");
		textSatir.setColumns(10);
		textSatir.setBounds(234, 175, 29, 20);
		frmAltnOyunu.getContentPane().add(textSatir);
		
		
		
		JButton btnOyunuBaslat = new JButton("Oyunu Ba\u015Flat");
		btnOyunuBaslat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 satir=Integer.parseInt(textSatir.getText());
				 sutun=Integer.parseInt(textSutun.getText());
				 timer=Integer.parseInt(textTimer.getText());
				 hareketPuani=Integer.parseInt(textHareketP.getText());
				 hamleSayisi=Integer.parseInt(textHamleSay.getText());
				 if(chckbxGizliGoster.isSelected()) {
					 gizliGoster=true;
				 }
				 System.out.println("Oyun Baþladý");
				 GamePage gamePage=new GamePage();
				 frmAltnOyunu.setVisible(false);
				 
		
				 
				
			}
		});
		btnOyunuBaslat.setBackground(Color.YELLOW);
		btnOyunuBaslat.setForeground(Color.BLACK);
		btnOyunuBaslat.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnOyunuBaslat.setBounds(191, 339, 124, 28);
		frmAltnOyunu.getContentPane().add(btnOyunuBaslat);
		
		JLabel lblBackground = new JLabel("");
		Image imgBack=new ImageIcon(this.getClass().getResource("/goldGame.gif")).getImage();
		lblBackground.setIcon(new ImageIcon(imgBack));
		lblBackground.setBounds(0, 0, 500, 500);
		frmAltnOyunu.getContentPane().add(lblBackground);
	}
}
