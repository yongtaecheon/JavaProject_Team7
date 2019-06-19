
public class User {
   private String name;
   private double height;
   private double weight;
   private String gender;//m = male(����), f = female(����)
   private double BMI;
   double calory;
   String[] food;
   int foodsize;//food�迭�� ũ��
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
   public void calculateBMI()
   {
      if(20<=BMI && BMI<25 )
      {
         System.out.printf("BMI������ %.2f �̹Ƿ� �����Դϴ�.", getBMI());
      }
      else if(25<=BMI && BMI<30)
      {
    	  System.out.printf("BMI������ %.2f �̹Ƿ� ��ü���Դϴ�.", getBMI());
      }
      else if(30<=BMI && BMI<40)
      {
    	  System.out.printf("BMI������ %.2f �̹Ƿ� ���Դϴ�.", getBMI());
      }
      else if( BMI> 40)
      {
    	  System.out.printf("BMI������ %.2f �̹Ƿ� �����Դϴ�.", getBMI());
      }
      else
      {
    	  System.out.printf("BMI������ %.2f �̹Ƿ� ��ü���Դϴ�.", getBMI());
      }
   }
   public String calculateCalory()
   {
      if(gender.equals("m")) {//����
         if(calory > 2700)
         {
            return ("���� ��� ������ �� Į�θ��� "+calory+"kcal�̰�,\n�Ϸ� ���� Į�θ����� �����ϴ�");
         }
         else if(calory == 2700)
         {
            return ("���� ��� ������ �� Į�θ��� "+calory+"kcal�̰�,\n�Ϸ� ���� Į�θ��Դϴ�. ");
         }
         else 
         {
            return ("���� ��� ������ �� Į�θ��� "+calory+"kcal�̰�,\n�Ϸ� ���� Į�θ����� �����ϴ�.");
         }
      }
      else {//����
         if(calory > 2000)
         {
            return ("���� ��� ������ �� Į�θ��� "+calory+"kcal�̰�,\n�Ϸ� ���� Į�θ����� �����ϴ�");
         }
         else if(calory == 2000)
         {
            return ("���� ��� ������ �� Į�θ��� "+calory+"kcal�̰�,\n�Ϸ� ���� Į�θ��Դϴ�. ");
         }
         else 
         {
            return ("���� ��� ������ �� Į�θ��� "+calory+"kcal�̰�,\n�Ϸ� ���� Į�θ����� �����ϴ�.");
         }
      }
   }
   
}