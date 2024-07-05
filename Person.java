import java.io.*;
public abstract class Person implements Serializable{

   protected String name; 
   protected int age;
   protected char gender; //(M)= male, (F)=female
   protected String phone;

   public Person(String n, int a, char g, String ph){
      name = n;
      age= a;
      gender= g;
      phone = ph;
   }

   public abstract Appointment[] myAppointments(Appointment[] app);

   public void displayInfo(){
   
      System.out.println("Name: " + name);
      System.out.println("Age: " + age);
      System.out.println("Gender: " + gender + "         /////(M)= male,(F)=female");
      System.out.println("Phone number: " + phone);
   }

   public String getName(){
      return name;
   }
   
   public String toString(){
   String info= "Name: " + name+ "\nAge: " + age + "\nGender: " + gender + "         /////(M)= male,(F)=female" + "\nPhone number: " + phone;
   return info;
}}