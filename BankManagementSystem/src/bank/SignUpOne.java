package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener{
	long random;
	JTextField field,field2,field3,field4,field5,field6,field7;
	JButton jButton;
	JRadioButton radioButton,radioButton2,married,unmarried,other;
	JDateChooser chooser;
	
	
	public SignUpOne() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		Random ran=new Random();
	 random= Math.abs((ran.nextLong()%9000L)+1000L);
		JLabel phno=new JLabel("APPLICATION FORM NO "+random);
		phno.setFont(new Font("Raleway",Font.BOLD,38));
		phno.setBounds(120,20,600,40);
		this.add(phno);

		JLabel pers=new JLabel("Page 1:Personal Details :");
		pers.setFont(new Font("Raleway",Font.BOLD,22));
		pers.setBounds(290,80,400,30);
		this.add(pers);

		JLabel name=new JLabel("Name :");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		this.add(name);

		 field=new JTextField();
		field.setFont(new Font("raleway",Font.BOLD,14));
		field.setBounds(300,140,400,30);
		add(field);

		JLabel fname=new JLabel("Father's Name :");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		this.add(fname);

		 field2=new JTextField();
		field2.setFont(new Font("raleway",Font.BOLD,14));
		field2.setBounds(300,190,400,30);
		add(field2);

		JLabel dob=new JLabel("Date Of Birth :");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		this.add(dob);

		 chooser=new JDateChooser();
		chooser.setBounds(300,240,400,30);
		chooser.setForeground(new Color(105,105,105));
		add(chooser);

		JLabel gn=new JLabel("Gender :");
		gn.setFont(new Font("Raleway",Font.BOLD,20));
		gn.setBounds(100,290,200,30);
		this.add(gn);

		 radioButton=new JRadioButton("Male");
		radioButton.setBounds(300,290,60,30);
		radioButton.setBackground(Color.white);
		radioButton.setForeground(Color.BLACK);
		add(radioButton);

		 radioButton2=new JRadioButton("Female");
		radioButton2.setBounds(450,290,80,30);
		radioButton2.setBackground(Color.white);
		radioButton2.setForeground(Color.BLACK);
		add(radioButton2);

		ButtonGroup group=new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton2);


		JLabel em=new JLabel("Email :");
		
		em.setFont(new Font("Raleway",Font.BOLD,20));
		em.setBounds(100,340,200,30);
		this.add(em);

		 field3=new JTextField();
		field3.setFont(new Font("raleway",Font.BOLD,14));
		field3.setBounds(300,340,400,30);
		add(field3);

		JLabel ms=new JLabel("Marital Status :");
		ms.setFont(new Font("Raleway",Font.BOLD,20));
		ms.setBounds(100,390,200,30);
		this.add(ms);

		 married=new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.white);
		married.setForeground(Color.BLACK);
		add(married);

		 unmarried=new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,100,30);
		unmarried.setBackground(Color.white);
		unmarried.setForeground(Color.BLACK);
		add(unmarried);

		 other=new JRadioButton("Other");
		other.setBounds(630,390,70,30);
		other.setBackground(Color.white);
		other.setForeground(Color.BLACK);
		add(other);

		ButtonGroup buttonGroup=new ButtonGroup();
		buttonGroup.add(married);
		buttonGroup.add(unmarried);
		buttonGroup.add(other);

		JLabel ad=new JLabel("Address :");
		ad.setFont(new Font("Raleway",Font.BOLD,20));
		ad.setBounds(100,440,200,30);
		this.add(ad);

		 field4=new JTextField();
		field4.setFont(new Font("raleway",Font.BOLD,14));
		field4.setBounds(300,440,400,30);
		add(field4);

		JLabel ci=new JLabel("City Name :");
		ci.setFont(new Font("Raleway",Font.BOLD,20));
		ci.setBounds(100,490,200,30);
		this.add(ci);

		 field5=new JTextField();
		field5.setFont(new Font("raleway",Font.BOLD,14));
		field5.setBounds(300,490,400,30);
		add(field5);

		JLabel st=new JLabel("State :");
		st.setFont(new Font("Raleway",Font.BOLD,20));
		st.setBounds(100,540,200,30);
		this.add(st);

		 field6=new JTextField();
		field6.setFont(new Font("raleway",Font.BOLD,14));
		field6.setBounds(300,540,400,30);
		add(field6);

		JLabel pin=new JLabel("Pin Code :");
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(100,590,200,30);
		this.add(pin);

		 field7=new JTextField();
		field7.setFont(new Font("raleway",Font.BOLD,14));
		field7.setBounds(300,600,400,30);
		add(field7);

		 jButton=new JButton("Next >>>>");
		jButton.setBackground(Color.gray);
		jButton.setForeground(Color.white);
		jButton.setFont(new Font("Rale",Font.BOLD,14));
		jButton.setBounds(620,660,120,30);
		jButton.addActionListener(this);
		add(jButton);
		
		getContentPane().setBackground(Color.white);
		this.setSize(850,800);
		this.setLocation(350, 10);
		this.setVisible(true);

	}
	public void actionPerformed(ActionEvent e) {
		String formno=""+random;
		String name=field.getText();
		String fname=field2.getText();
		String dob=((JTextField)chooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(radioButton.isSelected()) {
			gender="Male";
		}else if(radioButton2.isSelected()) {
			gender="FeMale";
		}
		String email=field3.getText();
		 String marital=null;
		 if(married.isSelected()) {
			 marital="Married";
		 }else if(unmarried.isSelected()) {
			 marital="UnMarried";
		 }else if(other.isSelected()) {
			 marital="Other";
		 }
		 String address=field4.getText();
		 String city=field5.getText();
		 String state=field6.getText();
		 String pin=field7.getText();
		 
		 try {
			 if(name.equals("")) {
				 JOptionPane.showMessageDialog(null, "Name is Required");
			 }else {
				 Connection connection=new Connection();
				 String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"',"
				 		+ "'"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
				 connection.s.executeUpdate(query);
				 
				 setVisible(false);
				 new SignUpTwo(formno).setVisible(true);
			 }
		 }catch(Exception e1) {
			 System.out.println(e1);
		 }
	}
	public static void main(String[] args) {
		new SignUpOne();

	}
	

}
