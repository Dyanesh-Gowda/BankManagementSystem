package bank;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener{
	
	JTextField adhar,pano;
	JButton jButton;
	JRadioButton yes,no,eyes,eno;
	
	JComboBox religion,category,income,vaieducation,vaioccupation;
	String formno;
	public SignUpTwo(String formno) {
		// TODO Auto-generated constructor stub
		this.formno=formno;
		setLayout(null);
		
			
		setTitle("NEW ACCOUNT APPLICATIO FORM-PAGE 2");
		

		JLabel additional=new JLabel("Page 2:Additional Details :");
		additional.setFont(new Font("Raleway",Font.BOLD,22));
		additional.setBounds(290,80,400,30);
		this.add(additional);

		JLabel name=new JLabel("Religion :");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		this.add(name);
		
		String vaiReligion[]={"Hindu","Muslim","Christian","Jain","other"};
		 religion=new JComboBox(vaiReligion);
		religion.setBounds(300,140,400,30);
		add(religion);

		

		JLabel fname=new JLabel("Category :");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		this.add(fname);
		
		 String vaiCategory[]= {"General","OBC","SC","ST","Other"};
		  category=new JComboBox(vaiCategory);
		 category.setBounds(300,190,400,30);
			add(category);


		

		JLabel dob=new JLabel("Income :");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		this.add(dob);
		
		 String vaiincome[]= {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
		  income=new JComboBox(vaiincome);
		 income.setBounds(300,240,400,30);
			add(income);

		

		JLabel gn=new JLabel("Educational");
		gn.setFont(new Font("Raleway",Font.BOLD,20));
		gn.setBounds(100,290,200,30);
		this.add(gn);

		 

		

		JLabel em=new JLabel("Qualification :");
		em.setFont(new Font("Raleway",Font.BOLD,20));
		em.setBounds(100,315,200,30);
		this.add(em);
		

		 String string[]= {"Non-Graduation","Graduate","post-Graduate","Doctrate","Others"};
		  vaieducation=new JComboBox(string);
		 vaieducation.setBounds(300,310,400,30);
			add(vaieducation);

		

		JLabel ms=new JLabel("Occupation :");
		ms.setFont(new Font("Raleway",Font.BOLD,20));
		ms.setBounds(100,390,200,30);
		this.add(ms);

		 String string2[]= {"Salaried","Self-Employee","BussinessMan","Student","Retired","Others"};
		  vaioccupation=new JComboBox(string2);
		 vaioccupation.setBounds(300,390,400,30);
			add(vaioccupation);


		JLabel pan=new JLabel("Pan No :");
		pan.setFont(new Font("Raleway",Font.BOLD,20));
		pan.setBounds(100,440,200,30);
		this.add(pan);

		 pano=new JTextField();
		 pano.setFont(new Font("raleway",Font.BOLD,14));
		 pano.setBounds(300,440,400,30);
		add(pano);

		JLabel aadhar=new JLabel("Aadhar Number :");
		aadhar.setFont(new Font("Raleway",Font.BOLD,20));
		aadhar.setBounds(100,490,200,30);
		this.add(aadhar);

		 adhar=new JTextField();
		adhar.setFont(new Font("raleway",Font.BOLD,14));
		adhar.setBounds(300,490,400,30);
		add(adhar);

		JLabel st=new JLabel("Senior Citizen :");
		st.setFont(new Font("Raleway",Font.BOLD,20));
		st.setBounds(100,540,200,30);
		this.add(st);

		 yes=new JRadioButton("Yes");
			yes.setBounds(300,540,100,30);
			yes.setBackground(Color.white);
			yes.setForeground(Color.BLACK);
			add(yes);

			 no=new JRadioButton("No");
			no.setBounds(450,540,100,30);
			no.setBackground(Color.white);
			no.setForeground(Color.BLACK);
			add(no);
			
			ButtonGroup group2=new ButtonGroup();
			group2.add(yes);
			group2.add(no);

		JLabel pin=new JLabel("Existing Account :");
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(100,590,200,30);
		this.add(pin);
		
		 eyes=new JRadioButton("Yes");
			eyes.setBounds(300,590,100,30);
			eyes.setBackground(Color.white);
			eyes.setForeground(Color.BLACK);
			add(eyes);

			 eno=new JRadioButton("No");
			eno.setBounds(450,590,100,30);
			eno.setBackground(Color.white);
			eno.setForeground(Color.BLACK);
			add(eno);
			
			ButtonGroup group=new ButtonGroup();
			group.add(eyes);
			group.add(eno);

		

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
		
		String sreligion=(String)religion.getSelectedItem();
		String scategory=(String)category.getSelectedItem();
		String sincome=(String)income.getSelectedItem();
		String seducation=(String)vaieducation.getSelectedItem();
		String soccupation=(String)vaioccupation.getSelectedItem();
		String seniorcitizen=null;
		if(yes.isSelected()) {
			seniorcitizen="Yes";
		}else if(no.isSelected()) {
			seniorcitizen="No";
		}
		
		 String existingaccount=null;
		 if(eyes.isSelected()) {
			 existingaccount="Yes";
		 }else if(eno.isSelected()) {
			existingaccount ="No";
		 }
		 String span=pano.getText();
		 String sadhar=adhar.getText();
		
		 
		try {
				 Connection connection=new Connection();
				 String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"',"
				 		+ "'"+span+"','"+sadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
				 connection.s.executeUpdate(query);
				 setVisible(false);
				 new SignUpThree(formno).setVisible(true);
			 
		 }catch(Exception e1) {
			 System.out.println(e1);
		 }
	}
	public static void main(String[] args) {
		new SignUpTwo("");

	}
	

}




