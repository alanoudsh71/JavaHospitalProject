
public class Clinic{

   private String name;
   private Doctor[] doctors;
   private int numOfDoctors=0;

   public Clinic(String n){
      name=n;
      doctors= new Doctor[3]; 
   }

   public Clinic(Clinic c){
      name=c.name;
      doctors=c.doctors;
      numOfDoctors=c.numOfDoctors;
   }

   public boolean addDoctor(Doctor d){
      if(numOfDoctors<doctors.length){
         doctors[numOfDoctors++]=d;
         return true;
      }
      return false; 
   }

   public void displayDoctors(){
      for(int i=0; i<numOfDoctors; i++)
         System.out.println(doctors[i].getName());
   }

   public String getName(){
      return name;
   }

   public Doctor[] getDoctors(){
      return doctors;
   }

   public int getNumOfDoctors(){
      return numOfDoctors;
   }

}