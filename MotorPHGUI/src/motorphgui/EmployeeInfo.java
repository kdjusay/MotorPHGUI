package motorphgui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EmployeeInfo implements ActionListener {
		EmployeeData edata = new EmployeeData();
		Data data = new Data();
		
		
	    JFrame frame;
	    JLabel empnumlbl;
	    JTextField empnumtf;
	    JPanel panel,panel2;
	    JButton detailsbtn, returnbtn;
	    JTextArea detailsta;
	    
	    
	    
	    EmployeeInfo(){
	        frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(null);
	        frame.setSize(800, 600);
	        frame.setResizable(false);
	        
	        panel = new JPanel();
	        panel.setBounds(0, 0, 800, 60);
	        panel.setLayout(null);
	        frame.add(panel);
	        
	        panel2 = new JPanel();
	        panel2.setBounds(0, 10, 800, 560);
	        panel2.setLayout(null);
	        frame.add(panel2);
	       
	        
	        empnumlbl = new JLabel("Enter Employee Number");
	        empnumlbl.setBounds(5, 10, 150, 30);
	        panel.add(empnumlbl);
	       
	        
	        empnumtf=new JTextField(10);
	        empnumtf.setBounds(160, 10, 150, 30);
	        panel.add(empnumtf);
	        
	        detailsbtn = new JButton("Show Employee Information");
	        detailsbtn.setBounds(575, 10, 200, 30);
	        panel.add(detailsbtn);
	        detailsbtn.addActionListener(this);
	        
	        returnbtn = new JButton("Return to Options");
	        returnbtn.setBounds(625, 500, 150, 30);
	        returnbtn.addActionListener(this);
	        panel2.add(returnbtn);
	        
	        
	       
	        
	        detailsta = new JTextArea();
	        detailsta.setBounds(10, 60, 765, 430);
	        panel2.add(detailsta);
	        
	        
	        frame.setVisible(true);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if(e.getSource()==detailsbtn){
	            detailsta.setText(null);
	           
	            
	            int n=0;
	                try{  
	                    int en =Integer.parseInt((empnumtf.getText()));
	                    n = en-10001;
	                    int arrayTest = data.getempNum()[n];// to test if given employee number is within array                                                           
	                    String s=edata.printData(n);
	                    detailsta.append(s); 
	                    detailsta.setEditable(false);
	                }
	                catch(Exception e1){
	                    JOptionPane.showMessageDialog(null, "Employee Number is invalid. Try Again.", "", JOptionPane.ERROR_MESSAGE);
	                    empnumtf.setText(null);
	                }
	        }
	        else if(e.getSource()==returnbtn){
	            new Options();
	            frame.dispose();
	        }
	    }
	    
	}