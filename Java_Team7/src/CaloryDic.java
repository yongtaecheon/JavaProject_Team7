
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.ImageIcon;

public class CaloryDic extends JFrame implements ActionListener{
	public static JPanel Panel = new JPanel();
	JTextField t1 ;
	ImageIcon I2;
	JTable table;
	boolean check=false;
	JButton b2;
	String header[]= {"이름","칼로리(kcal)","탄수화물","단백질","당류","나트륨"};
	String contents[][] = {{"","","","","","",""}};	
	
	
	ImageIcon icon2;
	
	public CaloryDic(){
		/*setTitle("칼로리사전");
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		
		Panel.setLayout(new GridLayout(4,1));
		
		JPanel p1 = new JPanel(new FlowLayout());
		JLabel L1 = new JLabel("칼로리사전");
		p1.add(L1);
		p1.setBackground(Color.white);
		
		JPanel p2 = new JPanel(new FlowLayout());
		JLabel L2 = new JLabel("음식이름 :");
		 t1 = new JTextField(30);
		ImageIcon I1 = new ImageIcon("C:\\Users\\user\\Desktop\\icon\\search.png");
		Image errorimg = I1.getImage();
		Image changedimg = errorimg.getScaledInstance(20,20, Image.SCALE_SMOOTH);
	    ImageIcon icon = new ImageIcon(changedimg);
	    
		JButton b1 = new JButton();
		b1.setIcon(icon);
		b1.addActionListener(this);
		b1.setPreferredSize(new Dimension(45,28));
		b1.setBorderPainted(false);
		b1.setFocusPainted(false);
		b1.setContentAreaFilled(false);
		
		p2.add(L2);
		p2.add(t1);
		p2.add(b1);
		p2.setBackground(Color.white);
		
		JPanel p3 = new JPanel(new FlowLayout());
		 //음식사진
		
		 I2 = new ImageIcon("");
		 errorimg = I2.getImage();
		 changedimg = errorimg.getScaledInstance(200,200, Image.SCALE_SMOOTH);
		 ImageIcon icon2 = new ImageIcon(changedimg);
		    
		 b2 = new JButton();
		 b2.setVisible(false);
		 
		 //b2.setPreferredSize(new Dimension(70,70));
		b2.setBorderPainted(false);
		b2.setFocusPainted(false);
		b2.setContentAreaFilled(false);
		
		p3.setBackground(Color.white);
		p3.add(b2);
		
		//setZero();
		JPanel p4 = new JPanel(new FlowLayout());
		table = new JTable(contents,header);
		table.setVisible(false);
		
		p4.setBackground(Color.white);
		p4.add(table);
		
		Panel.add(p1);
		Panel.add(p2);
		Panel.add(p3);
		Panel.add(p4);
		
		add(Panel);
		Panel.requestFocus(true);
		
	}
	 public void actionPerformed(ActionEvent e)
	    {
		 
		 I2 = new ImageIcon(t1.getText()+".jpeg");
		 Image errorimg = I2.getImage();
		 Image changedimg = errorimg.getScaledInstance(200,200, Image.SCALE_SMOOTH);
		 icon2 = new ImageIcon(changedimg);
		 b2.setIcon(icon2);
		 b2.setVisible(true);
		 table.setVisible(true); 
		    
		 contents[0][0] = "상추";
		 contents[0][1] = "상추";
		 contents[0][2] = "상추";
		 contents[0][3] = "상추";
		 contents[0][4] = "상추";
		 contents[0][5] = "상추";
		 contents[0][6] = "상추";
	    }
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaloryDic g = new CaloryDic(); 
	}*/
	/* public void setZero() {    //Food객체배열 초기화
         for(int i=0; i <7 ; i++){
           contents[i] = new String();
          }
     }*/ 

}
