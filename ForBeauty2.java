import java.io.*;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ForBeauty2{
   public static void main(String[]args){
   
      Hospital hospital= new Hospital("ForBeauty", 3, 100);
   
      Clinic c1= new Clinic("Dental");
      Clinic c2= new Clinic("Cosmetic");
      Clinic c3= new Clinic("Dermatology");
   
      Doctor d1= new Doctor("Ahmad", 30, 'M', "0504562745", "Orthodontics", 'S');
      Doctor d2= new Doctor("Amal", 50, 'F', "0507954486", "Jaw surgeon", 'C');
      Doctor d3= new Doctor("Saud", 26, 'M', "0507403785", "Endodontist", 'R');
   
      Doctor d4= new Doctor("Sarah", 32, 'F', "05047946099", "Plastic surgeon",'S');
      Doctor d5= new Doctor("Mona", 25, 'F', "0506700367", "Hair Transplant", 'R');
      Doctor d6= new Doctor("Mohammed", 55, 'M', "0504897652", "Injection expert", 'C');
   
      Doctor d7= new Doctor("Mustafa", 65, 'M', "0579593362", "Dermatological surgeon", 'C');
      Doctor d8= new Doctor("Rana", 44, 'F', "0577789005", "Skin & acne", 'S');
      Doctor d9= new Doctor("Haya", 24, 'F', "0500876554", "Liser hair remover", 'R');
   
      c1.addDoctor(d1);
      c1.addDoctor(d2);
      c1.addDoctor(d3);
   
      c2.addDoctor(d4);
      c2.addDoctor(d5);
      c2.addDoctor(d6);
   
      c3.addDoctor(d7);
      c3.addDoctor(d8);
      c3.addDoctor(d9);
   
      hospital.addClinic(c1);
      hospital.addClinic(c2);
      hospital.addClinic(c3);
   
      Patient p1 = new Patient("Tala adel", 20, 'F', "0500000001");
      Patient p2 = new Patient("Talal Fahad", 30, 'M', "0503333925");
      Patient p3 = new Patient("Thamer yaser", 32, 'M', "0506643194");
      Patient p4 = new Patient("Nouf Sami", 22, 'F', "0567839246");
   
      hospital.addAppointment(p1, d1, 2,5,2023);
      hospital.addAppointment(p2, d3, 4,5,2023);
      hospital.addAppointment(p3, d5, 2,6,2023);
      hospital.addAppointment(p1, d6, 10,5,2023);
      hospital.addAppointment(p4, d8, 12,4,2023);
      hospital.addAppointment(p3, d7, 8,5,2023);
      hospital.addAppointment(p2, d4, 16,6,2023);
      hospital.addAppointment(p4, d2, 13,5,2023);
      hospital.addAppointment(p3, d2, 2,5,2023);
            
      
      //Adding the appointments to the object file appointments
      try{
         File hospitalAppointments = new File("appointments.data");
         FileOutputStream fos = new FileOutputStream(hospitalAppointments);
         ObjectOutputStream oos = new ObjectOutputStream(fos);
      
         Appointment hAppointments[] = hospital.getAppointment();
         for(int i=0; i<hospital.getNumOfApp(); i++)                
            oos.writeObject(hAppointments[i]);
         oos.close();
      } 
      //Handeling the checked exception
      catch(IOException e){
         System.out.println("Sorry, file not found");
      }  
   
      Scanner input= new Scanner(System.in);
   
      Clinic[] clinics= hospital.getClinics();
      
   
   
      int choice;
      System.out.println("Select:\n(1)Doctor\n(2)patient: ");
      choice=input.nextInt();
   
      if(choice==1){
      
         String clinic=null;
         String name=null;
         
         //Getting the doctor's name and clinic from the text file (Doctor Info)
         try{
            File f= new File("Doctor Info.txt");
            FileReader fr= new FileReader(f);
            BufferedReader br= new BufferedReader(fr);
            clinic=br.readLine();
            name=br.readLine();
            br.close();
         }
         //Handeling the checked exception
         catch(IOException e){
            System.out.println("File not found");
         }
      
      
         while(true){
         
            System.out.println("\nEnter your option:\n(1)View my appointments \n(2)View a patient information \n(3)Exit");
            choice= input.nextInt();
         
            switch(choice){
               case 1:
                  Clinic c= null;
                  for(int i=0; i<clinics.length; i++)
                     if(clinics[i].getName().equalsIgnoreCase(clinic))
                        c=clinics[i];
                  if(c==null){
                     System.out.println("Sorry not found");
                     break;
                  }
               
               
                  Doctor[] doctors =c.getDoctors();
                  Doctor doc=null;
                  for(int i=0; i<doctors.length; i++)
                     if(doctors[i].getName().equalsIgnoreCase(name))
                        doc=doctors[i];
                  if(doc==null){
                     System.out.println("Sorry not found");
                     break;
                  }
               
               
                  Appointment[] appointments= doc.myAppointments(hospital.getAppointment());
                  try{
                     for(int i=0; i<=appointments.length; i++)                        
                        if(appointments[i]!=null)
                           appointments[i].displayInfo();
                  }
                  //Handeling unchecked exception (the loop's exception) 
                  catch(ArrayIndexOutOfBoundsException e){                       
                  }
               
                  break; 
            
               case 2:
                  String id;
                  
                  //Getting the patient id number from the user using GUI
                  GUI g= new GUI();
                  while(!g.IDState()){}
                  id= g.getID();
                  
                  appointments= hospital.getAppointment();
                  Patient p=null;
                  for(int i=0; i<appointments.length; i++)
                     if(appointments[i]!=null)
                        if(appointments[i].getPatient().getId().equals(id))
                           p=appointments[i].getPatient();
                  if(p==null){
                     JOptionPane.showMessageDialog(null,"Sorry not found","Patient info",JOptionPane.ERROR_MESSAGE);

                     break;
                  }
                  
                  //Displaing the patient information to the user in the GUI
                  g.textArea.append(p.toString());
                  
                  break;
            
               case 3:
                  System.exit(0);
               
               default:
                  System.out.println("Invalid input");
            }
         }
      }
      
      else if(choice==2){
         while(true){
            System.out.println("\nEnter your option:\n(1)Book appointment\n(2)Cancel appointment\n(3)View doctors of a specific clinic\n(4)View a doctor's information\n(5)View my appointments\n(6)Exit");
            choice= input.nextInt();
         
            switch(choice){
            
               case 1:
                  //The patient book an appointment using GUI
                  AppointmentGUI gui= new AppointmentGUI();
               
                  break;
            
               case 2:
                  int num;
                  System.out.println("Enter the appoinment number: ");
                  num= input.nextInt();
                  if(hospital.cancelAppointment(num))
                     System.out.println("The appointment is canceled successfully");
                  else System.out.println("Sorry, can't cancel the appointment");
                  break;
            
               case 3:
                  System.out.println("Enter the clinic you want to viwe it's doctors (Dental-Cosmetic-Dermatology): ");
                  String clinic= input.next();
                  hospital.searchDoctors(clinic);
                  break;
            
               case 4:
                  System.out.println("Enter the doctor's clinic name  (Dental-Cosmetic-Dermatology): ");
                  clinic= input.next();
                  System.out.println("Enter the doctor's name: ");
                  String name= input.next();
                  hospital.viewDoctorInfo(name,clinic);
                  break;
            
               case 5:
                  System.out.println("Enter your ID: ");
                  String id= input.next();
                  Appointment[] appointments= hospital.getAppointment();
                  Patient p=null;
                  for(int i=0; i<appointments.length; i++)
                     if(appointments[i]!=null)
                        if(appointments[i].getPatient().getId().equals(id))
                           p=appointments[i].getPatient();
                  if(p==null){
                     System.out.println("Sorry not found");
                     break;
                  }
                  Appointment[] apps=p.myAppointments(appointments);
                  for(int i=0; i<apps.length; i++)
                     if(apps[i]!=null)
                        apps[i].displayInfo();
                  break;
            
               case 6:
                  System.exit(0);
                   
               default:
                  System.out.println("Invalid input");
            }
         }
      }
      
      
      
      else System.out.println("Sorry, invalid input");
   
   }
}




