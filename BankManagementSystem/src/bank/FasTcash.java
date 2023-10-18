package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class FasTcash extends JFrame implements ActionListener {
	JButton dposit,withdraw,fast,mini,pin,balance,exit;
String pino;
	public FasTcash(String pino) {
		// TODO Auto-generated constructor stub
		this.pino=pino;
		setLayout(null);
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("bank/1678370907688.jpg"));
		Image i2=icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);

		JLabel text=new JLabel("PLEASE SELECT THE WITHDRAWL AMOUNT");
		text.setBounds(160,290,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("system",Font.BOLD,16));
		image.add(text);

		dposit=new JButton("RS 100");
		dposit.setBounds(170,415,150,30);
		dposit.addActionListener(this);
		image.add(dposit);

		withdraw=new JButton("RS 500");
		withdraw.setBounds(355,415,150,30);
		withdraw.addActionListener(this);
		image.add(withdraw);

		fast=new JButton("Rs 1000");
		fast.setBounds(170,450,150,30);
		fast.addActionListener(this);
		image.add(fast);

		mini=new JButton("Rs 2000");
		mini.setBounds(355,450,150,30);
		mini.addActionListener(this);
		image.add(mini);

		pin=new JButton("RS 5000");
		pin.setBounds(170,485,150,30);
		pin.addActionListener(this);
		image.add(pin);

		balance=new JButton("RS 10000");
		balance.setBounds(355,485,150,30);
		balance.addActionListener(this);
		image.add(balance);

		exit=new JButton("Back");
		exit.setBounds(355,520,150,30);
		exit.addActionListener(this);
		image.add(exit);


		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit) {
			setVisible(false);
			new Transaction(pino).setVisible(true);
		}else {
			String amount=((JButton)e.getSource()).getText().substring(3);
			Connection connection=new Connection();
			try {
				ResultSet rs=connection.s.executeQuery("select * from bank where pino='"+pino+"'");
				int balance=0;
				while(rs.next()) {
					if(rs.getString("acctype").equals("Deposit")) {
						balance+=Integer.parseInt(rs.getString("amount"));
					}else {
						balance-=Integer.parseInt(rs.getString("amount"));
					}
				}
				if(e.getSource()!=exit && balance<Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insuffiecient Balance");
					return;
				}
				Date date=new Date();
				String query="insert into bank values('"+pino+"','"+date+"','withdrawl','"+amount+"')";
				connection.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amount+"Debited Sucessfully");
				setVisible(false);
				new Transaction(pino).setVisible(true);
			}catch(Exception e2) {
				System.out.println(e2);
			}
		}
	}
	public static void main(String[] args) {
		new FasTcash("");
	}

}
