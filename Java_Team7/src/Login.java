import java.util.Scanner;
import java.io.*;

public class Login{
	//�̹� ������ �ҷ����� ������ ���ο� �ؽ�Ʈ ������ ����
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
						System.out.println("�߸��� ��й�ȣ �Դϴ�. �ٽ� �Է��� �ּ���.");
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
				System.out.println("���ο� ����� �̽ñ���! ������ ���� �����ϰڽ��ϴ�.");
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
