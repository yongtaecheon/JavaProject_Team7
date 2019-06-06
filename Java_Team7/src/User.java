
public class User {
	private double height;
	private double weight;
	private char gender;//m = male(남자), f = female(여자)
	private double BMI;
	public User() {
		height = 0;
		weight = 0;
		gender = 'm';
		BMI=0;
	}
	public User(double height, double weight, char gender) {
		this.height = height;
		this.weight = weight;
		this.gender = gender;
	}
	public double setHeight(double height) {
	
		return height;
	}
	public void getHeight()
	{
		this.height=height;
	}
	public double setWeight(double weight)
	{
		return weight;
	}
	public void getWeight()
	{
		this.weight=weight;
	}
	public double setBMI(double height,double weight)
	{
		return BMI=weight/(height*height);
	}
	public void getBMI()
	{
		this.BMI=BMI;
	}
	public String Bmi()
	{
		if(20<=BMI && BMI<=25 )
		{
			return ("정상");
		}
		else if(25<=BMI && BMI<=30)
		{
			return ("과체중");
		}
		else if(30<=BMI && BMI<=40)
		{
			return ("비만");
		}
		else if( BMI> 40)
		{
			return ("고도비만");
		}
		else
		{
			return ("저체중");
		}
	}
}
