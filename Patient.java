import java.io.*;
public class Patient extends Person implements Serializable{

   private String id;
   public static int numOfPatient; //counter

   public Patient(String n, int a, char g, String ph){
      super(n,a,g,ph);
      numOfPatient++;
      id=numOfPatient+"000"+ph.substring(0,3); //genrate unique id
   }

   public Appointment[] myAppointments( Appointment[] app){
      Appointment[] myApp = new Appointment[app.length];  
      int j = 0 ;
      for( int i = 0 ; i < myApp.length ; i++){
         if(app[i]!=null){
            if( app[ i ].getPatient().getId().equals(id)){  
               myApp[j]=app[i];
               j++;
               }
            break;
         }
      }
      return myApp;
   }

   public void displayInfo(){
      System.out.println("************Patient information************");
      super.displayInfo();
      System.out.println("ID: " + id);
   }

   public String getId(){
      return id  ;
   }
   
   public String toString(){
      return ("************Patient information************\n " + super.toString() + "\nID: " + id);
      
      }

}