import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_Login extends JFrame implements ActionListener{

	static GUI_Login mainwindow = new GUI_Login();
	
	public static User MainUser = new User();
	
	public static String NAME;
	public static String PASSWORD;
	
	public final int WIDTH = 500;
	public final int HEIGHT = 400;
	
	private JTextField namefield = new JTextField();
	private JPasswordField passwordfield = new JPasswordField();
	
	public GUI_Login()
	{
		super("식단 관리 프로그램");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\USER\\Desktop\\Yoda.jpg");
	    
		JPanel panel1 = new JPanel() {
	    	public void paintComponent(Graphics g) {
	    		Dimension d = getSize();
	    		g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);	
	    		setOpaque(false);
	    		super.paintComponent(g);
	    	}	
	    };	      
	    
		panel1.setLayout(null);
		
		JLabel namelabel = new JLabel("Name");
		namelabel.setBounds(130, 170, 50, 20);
		panel1.add(namelabel);
		namefield.setBounds(220, 170, 120, 20);
		panel1.add(namefield);
		
		JLabel pwlabel = new JLabel("PassWord");
		pwlabel.setBounds(130, 200, 70, 20);
		panel1.add(pwlabel);
		passwordfield.setBounds(220, 200, 120, 20);
		panel1.add(passwordfield);
		
		JButton loginButton = new JButton("로그인");
		loginButton.setBounds(130, 250, 90, 30);
		loginButton.addActionListener(this);
		panel1.add(loginButton);
		
		JButton newButton = new JButton("회원가입");
		newButton.setBounds(250, 250, 90, 30);
		newButton.addActionListener(this);
		panel1.add(newButton);
	
		add(panel1);
	}
	
	public void actionPerformed(ActionEvent e) 
	{		
		String buttonString = e.getActionCommand();
		
		if(buttonString.equals("로그인"))
		{
			NAME = namefield.getText();
			PASSWORD = passwordfield.getText();
			MainUser = Login.loadFile(NAME,PASSWORD);			
		}
		
		else
		{
			GUI_Regis g = new GUI_Regis();
		}
	
	}
	
	public static void main(String[] args)
	{	
		mainwindow.setVisible(true);
	}
	
}
