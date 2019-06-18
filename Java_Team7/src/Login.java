import java.util.Scanner;
import java.io.*;

public class Login{
	
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter Username: ");
		String name = keyboard.next();
		System.out.print("Enter Password: ");
		String password = keyboard.next();
		loadFile(name, password);
	}
	
	public static void createFile(String name, String password) {
		Scanner keyboard = new Scanner(System.in);
		User u = new User();
		Food f = new Food();
		f.readFoodFile();
		PrintWriter outputStream  = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(name+".txt"));
		}
		catch(FileNotFoundException e2) {
			System.out.println("Error opening the File.");
		}
		outputStream.println(password);
		System.out.println("Ű(m) ������(kg) ����(m/f) �Է�:");
		u.setHeight(keyboard.nextDouble());
		u.setWeight(keyboard.nextDouble());
		u.setGender(keyboard.next()); 
		u.setBMI(u.getHeight(), u.getWeight());
		outputStream.println(u.getHeight()); outputStream.println(u.getWeight()); outputStream.println(u.getGender()); outputStream.println(u.getBMI());
		System.out.println("���� �̸� �Է�:");
		while(true) {
			String input = keyboard.next();
			if(input.equals("��")) {
				break;
			}
			u.setFood(input);
			outputStream.println(u.getFood());
		}
		//Į�θ����
		for(int i = 0; i < u.foodsize; i++) {
			for(int j = 0; j < 50; j++) {
				if((u.food[i]).equals(f.food[j].getName())) {
					u.calory+= f.food[j].getKcal();
				}
			}
		}
		outputStream.println(u.getCalory());
		outputStream.close();
	}
	//�̹� ������ �ҷ����� ������ ���ο� �ؽ�Ʈ ������ ����
	public static void loadFile(String name, String password) {
		User u = new User();
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(name+".txt"));
			while(true) {
				if((inputStream.next()).equals(password)) {
					break;
				}
				else {
					System.out.println("�߸��� ��й�ȣ �Դϴ�. �ٽ� �Է��� �ּ���.");
				}
			}
			u.setHeight(inputStream.nextDouble());
			u.setWeight(inputStream.nextDouble());
			u.setGender(inputStream.next());
			u.setBMI(inputStream.nextDouble());
			while(inputStream.hasNextLine()) {
				if(inputStream.hasNextDouble()) {
					u.setCalory(inputStream.nextDouble());
					break;
				}
				u.setFood(inputStream.next());
			}
		}
		catch(FileNotFoundException e){
			System.out.println("���ο� ����� �̽ñ���! ������ ���� �����ϰڽ��ϴ�.");
			createFile(name, password);
		}
	}
	
}