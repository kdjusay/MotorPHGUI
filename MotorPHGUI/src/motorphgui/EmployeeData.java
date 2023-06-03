package motorphgui;

public class EmployeeData {
    Data data=new Data();
    
    public String printData(int n){
        String s =
        "Employee Details\n\n"+
        data.header[0]+data.getempNum()[n]+"\n"+//index data.header and Employee Number
        data.header[1]+data.getlastName()[n]+"\n"+//index data.header and use lastname from arraylist
        data.header[2]+data.getfirstName()[n]+"\n"+//index data.header and first name from arraylist      
        data.header[3]+data.getbirthday()[n]+"\n"+//index data.header and birthday
        data.header[4]+data.getaddress()[n]+"\n"+//index data.header and address
        data.header[5]+data.getphoneNum()[n]+"\n"+//index data.header and phone number
        data.header[6]+data.getsssNum()[n]+"\n"+//index data.header and SSS number
        data.header[7]+data.getphNum()[n]+"\n"+//index data.header and Philhealth number
        data.header[8]+data.gettinNum()[n]+"\n"+//index data.header and Tin number
        data.header[9]+data.getpgbNum()[n]+"\n"+//index data.header and pagibig number
        data.header[10]+data.getstatus()[n]+"\n"+//index data.header and status
        data.header[11]+data.getposition()[n]+"\n"+//index data.header and position
        data.header[12]+data.getsup()[n]+"\n\n"+//index data.header and supervisor
        "Salary and Other Benefits"+"\n\n"+
        data.header[13]+data.getsal()[n]+"\n"+//index data.header and salary
//---------------------------------------------------------------------------------------------------------------           
        data.header[14]+data.getrice()[n]+"\n"+//index data.header and rice subsidy
        data.header[15]+data.getphone()[n]+"\n"+//index data.header and phone allowance
        data.header[16]+data.getcloth()[n]+"\n"+//index data.header and salary
        data.header[17]+data.getsal()[n]/2+"\n"+//index data.header and compute gross semi month rate
        data.header[18]+data.getsal()[n]/(21*8)+"\n";//index data.header and compute hourly rate*/        
        
    return s;    
    
    }

	
}
