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
		//System.out.println("키(m) 몸무게(kg) 성별(m/f) 입력:");
		//keyboard부분을 gettext로 바꾸어 입력.
		u.setName(name);
		u.setHeight(height);
		u.setWeight(weight);
		u.setGender(gender); 
		u.setBMI(u.getHeight(), u.getWeight());
		outputStream.println("<키>"); outputStream.println(u.getHeight());
		outputStream.println("<몸무게>"); outputStream.println(u.getWeight());
		outputStream.println("<성별>"); outputStream.println(u.getGender());
		outputStream.println("<BMI지수>"); outputStream.println(u.getBMI());
		outputStream.println("<음식>"); 	
		outputStream.close();
		
		return u;
	}
	//이미 있으면 불러오고 없으면 새로운 텍스트 파일을 생성
	public static void loadFile(String name, String password) {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(name+".txt"));
			u.setName(name);
			String scan_password = inputStream.next();
				if(scan_password.equals(password)) {
					if(inputStream.next().equals("<키>")) {
						u.setHeight(inputStream.nextDouble());	
					}
					if(inputStream.next().equals("<몸무게>")) {
						u.setWeight(inputStream.nextDouble());
					}
					if(inputStream.next().equals("<성별>")) {
						u.setGender(inputStream.next());
					}
					if(inputStream.next().equals("<BMI지수>")) {
						u.setBMI(inputStream.nextDouble());
					}
					if(inputStream.next().equals("<음식>")) {
						while(inputStream.hasNext()) {
							u.setFood(inputStream.next());
						}
					}

					GUI_Login.MainUser = u;
					GUI_MainScreen m = new GUI_MainScreen();
					
				}	
				else // 비밀번호 틀렸을 때
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
