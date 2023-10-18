package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;


public class Deposit extends JFrame implements ActionListener{
	JTextField amount;
	JButton deposit,back;
	String pino;
	public Deposit(String pino) {
		// TODO Auto-generated constructor stub
		this.pino=pino;
		setLayout(null);
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("bank/1678370907688.jpg"));
		Image i2=icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text=new JLabel("Enter the amount you have to Deposit");
		text.setForeground(Color.white);
		text.setFont(new Font("system",Font.BOLD,16));
		text.setBounds(190,300,400,20);
		image.add(text);
		
		 deposit=new JButton("Deposit");
		deposit.setBounds(355,485,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		 back=new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		 amount=new JTextField();
		amount.setFont(new Font("system",Font.BOLD,22));
		amount.setBounds(170,350,320,22);
		image.add(amount);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==deposit) {
			String number=amount.getText();
			Date date=new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter the Amount you need to Deposit");
			}else {
				Connection connection=new Connection();
				String query="Insert into bank values('"+pino+"','"+date+"','Deposit','"+number+"')";
				try {
					connection.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+"Deposited sucessfully");
					setVisible(false);
					new Transaction(pino).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			
		}else if(e.getSource()==back) {
			setVisible(false);
			new Transaction(pino).setVisible(true);
			
		}
	}
	
	
	public static void main(String[] args) {
		new Deposit("");
	}

}
