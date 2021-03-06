
public class User {
   private String name;
   private double height;
   private double weight;
   private String gender;//m = male(남자), f = female(여자)
   private double BMI;
   double calory;
   String[] food;
   int foodsize;//food배열의 크기
   String filePath;
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
   
   public void setFilepath(String filePath) {
	   this.filePath = filePath;
   }
   
   public void setName(String name)
   {
	   this.name = name;
   }
   
   public String getName() {
	   return name;
   }
   
   public String getGender_Korean()
   {
	   if(gender.equals("m"))
		   return "남자";
	   else
		   return "여자";
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
      this.BMI = weight/(height*height)*10000;
   }
   public void setFood(String foodName) {
	   food[foodsize++]=foodName;
   }
   public String getFood() {
	   return food[foodsize-1];
   }
   
   public String calculateBMI() //변경
   {
      if(20<=BMI && BMI<25 )
      {
         return ("BMI지수가 "+getBMI()+" 이므로 정상입니다." );
      }
      else if(25<=BMI && BMI<30)
      {
         return ("BMI지수가 "+ getBMI()+" 이므로 과체중입니다." );
      }
      else if(30<=BMI && BMI<40)
      {
       return ("BMI지수가 "+getBMI()+" 이므로 비만입니다.");
      }
      else if( BMI> 40)
      {
         return ("BMI지수가"+ getBMI()+" 이므로 고도비만입니다.");
      }
      else
      {
        return("BMI지수가 "+getBMI()+" 이므로 저체중입니다.");
      }
   }
   
   public String calculateCalory()
   {
      if(gender.equals("m")) {//남자
         if(getCalory() > 2700)
         {
            return ("오늘 드신 음식의 총 칼로리는 "+getCalory()+"kcal이고,\n하루 권장 칼로리보다 많습니다");
         }
         else if(getCalory() == 2700)
         {
            return ("오늘 드신 음식의 총 칼로리는 "+getCalory()+"kcal이고,\n하루 권장 칼로리입니다. ");
         }
         else 
         {
            return ("오늘 드신 음식의 총 칼로리는 "+getCalory()+"kcal이고,\n하루 권장 칼로리보다 적습니다.");
         }
      }
      else {//여자
         if(getCalory() > 2000)
         {
            return ("오늘 드신 음식의 총 칼로리는 "+getCalory()+"kcal이고,\n하루 권장 칼로리보다 많습니다");
         }
         else if(getCalory() == 2000)
         {
            return ("오늘 드신 음식의 총 칼로리는 "+getCalory()+"kcal이고,\n하루 권장 칼로리입니다. ");
         }
         else 
         {
            return ("오늘 드신 음식의 총 칼로리는 "+getCalory()+"kcal이고,\n하루 권장 칼로리보다 적습니다.");
         }
      }
   }
   
}