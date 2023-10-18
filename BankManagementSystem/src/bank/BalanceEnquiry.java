package bank;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;


public class BalanceEnquiry extends JFrame implements ActionListener {
	String pino;
	JButton back;
	
	
	
	public BalanceEnquiry(String pino) {
		this.pino=pino;
		setLayout(null);
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("bank/1678370907688.jpg"));
		Image i2=icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		back=new JButton("back");
		
		
		back.setBounds(160,520,130,30);
		back.addActionListener(this);
		image.add(back);
		
		Connection connection=new Connection();
		int balance=0;
		try {
			ResultSet rs=connection.s.executeQuery("select * from bank where pino='"+pino+"'");
			
			while(rs.next()) {
				if(rs.getString("acctype").equals("Deposit")) {
					balance+=Integer.parseInt(rs.getString("amount"));
				}else {
					balance-=Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception e) {
					System.out.println(e);
				}
		
		JLabel text=new JLabel("YOUR CURRENT ACCOUNT BALANCE IS Rs "+balance);
		text.setForeground(Color.white);
		text.setBounds(170,300,400,30);
image.add(text);				
				
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transaction(pino).setVisible(true);
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		 new BalanceEnquiry("");
		
		
		
		
	}

}
