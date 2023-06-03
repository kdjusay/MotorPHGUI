package motorphgui;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.String.format;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ViewAllFrame implements ActionListener {
 
	JFrame frame,frame2;
    JPanel panel1,panel2;
    JTable table;
    String[] collbl;
    JScrollPane scrollpane;
    Object rowdata[][];
    JButton vmbtn,returnbtn, deletebtn;
    JComboBox year1cb,month1cb,day1cb,year2cb,month2cb,day2cb;
  
    Object selectedEmpnum;
    JLabel selectRowlbl, selectdatelbl, startlbl,endlbl,yr1lbl,m1lbl,d1lbl,yr2lbl,m2lbl,d2lbl;
    int selectedRow;
    
    Attendance attend = new Attendance();
    Computations compute = new Computations();
    Data data = new Data();
    
    Object[][] getRowData() throws FileNotFoundException, IOException{
        rowdata = new Object[25][7];  
        CSVReader csvreader = new CSVReader(new FileReader("MotorPH Employee Data.csv"));

        String[] line;
        int i=0;
        while((line=csvreader.readNext())!=null){
                

                rowdata[i][0] = line[0];
                rowdata[i][1] = line[1];
                rowdata[i][2] = line[2];
                rowdata[i][3] = line[6];
                rowdata[i][4] = line[7];
                rowdata[i][5] = line[8];
                rowdata[i][6] = line[9];
                i++;
            
        }
        csvreader.close();
        return rowdata;
        
    }
   
   
    
    ViewAllFrame() throws IOException{
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLayout(null);  
        
        frame2 = new JFrame();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(400, 300);
        frame2.setResizable(false);
        frame2.setLayout(null);  
        
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 800,20 );
        frame.add(panel1);
        
        
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 420, 800,180 );
        frame.add(panel2);

  
        vmbtn = new JButton("View Details and Salary");
        vmbtn.setBounds(590, 10, 180, 30);
        panel2.add(vmbtn);
        vmbtn.addActionListener(this);
      
        deletebtn = new JButton("Delete Selected Row");
        deletebtn.setBounds(590, 50, 180, 30);
        panel2.add(deletebtn);
        deletebtn.addActionListener(this);
        
        returnbtn = new JButton("Return to Options");
        returnbtn.setBounds(590,95,180,30);
        panel2.add(returnbtn);
        returnbtn.addActionListener(this);
         
        
        collbl =new String[]{"Employee Number","Last Name","First Name","SSS Number","Philhealth Number",
                "TIN","PAGIBIG Number"};   
        rowdata = getRowData();
         
        
        table = new JTable(rowdata,collbl);
       

        scrollpane = new JScrollPane(table);
        scrollpane.setBounds(13, 30, 760, 390);
        frame.getContentPane().add(scrollpane);
        
        selectdatelbl = new JLabel("Select Date for Salary Computation");
        selectdatelbl.setBounds(100, 0,300 , 20);
        panel2.add(selectdatelbl);
       
        startlbl = new JLabel("Start Date:");
        startlbl.setBounds(50, 30,80 , 20);
        panel2.add(startlbl);
        
        yr1lbl = new JLabel("Year:");
        yr1lbl.setBounds(13, 55, 80, 20);
        panel2.add(yr1lbl);    
        
        m1lbl = new JLabel("Month:");
        m1lbl.setBounds(13, 80, 80, 20);
        panel2.add(m1lbl);
        
        d1lbl = new JLabel("Day:");
        d1lbl.setBounds(13, 105, 80, 20);
        panel2.add(d1lbl);
        
        
        String[] yr = {"None","2022"};
        year1cb = new JComboBox(yr);
        year1cb.setBounds(70, 55, 80, 20);
        panel2.add(year1cb);
        
        
        String[] m = {"None","09","10","11","12"};
        month1cb = new JComboBox(m);
        month1cb.setBounds(70, 80, 80, 20);
        panel2.add(month1cb);   
        
        String[] d = {"None","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
                       "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        
        day1cb = new JComboBox(d);
        day1cb.setBounds(70, 105, 80, 20);
        panel2.add(day1cb);
       
        
        endlbl = new JLabel("End Date:");
        endlbl.setBounds(230, 30,80 , 20);
        panel2.add(endlbl);
        
        yr2lbl = new JLabel("Year:");
        yr2lbl.setBounds(200, 55, 80, 20);
        panel2.add(yr2lbl);       
        
        
        m2lbl = new JLabel("Month:");
        m2lbl.setBounds(200, 80, 80, 20);
        panel2.add(m2lbl);
        
        
        d2lbl = new JLabel("Day:");
        d2lbl.setBounds(200, 105, 80, 20);
        panel2.add(d2lbl);
        
        selectRowlbl = new JLabel("Select Employee in Table");
        selectRowlbl.setBounds(320,0,300,20);
        panel1.add(selectRowlbl);
        
       
        year2cb = new JComboBox(yr);
        year2cb.setBounds(260, 55, 80, 20);
        panel2.add(year2cb);
        
        

        
        month2cb = new JComboBox(m);
        month2cb.setBounds(260, 80, 80, 20);
        panel2.add(month2cb);   
        
  

        
        day2cb = new JComboBox(d);
        day2cb.setBounds(260, 105, 80, 20);
        panel2.add(day2cb);
        
      
        
        frame.setVisible(true);
        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel model = table.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e){
                            
               ListSelectionModel lsm = (ListSelectionModel) e.getSource();
               selectedRow=lsm.getMinSelectionIndex();
               data.setSelectedRow(selectedRow);
               selectedEmpnum=table.getValueAt(selectedRow, 0);

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vmbtn){
            if(table.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "No selected row.");
                
            }
            
            boolean testdate=true;
            
            if( month1cb.getSelectedItem().equals("None") |month2cb.getSelectedItem().equals("None")|
                year1cb.getSelectedItem().equals(selectedEmpnum)| year2cb.getSelectedItem().equals("None")|
                day1cb.getSelectedItem().equals("None")|day2cb.getSelectedItem().equals("None")){
                
                JOptionPane.showMessageDialog(null, "Date is invalid. Try Again.", "", JOptionPane.ERROR_MESSAGE);
                
                month1cb.setSelectedItem(0);
                day1cb.setSelectedIndex(0);
                year1cb.setSelectedIndex(0);
                month1cb.setSelectedIndex(0);
                day2cb.setSelectedIndex(0);
                year2cb.setSelectedIndex(0);
                
                testdate = false;
            }
 
            
            else if(!table.getSelectionModel().isSelectionEmpty() & testdate==true){
               
                String m = String.valueOf(selectedEmpnum);
                int n = Integer.parseInt(m)-10001;
                
                ViewMoreFrame vm =new ViewMoreFrame(data);
                
                frame.dispose();
                
                try {
                    CSVReader csvreader = new CSVReader(new FileReader("MotorPH Employee Data.csv"));
                    String[] line;
                    
                    while((line=csvreader.readNext())!=null){
                        if(m.equals(line[0])){
                            vm.enumtf.setText(line[0]);
                            vm.lnametf.setText(line[1]);
                            vm.fnametf.setText(line[2]);
                            vm.bdaytf.setText(line[3]);
                            vm.addtf.setText(line[4]);
                            vm.phonenumtf.setText(line[5]);
                            vm.sssnumtf.setText(line[6]);
                            vm.phnumtf.setText(line[7]);
                            vm.tinnumtf.setText(line[8]);
                            vm.pgnumtf.setText(line[9]);
                            vm.statustf.setText(line[10]);
                            vm.postf.setText(line[11]);
                            vm.suptf.setText(line[12]);
                            vm.basictf.setText(line[13]);
                            vm.ricetf.setText(line[14]);
                            vm.phonetf.setText(line[15]);
                            vm.clothtf.setText(line[16]);
                            vm.semratetf.setText(String.valueOf(format("%.2f",Float.parseFloat(line[13])/2)));
                            vm.hratetf.setText(String.valueOf(format("%.2f",Float.parseFloat(line[13])/(21*8))));
                            csvreader.close();
     
                        }
                    }
  
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ViewAllFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ViewAllFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String sdate = month1cb.getSelectedItem()+"/"+day1cb.getSelectedItem()+"/"+
                               year1cb.getSelectedItem();
                String edate = month2cb.getSelectedItem()+"/"+day2cb.getSelectedItem()+"/"+
                               year2cb.getSelectedItem();
                vm.salperiodtf.setText(sdate+" to "+edate);

                try{
                    CSVReader csvreader = new CSVReader(new FileReader("MotorPH Employee Data.csv"));
                    String[] line;

                    while((line=csvreader.readNext())!=null){
                        if(m.equals(line[0])){

                            float h = attend.computeHours(n, sdate, edate);

                            vm.salearnedtf.setText(String.valueOf(format("%.2f",compute.computegs(n, h))));
                            vm.rice1tf.setText(line[14]);
                            vm.phone1tf.setText(line[15]);
                            vm.cloth1tf.setText(line[16]);
                            vm.grosstf.setText(String.valueOf(format("%.2f",compute.computegs(n, h))));          
                            vm.sssdeducttf.setText(String.valueOf(format("%.2f",compute.computesss(n))));
                            vm.phdeducttf.setText(String.valueOf(format("%.2f",compute.computeph(n))));
                            vm.pgdeducttf.setText(String.valueOf(format("%.2f",compute.computepg(n))));
                            vm.taxdeducttf.setText(String.valueOf(format("%.2f",compute.computetax(n))));
                            vm.totaldeducttf.setText(String.valueOf(format("%.2f",compute.computeTotalDeduction(n))));
                            vm.nettf.setText(String.valueOf(format("%.2f",compute.computenet(n, h))));
                            
                            break;
                        }
                    }
                    csvreader.close();
       
               
                }   catch (FileNotFoundException ex) { 
                        Logger.getLogger(ViewAllFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ViewAllFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {  
                        Logger.getLogger(ViewAllFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } 
            }
        }
        
       
        else if(e.getSource()==returnbtn) {
            new Options();
            frame.dispose();
            
        }   
        else if(e.getSource()==deletebtn){
            
            String empNum=String.valueOf(selectedEmpnum) ;
             
            String csvfile = "MotorPH Employee Data.csv";
            
            try {
                CSVReader csvreader = new CSVReader(new FileReader(csvfile));
                CSVWriter csvwriter = new CSVWriter(new FileWriter(csvfile+".tmp"));
                
                String[] line;
                while((line =csvreader.readNext())!=null){
                    if(line[0].equals(empNum)){                  
                        continue;
                    }
                    csvwriter.writeNext(line);
                }
                csvreader.close();
                csvwriter.close();
                
                new File(csvfile).delete();
                new File(csvfile+".tmp").renameTo(new File(csvfile));
                
                JOptionPane.showMessageDialog(null, "Record Deleted.");
                new Options();
                frame.dispose();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ViewAllFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ViewAllFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
}