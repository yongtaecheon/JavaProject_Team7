import java.util.Scanner;
import java.io.*;

public class Food implements Serializable{
      private String name;
      private double kcal;
      private double ch; //Åº
      private double protein;//´Ü
      private double fat;//Áö
      private double sugar;//´ç·ù
      private double na;//³ªÆ®·ý
      Food[] food;
      
      public Food() {
          
          food = new Food[50];
          name=" ";
          kcal=0;
          ch=0;
          protein=0;
          fat=0;
          sugar=0;
          na=0;
        
      }
      public String getName() {
    	  return name;
      }
      public double getKcal() {
    	  return kcal;
      }
      public void setZero() {    //Food°´Ã¼¹è¿­ ÃÊ±âÈ­
          for(int i=0; i < 50 ; i++){
            food[i] = new Food();
           }
      } 
      public void readFoodFile() {
    	 int foodsize = 0;
    	 Scanner inputStream = null;  
         try{
        	 inputStream = new Scanner(new FileInputStream("foodInfo.txt"));
         }
         catch(FileNotFoundException e) {
              System.out.println("Cannot find datafile.");
         }
         setZero();
         while(inputStream.hasNextLine()) {
        	 if(inputStream.hasNext())
                 food[foodsize].name = inputStream.next();
             if(inputStream.hasNextInt())
            	   food[foodsize].kcal = inputStream.nextInt();
             if(inputStream.hasNextDouble())
            	   food[foodsize].ch=inputStream.nextDouble();
               if(inputStream.hasNextDouble())
            	   food[foodsize].protein=inputStream.nextDouble();
               if(inputStream.hasNextDouble())
            	   food[foodsize].fat=inputStream.nextDouble();
               if(inputStream.hasNextDouble())
            	   food[foodsize].sugar=inputStream.nextDouble();
               if(inputStream.hasNextDouble())
            	   food[foodsize].na=inputStream.nextDouble();
               foodsize++;             
         }
          
      }
}
     
