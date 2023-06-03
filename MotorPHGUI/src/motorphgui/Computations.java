package motorphgui;

import java.text.ParseException;
import static java.lang.String.format;

public class Computations {

	Data data = new Data();
	
	
    public double computesss(int n){
        
        double sss;// if-elseif-else statement is to check the category of the salary  
            if(data.getsal()[n]<=3250){
                sss = 135;
            }
            else if(data.getsal()[n]>3250 & data.getsal()[n]<=24750) {
               if(data.getsal()[n]%1000==250 |data.getsal()[n]%1000==750 ){// this check whether the salary is in the lower/upper bound of range. 
                   float mod = (data.getsal()[n]-3250)%500; // after deducting 3250, in every 500 increment, the sss increases by 22.5
                    float multiplier = ((data.getsal()[n]-3250-mod)/500);              
                    sss = 22.5*(multiplier)+135;                        
               }
                else{// this applies the normal formule is salary falls within the range
                    float mod = (data.getsal()[n]-3250)%500; 
                    float multiplier = ((data.getsal()[n]-3250-mod)/500);              
                    sss = 22.5*(multiplier+1)+135;           
               }
            }
            else{
                sss = 1125;
            }    
            return sss;  
    }
    public double computeph(int n){
           double ph;
          
           if(data.getsal()[n]<=10000){//if-elseif-else statement checks the range of salary and applies formula in each range
               ph = 300/2;
           }
           else if (data.getsal()[n]>10000 & data.getsal()[n]<60000){
               ph = data.getsal()[n]*(0.03)/2;
           }
           else{
               ph = 1800/2;
           }
            return ph;
    }
    
    public double computepg(int n){
        double pagibig;
        
        if(data.getsal()[n]>1000 & data.getsal()[n]<=1500){//if-else statement checks the range of salary and applies formula in each rang
            pagibig = data.getsal()[n]*(float)0.01;
        } 
        else{
            if(data.getsal()[n]*0.02 <100){// this nested if-else statement provides the pagibig to be 100 if the values exceeds 100
              pagibig= data.getsal()[n]*(float)0.02;
            }
            else{
                pagibig = 100;
            }
        }
        return pagibig;    
    }
    public double computetaxable(int n){
        double taxable = data.getsal()[n]-computesss(n)-computepg(n)-computeph(n);// saves all the deduction to get taxable income and save to variable taxable
        
        return taxable;
    }
    public float computetax(int n){
           double tax;
            
            if(data.getsal()[n] <=20832){//if-elseif-else statement checks the range of taxable income and applies formula in each range 
                tax = 0;
            }
            else if(data.getsal()[n]>20832 & data.getsal()[n]<33333){
                tax = (computetaxable(n)-20833)*0.2;               
            }
            else if(data.getsal()[n]>=33333 & data.getsal()[n]< 66667){
                tax = (computetaxable(n)-33333)*0.25+2500;
            }
            else if(data.getsal()[n]>=66667 & data.getsal()[n]< 166667){
                tax = (computetaxable(n)-66667)*0.3+10833;
            }
            else if(data.getsal()[n]>=166667 & data.getsal()[n]< 666667){
                tax = (computetaxable(n)-166667)*0.32+40833.33;
            }
            else{
                tax = (data.getsal()[n]-666667)*0.35+200833.33;
            }
           
            return (float) 
                    tax;
    }
    
    public float computeTotalDeduction(int n){
        float td = (float)(computesss(n)+computeph(n)+computepg(n)+computetax(n));
        return td;
    }
    
    public float computeTotalBenefits(int n){
        float tb = data.getrice()[n]+data.getphone()[n]+data.getcloth()[n];
        return tb;
        
    }
    
   
    public float computegs(int n, float hw) throws ParseException{
        float gs = ((data.getsal()[n])/(21*8))*hw;
        return gs;
    }
 
    public float computebenefits(int n){
        float benefits = data.getrice()[n]+data.getcloth()[n]+data.getphone()[n];
        return benefits;
    }
     public float computenet(int n,float hw) throws ParseException{
        
        float net = computegs(n,hw)+computebenefits(n)-computeTotalDeduction(n);
        return net;
    }
    
    
    public String printPayslip(int n,String sd, String ed, float hw) throws ParseException{
        String s = 
       
        "\n"+
        "                                                                 PAYSLIP\n"+
        "==================================================================================================\n"+        
        "Name:   \t"+data.getlastName()[n]+","+data.getfirstName()[n]+"\n"+
        "Position:   \t"+data.getposition()[n]+"\n"+
        "Basic Salary: \t"+data.getsal()[n]+"\n"+
        "Salary Period: "+sd+" to "+ed+"\n"+
        "=================================================================================================="+
        "\n                                                               EARNINGS\n"+
        "(Note: Salary Earned is temporarily based on hourly rate)\n\n"+
        "Salary Earned for the Period: "+format("%.2f",computegs(n,hw))+"\n\n"+
        
        "Benefits\n"+
        "Rice Subsidy:\t        "+data.getrice()[n]+"\n"+
        "Phone Allowance:  "+data.getphone()[n]+"\n"+ 
        "Clothing Allowance:"+data.getcloth()[n]+"\n\n"+
        "Gross Salary: "+format("%.2f",computegs(n,hw)+computeTotalBenefits(n))+"\n"+
        "==================================================================================================\n"+        
        "                                                                 DEDUCTIONS\n"+
        "Government Deductions\n"+
        "SSS:\t"+format("%.2f",computesss(n))+"\n"+
        "Philhealth:\t"+format("%.2f",computeph(n))+"\n"+
        "Pag-IBIG:\t"+format("%.2f",computepg(n))+"\n\n"+
        "Taxable Income: "+format("%.2f",computetaxable(n))+"\n"+
        "Withholding Tax: "+format("%.2f",computetax(n))+"\n\n"+
        "Total Deductions: "+format("%.2f",computeTotalDeduction(n))+"\n"+
        "==================================================================================================\n"+
        "Net Salary:\t"+format("%.2f",computenet(n,hw))+"\n"+
        "====================================================================================================";
        
        return s;
             
    }  
	
	
}
