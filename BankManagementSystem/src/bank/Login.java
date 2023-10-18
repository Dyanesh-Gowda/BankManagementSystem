package bank;

import java.awt.*;
import java.beans.ExceptionListener;
import java.sql.ResultSet;
import java.awt.event.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	JButton button,button2,button3;
	JTextField field;
	
	JPasswordField field2;
	
	public Login() {
		// TODO Auto-generated constructor stub
		this.setTitle("AUTOMATIC TELLER MACHINE");
		setLayout(null);
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("bank/logo.jpg"));
		Image i2=icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(70,10,100,100);
		JLabel jLabel=new JLabel("Welcome To ATM");
		jLabel.setFont(new Font("Password",Font.BOLD,38));
		jLabel.setBounds(200,40,400,40);
		this.add(jLabel);
		
		
		JLabel jc=new JLabel("Card No :");
		jc.setFont(new Font("Password",Font.BOLD,28));
		jc.setBounds(120,150,150,30);
		this.add(jc);
		
		 field=new JTextField();
		field.setBounds(300,150,230,30);
		field.setFont(new Font("Arial",Font.BOLD,14));
		this.add(field);
		
		JLabel pin=new JLabel("PIN :");
		pin.setFont(new Font("Password",Font.BOLD,38));
		pin.setBounds(120,220,230,30);
		this.add(pin);
		
		field2=new JPasswordField();
		field2.setBounds(300,220,230,30);
		field2.setFont(new Font("Arial",Font.BOLD,15));
		this.add(field2);
		
		 button=new JButton("SIGN_IN");
		button.setBounds(300,300,100,30);
		button.setBackground(Color.GREEN);
		button.setForeground(Color.white);
		button.addActionListener(this);
		this.add(button);
		
		
		 button2=new JButton("CLEAR");
		button2.setBounds(430,300,100,30);
		button2.setBackground(Color.GREEN);
		button2.setForeground(Color.white);
		button2.addActionListener(this);
		this.add(button2);
		
		
		 button3=new JButton("SIGN_UP");
		button3.setBounds(300,350,230,30);
		button3.setBackground(Color.GREEN);
		button3.setForeground(Color.white);
		button3.addActionListener(this);
		this.add(button3);
		
		getContentPane().setBackground(Color.white);
		this.add(label);
		this.setSize(1000,600);
		this.setVisible(true);
		this.setLocation(350,200);
		
		
		
	}
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==button2) {
			field.setText("");
			field2.setText("");
		}else if(event.getSource()==button) {
			Connection connection=new Connection();
			String cardno=field.getText();
			String pino=field2.getText();
			String query="select * from login where cardno='"+cardno+"' and pino='"+pino+"'";
		try {
			ResultSet resultSet= connection.s.executeQuery(query);
			if(resultSet.next()) {
				
				setVisible(false);
				new Transaction(pino).setVisible(true);
			}else if(cardno.equals("") ) {
				JOptionPane.showMessageDialog(null, "Please Enter your Card Number");
				
			}else if( pino.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter your PIN ");
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		}else if(event.getSource()==button3) {
			setVisible(false);
			new SignUpOne().setVisible(true);
			
		}
	}
	
	public static void main(String[] args) {
		new Login();
		
	}

}
