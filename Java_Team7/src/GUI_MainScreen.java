
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI_MainScreen extends JFrame implements ActionListener{
		
	
	private JPanel AddFoodPanel = new JPanel();
	private JPanel ManagePanel = new JPanel();
	private JPanel ExercisePanel = new JPanel();
	private JPanel CalDictionPanel = new JPanel(); 
	
	private JLabel Heightlabel = new JLabel("키");
	private JLabel Weightlabel = new JLabel("몸무게");
	private JLabel BMIlabel = new JLabel("BMI");
	private JLabel Genderlabel = new JLabel("성별 ");
	
	private JLabel myHeightlabel = new JLabel(GUI_Login.MainUser.getHeight()+"Cm");
	private JLabel myWeightlabel = new JLabel(GUI_Login.MainUser.getWeight()+"Kg");
	private JLabel myBMIlabel = new JLabel(GUI_Login.MainUser.getBMI()+"");
	private JLabel myGenderlabel = new JLabel(GUI_Login.MainUser.getGender_Korean());
	
	private JLabel manage = new JLabel(); // 식단 관리
	private JLabel BMImanage = new JLabel(GUI_Login.MainUser.calculateBMI());
	private JLabel Nutmanage = new JLabel();   
	
	private JTextField BField = new JTextField();
	private JTextField LField = new JTextField();
	private JTextField DField = new JTextField();
	
	private Font font = new Font("SansSerif", Font.BOLD, 10);
			
	ImageIcon I1 = new ImageIcon("Plus.png");
    Image errorimg = I1.getImage();
    Image changedimg = errorimg.getScaledInstance(20,20, Image.SCALE_SMOOTH);
    ImageIcon icon = new ImageIcon(changedimg); 
    
    
    ImageIcon b1t1 = new ImageIcon("addfood.png");
    Image b1img = b1t1.getImage();
    Image changedimg1 = b1img.getScaledInstance(120,120, Image.SCALE_SMOOTH);
    ImageIcon ButtonIcon1 = new ImageIcon(changedimg1); 
    
    ImageIcon b2t1 = new ImageIcon("management.png");
    Image b2img = b2t1.getImage();
    Image changedimg2 = b2img.getScaledInstance(120,120, Image.SCALE_SMOOTH);
    ImageIcon ButtonIcon2 = new ImageIcon(changedimg2); 

    ImageIcon b3t1 = new ImageIcon("Exercise.png");
    Image b3img = b3t1.getImage();
    Image changedimg3 = b3img.getScaledInstance(120,120, Image.SCALE_SMOOTH);
    ImageIcon ButtonIcon3 = new ImageIcon(changedimg3); 
    
    ImageIcon b4t1 = new ImageIcon("fooddictionary.png");
    Image b4img = b4t1.getImage();
    Image changedimg4 = b4img.getScaledInstance(120,120, Image.SCALE_SMOOTH);
    ImageIcon ButtonIcon4 = new ImageIcon(changedimg4); 
    
	public GUI_MainScreen()
	{
		super("식단 관리 프로그램");
		setSize(1200,650);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		//로고 추가
		ImageIcon icon2 = new ImageIcon("Yodamain.png");
		JPanel LogoPanel = new JPanel() {
		public void paintComponent(Graphics g) {
    		Dimension d = getSize();
    		g.drawImage(icon2.getImage(), 0, 0, d.width, d.height, null);	
    		setOpaque(false);
    		super.paintComponent(g);
    	}
		};
		LogoPanel.setBounds(870, 400, 300, 200);
		add(LogoPanel);
		//
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setBackground(Color.WHITE);
		ButtonPanel.setLayout(null);
		ButtonPanel.setBounds(0,0,150,650);
		JButton AddFoodButton = new JButton("1");
		JButton ManageButton = new JButton("2");
		JButton ExerciseButton = new JButton("3");
		JButton CalDictionButton = new JButton("4");
		
		
		AddFoodButton.setBounds(0,0,150,150);		
		AddFoodButton.setIcon(ButtonIcon1);
		//AddFoodButton.setPreferredSize(new Dimension(45,28));
		AddFoodButton.setBorderPainted(false);
		AddFoodButton.setFocusPainted(false);
		AddFoodButton.setContentAreaFilled(false);
		AddFoodButton.addActionListener(this);
		ButtonPanel.add(AddFoodButton);
		
		ManageButton.setBounds(0,150,150,150);
		ManageButton.setIcon(ButtonIcon2);
		ManageButton.setPreferredSize(new Dimension(45,28));
		ManageButton.setBorderPainted(false);
		ManageButton.setFocusPainted(false);
		ManageButton.setContentAreaFilled(false);
		ManageButton.addActionListener(this);
		ButtonPanel.add(ManageButton);
		
		ExerciseButton.setBounds(0,300,150,150);
		ExerciseButton.setIcon(ButtonIcon3);
		ExerciseButton.setPreferredSize(new Dimension(45,28));
		ExerciseButton.setBorderPainted(false);
		ExerciseButton.setFocusPainted(false);
		ExerciseButton.setContentAreaFilled(false);
		ExerciseButton.addActionListener(this);
		ButtonPanel.add(ExerciseButton);
		
		CalDictionButton.setBounds(0,450,150,150);
		CalDictionButton.setIcon(ButtonIcon4);
		CalDictionButton.setPreferredSize(new Dimension(45,28));
		CalDictionButton.setBorderPainted(false);
		CalDictionButton.setFocusPainted(false);
		CalDictionButton.setContentAreaFilled(false);
		CalDictionButton.addActionListener(this);
		ButtonPanel.add(CalDictionButton);
		
		add(ButtonPanel);
		
		// 음식 추가 Panel
		AddFoodPanel.setBounds(150, 0, 700, 650);
		AddFoodPanel.setLayout(new BorderLayout());
		AddFoodPanel.setVisible(false);
		
		JPanel FoodinnerPanel = new JPanel();
		FoodinnerPanel.setLayout(null);
		FoodinnerPanel.setBackground(Color.WHITE);
		JLabel Breakfast = new JLabel("아침");
		Breakfast.setBounds(100, 200, 40, 20);
		FoodinnerPanel.add(Breakfast);
		BField.setBounds(300, 200, 70, 20);
		FoodinnerPanel.add(BField);
		JButton P1Button = new JButton(); // 추가 아이콘
		P1Button.setBounds(380, 200, 20, 20);
		P1Button.setIcon(icon);
		P1Button.setPreferredSize(new Dimension(150,150));
		P1Button.setBorderPainted(false);
		P1Button.setFocusPainted(false);
		P1Button.setContentAreaFilled(false);
		P1Button.addActionListener(new Plus1Action());//버튼 누르기
		FoodinnerPanel.add(P1Button);
		
		JLabel Lunch = new JLabel("점심");
		Lunch.setBounds(100, 300, 40, 20);
		FoodinnerPanel.add(Lunch);
		LField.setBounds(300, 300, 70, 20);
		FoodinnerPanel.add(LField);
		JButton P2Button = new JButton(); // 추가 아이콘
		P2Button.setBounds(380, 300, 20, 20);
		P2Button.setIcon(icon);
		P2Button.setPreferredSize(new Dimension(45,28));
		P2Button.setBorderPainted(false);
		P2Button.setFocusPainted(false);
		P2Button.setContentAreaFilled(false);
		P2Button.addActionListener(new Plus2Action()); //버튼 누르기
		FoodinnerPanel.add(P2Button);
		
		JLabel Dinner = new JLabel("저녁");
		Dinner.setBounds(100, 400, 40, 20);
		FoodinnerPanel.add(Dinner);
		DField.setBounds(300, 400, 70, 20);
		FoodinnerPanel.add(DField);
		JButton P3Button = new JButton(); // 추가 아이콘
		P3Button.setBounds(380, 400, 20, 20);
		P3Button.setIcon(icon);
		P3Button.setPreferredSize(new Dimension(45,28));
		P3Button.setBorderPainted(false);
		P3Button.setFocusPainted(false);
		P3Button.setContentAreaFilled(false);
		P3Button.addActionListener(new Plus3Action()); // 버튼 누르기
		FoodinnerPanel.add(P3Button);
		
		AddFoodPanel.add(FoodinnerPanel);
		add(AddFoodPanel);
		
		// 식단 관리 Panel
		ManagePanel.setBounds(150, 0, 700, 650);
		ManagePanel.setBackground(Color.WHITE);
		ManagePanel.setVisible(false);
		ManagePanel.setLayout(null);
		add(ManagePanel);
      
        JLabel Manage = new JLabel("오늘 하루의 평가 :");
        JLabel Bmi = new JLabel("현재 몸상태    : ");
        JLabel Nut = new JLabel("영양소 섭취량: ");
        
        Manage.setBounds(90,100,150,100); //x, y , width, height
        manage.setBounds(200, 100, 500, 100);
        manage.setText(FoodManagemnet.showCal(GUI_Login.MainUser));// 칼로리 메세지
        
        Nut.setBounds(90,250,150,100);
        Nutmanage.setBounds(200,250,500,100);
        Nutmanage.setText(FoodManagemnet.getNutrient(GUI_Login.MainUser));
        
        Bmi.setBounds(90,400,100,100);
        BMImanage.setBounds(250,400,500,100);
        
        ManagePanel.add(Nut);
        ManagePanel.add(Nutmanage);
        ManagePanel.add(Manage);//오늘 하루 섭취한 calory,권장칼로리
        ManagePanel.add(manage);
        ManagePanel.add(Bmi);// 자신의 BMI와 몸상태 판단
        ManagePanel.add(BMImanage);
        add(ManagePanel);
     
		
		// 운동 Panel
		ExercisePanel.setBounds(150, 0, 700, 650);
		ExercisePanel.setBackground(Color.WHITE);
		ExercisePanel.setLayout(new BorderLayout());
		ExercisePanel.setVisible(false);
		GUI_Sports s = new GUI_Sports();
		ExercisePanel.add(GUI_Sports.SportsPanel, BorderLayout.CENTER);
		add(ExercisePanel);	
		
		// 칼로리 사전 Panel
		CalDictionPanel.setBounds(150, 0, 700, 650);
		CalDictionPanel.setBackground(Color.WHITE);
		CalDictionPanel.setVisible(false);
		CaloryDic c = new CaloryDic();
		CalDictionPanel.add(CaloryDic.Panel);
		add(CalDictionPanel);
	
		// 내 정보 패널
		ImageIcon usericon = new ImageIcon(GUI_AddPicture.filePath);
		JPanel PicPanel = new JPanel(){
			public void paintComponent(Graphics g) {
	    		Dimension d2 = getSize();
	    		g.drawImage(usericon.getImage(), 0, 0, d2.width, d2.height, null);	
	    		setOpaque(false);
	    		super.paintComponent(g);
	    	}
			};
		PicPanel.setBounds(910, 10, 200, 200);
		add(PicPanel);
		
		Heightlabel.setBounds(900, 220, 70, 20);
		myHeightlabel.setBounds(1050, 220, 70, 20);
		add(Heightlabel);
		add(myHeightlabel);
		
	    Weightlabel.setBounds(900, 270, 70, 20);
	    myWeightlabel.setBounds(1050, 270, 70, 20);
	    add(Weightlabel);
	    add(myWeightlabel);
	    
	  	BMIlabel.setBounds(900, 320, 70, 20);
	    myBMIlabel.setBounds(1050, 320, 70, 20);
	    add(BMIlabel); 
	    add(myBMIlabel);
	    
	    Genderlabel.setBounds(900, 370, 70, 20);
	    myGenderlabel.setBounds(1050, 370, 70, 20);
	    add(Genderlabel);
	    add(myGenderlabel);
	    
	    
	    GUI_Login.mainwindow.dispose();
		setVisible(true);
		
	}

	private class Plus1Action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String food = BField.getText();
			FoodManagemnet.addFood(GUI_Login.MainUser.getName(), food);
			GUI_Login.MainUser.setFood(food);
			manage.setText(FoodManagemnet.showCal(GUI_Login.MainUser));
			Nutmanage.setText(FoodManagemnet.getNutrient(GUI_Login.MainUser));
			BField.setText("");
		}
	}
	
	private class Plus2Action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String food = LField.getText();
			FoodManagemnet.addFood(GUI_Login.MainUser.getName(), food);
			GUI_Login.MainUser.setFood(food);
			manage.setText(FoodManagemnet.showCal(GUI_Login.MainUser));
			Nutmanage.setText(FoodManagemnet.getNutrient(GUI_Login.MainUser));
			LField.setText("");
		}
	}
	
	private class Plus3Action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String food = DField.getText();
			FoodManagemnet.addFood(GUI_Login.MainUser.getName(), food);
			GUI_Login.MainUser.setFood(food);
			manage.setText(FoodManagemnet.showCal(GUI_Login.MainUser));
			Nutmanage.setText(FoodManagemnet.getNutrient(GUI_Login.MainUser));
			DField.setText("");
		}
	}

	
	public void actionPerformed(ActionEvent e)
	{
		String ButtonString = e.getActionCommand();
	
		if(ButtonString.contentEquals("1"))
		{
			AddFoodPanel.setVisible(true);
			ManagePanel.setVisible(false);
			ExercisePanel.setVisible(false);
			CalDictionPanel.setVisible(false);
		}
		
		else if(ButtonString.contentEquals("2"))
		{
			AddFoodPanel.setVisible(false);
			ManagePanel.setVisible(true);
			ExercisePanel.setVisible(false);
			CalDictionPanel.setVisible(false);
		}
		
		else if(ButtonString.contentEquals("3"))
		{
			AddFoodPanel.setVisible(false);
			ManagePanel.setVisible(false);
			ExercisePanel.setVisible(true);
			CalDictionPanel.setVisible(false);
		}
		
		else
		{
			AddFoodPanel.setVisible(false);
			ManagePanel.setVisible(false);
			ExercisePanel.setVisible(false);
			CalDictionPanel.setVisible(true);
		}		
	}
}
