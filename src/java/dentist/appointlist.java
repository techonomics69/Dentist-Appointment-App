package dentist;


/***
 *
 * This class is the business object to make an appointment list
 **/
public class appointlist {
    
    
    //list of accounts array
    public int count = 0;
    public Appoint alist[] = new Appoint[10];
    
    
    //addaccount method
    public void adapoint(Appoint a1) {
        alist[count] = a1;
        count++;
    }
    //Display method
    public void display() {
        for (int x = 0; x < count; x++) {
            alist[x].display();
            System.out.println("-------------");
        }
    }
    //testing main
   
    
}
