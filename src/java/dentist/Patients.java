
package dentist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/***
     * 
     * This class is the business object for the patients
     ***/
public class Patients {

    String patId;
    String password;
    String firstName;
    String lastName;
    String addr;
    String email;
    String insco;
    String apptime;
    

    // Setting the fields 
    public Patients() {
        patId = "";
        password = "";
        firstName = "";
        lastName = "";
        addr = "";
        email = "";
        insco = "";

    }
    //constructor that takes all fields 

    public Patients(String id, String pw, String fn, String ln, String add, String em, String ins) {
        patId = id;
        password = pw;
        firstName = fn;
        lastName = ln;
        addr = add;
        email = em;
        insco = ins;
    }
    //Getters and setters for the patient

    public void setpatid(String id) {
        patId = id;
    }

    public String getpatid() {
        return patId;
    }

    public void setpatpw(String pw) {
        password = pw;
    }

    public String getpatpw() {
        return password;
    }

    public void setpatfn(String fn) {
        firstName = fn;
    }

    public String getpatfn() {
        return firstName;
    }

    public void setpatln(String ln) {
        lastName = ln;
    }

    public String getpatln() {
        return lastName;
    }

    public void setpatadd(String add) {
        addr = add;
    }

    public String getpatadd() {
        return addr;
    }

    public void setpatem(String em) {
        email = em;
    }

    public String getpatem() {
        return email;
    }

    public void setpatinsco(String ins) {
        insco = ins;
    }

    public String getpatinsco() {
        return insco;
    }

    //Display method to console
    public void display() {
        System.out.println("Your patient id is " + patId);
        System.out.println("Your password is " + password);
        System.out.println("Your first name  is " + firstName);
        System.out.println("Your lastname is " + lastName);
        System.out.println("Your address is " + addr);
        System.out.println("Your email is " + email);
        System.out.println("Your insurance is " + insco);
    }

    /***
     * 
     * This method is to select information from the patients table
     ***/
    public void selectDB(String id) {
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/DentistOfficeACCDB.accdb");
            Statement stmt = con.createStatement();
            String sql = "select * from Patients WHERE patId = "+"'"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                
                patId = rs.getString(1);
                password = rs.getString(7);
                firstName = rs.getString(2);
                lastName = rs.getString(3);
                addr = rs.getString(4);
                email = rs.getString(5);
                insco = rs.getString(6);
                
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
     * This method is to update information to the patients table
     ***/
     public void updateDB(){
        
        try {  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/DentistOfficeACCDB.accdb");
            Statement stmt = con.createStatement();
            String sql = "Update Patients  Set passwd ='"+getpatpw()+"', firstName ='"+getpatfn()+
                    "', lastName ='"+getpatln()+"', addr ='"+getpatadd()+"', email ='"+getpatem()+"', insCo ='"+getpatinsco()+
                    "' where patId = '"+getpatid()+"'";  
            System.out.println(sql);
            int n;
            n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("Update Successful!!");
              con.close();
             
        }catch(Exception ae){
            
        }
    }
    /*
        public void getAppoint(){

        Appoint ap = new Appoint();
        ap.selectDB(patId);
        HttpSession ses1;
        ses1 = request.getSession();
        //setting the object in session
        ses1.setAttribute("ap", ap);
        
     
       
    
        }
    */
    
    

   public static void main(String[] args) {
        Patients p2 = new Patients();
        String tap = "a911";
       p2.selectDB(tap);
        p2.setpatpw("");
         p2.updateDB();
         
       /**String name = "workerbe";
       p2.setpatfn(name);
       p2.setpatln("empire");
      
        //p1.getpatid();
       **/
        
        p2.display();
        
    }
  
        
  
        //p1.getpatid();
       
}
