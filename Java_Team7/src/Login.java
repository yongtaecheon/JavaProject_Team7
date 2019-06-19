import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login{
	
	static User u = new User();
	static Scanner keyboard = new Scanner(System.in);
	
	public static User createFile(String name, String password, double height, double weight, String gender) {
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
		u.setName(name);
		u.setHeight(height);
		u.setWeight(weight);
		u.setGender(gender); 
		u.setBMI(u.getHeight(), u.getWeight());
		outputStream.println("<Ű>"); outputStream.println(u.getHeight());
		outputStream.println("<������>"); outputStream.println(u.getWeight());
		outputStream.println("<����>"); outputStream.println(u.getGender());
		outputStream.println("<BMI����>"); outputStream.println(u.getBMI());
		outputStream.println("<����>"); 	
		outputStream.close();
		
		return u;
	}
	//�̹� ������ �ҷ����� ������ ���ο� �ؽ�Ʈ ������ ����
	public static void loadFile(String name, String password) {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(name+".txt"));
			u.setName(name);
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
					if(inputStream.next().equals("<BMI����>")) {
						u.setBMI(inputStream.nextDouble());
					}
					if(inputStream.next().equals("<����>")) {
						while(inputStream.hasNext()) {
							u.setFood(inputStream.next());
						}
					}

					GUI_Login.MainUser = u;
					GUI_MainScreen m = new GUI_MainScreen();
					
				}	
				else // ��й�ȣ Ʋ���� ��
				{
					GUI_LoginFail f = new GUI_LoginFail();
				}
				
			inputStream.close();
		}
		catch(FileNotFoundException e)
		{
			GUI_LoginFail f = new GUI_LoginFail();
		}
		
	}

	
}
