package motorphgui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Payroll implements ActionListener {

    Data data = new Data();
    Attendance attend = new Attendance();
    Computations compute = new Computations();
    
    JFrame frame;
    JPanel panel1,panel2;
    JComboBox yearcb,monthcb,daycb,year2cb,month2cb,day2cb;
    JLabel sdlbl,yrlbl,mlbl,dlbl,edlbl,yr2lbl,m2lbl,d2lbl,empnumlbl;
    JButton payslipbtn,returnbtn;
    JTextArea payslipta;
    JTextField empnumtf;
    String sdate = null;
    String edate = null;
    
    Payroll(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(800, 600);
        frame.setResizable(false);
        
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0,200 , 600);
        frame.add(panel1);
        
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(200, 0,600 , 600);
        frame.add(panel2);
        
        
        empnumlbl= new JLabel("Enter Employee Number:");
        empnumlbl.setBounds(25, 20, 150, 20);
        panel1.add(empnumlbl);
        
        empnumtf= new JTextField(10);
        empnumtf.setBounds(25, 50, 150, 30);
        panel1.add(empnumtf);
        
        sdlbl = new JLabel("Start Date:");
        sdlbl.setBounds(10, 110, 100, 30);
        panel1.add(sdlbl);
        
        yrlbl = new JLabel("Year:");
        yrlbl.setBounds(10, 150, 100, 30);
        panel1.add(yrlbl);       
        
        String[] yr = {"None","2022"};
        yearcb = new JComboBox(yr);
        yearcb.setBounds(80, 160, 100, 20);
        panel1.add(yearcb);
        

        mlbl = new JLabel("Month:");
        mlbl.setBounds(10, 180, 100, 30);
        panel1.add(mlbl);

        String[] m = {"None","09","10","11","12"};
        monthcb = new JComboBox(m);
        monthcb.setBounds(80, 190, 100, 20);
        panel1.add(monthcb);   
        
  
        dlbl = new JLabel("Day:");
        dlbl.setBounds(10, 210, 100, 30);
        panel1.add(dlbl);

        
        String[] d = {"None","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
                       "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        
        daycb = new JComboBox(d);
        daycb.setBounds(80, 220, 100, 20);
        panel1.add(daycb);
        

        
        edlbl = new JLabel("End Date:");
        edlbl.setBounds(10, 260, 100, 30);
        panel1.add(edlbl);
        
        yr2lbl = new JLabel("Year:");
        yr2lbl.setBounds(10, 300, 100, 30);
        panel1.add(yr2lbl);       
        
        
        year2cb = new JComboBox(yr);
        year2cb.setBounds(80, 310, 100, 20);
        panel1.add(year2cb);
        
        
        m2lbl = new JLabel("Month:");
        m2lbl.setBounds(10, 330, 100, 30);
        panel1.add(m2lbl);
        
        
        month2cb = new JComboBox(m);
        month2cb.setBounds(80, 340, 100, 20);
        panel1.add(month2cb);
        
        
        d2lbl = new JLabel("Day:");
        d2lbl.setBounds(10, 360, 100, 30);
        panel1.add(d2lbl);
        
        day2cb = new JComboBox(d);
        day2cb.setBounds(80, 370, 100, 20);
        panel1.add(day2cb);
        
        
       
        
        payslipbtn = new JButton("Generate Payslip");
        payslipbtn.setBounds(25, 450, 150, 30);
        panel1.add(payslipbtn);
        payslipbtn.addActionListener(this);
        
        returnbtn = new JButton("Return to Options");
        returnbtn.setBounds(25, 500, 150, 30);
        panel1.add(returnbtn);
        returnbtn.addActionListener(this);
        
        
        payslipta = new JTextArea();
        payslipta.setBounds(10, 10, 565, 545);
        panel2.add(payslipta);
        
        
        
        
       frame.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==payslipbtn){
           payslipta.setText(null);
 
            int n=0;
            
            try{  
               
                int en =Integer.parseInt((empnumtf.getText()));
                n = en-10001;
                int arrayTest = data.getempNum()[n];// to test if given employee number is within array
                
                

            }
            catch(Exception e1){
                JOptionPane.showMessageDialog(null, "Employee Number is invalid. Try Again.", "", JOptionPane.ERROR_MESSAGE);
                empnumtf.setText(null);
            }
            
            sdate =  monthcb.getSelectedItem()+"/"+daycb.getSelectedItem()+"/"+
                       yearcb.getSelectedItem();
            edate = monthcb.getSelectedItem()+"/"+day2cb.getSelectedItem()+"/"+
                        year2cb.getSelectedItem();
  
            try{
                float h = attend.computeHours(n, sdate, edate);
                String s = compute.printPayslip(n, sdate, edate,h);
                payslipta.append(s);    
                payslipta.setEditable(false);
            }
            catch(Exception e2){
                JOptionPane.showMessageDialog(null, "Date is invalid. Try Again.", "", JOptionPane.ERROR_MESSAGE);
                monthcb.setSelectedItem(0);
                daycb.setSelectedIndex(0);
                yearcb.setSelectedIndex(0);
                monthcb.setSelectedIndex(0);
                day2cb.setSelectedIndex(0);
                year2cb.setSelectedIndex(0);
                empnumtf.setText(null);
            }
       }
       else if(e.getSource()==returnbtn){
           new Options();
           frame.dispose();
       }
        
    }
    
}