import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI_LoginFail extends JFrame implements ActionListener{
	public GUI_LoginFail()
	{
		super("오류!");
		setBounds(0,0,300,200);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ImageIcon error = new ImageIcon("C:\\Users\\USER\\Desktop\\Error.png");
		JLabel text = new JLabel("잘못된 비밀번호 입니다!");
		text.setIcon(error);
		text.setBounds(70,50,150,20);
		add(text);
		JButton closeButton = new JButton("확인");
		closeButton.setBounds(110,90,60,40);
		closeButton.addActionListener(this);
		add(closeButton);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		dispose();
	}
}
