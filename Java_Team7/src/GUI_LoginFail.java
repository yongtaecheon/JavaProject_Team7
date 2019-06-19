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
		
		ImageIcon error = new ImageIcon("Error.png");
		Image errorimg = error.getImage();
		Image changedimg = errorimg.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(changedimg);
		
		
		JLabel text = new JLabel("잘못된 비밀번호 입니다!");
		text.setIcon(icon);
		text.setBounds(50,50,250,20);
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
