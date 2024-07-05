import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class AppointmentGUI extends JFrame implements ActionListener {
   
   private JLabel nameLabel, ageLabel, phoneLabel, genderLabel, clinicLabel, doctorLabel, dateLabel;
   private JTextField nameField, ageField, phoneField;
   private JButton saveButton;
   private JRadioButton maleRadio, femaleRadio;
   private ButtonGroup genderGroup = new ButtonGroup();
   private JComboBox<String> clinicComboBox, doctorComboBox, dayComboBox, monthComboBox, yearComboBox;
   Container contentPane;
   private String[][] doctors = {
      {"Ahmad", "Amal", "Saud"},
      {"Sarah", "Mona", "Mohammed"},
      {"Mustafa", "Rana", "Haya"}
      };
   private String[] clinics = {"Dental", "Cosmetics", "Dermatology"};
      
   private String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                           "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
   private String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
   private String[] years = {"2022", "2023", "2024", "2025"};
   
   private String name=null;
   private int age;
   private String phone=null;
   private char gender=' ';
   private String clinic;
   private String doctor;
   private int day;
   private int month;
   private int year;

   public AppointmentGUI() {
      setTitle("Hospital Appointment System");
      setSize(700, 600);
      setLocation (200, 300);
      setResizable (false);
      // Create a content pane
      contentPane = getContentPane();
      contentPane.setLayout(null);
   
      nameLabel = new JLabel("Name:");
      nameLabel.setBounds(30 , 50 , 150 , 30 ); 
      contentPane.add(nameLabel);
      
      nameField = new JTextField();
      nameField.setBounds(160 , 50 , 150 , 30 ) ;
      nameField.setColumns(10);
      contentPane.add(nameField);
   
      ageLabel = new JLabel("Age:");
      ageLabel.setBounds(30 , 100 , 150 , 30 );
      contentPane.add(ageLabel);
      
      ageField = new JTextField();
      ageField.setBounds(160 , 100 , 50 , 30 ) ;
      ageField.setColumns(4);
      contentPane.add(ageField);
   
      phoneLabel = new JLabel("Phone:");
      phoneLabel.setBounds(30 ,150 , 150 , 30 );
      contentPane.add(phoneLabel);
      
      phoneField = new JTextField();
      phoneField.setBounds(160 ,150 , 150 , 30 );
      phoneField.setColumns(10);
      contentPane.add(phoneField);
   
      genderLabel = new JLabel("Gender:");
      genderLabel.setBounds(30 ,200 , 150 , 30 );
      contentPane.add(genderLabel);
      
      maleRadio = new JRadioButton("Male");
      maleRadio.setBounds(140 , 200 , 100 , 30 ) ;
      contentPane.add(maleRadio );
      
      femaleRadio = new JRadioButton("Female");
      femaleRadio.setBounds(240 , 200 , 100 , 30 ) ;
      contentPane.add(femaleRadio );
   
     
      genderGroup.add(maleRadio);
      genderGroup.add(femaleRadio);
   
   
      clinicLabel = new JLabel("Clinic:");
      clinicLabel.setBounds(30 ,250 , 150 , 30 );
      contentPane.add(clinicLabel);
      
      clinicComboBox = new JComboBox<>(clinics);
      clinicComboBox.setBounds(160 ,250 , 150 , 30 );
      clinicComboBox.addActionListener(this);
      contentPane.add(clinicComboBox);
   
      doctorLabel = new JLabel("Doctor:");
      doctorLabel.setBounds(30 ,300 , 150 , 30 );
      contentPane.add(doctorLabel);
      
      doctorComboBox = new JComboBox<>(doctors[0]); // Initialize with the first clinic's doctors
      doctorComboBox.setBounds(160, 300, 150, 30);
      contentPane.add(doctorComboBox);
   
      dateLabel = new JLabel("Date:");
      dateLabel.setBounds(30 ,350 , 150 , 30 );
      contentPane.add(dateLabel);
      
      
      dayComboBox = new JComboBox<>(days);
      dayComboBox.setBounds(160 ,350 , 150 , 30 );
      contentPane.add(dayComboBox);
      monthComboBox = new JComboBox<>(months);
      monthComboBox.setBounds(340 ,350 , 150 , 30 );
      contentPane.add(monthComboBox);
      yearComboBox = new JComboBox<>(years);
      yearComboBox.setBounds(520 ,350 , 150 , 30 );
      contentPane.add(yearComboBox);
      
      saveButton = new JButton("Book");
      saveButton.setBounds(160 ,500 , 150 , 30 );
      contentPane.add(saveButton);
      saveButton.addActionListener(this);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      
      
      
   }

   public void actionPerformed(ActionEvent event) {
      if (event.getSource() == clinicComboBox) {
         // When clinicComboBox selection changes, update doctorComboBox accordingly
         int selectedClinicIndex = clinicComboBox.getSelectedIndex();
         doctorComboBox.removeAllItems();
         for (String doctor : doctors[selectedClinicIndex]) {
            doctorComboBox.addItem(doctor);
         }
      }
      //When the button is clicked 
      else if (event.getSource() == saveButton) {
      
         name= nameField.getText();
         
         //When the age field is empty a massage appears
         if(ageField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please fill all the required fields","Booking appointment",JOptionPane.ERROR_MESSAGE);
            return;}
         
         age= Integer.parseInt(ageField.getText());
         try{
            if(age<0)
               throw new NegativNumberException("negativ age") ;
         }
                        
              //Handeling unchecked exception (negative age)
         catch(NegativNumberException e){
            JOptionPane.showMessageDialog(null,"Invalid age","Booking appointment",JOptionPane.ERROR_MESSAGE);
            return;  
         }
      
         phone= phoneField.getText();
         
         if(maleRadio.isSelected()==true)
            gender='M';
         
         else if(femaleRadio.isSelected()==true)
            gender='F';
      
         clinic= clinicComboBox.getSelectedItem().toString();
         doctor= doctorComboBox.getSelectedItem().toString();
         day= Integer.parseInt(dayComboBox.getSelectedItem().toString());
         month=Integer.parseInt(monthComboBox.getSelectedItem().toString());
         year= Integer.parseInt(yearComboBox.getSelectedItem().toString());
         
         //When there is an invalid field a massage appears
         if(name.equals("")||phone.equals("")||phone.length()<3||gender==' '){
            JOptionPane.showMessageDialog(null,"Please fill all the required fields","Booking appointment",JOptionPane.ERROR_MESSAGE);
            return; }
         
         
         Doctor d=null;
         
         //Creating a Doctor object according to the user selection
         if(doctor.equalsIgnoreCase("Ahmad"))
            d= new Doctor("Ahmad", 30, 'M', "0504562745", "Orthodontics", 'S');
         else if(doctor.equalsIgnoreCase("Amal"))
            d= new Doctor("Amal", 50, 'F', "0507954486", "Jaw surgeon", 'C');
         else if(doctor.equalsIgnoreCase("Saud"))
            d= new Doctor("Saud", 26, 'M', "0507403785", "Endodontist", 'R');
         else if(doctor.equalsIgnoreCase("Sara"))
            d= new Doctor("Sarah", 32, 'F', "05047946099", "Plastic surgeon",'S');
         else if(doctor.equalsIgnoreCase("Mona"))
            d= new Doctor("Mona", 25, 'F', "0506700367", "Hair Transplant", 'R');
         else if(doctor.equalsIgnoreCase("Mohammed"))
            d= new Doctor("Mohammed", 55, 'M', "0504897652", "Injection expert", 'C');
         else if(doctor.equalsIgnoreCase("Mustafa"))
            d= new Doctor("Mustafa", 65, 'M', "0579593362", "Dermatological surgeon", 'C');
         else if(doctor.equalsIgnoreCase("Rana"))
            d= new Doctor("Rana", 44, 'F', "0577789005", "Skin & acne", 'S');
         else if(doctor.equalsIgnoreCase("Haya")) 
            d= new Doctor("Haya", 24, 'F', "0500876554", "Liser hair remover", 'R');
        
        //Creating a Patient object using the information
         Patient p= new Patient(name,age,gender,phone); 
        
        //Creating the appointment  
         Appointment a= new Appointment(p,d);
         a.setDay(day);  
         a.setMonth(month);
         a.setYear(year);
        
        //Adding the appointment to the object file appointments
         try{
            File f= new File("appointments.data");
            FileOutputStream fos=new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);
            oos.close();
            JOptionPane.showMessageDialog(null,"The appointment is booked successfully","Booking appointment",JOptionPane.INFORMATION_MESSAGE);
         }
         
         //Handeling the checked exception
         catch(IOException e){
            JOptionPane.showMessageDialog(null,"Sorry, can not book the appointment","Booking appointment",JOptionPane.ERROR_MESSAGE);
         }
      
      
      }}
}

  

   
