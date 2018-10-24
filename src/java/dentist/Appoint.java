/*
 *  Author     : Levi Llewellyn
 */
package dentist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/***
This Class is the business object to select, insert, and delete appointments
 ***/
public class Appoint {
    String apptime;
    String patid;
    String dentid;
    String procode;
  
    public Appoint(){
        
    }
    
    public Appoint(String app, String id, String did, String code){
        apptime = app;
        patid = id;
        dentid = did;
        procode = code;
        
    }
    
    public void setapptime(String ap){
        apptime = ap;
    }
    public String getapptime(){
        return apptime;
    }
    public void setpatida(String pid){
        patid = pid;
    }
    public String getpatida(){
        return patid;
    }
    public void setdenit(String did){
        dentid = did;
    }
    public String getdenit(){
        return dentid;
    }
    public void setprocode(String pc){
        procode = pc;
    }
    public String getprocode(){
        return procode;
    }
    
    // The display method
    public void display(){
        
        System.out.println("The appointment time is "+apptime);
        System.out.println("The patients id is "+ patid);
        System.out.println("The dentist id is "+ dentid);
        System.out.println("The procedure code is "+ procode);
    }
    
    /*** 
     * 
     * This method is to select from the appointment database based on patient id
     ***/
      public void selectDBP(String id) {
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/DentistOfficeACCDB.accdb");
            Statement stmt = con.createStatement();
            String sql = "select apptDateTime, patId, dentId, procCode from Appointments WHERE patId = "+"'"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                
                apptime = rs.getString(1);
                patid = rs.getString(2);
                dentid = rs.getString(3);
                procode = rs.getString(4);
                
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
     * This method is to insert to the appointments table
     ***/
      public void insertDB(){
          
          try {
              Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/DentistOfficeACCDB.accdb");
            Statement stmt = con.createStatement();
              String sql = "Insert into Appointments (apptDateTime, patId, dentId, procCode) "
                      + "values('"+getapptime()+"','"+getpatida()+"','"+getdenit()+"','"+getprocode()+"')";
               int n;
               System.out.println(sql);
            n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("Update Successful!!");
              con.close();
          }
          catch(Exception ae){
              System.out.println(ae);
          }
          
          
      }
      
      /***
     * 
     * This method is to delete information from the appointments table
     ***/
      public void deleteDB(){
          
          try {
              Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/DentistOfficeACCDB.accdb");
            Statement stmt = con.createStatement();
              String sql = "Delete  from Appointments where patId ='" + getpatida()+"' " ;
                      
               int n;
            n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("delete Successful!!");
              con.close();
          }
          catch(Exception ae){
              System.out.println(ae);
          }
      }
      /***
     * 
     * This method is to select from the appointment table based on dentist id
     ***/
           public void selectDBD(String id){
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/DentistOfficeACCDB.accdb");
            Statement stmt = con.createStatement();
            String sql = "select apptDateTime, patId, dentId, procCode from Appointments WHERE dentId = "+"'"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                
                apptime = rs.getString(1);
                patid = rs.getString(2);
                dentid = rs.getString(3);
                procode = rs.getString(4);
                
            }
            con.close();
            
        }
        catch(Exception ae){
            System.out.println(ae);
            ae.printStackTrace();
        }
    }
      
      public static void main(String[] args) {
        Appoint p2 = new Appoint();
        p2.selectDBP("a911");
       p2.display();
     p2.deleteDB();
     
     /*p2.setapptime("jan 3 2018 9:00am");
       p2.setdenit("d902 ");
       p2.setprocode("p114");
       
       p2.setpatida("a911 ");
       p2.insertDB();
        p2.display();
        //p1.getpatid();
       
        String name = p2.getapptime();
        System.out.println(name);*/
    }
      
  

}

