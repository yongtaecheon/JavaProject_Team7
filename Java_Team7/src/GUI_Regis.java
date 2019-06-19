import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GUI_Regis extends JFrame implements ActionListener{

	public static String NAME;
	public static String PASSWORD;
	public static Double HEIGHT;
	public static Double WEIGHT;
	public static String GENDER;
	
	private static JPanel MyPanel = new JPanel();
	
	private static JLabel TitleLabel = new JLabel("신규 회원 정보");
	
	private static JLabel NameLabel = new JLabel("Name");
	private static JLabel PasswordLabel = new JLabel("Password");
	private static JLabel HeightLabel = new JLabel("Height");
	private static JLabel WeightLabel = new JLabel("Weight");
	private static JLabel GenderLabel = new JLabel("Gender");
	
	private static JTextField NameField = new JTextField();
	private static JPasswordField PasswordField = new JPasswordField();
	private static JTextField HeightField = new JTextField();
	private static JTextField WeightField = new JTextField();
	private static JCheckBox GenderField1 = new JCheckBox("남자");
	private static JCheckBox GenderField2 = new JCheckBox("여자");
	
	private static JButton FinishButton = new JButton("회원 가입 완료");
	
	public GUI_Regis()
	{
		super("신규 회원 정보 등록");
		setBounds(400,300,300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel.setLayout(null);
		
		TitleLabel.setBounds(30,10,200,20);//제목
		MyPanel.add(TitleLabel);
		NameLabel.setBounds(30,40,50,20);//이름
		MyPanel.add(NameLabel);	
		PasswordLabel.setBounds(30,70,70,20);//비밀번호
		MyPanel.add(PasswordLabel);	
		HeightLabel.setBounds(30,100,50,20);//키
		MyPanel.add(HeightLabel);	
		WeightLabel.setBounds(30,130,50,20);//몸무게
		MyPanel.add(WeightLabel);	
		GenderLabel.setBounds(30,160,50,20);//성별
		MyPanel.add(GenderLabel);
		
		NameField.setBounds(150,40,120,20);//이름 입력
		MyPanel.add(NameField);
		PasswordField.setBounds(150,70,120,20);//비밀번호 입력
		MyPanel.add(PasswordField);
		HeightField.setBounds(150,100,120,20);//키 입력
		MyPanel.add(HeightField);
		WeightField.setBounds(150,130,120,20);//몸무게 입력
		MyPanel.add(WeightField);
		GenderField1.setBounds(145,160,55,20);//성별 선택
		GenderField2.setBounds(200,160,55,20);
		MyPanel.add(GenderField1);
		MyPanel.add(GenderField2);
		FinishButton.setBounds(70,200,140,30);
		FinishButton.addActionListener(this);
		MyPanel.add(FinishButton);
		
		add(MyPanel);
	}

	public void actionPerformed(ActionEvent e)
	{
		NAME = NameField.getText();
		PASSWORD = PasswordField.getText();
		HEIGHT = Double.parseDouble(HeightField.getText());
		WEIGHT = Double.parseDouble(WeightField.getText());
		
		if(GenderField1.isSelected())
			GENDER = "m";
		else
			GENDER = "f";
		
		GUI_Login.MainUser = Login.createFile(NAME, PASSWORD, HEIGHT, WEIGHT, GENDER);
		
		GUI_Ok o = new GUI_Ok();// 회원 가입 완료 창
		dispose();
		GUI_Login.mainwindow.setVisible(false); // 회원 가입 후 로그인 창 닫기
	}
	
	public class GUI_Ok extends JFrame implements ActionListener
	{
		public GUI_Ok() {
			setSize(350,200);
			setVisible(true);
			setLayout(null);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			
			JLabel text = new JLabel("회원 등록을 성공적으로 완료하였습니다!");
			text.setBounds(60, 50, 250, 20);
			add(text);
			
			JButton exitButton = new JButton("확인");
			exitButton.setBounds(140,90,60,40);
			exitButton.addActionListener(this);
			add(exitButton);
			
		}

		public void actionPerformed(ActionEvent e)
		{
			dispose();
			GUI_MainScreen m = new GUI_MainScreen();
			m.setVisible(true);
		}
	}
	
}
