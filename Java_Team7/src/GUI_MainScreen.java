
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
