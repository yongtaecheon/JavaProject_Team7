import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI_Sports extends JFrame implements ActionListener{
	Sports spo = new Sports();
	public static JPanel SportsPanel = new JPanel();
	JTextField text_time;
	JTextField text_sportsName;
	JTextField text_sportsName2;
	JTextField text_gettime;
	JTextField text_minmax;
	
	public GUI_Sports() {
		/*super("운동");
		setSize(850,300);
		setLayout(new FlowLayout());*/
		SportsPanel.setLayout(new GridLayout(4,1));
		SportsPanel.setBackground(Color.WHITE);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("운동명:"); text_sportsName = new JTextField(7);JLabel label2 = new JLabel("시간(분):");text_time = new JTextField(5);JButton button1 = new JButton("시간 설정");
		panel1.add(label1); panel1.add(text_sportsName); panel1.add(label2); panel1.add(text_time); panel1.add(button1);
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JLabel label3 = new JLabel("운동명:"); text_sportsName2 = new JTextField(7);JButton button2 = new JButton("운동량 보기");text_gettime = new JTextField(30);
		panel2.add(label3);panel2.add(text_sportsName2);panel2.add(button2);panel2.add(text_gettime);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		JButton button3 = new JButton("최대 운동시간");text_minmax = new JTextField(50);
		panel3.add(button3);panel3.add(text_minmax);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		JLabel sportsList = new JLabel("걷기, 등산, 수영, 축구, 농구, 야구, 스쿼트, 계단오르기, 자전거 중 운동명을 입력하세요.");
		panel4.add(sportsList);
		
		text_gettime.setEditable(false);
		text_minmax.setEditable(false);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		
		panel1.setBackground(Color.WHITE);
		panel2.setBackground(Color.WHITE);
		panel3.setBackground(Color.WHITE);
		panel4.setBackground(Color.WHITE);
		SportsPanel.add(panel1);
		SportsPanel.add(panel2);
		SportsPanel.add(panel3);
		SportsPanel.add(panel4);
		add(SportsPanel);
		
	}
	public void actionPerformed(ActionEvent e) {
		String ButtonString = e.getActionCommand();
		if(ButtonString.equals("시간 설정")){
			spo.setTime(text_sportsName.getText(), Double.parseDouble(text_time.getText()));
			text_sportsName.setText("");
			text_time.setText("");
		}
		else if(ButtonString.equals("운동량 보기")) {
			text_gettime.setText(spo.getTime(text_sportsName2.getText()));
			text_sportsName2.setText("");
		}
		else if(ButtonString.equals("최대 운동시간")) {
			text_minmax.setText(spo.minmaxSports());
		}
	}
	
/*	public static void main(String args[]) {
		GUI_Sports gui = new GUI_Sports();
		gui.setVisible(true);
	}*/
}
