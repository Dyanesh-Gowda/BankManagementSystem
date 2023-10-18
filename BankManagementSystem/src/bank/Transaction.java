package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transaction extends JFrame implements ActionListener {
	JButton dposit,withdraw,fast,mini,pin,balance,exit;
String pino;
	public Transaction(String pino) {
		// TODO Auto-generated constructor stub
		this.pino=pino;
		setLayout(null);
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("bank/1678370907688.jpg"));
		Image i2=icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);

		JLabel text=new JLabel("Please select your Transaction");
		text.setBounds(230,290,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("system",Font.BOLD,16));
		image.add(text);

		dposit=new JButton("Deposit");
		dposit.setBounds(170,415,150,30);
		dposit.addActionListener(this);
		image.add(dposit);

		withdraw=new JButton("Cash Withdrawl");
		withdraw.setBounds(355,415,150,30);
		withdraw.addActionListener(this);
		image.add(withdraw);

		fast=new JButton("Fast Cash");
		fast.setBounds(170,450,150,30);
		fast.addActionListener(this);
		image.add(fast);

		mini=new JButton("Mini Statement");
		mini.setBounds(355,450,150,30);
		mini.addActionListener(this);
		image.add(mini);

		pin=new JButton("Pin Change");
		pin.setBounds(170,485,150,30);
		pin.addActionListener(this);
		image.add(pin);

		balance=new JButton("Balance Enquiry");
		balance.setBounds(355,485,150,30);
		balance.addActionListener(this);
		image.add(balance);

		exit=new JButton("Exit");
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
			System.exit(0);
		}else if(e.getSource()==dposit) {
			setVisible(false);
			new Deposit(pino).setVisible(true);
		}else if(e.getSource()==withdraw) {
			setVisible(false);
			new WithDraw(pino).setVisible(true);

	}else if(e.getSource()==fast) {
		setVisible(false);
		new FasTcash(pino).setVisible(true);
	}else if(e.getSource()==pin) {
		setVisible(false);
		new PinChange(pino).setVisible(true);
	}else if(e.getSource()==balance) {
		setVisible(false);
		new BalanceEnquiry(pino).setVisible(true);
		
	}else if(e.getSource()==mini) {
		
		new MiniStatement(pino).setVisible(true);
		
	}
	}
	public static void main(String[] args) {
		new Transaction("");
	}

}
