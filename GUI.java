import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class GUI extends JFrame implements ActionListener{
  
   private JButton button ;
   private JLabel label ;
   private JTextField inputLine;
   public JTextArea textArea ;
   private String PatientID;
 
 
   public GUI(){
   
      Container contentPane = getContentPane( );
      setSize (700, 600);
      setResizable (false);
      setTitle ("Hospital system ");
      setLocation (200, 300);
      contentPane.setLayout(null);
   
   
   
      label = new JLabel("Enter patient ID" ) ;
      label.setBounds(30 , 100 , 150 , 30 ) ;
      contentPane.add(label);
   
      inputLine = new JTextField();
      inputLine.setColumns(10);
      inputLine.setBounds(160 , 100 , 150 , 30 ) ;
      contentPane.add(inputLine);
   
      button = new JButton("view info");
      button.setBounds(320 , 100 , 150 , 30 ) ;
      contentPane.add(button) ;
      button.addActionListener(this);
   
   
      textArea = new JTextArea();
      textArea.setColumns(15);
      textArea.setRows(8);
      textArea.setBorder(BorderFactory.createLineBorder(Color.blue));
      textArea.setEditable(false);
      textArea.setBounds(30 , 200 , 400 , 200 ) ;
      contentPane.add(textArea);
   
      setDefaultCloseOperation( EXIT_ON_CLOSE ); 
      setVisible(true);
   }

   public void actionPerformed(ActionEvent event) {
   
      PatientID = inputLine.getText();
   
   
   }
   public String getID(){
      return PatientID;
   }
 
   public boolean IDState(){
      if(PatientID==null)
         return false;
      return true;
   }
}