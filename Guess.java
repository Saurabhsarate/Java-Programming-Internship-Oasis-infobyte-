
// import javax.swing.JLabel;
// import javax.swing.JTextField;
// import javax.swing.JFrame;
// import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Guess extends JFrame
{
	JTextField t1,t2,t3,t4;
	JLabel j4;
	ButtonListener bl1;
	ButtonListener2 bl2;
	ButtonListener3 bl3;
	
	// int attempt=5;
	// int userGuessNumber= 0;
	int rand=(int)(Math.random()*100);
     int count=0;
	public Guess()
	{
		Container cn=getContentPane();
		cn.setBackground(Color.yellow);

		JLabel lblpic =new JLabel("");
		lblpic.setIcon(new ImageIcon("elec.png"));
		lblpic.setBounds(0,0,500,350);
		
		JLabel j=new JLabel(" Guess my number game");
		j.setForeground(Color.red); 
		j.setFont(new Font("Arial", Font.BOLD, 19));
		j.setSize(270,20);
		j.setLocation(300,35);

				JLabel j1=new JLabel("Enter number between 1-100"); 
				j1.setFont(new Font("Arial", Font.PLAIN,16));
				j1.setSize(270,20);
				j1.setLocation(300,60);
				
				t1=new JTextField(10);
				t1.setSize(50,30);
				t1.setLocation(350,80);
				
		j4=new JLabel ("Try and guess my number");
		j4.setFont(new Font("Arial",Font.PLAIN,17));
		j4.setSize(270,20);
		j4.setLocation(290,130);
		
		t2=new JTextField(10);
		t2.setSize(40,20);
		t2.setLocation(10,10);
		
		JLabel j5=new JLabel("Best Score");
		j5.setFont(new Font ("Arial",Font.PLAIN,17));
		j5.setSize(270,20);
		j5.setLocation(60,10);
		
		t3=new JTextField(10);
		t3.setSize(40,20);
		t3.setLocation(160,10);

		JLabel j6=new JLabel(" Guesses");
		j6.setFont(new Font ("Arial",Font.PLAIN,17));
		j6.setSize(270,20);
		j6.setLocation(180,10);
		
		JButton b1=new JButton("Guess");
		b1.setSize(150,40);
		b1.setLocation(260,250);
		bl1=new ButtonListener();
		b1.addActionListener(bl1);
		
		JButton b2=new JButton(" Give Up");
		b2.setSize(100,30);
		b2.setLocation(180,200);
		bl2=new ButtonListener2();
		b2.addActionListener(bl2);
		
		JButton b3=new JButton("Play Again !!");
		b3.setSize(120,30);
		b3.setLocation(330,200);
		bl3=new ButtonListener3();
		b3.addActionListener(bl3);
		
		cn.add(j6);
		cn.add(j5);
		cn.add(j4);
		cn.add(lblpic);
		cn.add(j);
		cn.add(j1);
		cn.add(t1);
		cn.add(t2);
		cn.add(t3);
		cn.add(b1);
		cn.add(b2);
		cn.add(b3);
		cn.add(j6);
		
		t2.setEditable(false);
		t3.setEditable(true);
		
		setTitle("NUMBER GUESSING GAME");
		
		setSize(550,350);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private class ButtonListener implements ActionListener
	{
		int bestScore=100;
		public void actionPerformed(ActionEvent e)
		{
			int  a=Integer.parseInt(t1.getText());
			count=count+1;
			if(a>rand)
			{
				j4.setText(a+ "\t This is Greater Number !!");
				
			}
			else if(a<rand)
			{
				j4.setText(a+ "\tThis is Smaller Number !!");
				
			}
			else
			{
				j4.setText("CORRECT, CONGRATULATION YOU ARE WINNER");
				if(count<bestScore)
				{
					bestScore=count;
					t2.setText(bestScore+"");
				}
				else
					t2.setText(""+bestScore);
				t1.setEditable(false);
			}
			
			t1.requestFocus();
			t1.selectAll();
			
			t3.setText(count+"");
		}
	}	
	private class ButtonListener2 implements  ActionListener
	{	
		 public void actionPerformed(ActionEvent e)
		 {
			 t3.setText("");
			 j4.setText("THE ANSWER IS \t"+rand);
			 t1.setText("");
			 t1.setEditable(false);
		 }
	}
	
	private class ButtonListener3 implements  ActionListener
	{	
		 public void actionPerformed(ActionEvent e)
		 {
			 rand=(int) (Math.random()*100);
			 t1.setText("");
			 t3.setText("");
			 j4.setText("Try and guess my number");
			 t3.setText("");
			 count=0;
			 t1.setEditable(true);
			 t1.requestFocus();
		 }
	}
	public static void main(String args[])
	{
		new Guess();
	}	
}