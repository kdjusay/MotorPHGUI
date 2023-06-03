package motorphgui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Options implements ActionListener {

    JFrame frame;
    JButton infobtn,payrollbtn,viewAllbtn,leavebtn,exitbtn;
    JPanel panel;
    
    
    
   
   Options(){
       frame = new JFrame();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(false);
       frame.setLayout(null);
       frame.setSize(395, 280);
       
       panel= new JPanel();
       panel.setLayout(null);
       panel.setBounds(0, 0, 395, 280);
       frame.add(panel);
      
       
       
       infobtn = new JButton("Employee Information");
       infobtn.setBounds(10, 30, 170, 40);
       panel.add(infobtn);
       infobtn.addActionListener(this);
       
       
       payrollbtn = new JButton("Employee Payroll");
       payrollbtn.setBounds(10, 100, 170, 40);
       panel.add(payrollbtn);
       payrollbtn.addActionListener(this);
       
       exitbtn =new JButton("Exit");
       exitbtn.setBounds(10, 170, 170, 40);
       panel.add(exitbtn);
       exitbtn.addActionListener(this);
       
       viewAllbtn = new JButton("View All");
       viewAllbtn.setBounds(200, 30, 170, 40);
       panel.add(viewAllbtn);
       viewAllbtn.addActionListener(this);

       leavebtn = new JButton("Leave Application");
       leavebtn.setBounds(200, 100, 170, 40);
       panel.add(leavebtn);
       leavebtn.addActionListener(this);
       
       frame.setVisible(true);

       
   }

   @Override
   public void actionPerformed(ActionEvent e) {
       if(e.getSource()==infobtn){
           new EmployeeInfo();
           frame.dispose();
           
       }
       
       else if(e.getSource()==payrollbtn){
           new Payroll();
           frame.dispose();
       }
       
       else if(e.getSource()==viewAllbtn){
           try {
               new ViewAllFrame();
               frame.dispose();
           } catch (IOException ex) {
               Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
       
       
       else if(e.getSource()==leavebtn){
           try {
               new LeaveApplicationFrame();
           } catch (IOException ex) {
               Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
           }
           frame.dispose();
       }
       
       else if(e.getSource()==exitbtn){
           new LogIn();
           frame.dispose();
       }
       
       
   }
   
}