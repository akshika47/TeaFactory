
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//completed
/**
 *
 * @author acer
 */
public class Staff_Pay_Info {
    
    private double ETF_allowance;  // %
    private double EPF_allowance;   // %
    private double welfareAllowance;
    private double OTRate;
    
    public Staff_Pay_Info(double ETF_allowance,double EPF_allowance,
            double welfareAllowance,double OTRate){
        
        this.ETF_allowance=ETF_allowance;
        this.EPF_allowance=EPF_allowance;
        this.welfareAllowance=welfareAllowance;
        this.OTRate=OTRate;
    }
    
    public Staff_Pay_Info(){
        
        this.ETF_allowance=0;
        this.EPF_allowance=0;
        this.welfareAllowance=0;
        this.OTRate=0;
    }
    
    //setters
    
    public void setETFAllowance(double ETF_allowance ){
        this.ETF_allowance=ETF_allowance;
    }
    public void setEPFAllowance(double EPF_allowance){
        this.EPF_allowance=EPF_allowance;
    }
    public void setWelfareAllowance(double welfareAllowance ){
        this.welfareAllowance=welfareAllowance;
    }
    public void setOTRate(double OTRate){
        this.OTRate=OTRate;
    }
    
    //getters
    
    public double getETFAllowance(){
        return ETF_allowance;
    }
    public double getEPFAllowance(){
        return EPF_allowance;
    }
    public double getWelfareAllowance(){
        return welfareAllowance;
    }
    public double getOTRate(){
        return OTRate;
    }
    
    public void addTodatabase(){
        try {
            DatabaseManager dbm = DatabaseManager.getDbCon();
            dbm.insert("UPDATE staff_pay_info SET epf='"+EPF_allowance+"' WHERE pay_info='1'");
            dbm.insert("UPDATE staff_pay_info SET etf='"+ETF_allowance+"' WHERE pay_info='1'");
            dbm.insert("UPDATE staff_pay_info SET welfare='"+welfareAllowance+"' WHERE pay_info='1'");
            dbm.insert("UPDATE staff_pay_info SET ot_rate='"+OTRate+"' WHERE pay_info='1'");
            
            
            
        } catch (SQLException ex) {
            MessageBox.showMessage(ex.getMessage(), "SQL ERROR", "error");
        }
    }

}
