package bank;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class SignUpThree extends JFrame implements ActionListener {
	
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	public SignUpThree(String formno) {
		// TODO Auto-generated constructor stub
		this.formno=formno;
		setLayout(null);
		
	
	
		
		JLabel l1=new JLabel("Page 3 :Account Details");
		
		l1.setFont(new Font("raleway",Font.BOLD,22));
		l1.setBounds(280,40,400,40);
		add(l1);
		
JLabel type=new JLabel("Account type");
		
		type.setFont(new Font("raleway",Font.BOLD,22));
		type.setBounds(100,140,200,30);
		add(type);
		r1=new JRadioButton("Saving Account");
		r1.setFont(new Font("raleway",Font.BOLD,16));
		r1.setBackground(Color.white);
		r1.setBounds(100,180,150,20);
		add(r1);
		
		r2=new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("raleway",Font.BOLD,16));
		r2.setBackground(Color.white);
		r2.setBounds(350,180,200,20);
		add(r2);
		
		r3=new JRadioButton("Current Account");
		r3.setFont(new Font("raleway",Font.BOLD,16));
		r3.setBackground(Color.white);
		r3.setBounds(100,220,150,20);
		add(r3);
		
		r4=new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("raleway",Font.BOLD,16));
		r4.setBackground(Color.white);
		r4.setBounds(350,220,240,20);
		add(r4);
		
		ButtonGroup buttonaccount=new ButtonGroup();
		buttonaccount.add(r1);
		buttonaccount.add(r2);
		buttonaccount.add(r3);
		buttonaccount.add(r4);
		
		
JLabel card=new JLabel("Card Number");
		
		card.setFont(new Font("raleway",Font.BOLD,22));
		card.setBounds(100,300,200,30);
		add(card);
		
		
JLabel number=new JLabel("XXXX-XXXX-XXXX-1484");
		
		number.setFont(new Font("raleway",Font.BOLD,22));
		number.setBounds(330,300,280,30);
		add(number);
		
JLabel carddet=new JLabel("Your 16 Digit Card Number");
		
		carddet.setFont(new Font("raleway",Font.BOLD,12));
		carddet.setBounds(100,330,280,15);
		add(carddet);
		
JLabel pin=new JLabel("PIN :");
		
		pin.setFont(new Font("raleway",Font.BOLD,22));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		
JLabel pno=new JLabel("XXXX-XXXX-XXXX-1484");
		
		pno.setFont(new Font("raleway",Font.BOLD,22));
		pno.setBounds(330,370,280,30);
		add(pno);
		
JLabel pindet=new JLabel("Your 4 Digit Password");
		
		pindet.setFont(new Font("raleway",Font.BOLD,12));
		pindet.setBounds(100,400,280,15);
		add(pindet);
		
JLabel services=new JLabel("Services Required");
		
		services.setFont(new Font("raleway",Font.BOLD,22));
		services.setBounds(100,450,280,29);
		add(services);
		
		c1=new JCheckBox("ATM CARD");
		c1.setFont(new Font("raleway",Font.BOLD,16));
		c1.setBackground(Color.white);
		c1.setBounds(100,500,200,30);
		add(c1);
		
		c2=new JCheckBox("Internet Banking");
		c2.setFont(new Font("raleway",Font.BOLD,16));
		c2.setBackground(Color.white);
		c2.setBounds(350,500,200,30);
		add(c2);
		
		c3=new JCheckBox("Mobile Banking");
		c3.setFont(new Font("raleway",Font.BOLD,16));
		c3.setBackground(Color.white);
		c3.setBounds(100,550,200,30);
		add(c3);
		
		c4=new JCheckBox("EMAIL & SMS ALLERTS");
		c4.setFont(new Font("raleway",Font.BOLD,16));
		c4.setBackground(Color.white);
		c4.setBounds(350,550,200,30);
		add(c4);
		
		c5=new JCheckBox("CHEQUE BOOK");
		c5.setFont(new Font("raleway",Font.BOLD,16));
		c5.setBackground(Color.white);
		c5.setBounds(100,600,200,30);
		add(c5);
		
		c6=new JCheckBox("E-STATEMENT");
		c6.setFont(new Font("raleway",Font.BOLD,16));
		c6.setBackground(Color.white);
		c6.setBounds(350,600,200,30);
		add(c6);
		
		c7=new JCheckBox("I hereby declare tahat the above entered Details are correct to the best of my Knowledge");
		c7.setFont(new Font("raleway",Font.BOLD,12));
		c7.setBackground(Color.white);
		c7.setBounds(100,680,600,30);
		add(c7);
		
		submit=new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("raleway",Font.BOLD,16));
		submit.setBounds(250,720,100,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("cancel");
		cancel.setBackground(Color.green);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("raleway",Font.BOLD,16));
		cancel.setBounds(420,720,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.white);
		
		
		
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submit) {
			
			String accountType=null;
			if(r1.isSelected()) {
				accountType="Saving Account";
			}else if(r2.isSelected()) {
				accountType="Fixed Deposit Account";
			}else if(r3.isSelected()) {
				accountType="Current Account";
			}else if(r4.isSelected()) {
				accountType="Recurring Deposit Account";
			}
			Random random=new Random();
			
			String cardno=""+Math.abs((random.nextLong()%90000000l)+5040936000000000l);
			String pino=""+Math.abs((random.nextLong()%9000l)+1000l);
			
			String facility="";
			if(c1.isSelected()) {
				facility=facility+"ATM Card";
			}else if(c2.isSelected()) {
				facility=facility+"Internet Banking";
			}else if(c3.isSelected()) {
				facility=facility+"Mobile Banking";
			}else if(c4.isSelected()) {
				facility=facility+"Email & SMS Allerts";
			}else if(c5.isSelected()) {
				facility=facility+"Cheque Book";
			}else if(c6.isSelected()) {
				facility=facility+"E-Statement";
			}
			
			try {
			if(accountType.equals("")) {
				JOptionPane.showMessageDialog(null, "Account Type is Required");
			}else {
				Connection connection=new Connection();
				String query="insert into signupthree values('"+formno+"','"+accountType+"','"+cardno+"','"+pino+"','"+facility+"')";
				String quer2="insert into login values('"+formno+"','"+cardno+"','"+pino+"')";
				connection.s.executeUpdate(query);
				connection.s.executeUpdate(quer2);
			JOptionPane.showMessageDialog(null, "card Number :"+cardno+"\n Pin :"+pino);
				
			}
			setVisible(false);
			new Transaction(pino).setVisible(true);
				
			}catch(Exception e1) {
				System.out.println(e1);
			}
			
					
			
		}else if(e.getSource()==cancel) {
			setVisible(false);
			new Login().setVisible(true);
			
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		new  SignUpThree("");
	}

}
