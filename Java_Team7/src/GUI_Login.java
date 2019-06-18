import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_Login extends JFrame implements ActionListener{

	public static String NAME;
	public static String PASSWORD;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 400;
	
	private JTextField name;
	private JPasswordField password;
	public GUI_Login()
	{
		super("식단 관리 프로그램");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		getContentPane().setBackground(Color.white);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\USER\\Desktop\\mic.jpg");
				
		JPanel panel1 = new JPanel();    
		panel1.setLayout(new BorderLayout());
		JLabel label1 = new JLabel();
		label1.setIcon(icon);
		panel1.add(label1);
		panel1.setBackground(Color.white);
		
		JPanel logpanel = new JPanel();
		logpanel.setLayout(new GridLayout(2,1));
		
		JPanel namepanel = new JPanel();
		namepanel.setLayout(new FlowLayout());
		
		JPanel pwpanel = new JPanel();
		pwpanel.setLayout(new FlowLayout());
		
		JLabel namelabel = new JLabel("Name        ");
		JLabel pwlabel = new JLabel("PassWord");
		name = new JTextField(10);
		//add
		password = new JPasswordField(10);
		//add
		JPanel ButtonPanel = new JPanel(new FlowLayout());
		JButton loginButton = new JButton("Log-In");
		loginButton.addActionListener(this);
		
		ButtonPanel.setBackground(Color.white);
		ButtonPanel.add(loginButton);
		
		namepanel.add(namelabel);
		namepanel.add(name);
		
		pwpanel.add(pwlabel);
		pwpanel.add(password);
		
		logpanel.add(namepanel);
		logpanel.add(pwpanel);
		
		namepanel.setBackground(Color.white);
		pwpanel.setBackground(Color.white);
		
		add(panel1);		
		add(logpanel);
		add(ButtonPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		NAME = name.getText();
		PASSWORD = password.getText();
		
	}
	
	public static void main(String[] args)
	{
		GUI_Login g = new GUI_Login();
		g.setVisible(true);
		
		
	}

	

	
}
