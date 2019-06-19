
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI_MainScreen extends JFrame implements ActionListener{
	
	
	private JPanel AddFoodPanel = new JPanel();
	private JPanel ManagePanel = new JPanel();
	private JPanel ExercisePanel = new JPanel();
	private JPanel CalDictionPanel = new JPanel(); 
	
	public GUI_MainScreen()
	{
		super("식단 관리 프로그램");
		setSize(1200,650);
		
		setLayout(null);
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setLayout(null);
		ButtonPanel.setBounds(0,0,150,650);
		JButton AddFoodButton = new JButton("음식 추가");
		JButton ManageButton = new JButton("식단 관리");
		JButton ExerciseButton = new JButton("운동");
		JButton CalDictionButton = new JButton("칼로리 사전");
		
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
		
		// 음식 추가 Panel
		AddFoodPanel.setBounds(150, 0, 700, 650);
		AddFoodPanel.setBackground(Color.RED);
		add(AddFoodPanel);
		
		// 식단 관리 Panel
		ManagePanel.setBounds(150, 0, 700, 650);
		ManagePanel.setBackground(Color.YELLOW);
		add(ManagePanel);
		
		// 운동 Panel
		ExercisePanel.setBounds(150, 0, 700, 650);
		ExercisePanel.setBackground(Color.WHITE);
		add(ExercisePanel);
		
		// 칼로리 사전 Panel
		CalDictionPanel.setBounds(150, 0, 700, 650);
		CalDictionPanel.setBackground(Color.GREEN);
		add(CalDictionPanel);
	
		JPanel InfoPanel = new JPanel(); // 내 정보 패널
		InfoPanel.setBounds(850, 0, 350, 650);
		InfoPanel.setLayout(null);
		
		
		JLabel Heightlabel = new JLabel("키");
		Heightlabel.setBounds(900, 380, 20, 20);
		InfoPanel.add(Heightlabel);
	    
		JLabel Weightlabel = new JLabel("몸무게");
	    Weightlabel.setBounds(900, 410, 20, 20);
	    InfoPanel.add(Weightlabel);
	    
	    JLabel BMIlabel = new JLabel("BMI");
	    BMIlabel.setBounds(900, 430, 20, 20);
	    InfoPanel.add(BMIlabel);
	    
	    JLabel Genderlabel = new JLabel("성별 ");
	    Genderlabel.setBounds(900, 460, 20, 20);
	    InfoPanel.add(Genderlabel);
	    
		
	    add(InfoPanel);
		
		
	}
	
	public static void main(String[] args)
	{
		GUI_MainScreen m = new GUI_MainScreen();
		m.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		String ButtonString = e.getActionCommand();
	
		if(ButtonString.contentEquals("음식 추가"))
		{
			AddFoodPanel.setVisible(true);
			ManagePanel.setVisible(false);
			ExercisePanel.setVisible(false);
			CalDictionPanel.setVisible(false);
		}
		
		else if(ButtonString.contentEquals("식단 관리"))
		{
			AddFoodPanel.setVisible(false);
			ManagePanel.setVisible(true);
			ExercisePanel.setVisible(false);
			CalDictionPanel.setVisible(false);
		}
		
		else if(ButtonString.contentEquals("운동"))
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
