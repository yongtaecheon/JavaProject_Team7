import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.*;

public class Login{
	static User u = new User();
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String args[]) {
		System.out.print("Enter Username: ");
		String name = keyboard.next();
		System.out.print("Enter Password: ");
		String password = keyboard.next();
		loadFile(name, password);
		addFood(name);
		System.out.println(getCal(name));
	}
	public static double getCal(String name) {//name.txt������ ������ �а� Į�θ��� ����Ͽ� ���
		Food f = new Food();
		f.readFoodFile();
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(name+".txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening the File.");
		}
		while(inputStream.hasNextLine()) {
			if(inputStream.next().equals("<����>")){
				break;
			}
		}
		while(inputStream.hasNext()) {
			u.setFood(inputStream.next());
		}
		//Į�θ����
		for(int i = 0; i < u.foodsize; i++) {
			for(int j = 0; j < 50; j++) {
				if((u.food[i]).equals(f.food[j].getName())) {
					u.calory+= f.food[j].getKcal();
				}
			}
		}
		inputStream.close();
		return u.calory;
	}
	
	public static void addFood(String name) {//append���� ������ ������ ��� ������ �߰�
		PrintWriter outputStream = null;
		try{
			outputStream = new PrintWriter(new FileOutputStream(name+".txt", true));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening the File.");
		}
		System.out.println("���� �̸� �Է�:");
		while(true) {
			String input = keyboard.next();
			if(input.equals("��")) {
				break;
			}
			outputStream.println(input);
		}
		outputStream.close();
	}
	
	public static void createFile(String name, String password) {
		PrintWriter outputStream  = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(name+".txt"));
		}
		catch(FileNotFoundException e2) {
			System.out.println("Error opening the File.");
		}
		outputStream.println(password);
		//System.out.println("Ű(m) ������(kg) ����(m/f) �Է�:");
		//keyboard�κ��� gettext�� �ٲپ� �Է�.
		u.setHeight(keyboard.nextDouble());
		u.setWeight(keyboard.nextDouble());
		u.setGender(keyboard.next()); 
		u.setBMI(u.getHeight(), u.getWeight());
		outputStream.println("<Ű>"); outputStream.println(u.getHeight());
		outputStream.println("<������>"); outputStream.println(u.getWeight());
		outputStream.println("<����>"); outputStream.println(u.getGender());
		outputStream.println("<BMI����>"); outputStream.println(u.getBMI());
		outputStream.println("<����>"); 
		outputStream.close();
	}
	//�̹� ������ �ҷ����� ������ ���ο� �ؽ�Ʈ ������ ����
	public static User loadFile(String name, String password) {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(name+".txt"));
			String scan_password = inputStream.next();
				if(scan_password.equals(password)) {
					if(inputStream.next().equals("<Ű>")) {
						u.setHeight(inputStream.nextDouble());	
					}
					if(inputStream.next().equals("<������>")) {
						u.setWeight(inputStream.nextDouble());
					}
					if(inputStream.next().equals("<����>")) {
						u.setGender(inputStream.next());
					}
					if(inputStream.next().equals("<BMI>")) {
						u.setBMI(inputStream.nextDouble());
					}
					if(inputStream.next().equals("<����>")) {
						while(inputStream.hasNextLine()) {
							u.setFood(inputStream.next());
						}
					}
				}
				else {
						FailPW f=new FailPW();
						f.setVisible(true);
				}
			inputStream.close();
		}
		catch(FileNotFoundException e){
			AddFile a = new AddFile();
			a.setVisible(true);
			//createFile(name, password);
		}
		return u;
	}
	
	public static class FailPW extends JFrame{
		public FailPW()
		{
			setSize(250,150);
			setLayout(new BorderLayout());
			getContentPane().setBackground(Color.RED);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JLabel text = new JLabel("             �߸��� ��й�ȣ �Դϴ�!");
			add(text,BorderLayout.CENTER);
		}
	}

	public static class AddFile extends JFrame{
		public AddFile()
		{
			setSize(300,500);
			setLayout(new BorderLayout());
			getContentPane().setBackground(Color.WHITE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel text = new JLabel("���ο� ������̱���! ������ �����ϰڽ��ϴ�.");
			
			JPanel userpanel = new JPanel(new GridLayout(3,1));
			
			JPanel heightpanel = new JPanel(new FlowLayout());
			JLabel heightlabel = new JLabel("Ű");
			JTextField heighttext = new JTextField(10);
			
			JPanel weightpanel = new JPanel(new FlowLayout());
			JLabel weightlabel = new JLabel("������");
			JTextField weighttext = new JTextField(10);

			JPanel genderpanel = new JPanel(new FlowLayout());
			JLabel genderlabel = new JLabel("����(��:m / ��:f)");
			JTextField gendertext = new JTextField(10);			
			
			heightpanel.add(heightlabel);
			heightpanel.add(heighttext);
			weightpanel.add(weightlabel);
			weightpanel.add(weighttext);	
			genderpanel.add(genderlabel);
			genderpanel.add(gendertext);
			
			
			
			userpanel.add(heightpanel);
			userpanel.add(weightpanel);
			userpanel.add(genderpanel);
			
			add(text,BorderLayout.NORTH);
			add(userpanel,BorderLayout.CENTER);
			
		}
	}
}
