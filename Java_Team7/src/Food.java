import java.util.Scanner;
import java.io.*;

public class Food implements Serializable {
      String name;
      int kcal;
      double ch; //ź
      double protein;//��
      double fat;//��
      double sugar;//���
      double na;//��Ʈ��
      int a=0;
      int b=0;
      Food[] ary;
       
      public Food() {
      
    	  ary = new Food[500];
    	  name=" ";
    	  kcal=0;
    	  ch=0;
    	  protein=0;
    	  fat=0;
    	  sugar=0;
    	  na=0;
    	
      }
      
      public void readFoodFile() {
         Scanner inputStream=null;  
         try{
            inputStream = new Scanner(new FileInputStream("input.txt"));
              }
           catch(FileNotFoundException e) {
              System.out.println("Cannot find datafile.");
           }
         catch(Exception e) {
        	 System.out.println("System Error!");
         }
         setZero(); //�迭�ʱ�ȭ
         while(inputStream.hasNextLine()) {	//�迭�� �����ؽ�Ʈ��������
          
        	if(inputStream.hasNext())
        		ary[a].name = inputStream.next();
            if(inputStream.hasNextInt())
            	ary[a].kcal = inputStream.nextInt();
            if(inputStream.hasNextDouble())
            	ary[a].ch=inputStream.nextDouble();
            if(inputStream.hasNextDouble())
            	ary[a].protein=inputStream.nextDouble();
            if(inputStream.hasNextDouble())
            	ary[a].fat=inputStream.nextDouble();
            if(inputStream.hasNextDouble())
            	ary[a].sugar=inputStream.nextDouble();
            if(inputStream.hasNextDouble())
            	ary[a].na=inputStream.nextDouble();
            System.out.println(ary[a].name);
            a++;             
         }
           inputStream.close();
          
      }
      public void setZero() {    //Food��ü�迭 �ʱ�ȭ
    	   for(int i=0; i < 500 ; i++){
    		  ary[i] = new Food();
    		 }
      }      
      public static void main(String args[]) {
    	  Food f = new Food();
    	  f.readFoodFile();	  
      }
}