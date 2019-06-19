import java.util.Scanner;
import java.io.*;

public class Food implements Serializable{
      String name;
      double kcal;
      double ch; //Åº
      double protein;//´Ü
      double fat;//Áö
      double sugar;//´ç·ù
      double na;//³ªÆ®·ý
      Food[] food;
      int foodsize;
      
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
      public double getch() {
    	  return ch;
      }
      public double getprotein() {
    	  return protein;
      }
      public double getfat() {
    	  return fat;
      }
      public double getsugar() {
    	  return sugar;
      }
      public double getna() {
    	  return na;
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
         while(inputStream.hasNext()) {
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
         
         inputStream.close();
       
          
      }
}
     
