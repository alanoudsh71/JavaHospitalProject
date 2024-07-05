import java.io.*;
public class Appointment implements Serializable {

   private Doctor doctor;
   private Patient patient;
   private int day;
   private int month;
   private int year;
   private static int appCounter=0; 
   private int appNum; //Uniqe number for each appointment

   public Appointment(Patient p, Doctor d){
      patient=p;
      doctor=d;
      day=0;
      month=0;
      year=0;
      appNum= ++appCounter;
   }

   public Appointment(Appointment a){
      doctor= a.doctor;
      patient= a.patient;
      day=a.day;
      month=a.month;
      year=a.year;
      appNum=a.appNum; 
   }

   public void displayInfo(){
      System.out.println("    ************Appointment information************");
      System.out.println("The doctor: ");
      doctor.displayInfo();
      System.out.println("The patient: ");
      patient.displayInfo();
      System.out.println("Date: \n" + day + "/" + month +  "/" + year + "\nAppointmen number: " + appNum);
   }
   
   public boolean checkDate(int d, int m, int y, Doctor doc){
      boolean date= false;
      if(day==d)
         if(month==m)
            if(year==y)
               if(doctor.getName().equals(doc.getName()))
                  date= true;
      return date;
   }

   public void setDay(int d){
      day=d; 
   }

   public void setMonth(int m){
      month=m; 
   }

   public void setYear(int y){
      year=y; 
   }

   public Doctor getDoctor(){
      return doctor; 
   }

   public Patient getPatient(){
      return patient; 
   }

   public int getDay(){
      return day; 
   } 

   public int getMonth(){
      return month; 
   }

   public int getYear(){
      return year; 
   }

   public int getAppNum(){
      return appNum; 
   }

}