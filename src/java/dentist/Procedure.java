/*
 *  Author     : Levi Llewellyn
 */
package dentist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * This class is the business object for the procedure table
 */
public class Procedure {
    String procode;
    String procname;
    String procdesc;
    double cost;
    
    
    public Procedure(){
        
    }
    
    public Procedure(String pcode, String proname, String prode, double cs){
        
        procode = pcode;
        procname = proname;
        procdesc = prode;
        cost = cs;
    }
    
    public void setpcode(String pc){
        procode = pc;
    }
    public String getpcode(){
        return procode;
    }
    public void setpname(String pn){
        procname = pn;
    }
    public String getpname(){
        return procname;
    }
    public void setpdes(String pd){
        procdesc = pd;
    }
    public String getpdes(){
        return procdesc;
    }
    public void setcost(double ct){
        cost = ct;
    }
    public double getcost(){
        return cost;
    }
    
    public void display(){
        System.out.println("The procedure code is "+procode);
        System.out.println("The procedure name is "+ procname);
        System.out.println("The procedure description is "+ procdesc);
        System.out.println("The procedure cost is "+ cost);
        
        
    }  
    /***
     * 
     * This method is to select data based on the procode
     ***/
     public void selectDBP(String pcode) {
        
        try {
            //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/DentistOfficeACCDB.accdb");
            Statement stmt = con.createStatement();
            String sql = "select * from Procedures WHERE procCode = "+"'"+ pcode+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                
                procode = rs.getString(1);
                procname = rs.getString(2);
                procdesc = rs.getString(3);
                cost = rs.getDouble(4);
                
            }
            con.close();
            
        }
        catch(Exception ae){
            System.out.println(ae);
            ae.printStackTrace();
        }
    }
  /***
     * 
     * This method is to select data from the procedure table
     ***/
     
     public void selectDBD(String pcode) {
        
        try {
            //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/DentistOfficeACCDB.accdb");
            Statement stmt = con.createStatement();
            String sql = "select * from Procedures WHERE procCode = "+"'"+ pcode+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                
                procode = rs.getString(1);
                procname = rs.getString(2);
                procdesc = rs.getString(3);
                cost = rs.getDouble(4);
                
            }
            con.close();
            
        }
        catch(Exception ae){
            System.out.println(ae);
            ae.printStackTrace();
        }
    }
     
    public static void main(String[] args) {
        Procedure p2 = new Procedure();
        String tap = "p114";
        p2.selectDBP(tap);
       
        //p1.getpatid();
        p2.display();
        String name = p2.getpcode();
        System.out.println(name);
    }
    
}
