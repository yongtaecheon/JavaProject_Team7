
public class Sports {
	private String[] name;
	private double[] time;
	//�ȱ�, ���, ������, ����, �౸, ��, �߱�, �䰡, ����Ʈ, ��ܿ�����
	public Sports() {
		name = new String[10];
		time = new double[10];
		for(int i=0;i<10;i++) {
			time[i] = 0;
		}
		name[0] ="�ȱ�";
		name[1] = "���";
		name[2] = "����";
		name[3] = "�౸";
		name[4] = "��";
		name[5] = "�߱�";
		name[6] = "�䰡";
		name[7] = "����Ʈ";
		name[8] = "��ܿ�����";
		name[9] = "������";
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
				return (sportsName+"�� ��Ͻ� �ð��� �� "+this.time[i]+"�� �Դϴ�.");
			}
		}
		return "�������� �ʴ� ��� �Դϴ�.";//���� ���
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
		return maxsports+"��(��) "+max+"�� ���� ���� ���� � �ϼ̽��ϴ�.";
					
	}
}
