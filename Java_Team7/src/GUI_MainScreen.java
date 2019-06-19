
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI_MainScreen extends JFrame implements ActionListener{
	
	
	private JPanel AddFoodPanel = new JPanel();
	private JPanel ManagePanel = new JPanel();
	private JPanel ExercisePanel = new JPanel();
	private JPanel CalDictionPanel = new JPanel(); 
	
	private JLabel Heightlabel = new JLabel("Ű");
	private JLabel Weightlabel = new JLabel("������");
	private JLabel BMIlabel = new JLabel("BMI");
	private JLabel Genderlabel = new JLabel("���� ");
	
	private JLabel myHeightlabel = new JLabel(GUI_Login.MainUser.getHeight()+"Cm");
	private JLabel myWeightlabel = new JLabel(GUI_Login.MainUser.getWeight()+"Kg");
	private JLabel myBMIlabel = new JLabel(GUI_Login.MainUser.getBMI()+"");
	private JLabel myGenderlabel = new JLabel(GUI_Login.MainUser.getGender_Korean());
	
	private JTextField BField = new JTextField();
	private JTextField LField = new JTextField();
	private JTextField DField = new JTextField();
	
	
	ImageIcon I1 = new ImageIcon("C:\\Users\\USER\\Desktop\\Plus.png");
    Image errorimg = I1.getImage();
    Image changedimg = errorimg.getScaledInstance(20,20, Image.SCALE_SMOOTH);
    ImageIcon icon = new ImageIcon(changedimg);  
   
	
	public GUI_MainScreen()
	{
		super("�Ĵ� ���� ���α׷�");
		setSize(1200,650);
		
		setLayout(null);
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setLayout(null);
		ButtonPanel.setBounds(0,0,150,650);
		JButton AddFoodButton = new JButton("���� �߰�");
		JButton ManageButton = new JButton("�Ĵ� ����");
		JButton ExerciseButton = new JButton("�");
		JButton CalDictionButton = new JButton("Į�θ� ����");
		
		ButtonPanel.add(AddFoodButton);
		AddFoodButton.setBounds(0,0,150,150);
		AddFoodButton.addActionListener(this);
		
		ButtonPanel.add(ManageButton);
		ManageButton.setBounds(0,150,150,150);
		ManageButton.addActionListener(this);
		
		ButtonPanel.add(ExerciseButton);
		ExerciseButton.setBounds(0,300,150,150);
		ExerciseButton.addActionListener(this);
		
		ButtonPanel.add(CalDictionButton);
		CalDictionButton.setBounds(0,450,150,150);
		CalDictionButton.addActionListener(this);
		
		add(ButtonPanel);
		
		// ���� �߰� Panel
		AddFoodPanel.setBounds(150, 0, 700, 650);
		AddFoodPanel.setBackground(Color.RED);
		AddFoodPanel.setLayout(new BorderLayout());
		
		JPanel FoodinnerPanel = new JPanel();
		//FoodinnerPanel.setSize(700,650);
		FoodinnerPanel.setLayout(null);
		
		JLabel Breakfast = new JLabel("��ħ");
		Breakfast.setBounds(100, 200, 40, 20);
		FoodinnerPanel.add(Breakfast);
		BField.setBounds(300, 200, 70, 20);
		FoodinnerPanel.add(BField);
		JButton P1Button = new JButton(); // �߰� ������
		P1Button.setBounds(380, 200, 20, 20);
		P1Button.setIcon(icon);
		P1Button.setPreferredSize(new Dimension(45,28));
		P1Button.setBorderPainted(false);
		P1Button.setFocusPainted(false);
		P1Button.setContentAreaFilled(false);
		P1Button.addActionListener(new Plus1Action());//��ư ������
		FoodinnerPanel.add(P1Button);
		
		JLabel Lunch = new JLabel("����");
		Lunch.setBounds(100, 300, 40, 20);
		FoodinnerPanel.add(Lunch);
		LField.setBounds(300, 300, 70, 20);
		FoodinnerPanel.add(LField);
		JButton P2Button = new JButton(); // �߰� ������
		P2Button.setBounds(380, 300, 20, 20);
		P2Button.setIcon(icon);
		P2Button.setPreferredSize(new Dimension(45,28));
		P2Button.setBorderPainted(false);
		P2Button.setFocusPainted(false);
		P2Button.setContentAreaFilled(false);
		P2Button.addActionListener(new Plus2Action()); //��ư ������
		FoodinnerPanel.add(P2Button);
		
		JLabel Dinner = new JLabel("����");
		Dinner.setBounds(100, 400, 40, 20);
		FoodinnerPanel.add(Dinner);
		DField.setBounds(300, 400, 70, 20);
		FoodinnerPanel.add(DField);
		JButton P3Button = new JButton(); // �߰� ������
		P3Button.setBounds(380, 400, 20, 20);
		P3Button.setIcon(icon);
		P3Button.setPreferredSize(new Dimension(45,28));
		P3Button.setBorderPainted(false);
		P3Button.setFocusPainted(false);
		P3Button.setContentAreaFilled(false);
		P3Button.addActionListener(new Plus3Action()); // ��ư ������
		FoodinnerPanel.add(P3Button);
		
		AddFoodPanel.add(FoodinnerPanel);
		add(AddFoodPanel);
		
		// �Ĵ� ���� Panel
		ManagePanel.setBounds(150, 0, 700, 650);
		ManagePanel.setBackground(Color.YELLOW);
		add(ManagePanel);
		
		// � Panel
		ExercisePanel.setBounds(150, 0, 700, 650);
		ExercisePanel.setBackground(Color.WHITE);
		add(ExercisePanel);	
		
		// Į�θ� ���� Panel
		CalDictionPanel.setBounds(150, 0, 700, 650);
		CalDictionPanel.setBackground(Color.GREEN);
		add(CalDictionPanel);
	
		// �� ���� �г�
		Heightlabel.setBounds(900, 250, 70, 20);
		myHeightlabel.setBounds(1050, 250, 70, 20);
		add(Heightlabel);
		add(myHeightlabel);
		
	    Weightlabel.setBounds(900, 300, 70, 20);
	    myWeightlabel.setBounds(1050, 300, 70, 20);
	    add(Weightlabel);
	    add(myWeightlabel);
	    
	  	BMIlabel.setBounds(900, 350, 70, 20);
	    myBMIlabel.setBounds(1050, 350, 70, 20);
	    add(BMIlabel); 
	    add(myBMIlabel);
	    
	    Genderlabel.setBounds(900, 400, 70, 20);
	    myGenderlabel.setBounds(1050, 400, 70, 20);
	    add(Genderlabel);
	    add(myGenderlabel);
	    
		setVisible(true);
		
	}

	private class Plus1Action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String food = BField.getText();
			FoodManagemnet.addFood(GUI_Login.MainUser.getName(), food);
			BField.setText("");
		}
	}
	
	private class Plus2Action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String food = LField.getText();
			FoodManagemnet.addFood(GUI_Login.MainUser.getName(), food);
			LField.setText("");
		}
	}
	
	private class Plus3Action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String food = DField.getText();
			FoodManagemnet.addFood(GUI_Login.MainUser.getName(), food);
			DField.setText("");
		}
	}

	
	public void actionPerformed(ActionEvent e)
	{
		String ButtonString = e.getActionCommand();
	
		if(ButtonString.contentEquals("���� �߰�"))
		{
			AddFoodPanel.setVisible(true);
			ManagePanel.setVisible(false);
			ExercisePanel.setVisible(false);
			CalDictionPanel.setVisible(false);
		}
		
		else if(ButtonString.contentEquals("�Ĵ� ����"))
		{
			AddFoodPanel.setVisible(false);
			ManagePanel.setVisible(true);
			ExercisePanel.setVisible(false);
			CalDictionPanel.setVisible(false);
		}
		
		else if(ButtonString.contentEquals("�"))
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
