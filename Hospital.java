public class Hospital{
  
   private String name;
   private Clinic[] clinics;
   private int numOfClinics;
   private Appointment[] appointment;
   private int numOfApp=0;

   public Hospital(String n, int cSize, int aSize){
      name= n;
      clinics= new Clinic[cSize];
      numOfClinics=0;
      appointment= new Appointment[aSize];
   
   }

   public void addClinic(Clinic c){
      if(numOfClinics<clinics.length)
         clinics[numOfClinics++]= new Clinic(c); 
         
         }


   public boolean addAppointment(Patient p, Doctor doc, int d, int m, int y){   //The method checks first if the appointment is available (not booked)
      boolean available=false;
      if(numOfApp < appointment.length){
         for(int i=0; i<numOfApp; i++){
            available=appointment[i].checkDate(d,m,y,doc);
            if(available)
               break;
         }
         if(available)
            return false;
         else{
            Appointment app =new Appointment(p,doc);
            app.setDay(d);
            app.setMonth(m);
            app.setYear(y);
            appointment[numOfApp++]=new Appointment(app);
            return true;
         }
      }
      return false; 
   }
 
   public boolean cancelAppointment(int appNum){
      for(int i=0;i<numOfApp;i++)
         if(appointment[i].getAppNum()==appNum){
            for(int j=i ;j<numOfApp-1 ;j++)
               appointment[j]=appointment[j+1];
            numOfApp--;
            appointment[numOfApp]=null;
            return true;
         }
      return false;
   }

   public void searchDoctors(String cName){
      for(int i=0;i<3;i++)
         if(clinics[i].getName().equals(cName)){
            System.out.println("The Name of doctors in the clinic:\n ");
            clinics[i].displayDoctors();
            return; 
         }
      System.out.println("The Name of clinic not available");
   }

   public void viewDoctorInfo(String dName,String cName){
      int index=0;
      for(int i=0;i<3;i++)
         if(clinics[i].getName().equals(cName)){
            index=i; 
            break;
         }
      Doctor[] doc= clinics[index].getDoctors();
      for(int i=0; i<3 ; i++)
         if(doc[i].getName().equals(dName)){
            doc[i].displayInfo();
            return;
         }
      System.out.println("not found");
   }

   public Appointment[] getAppointment(){
      return appointment;
   }

   public Clinic[] getClinics(){
      return clinics;
   }
   
   public int getNumOfApp(){
   return numOfApp;
   }
}
