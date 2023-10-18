package bank;

import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;

public class MiniStatement extends JFrame {
	String pino;

	public MiniStatement(String pino) {
		// TODO Auto-generated constructor stub
		this.pino = pino;
		setTitle("MINI STATEMENT");
		
		setLayout(null);

		JLabel mini = new JLabel();
		mini.setBounds(50,100,400,200);
		add(mini);

		JLabel bank = new JLabel("Indian Bank");
		bank.setFont(new Font("system",Font.BOLD,16));
		bank.setBounds(250, 20, 250, 20);
		add(bank);

		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		JLabel balance=new JLabel();
		balance.setBounds(50,600,500,20);
		add(balance);

		try {
			Connection connection = new Connection();
			ResultSet rs = connection.s.executeQuery("select * from login where pino='" + pino + "'");
			while (rs.next()) {
				card.setText("Card Number :" + rs.getString("cardno").substring(0, 4) + "XXXXXXXX"
						+ rs.getString("cardno").substring(12));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Connection connection = new Connection();
			int bal=0;
			ResultSet rs = connection.s.executeQuery("select * from bank where pino='" 
			+ pino + "'");//
			while (rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ rs.getString("acctype")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
				if(rs.getString("acctype").equals("Deposit")) {
					bal+=Integer.parseInt(rs.getString("amount"));
				}else {
					bal-=Integer.parseInt(rs.getString("amount"));
				}
			}
		balance.setText("YOUR CURRENT ACCOUNT BALANCE IS RS "+bal);

		
		} catch (Exception e) {
			System.out.println(e);
		}

		setSize(600, 800);
		setLocation(50, 50);
		getContentPane().setBackground(Color.white);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MiniStatement("");
	}

}
