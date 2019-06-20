import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.awt.*;

public class GUI_AddPicture extends JFrame{
	Container contentPane;
	JLabel imageLabel = new JLabel();
	
	GUI_AddPicture()
	{
		setTitle("File Open");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.add(imageLabel);
		createMenu();
		setSize(300,200);
		setVisible(true);
	}
	
	void createMenu()
	{
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		
		openItem.addActionListener(new OpenActionListener());
		fileMenu.add(openItem);
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}
	
	class OpenActionListener implements ActionListener
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
			
			String filePath = chooser.getSelectedFile().getPath();
			imageLabel.setIcon(new ImageIcon(filePath));
			pack();
			
		}
		
	}
	
	public static void main(String[] args)
	{
		new GUI_AddPicture();
	}
	
}
