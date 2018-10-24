
package dentist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * *
 *  Author     : Levi Llewellyn
 * This is the dentist business object class
     **
 */
//variables
public class Dentist {

    String denid;
    String passwd;
    String fname;
    String lname;
    String email;
    String office;
    public appointlist alists = new appointlist();

    //Blank constructor
    public Dentist() {

    }

    public Dentist(String ids, String pw, String fn, String ln, String em, String off) {
        denid = ids;
        passwd = pw;
        fname = fn;
        lname = ln;
        email = em;
        office = off;

    }

    //Getters and Setters
    public void setDenid(String ids) {
        denid = ids;
    }

    public String getDenid() {
        return denid;
    }

    public void setDenpass(String pw) {
        passwd = pw;
    }

    public String getDenpass() {
        return passwd;
    }

    public void setDenfname(String fn) {
        fname = fn;
    }

    public String getDenfname() {
        return fname;
    }

    public void setDenlname(String ln) {
        lname = ln;
    }

    public String getDenlname() {
        return lname;
    }

    public void setDenemail(String em) {
        email = em;
    }

    public String getDenemail() {
        return email;
    }

    public void setDenoffice(String off) {
        office = off;
    }

    public String getDenoffice() {
        return office;
    }
/***
     * 
     * This display method for the dentist business object
     ***/
    public void display() {
        System.out.println("Your patient id is " + denid);
        System.out.println("Your password is " + passwd);
        System.out.println("Your first name  is " + fname);
        System.out.println("Your lastname is " + lname);
        System.out.println("Your email is " + email);
        System.out.println("Your office is " + office);
        alists.display();

    }
  /***
     * 
     * This method is to select information from the dentist table  
     ***/
    public void selectDB(String id) {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/DentistOfficeACCDB.accdb");
            Statement stmt = con.createStatement();
            String sql = "select * from Dentists WHERE id = " + "'" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                denid = rs.getString(1);
                passwd = rs.getString(5);
                fname = rs.getString(2);
                lname = rs.getString(3);
                email = rs.getString(4);
                office = rs.getString(6);

            }
            con.close();

        } catch (Exception ae) {
            System.out.println(ae);
            ae.printStackTrace();
        }

        getAppointments();

    }
/***
     * 
     * This method is to update the information to the dentist table
     ***/
    public void updateDB() {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/DentistOfficeACCDB.accdb");
            Statement stmt = con.createStatement();
            String sql = "Update Dentists  Set passwd ='" + getDenpass() + "', firstName ='" + getDenfname()
                    + "', lastName ='" + getDenlname() + "', email ='" + getDenemail() + "', office ='" + getDenoffice()
                    + "' where Id = '" + getDenid() + "'";
            System.out.println(sql);
            int n;
            n = stmt.executeUpdate(sql);
            if (n == 1) {
                System.out.println("Update Successful!!");
            }
            con.close();

        } catch (Exception ae) {

        }
    }
    /***
     * 
     * This method get a list of appointments based on the dentist id
     ***/

    public void getAppointments() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/DentistOfficeACCDB.accdb");
            Statement stmt = con.createStatement();
            String sql = "select Patid  from Appointments WHERE dentId = " + "'" + getDenid() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            Appoint a1;
            String patid;
            while (rs.next()) {

                patid = rs.getString(1);
                System.out.println("Pat ID = " + patid);
                a1 = new Appoint();
                a1.selectDBP(patid);
                //a1.display();
                alists.adapoint(a1);
                //a1.display();            
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Dentist p2 = new Dentist();
        String tap = "d201";
        p2.selectDB(tap);
       p2.display();
        p2.setDenpass("11111");
        p2.updateDB();
        
       /* String name = "jackey";
        //p1.getpatid();
        p2.setDenfname(name);
        p2.setDenlname("working");
        p2.setDenpass("12345");
        p2.updateDB();
        p2.display();

        //   System.out.println(name);*/
    }
}
