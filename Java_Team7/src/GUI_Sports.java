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
		/*super("�");
		setSize(850,300);
		setLayout(new FlowLayout());*/
		SportsPanel.setLayout(new GridLayout(4,1));
		SportsPanel.setBackground(Color.WHITE);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("���:"); text_sportsName = new JTextField(7);JLabel label2 = new JLabel("�ð�(��):");text_time = new JTextField(5);JButton button1 = new JButton("�ð� ����");
		panel1.add(label1); panel1.add(text_sportsName); panel1.add(label2); panel1.add(text_time); panel1.add(button1);
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JLabel label3 = new JLabel("���:"); text_sportsName2 = new JTextField(7);JButton button2 = new JButton("��� ����");text_gettime = new JTextField(30);
		panel2.add(label3);panel2.add(text_sportsName2);panel2.add(button2);panel2.add(text_gettime);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		JButton button3 = new JButton("�ִ� ��ð�");text_minmax = new JTextField(50);
		panel3.add(button3);panel3.add(text_minmax);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		JLabel sportsList = new JLabel("�ȱ�, ���, ����, �౸, ��, �߱�, ����Ʈ, ��ܿ�����, ������ �� ����� �Է��ϼ���.");
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
		if(ButtonString.equals("�ð� ����")){
			spo.setTime(text_sportsName.getText(), Double.parseDouble(text_time.getText()));
			text_sportsName.setText("");
			text_time.setText("");
		}
		else if(ButtonString.equals("��� ����")) {
			text_gettime.setText(spo.getTime(text_sportsName2.getText()));
			text_sportsName2.setText("");
		}
		else if(ButtonString.equals("�ִ� ��ð�")) {
			text_minmax.setText(spo.minmaxSports());
		}
	}
	
/*	public static void main(String args[]) {
		GUI_Sports gui = new GUI_Sports();
		gui.setVisible(true);
	}*/
}
