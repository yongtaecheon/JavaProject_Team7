import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login{
	
	static User u = new User();
	static Scanner keyboard = new Scanner(System.in);
	
	public static double getCal(String name) {//name.txt파일의 음식을 읽고 칼로리르 계산하여 출력
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
			if(inputStream.next().equals("<음식>")){
				break;
			}
		}
		while(inputStream.hasNext()) {
			u.setFood(inputStream.next());
		}
		//칼로리계산
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
	
	public static void addFood(String name) {//append모드로 기존의 파일을 열어서 음식을 추가
		PrintWriter outputStream = null;
		try{
			outputStream = new PrintWriter(new FileOutputStream(name+".txt", true));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening the File.");
		}
		System.out.println("음식 이름 입력:");
		while(true) {
			String input = keyboard.next();
			if(input.equals("끝")) {
				break;
			}
			outputStream.println(input);
		}
		outputStream.close();
	}
	
	public static void createFile(String name, String password, double height, double weight, String gender) {
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
	}
	//이미 있으면 불러오고 없으면 새로운 텍스트 파일을 생성
	public static User loadFile(String name, String password) {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(name+".txt"));
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
					if(inputStream.next().equals("<BMI>")) {
						u.setBMI(inputStream.nextDouble());
					}
					if(inputStream.next().equals("<음식>")) {
						while(inputStream.hasNextLine()) {
							u.setFood(inputStream.next());
						}
					}
				}
				else {
					GUI_LoginFail f = new GUI_LoginFail();
				}
			inputStream.close();
		}
		catch(FileNotFoundException e){
		
		}
		return u;
	}

	
}
