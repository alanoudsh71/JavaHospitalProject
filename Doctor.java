import java.io.*;
public class Doctor extends Person implements Serializable{

   private String field;
   private char degree; //(C)= consultant,(S)=specialist,(R)=resident

   public Doctor(String n, int a, char g, String ph, String f, char d){
      super(n,a,g,ph);
      field= f;
      degree= d;
   }

   public  Appointment[] myAppointments( Appointment[] app){
      Appointment[] myApp = new Appointment[app.length];  
      int j = 0 ;
      for( int i = 0 ; i < myApp.length ; i++){
         if(app[i]!=null){
            if( app[ i ].getDoctor().getName().equalsIgnoreCase(name) ){ 
               myApp[j]=app[i];
               j++;
            }
            break;
         }
      }
      return myApp;
   }


   public void displayInfo(){
      System.out.println("************Doctor information************");
      System.out.println("Doctor name: " + super.getName());
      System.out.println("Doctor field: " + field);
      System.out.println("Doctor degree:" + degree + "         /////(C)= consultant,(S)=specialist,(R)=resident");
   
   }

}