
public class Sports {
	private String[] name;
	private double[] time;
	//걷기, 등산, 자전거, 수영, 축구, 농구, 야구, 요가, 스쿼트, 계단오르기
	public Sports() {
		name = new String[10];
		time = new double[10];
		for(int i=0;i<10;i++) {
			time[i] = 0;
		}
		name[0] ="걷기";
		name[1] = "등산";
		name[2] = "수영";
		name[3] = "축구";
		name[4] = "농구";
		name[5] = "야구";
		name[6] = "요가";
		name[7] = "스쿼트";
		name[8] = "계단오르기";
		name[9] = "자전거";
	}
	public void setTime(String sportsName, double time) {
		for(int i=0;i<10;i++) {
			if(sportsName.equals(name[i])) {
				this.time[i] += time;
			}
		}
	}
	
	public String getTime(String sportsName) {
		for(int i=0;i<10;i++) {
			if(sportsName.equals(name[i])) {
				return (sportsName+"을 운동하신 시간은 총 "+this.time[i]+"분 입니다.");
			}
		}
		return "지원하지 않는 운동명 입니다.";//없는 경우
	}
	
	public String minmaxSports() {
		double max = time[0];
		String maxsports = "null";
		
		for(int i=1;i<10;i++) {
			if(time[i]>max) {
				max = time[i];
				maxsports = name[i];
			}
		}
		return maxsports+"을(를) "+max+"분 으로 가장 오래 운동 하셨습니다.";
					
	}
}
