package bank;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
	JPasswordField pin2,repin;
	JButton change,back;
	String pino;
	public PinChange(String pino) {
		// TODO Auto-generated constructor stub
		this.pino=pino;
		setLayout(null);
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("bank/1678370907688.jpg"));
		Image i2=icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text=new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.white);
		text.setFont(new Font("system",Font.BOLD,16));
		text.setBounds(250,300,500,35);
		image.add(text);
		
		JLabel pin=new JLabel("NEW PIN :");
		pin.setForeground(Color.white);
		pin.setFont(new Font("system",Font.BOLD,16));
		pin.setBounds(165,415,180,25);
		image.add(pin);
		
		 pin2=new JPasswordField();
		pin2.setFont(new Font("system",Font.BOLD,25));
		pin2.setBounds(330,415,180,25);
		image.add(pin2);
		
		
		JLabel reenter=new JLabel("RE-ENTER NEW PIN :");
		reenter.setForeground(Color.white);
		reenter.setFont(new Font("system",Font.BOLD,16));
		reenter.setBounds(165,450,500,35);
		image.add(reenter);
		
		
		 repin=new JPasswordField();
		repin.setFont(new Font("system",Font.BOLD,25));
		repin.setBounds(330,450,180,25);
		image.add(repin);
		
		 change=new JButton("CHANGE");
		change.setBounds(360,525,150,30);
		change.addActionListener(this);
		image.add(change);
		
		 back=new JButton("BACK");
		back.setBounds(160,525,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
		try {
			String npin=pin2.getText();
			String rpin=repin.getText();
			
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "ENTERED PIN DOESN'T EXIST");
				return;
			}
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "PLEASE ENTER PIN");
				return;
			}
			if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "PLEASE ENTER RE-PIN ");
				return;
			}
			Connection connection=new Connection();
			String query1="update bank set pino='"+rpin+"' where pino='"+pino+"'";
			String query2="update login set pino='"+rpin+"' where pino='"+pino+"'";
			String query3="update signupthree set pino='"+rpin+"' where pino='"+pino+"'";
			connection.s.executeUpdate(query1);
			connection.s.executeUpdate(query2);
			connection.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN CHANGED SUCESSFULLY ");
			setVisible(false);
			new Transaction(rpin).setVisible(true);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		}else {
			setVisible(false);
			new Transaction(pino).setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		new PinChange("").setVisible(true);;
		
	}

}
