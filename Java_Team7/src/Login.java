import java.util.Scanner;
import java.io.*;

public class Login{
	//이미 있으면 불러오고 없으면 새로운 텍스트 파일을 생성
	public static void loadFile(String name, String password) {
		Scanner inputStream = null;
		while(true) {
			try {
				inputStream = new Scanner(new FileInputStream(name+".txt"));
				while(true) {
					if(inputStream.next() == password) {
						break;
					}
					else {
						System.out.println("잘못된 비밀번호 입니다. 다시 입력해 주세요.");
					}
				}
				User u1 = new User();
				u1.setHeight(inputStream.nextDouble());
				u1.setWeight(inputStream.nextDouble());
				u1.setGender(inputStream.next());
				u1.setBMI(inputStream.nextDouble());
				u1.setCalory(inputStream.nextDouble());
				while(inputStream.hasNext()) {
					u1.setFood(inputStream.next());
				}
				break;
			}
			catch(FileNotFoundException e){
				System.out.println("새로운 사용자 이시군요! 계정을 새로 생성하겠습니다.");
				PrintWriter outputStream  = null;
				try {
					new PrintWriter(new FileOutputStream(name+".txt"));
				}
				catch(FileNotFoundException e2) {
					System.out.println("Error opening the File.");
				}
				outputStream.close();
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("Enter Username: ");
		String name = keyboard.next();
		System.out.println("Enter Password: ");
		String password = keyboard.next();
		loadFile(name, password);
	}
}
