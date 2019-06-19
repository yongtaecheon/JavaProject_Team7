import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FoodManagemnet {
	static Scanner keyboard = new Scanner(System.in);
	static Food f = new Food();
	
	public static double[] getNutrient(User u) {
		double[] nutrient = new double[5]; //ch(ź��ȭ��), protein(�ܹ���), fat(����), sugar(����), na(��Ʈ��) ��
		f.readFoodFile();
		for (int i=0; i < 5;i++) {
			nutrient[i] = 0;
		}
		for(int i = 0; i < u.foodsize; i++) {
			for(int j = 0; j < 50; j++) {
				if((u.food[i]).equals(f.food[j].getName())) {
					nutrient[0] += f.food[j].ch;
					nutrient[1] += f.food[j].protein;
					nutrient[2] += f.food[j].fat;
					nutrient[3] += f.food[j].sugar;
					nutrient[4] += f.food[j].na;
				}
			}	
		}
		return nutrient;
	}
	
	public static String showCal(User u) {//loadfile �޼ҵ�� ���� user�� return�޾� ��Į�θ����� ����ϰ� ���差���� �ƴ����� ���
		f.readFoodFile();
		//Į�θ����
		for(int i = 0; i < u.foodsize; i++) {
			for(int j = 0; j < 50; j++) {
				if((u.food[i]).equals(f.food[j].getName())) {
					u.calory += f.food[j].getKcal();
				}
			}	
		}
		
		return u.calculateCalory();
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
}
