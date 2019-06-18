
public class User {
   private double height;
   private double weight;
   private String gender;//m = male(남자), f = female(여자)
   private double BMI;
   double calory;
   String[] food;
   int foodsize;//food배열의 크기
   public User() {
      height = 0;
      weight = 0;
      gender = "m";
      BMI=0;
      calory=0;
      food = new String[50];
      foodsize = 0;
   }
   public User(double height, double weight, String gender) {
      this.height = height;
      this.weight = weight;
      this.gender = gender;
      food = new String[50];
      foodsize = 0;
   }
   public String getGender(){
      return gender;
   }
   public void setGender(String gender) {
      this.gender=gender;
   }
   
   public double getHeight() {
      return height;
   }
   public void setHeight(double height) {
      this.height=height;
   }
   public double getWeight() {
      return weight;
   }
   public void setWeight(double weight){
      this.weight=weight;
   }
   public double getCalory(){
      return calory;
   }
   public void setCalory(double calory){
      this.calory=calory;
   }
   public double getBMI(){
      return BMI;
   }
   public void setBMI(double BMI) {
	   this.BMI = BMI;
   }
   public void setBMI(double height,double weight){
      this.BMI=weight/(height*height);
   }
   public void setFood(String foodName) {
	   food[foodsize++]=foodName;
   }
   public String getFood() {
	   return food[foodsize-1];
   }
   public void calculateBMI()
   {
      if(20<=BMI && BMI<25 )
      {
         System.out.printf("BMI지수가 %.2f 이므로 정상입니다.", getBMI());
      }
      else if(25<=BMI && BMI<30)
      {
    	  System.out.printf("BMI지수가 %.2f 이므로 과체중입니다.", getBMI());
      }
      else if(30<=BMI && BMI<40)
      {
    	  System.out.printf("BMI지수가 %.2f 이므로 비만입니다.", getBMI());
      }
      else if( BMI> 40)
      {
    	  System.out.printf("BMI지수가 %.2f 이므로 고도비만입니다.", getBMI());
      }
      else
      {
    	  System.out.printf("BMI지수가 %.2f 이므로 저체중입니다.", getBMI());
      }
   }
   public String calculateCalory(String gender)
   {
      if(gender.equals("m")) {//남자
         if(calory > 2700)
         {
            return ("하루 권장 칼로리보다 많습니다");
         }
         else if(calory == 2700)
         {
            return ("하루 권장 칼로리입니다");
         }
         else 
         {
            return ("하루 권장 칼로리 보다 작습니다");
         }
      }
      else {//여자
         if(calory > 2000)
         {
            return ("하루 권장 칼로리보다 많습니다");
         }
         else if(calory == 2000)
         {
            return ("하루 권장 칼로리입니다");
         }
         else 
         {
            return ("하루 권장 칼로리 보다 작습니다");
         }
      }
   }
   
}