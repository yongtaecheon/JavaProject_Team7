
public class User {
   private String name;
   private double height;
   private double weight;
   private String gender;//m = male(����), f = female(����)
   private double BMI;
   double calory;
   String[] food;
   int foodsize;//food�迭�� ũ��
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
		   return "����";
	   else
		   return "����";
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
   
   public String calculateBMI() //����
   {
      if(20<=BMI && BMI<25 )
      {
         return ("BMI������ "+getBMI()+" �̹Ƿ� �����Դϴ�." );
      }
      else if(25<=BMI && BMI<30)
      {
         return ("BMI������ "+ getBMI()+" �̹Ƿ� ��ü���Դϴ�." );
      }
      else if(30<=BMI && BMI<40)
      {
       return ("BMI������ "+getBMI()+" �̹Ƿ� ���Դϴ�.");
      }
      else if( BMI> 40)
      {
         return ("BMI������"+ getBMI()+" �̹Ƿ� �����Դϴ�.");
      }
      else
      {
        return("BMI������ "+getBMI()+" �̹Ƿ� ��ü���Դϴ�.");
      }
   }
   
   public String calculateCalory()
   {
      if(gender.equals("m")) {//����
         if(getCalory() > 2700)
         {
            return ("���� ��� ������ �� Į�θ��� "+getCalory()+"kcal�̰�,\n�Ϸ� ���� Į�θ����� �����ϴ�");
         }
         else if(getCalory() == 2700)
         {
            return ("���� ��� ������ �� Į�θ��� "+getCalory()+"kcal�̰�,\n�Ϸ� ���� Į�θ��Դϴ�. ");
         }
         else 
         {
            return ("���� ��� ������ �� Į�θ��� "+getCalory()+"kcal�̰�,\n�Ϸ� ���� Į�θ����� �����ϴ�.");
         }
      }
      else {//����
         if(getCalory() > 2000)
         {
            return ("���� ��� ������ �� Į�θ��� "+getCalory()+"kcal�̰�,\n�Ϸ� ���� Į�θ����� �����ϴ�");
         }
         else if(getCalory() == 2000)
         {
            return ("���� ��� ������ �� Į�θ��� "+getCalory()+"kcal�̰�,\n�Ϸ� ���� Į�θ��Դϴ�. ");
         }
         else 
         {
            return ("���� ��� ������ �� Į�θ��� "+getCalory()+"kcal�̰�,\n�Ϸ� ���� Į�θ����� �����ϴ�.");
         }
      }
   }
   
}