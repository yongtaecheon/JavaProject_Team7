import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.awt.*;

public class GUI_AddPicture extends JFrame{
	Container contentPane;
	JLabel imageLabel = new JLabel();
	
	public class OpenActionListener implements ActionListener
	{
		JFileChooser chooser;
		
		OpenActionListener()
		{
			chooser = new JFileChooser();
		}
		
		public void actionPerformed(ActionEvent e)
		{
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images","jpg","gif");
			chooser.setFileFilter(filter);
			
			int ret = chooser.showOpenDialog(null);
			
			if(ret != JFileChooser.APPROVE_OPTION)
			{
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다","경고",JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			String filePath = chooser.getSelectedFile().getPath(); // 파일 경로
			
			ImageIcon icon = new ImageIcon(filePath);
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(GUI_Regis.AddPicButton.getWidth(), 
					GUI_Regis.AddPicButton.getHeight(), java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			
			GUI_Regis.AddPicButton.setIcon(icon);
			
		}
		
	}
	
	public static void main(String[] args)
	{
		new GUI_AddPicture();
	}
	
}
