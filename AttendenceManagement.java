
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AttendenceManagement
{
 private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;

   public AttendenceManagement(){
      prepareGUI();
   }

   public static void main(String[] args){  
AttendenceManagement  a = new AttendenceManagement();
      a.showEventDemo();
}

   public void prepareGUI(){
      mainFrame = new Frame("Java AWT Examples");
      mainFrame.setSize(900,900);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);
controlPanel=new Panel();
     mainFrame.add(headerLabel);
     mainFrame.add(controlPanel);
     mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
   }

   public void showEventDemo(){
      Button start=new Button("start");

headerLabel.setText("Starting attendence management System"); 
     
 start.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) { 
    
Login1 lg1=new Login1();
lg1.showlogin1();
mainFrame.dispose();
      }
      });
      controlPanel.add(start);
      mainFrame.setVisible(true);  
   }
 }		



 class Login1{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/narayan";
    static final String USER = "root";
   static final String PASS = "1234";
Connection conn;
Statement stmt;

   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;
   private Panel menu;
   public Login1(){
      login1GUI();
   }



   public void login1GUI(){
      mainFrame = new Frame("admin login");
      mainFrame.setSize(900,900);
      mainFrame.setLayout(new GridLayout(4, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());
      menu = new Panel();
      menu.setLayout(new FlowLayout());
      mainFrame.add(menu);
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   public void showlogin1(){
      headerLabel.setText("enter admin username and password"); 

      Label  namelabel= new Label("Username: ", Label.RIGHT);
      Label  passwordLabel = new Label("Password: ", Label.CENTER);
      final TextField userText = new TextField(6);
      final TextField passwordText = new TextField(6);
      passwordText.setEchoChar('*');

      Button loginButton = new Button("Login");
      Button authlogin = new Button("admin login");
      Button studentlogin = new Button("student login");
      Button teacherlogin =  new Button("teacher login");
      Button parentlogin = new Button("parent login");
      loginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) { 
     String data =userText.getText();
String data2=passwordText.getText();   
  try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM authtable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         String id  = rs.getString("name");
         String pass = rs.getString("password");

if(data.equals(id)&&data2.equals(pass) )           
{
statusLabel.setText("logged in");
Att1 a1=new Att1();
a1.showatt1();
mainFrame.dispose();
break;
}
else
   statusLabel.setText("wrong admin id or password");     
  
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }           

        }
      }); 

authlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login1 lg1 = new Login1();
lg1.showlogin1();
 mainFrame.dispose();
        }
      }); 

  studentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login2 obj = new Login2();
obj.showlogin2();
 mainFrame.dispose();
        }
      }); 

 teacherlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login3 lg3 = new Login3();
lg3.showlogin3();
 mainFrame.dispose();
        }
      }); 

parentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login4 lg4 = new Login4();
lg4.showlogin4();
 mainFrame.dispose();
        }
      }); 
      menu.add(authlogin);
     menu.add(studentlogin);
     menu.add(teacherlogin);
     menu.add(parentlogin);
     controlPanel.add(namelabel);
      controlPanel.add(userText);
      controlPanel.add(passwordLabel);       
      controlPanel.add(passwordText);
      controlPanel.add(loginButton);
      mainFrame.setVisible(true);  
   }
}



class Login2{
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/narayan";
    static final String USER = "root";
   static final String PASS = "1234";
Connection conn;
Statement stmt;

   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;
   private Panel menu;
   public Login2(){
      login2GUI();
   }


   public void login2GUI(){
      mainFrame = new Frame("student login");
      mainFrame.setSize(900,900);
      mainFrame.setLayout(new GridLayout(4, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());
      menu = new Panel();
      menu.setLayout(new FlowLayout());
      mainFrame.add(menu);
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   public void showlogin2(){
      headerLabel.setText("enter student id and password"); 

      Label  namelabel= new Label("student ID: ", Label.RIGHT);
      Label  passwordLabel = new Label("Password: ", Label.CENTER);
      final TextField userText = new TextField(6);
      final TextField passwordText = new TextField(6);
      passwordText.setEchoChar('*');

      Button loginButton = new Button("Login");
      Button authlogin = new Button("admin login");
      Button studentlogin = new Button("student login");
      Button teacherlogin =  new Button("teacher login");
      Button parentlogin = new Button("parent login");
      loginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {     
             String data =userText.getText();
String data2=passwordText.getText();   
  try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         String id  = rs.getString("id");
         String pass = rs.getString("password");

if(data.equals(id)&&data2.equals(pass) )           
{
statusLabel.setText("logged in");
Att2 a2=new Att2();
a2.showatt2();
mainFrame.dispose();
break;
}
else
   statusLabel.setText("wrong student id or password");     
  
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }           

        }
      }); 
authlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login1 lg1 = new Login1();
lg1.showlogin1();
 mainFrame.dispose();
        }
      }); 

  studentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login2 obj = new Login2();
obj.showlogin2();
 mainFrame.dispose();
        }
      }); 

 teacherlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login3 lg3 = new Login3();
lg3.showlogin3();
 mainFrame.dispose();
        }
      }); 

parentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login4 lg4 = new Login4();
lg4.showlogin4();
 mainFrame.dispose();
        }
      }); 
      menu.add(authlogin);
     menu.add(studentlogin);
     menu.add(teacherlogin);
     menu.add(parentlogin);
     controlPanel.add(namelabel);
      controlPanel.add(userText);
      controlPanel.add(passwordLabel);       
      controlPanel.add(passwordText);
      controlPanel.add(loginButton);
      mainFrame.setVisible(true);  
   }
}

class Login3{
 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/narayan";
    static final String USER = "root";
   static final String PASS = "1234";
Connection conn;
Statement stmt;


   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;
   private Panel menu;
   public Login3(){
      login3GUI();
   }

   public void login3GUI(){
      mainFrame = new Frame("teacher login");
      mainFrame.setSize(900,900);
      mainFrame.setLayout(new GridLayout(4, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());
      menu = new Panel();
      menu.setLayout(new FlowLayout());
      mainFrame.add(menu);
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   public void showlogin3(){
      headerLabel.setText("enter teacher id and password"); 

      Label  namelabel= new Label("teacher ID: ", Label.RIGHT);
      Label  passwordLabel = new Label("Password: ", Label.CENTER);
      final TextField userText = new TextField(6);
      final TextField passwordText = new TextField(6);
      passwordText.setEchoChar('*');

      Button loginButton = new Button("Login");
      Button authlogin = new Button("admin login");
      Button studentlogin = new Button("student login");
      Button teacherlogin =  new Button("teacher login");
      Button parentlogin = new Button("parent login");
      loginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {     
         String data =userText.getText();
String data2=passwordText.getText();   
  try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM teachertable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         String id  = rs.getString("id");
         String pass = rs.getString("password");

if(data.equals(id)&&data2.equals(pass) )           
{
statusLabel.setText("logged in");
Att3 a3=new Att3();
a3.showatt3();
mainFrame.dispose();
break;
}
else
   statusLabel.setText("wrong teacher id or password");     
  
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }              
        }
      }); 
authlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login1 lg1 = new Login1();
lg1.showlogin1();
 mainFrame.dispose();
        }
      }); 

  studentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login2 obj = new Login2();
obj.showlogin2();
 mainFrame.dispose();
        }
      }); 

 teacherlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login3 lg3 = new Login3();
lg3.showlogin3();
 mainFrame.dispose();
        }
      }); 

parentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login4 lg4 = new Login4();
lg4.showlogin4();
 mainFrame.dispose();
        }
      }); 
      menu.add(authlogin);
     menu.add(studentlogin);
     menu.add(teacherlogin);
     menu.add(parentlogin);
     controlPanel.add(namelabel);
      controlPanel.add(userText);
      controlPanel.add(passwordLabel);       
      controlPanel.add(passwordText);
      controlPanel.add(loginButton);
      mainFrame.setVisible(true);  
   }
}


class Login4{
 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/narayan";
    static final String USER = "root";
   static final String PASS = "1234";
Connection conn;
Statement stmt;
   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;
   private Panel menu;
   public Login4(){
      login4GUI();
   }

 

   public void login4GUI(){
      mainFrame = new Frame("parent login");
      mainFrame.setSize(900,900);
mainFrame.setLayout(new GridLayout(4,1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

 
      menu = new Panel();
      menu.setLayout(new FlowLayout());
      controlPanel = new Panel();
      controlPanel.setLayout(new GridLayout(4,2));
      mainFrame.add(menu);
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
       mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

public void showlogin4(){
      headerLabel.setText("enter following details"); 

      Label  namelabel= new Label("parents name: ", Label.LEFT);
      Label  rollno = new Label("roll no of student: ", Label.LEFT);
      Label  mail= new Label("parents mail as specified by student ", Label.LEFT);
      final TextField nameText = new TextField(6);
      final TextField rollnoText = new TextField(6);
      final TextField mailText = new TextField(6);
      Button loginButton = new Button("Login");
Button clearButton = new Button("Clear");
      Button authlogin = new Button("authority login");
      Button studentlogin = new Button("student login");
      Button teacherlogin =  new Button("teacher login");
      Button parentlogin = new Button("parent login");
      loginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {     
              String data =rollnoText.getText();
String data2=mailText.getText();   
  try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         String roll  = rs.getString("rollno");
         String pm = rs.getString("pmail");

if(data.equals(roll)&&data2.equals(pm) )           
{
statusLabel.setText("logged in");
Att2 a2=new Att2();
a2.showatt2();
mainFrame.dispose();
break;
}
else
   statusLabel.setText("roll no or parent mail not in records");     
  
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  

        }
      }); 
 
clearButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent aae) {   

nameText.setText(" ");
rollnoText.setText(" ");
mailText.setText(" ");


  }
      }); 

authlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login1 lg1 = new Login1();
lg1.showlogin1();
 mainFrame.dispose();
        }
      }); 

  studentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login2 obj = new Login2();
obj.showlogin2();
 mainFrame.dispose();
        }
      }); 

 teacherlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login3 lg3 = new Login3();
lg3.showlogin3();
 mainFrame.dispose();
        }
      }); 

parentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login4 lg4 = new Login4();
lg4.showlogin4();
 mainFrame.dispose();
        }
      }); 
      menu.add(authlogin);
     menu.add(studentlogin);
     menu.add(teacherlogin);
     menu.add(parentlogin);
controlPanel.add(namelabel);
      controlPanel.add(nameText);
      controlPanel.add(rollno);
     controlPanel.add(rollnoText);
       controlPanel.add(mail);
      controlPanel.add(mailText);
    controlPanel.add(loginButton);
controlPanel.add(clearButton);
       
      mainFrame.setVisible(true);
  
   }
}

class Att1{
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/narayan";
    static final String USER = "root";
   static final String PASS = "1234";
Connection conn;
Statement stmt;
int i,m,n;

   private Frame mainFrame;
 private Panel table;
   private Panel controlPanel;
   private Panel menu;
   public Att1(){
      att1GUI();
   }

   public void att1GUI(){
      mainFrame = new Frame("student attendece");
      mainFrame.setSize(900,900);
      mainFrame.setLayout(new GridLayout(6, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
    
     table = new Panel();
      table.setLayout(new GridLayout(9, 11));
      
      

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());
      menu = new Panel();
      menu.setLayout(new FlowLayout());
      mainFrame.add(menu);
 
      mainFrame.add(controlPanel);
       mainFrame.add(table);
      mainFrame.setVisible(true);  
   }

   public void showatt1(){
       
      Label user = new Label("                 username");
      Button details = new Button("details");
      Button student =new Button("Student");
      Button teacher=new Button("teacher");
      Button authlogin = new Button("admin login");
      Button studentlogin = new Button("student login");
      Button teacherlogin =  new Button("teacher login");
      Button parentlogin = new Button("parent login");
Label A=new Label("A   T");
Label name=new Label("name");
Label rn=new Label("roll no");
Label sub=new Label("subject");
Label oopm=new Label("oopm");
Label ds=new Label("ds");
Label dd=new Label("dd");
Label coa=new Label("coa");
Label maths3=new Label("maths3");
Label dsgt=new Label("dsgt");
Label total=new Label("total");

      details.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {     
            Detail1 d1=new Detail1();
           d1.showdetail1();
           mainFrame.dispose();
        }
      }); 
      student.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent be) {     
             Att1 a1=new Att1();
           a1.showatt1();
           mainFrame.dispose();
        }
      }); 
      teacher.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ce) {     
            Att3 a3=new Att3();
           a3.showatt3();
        }
      }); 
authlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login1 lg1 = new Login1();
lg1.showlogin1();
 mainFrame.dispose();
        }
      }); 

  studentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login2 obj = new Login2();
obj.showlogin2();
 mainFrame.dispose();
        }
      }); 

 teacherlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login3 lg3 = new Login3();
lg3.showlogin3();
 mainFrame.dispose();
        }
      }); 

parentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login4 lg4 = new Login4();
lg4.showlogin4();
 mainFrame.dispose();
        }
      }); 
      menu.add(authlogin);
     menu.add(studentlogin);
     menu.add(teacherlogin);
     menu.add(parentlogin);
    
controlPanel.add(student);
controlPanel.add(teacher);
controlPanel.add(user);
controlPanel.add(details);
table.add(name);
Label a[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         a[i]= new Label(rs.getString("name"));
         table.add(a[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }           

table.add(rn);
Label b[]=new Label[14];
long k=1611000; 
i=1; 
while(i<=10)
         {b[i]= new Label(String.valueOf(k));
         table.add(b[i]);
       i++;
k++;}

table.add(oopm);
Label c[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("oopm");
         c[i]= new Label(String.valueOf(m)+" /8 ");
         table.add(c[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception t){
      //Handle errors for Class.forName
      t.printStackTrace();
   } 




table.add(dd);
Label d[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("dd");
         d[i]= new Label(String.valueOf(m)+" /8 ");
         table.add(d[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception w){
      //Handle errors for Class.forName
      w.printStackTrace();
   } 

table.add(ds);
Label e[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("ds");
         e[i]= new Label(String.valueOf(m)+" /8 ");
         table.add(e[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception u){
      //Handle errors for Class.forName
      u.printStackTrace();
   } 




table.add(coa);
Label f[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("coa");
         f[i]= new Label(String.valueOf(m)+" /8 ");
         table.add(f[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception x){
      //Handle errors for Class.forName
      x.printStackTrace();
   } 

table.add(maths3);
Label g[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("maths3");
         g[i]= new Label(String.valueOf(m)+" /8 ");
         table.add(g[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception y){
      //Handle errors for Class.forName
      y.printStackTrace();
   } 


table.add(dsgt);
Label h[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("dsgt");
         h[i]= new Label(String.valueOf(m)+" /8 ");
         table.add(h[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception z){
      //Handle errors for Class.forName
      z.printStackTrace();
   } 



table.add(total);

i=1; k=9;
while(i<=10)
         {b[i]= new Label(String.valueOf(k));
         table.add(b[i]);
       i++;
k++;}

mainFrame.setVisible(true);  
   }
}


class Att2{
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/narayan";
    static final String USER = "root";
   static final String PASS = "1234";
Connection conn;
Statement stmt;
 private Panel table;int i,m,n;
   private Frame mainFrame;
 
   private Panel controlPanel;
   private Panel menu;
   public Att2(){
      att2GUI();
   }

 

   public void att2GUI(){
      mainFrame = new Frame("student attendence");
      mainFrame.setSize(900,900);
      mainFrame.setLayout(new GridLayout(6, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
     
     
      table = new Panel();
      table.setLayout(new GridLayout(9, 11)); 
      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());
      menu = new Panel();
      menu.setLayout(new FlowLayout());
      mainFrame.add(menu);
 
      mainFrame.add(controlPanel);
      mainFrame.add(table);
      mainFrame.setVisible(true);  
   }

   public void showatt2(){
     
      Label user = new Label("                 username");
      Button details = new Button("details");
      Button student =new Button("Student");
      Button authlogin = new Button("admin login");
      Button studentlogin = new Button("student login");
      Button teacherlogin =  new Button("teacher login");
      Button parentlogin = new Button("parent login");

Label A=new Label("A   T");
Label name=new Label("name");
Label rn=new Label("roll no");
Label sub=new Label("subject");
Label oopm=new Label("oopm");
Label ds=new Label("ds");
Label dd=new Label("dd");
Label coa=new Label("coa");
Label maths3=new Label("maths3");
Label dsgt=new Label("dsgt");


Label total=new Label("total");

 student.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Att2 obj = new Att2();
obj.showatt2();
 mainFrame.dispose();
        }
      }); 

      details.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     
            Detail2 d2=new Detail2();
           d2.showdetail2();
           mainFrame.dispose();
        }
      }); 
authlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login1 lg1 = new Login1();
lg1.showlogin1();
 mainFrame.dispose();
        }
      }); 

  studentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login2 obj = new Login2();
obj.showlogin2();
 mainFrame.dispose();
        }
      }); 

 teacherlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login3 lg3 = new Login3();
lg3.showlogin3();
 mainFrame.dispose();
        }
      }); 

parentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login4 lg4 = new Login4();
lg4.showlogin4();
 mainFrame.dispose();
        }
      }); 
      menu.add(authlogin);
     menu.add(studentlogin);
     menu.add(teacherlogin);
     menu.add(parentlogin);
    
controlPanel.add(student);
controlPanel.add(user);
controlPanel.add(details);
table.add(name);
Label a[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         a[i]= new Label(rs.getString("name"));
         table.add(a[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }           

table.add(rn);
Label b[]=new Label[14];
long k=1611000; 
i=1; 
while(i<=10)
         {b[i]= new Label(String.valueOf(k));
         table.add(b[i]);
       i++;
k++;}

table.add(oopm);
Label c[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("oopm");
         c[i]= new Label(String.valueOf(m)+" / 8 ");
         table.add(c[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception t){
      //Handle errors for Class.forName
      t.printStackTrace();
   } 




table.add(dd);
Label d[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("dd");
         d[i]= new Label(String.valueOf(m)+" /8 ");
         table.add(d[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception w){
      //Handle errors for Class.forName
      w.printStackTrace();
   } 

table.add(ds);
Label e[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("ds");
         e[i]= new Label(String.valueOf(m)+" /8 ");
         table.add(e[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception u){
      //Handle errors for Class.forName
      u.printStackTrace();
   } 




table.add(coa);
Label f[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("coa");
         f[i]= new Label(String.valueOf(m)+" /8 ");
         table.add(f[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception x){
      //Handle errors for Class.forName
      x.printStackTrace();
   } 

table.add(maths3);
Label g[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("maths3");
         g[i]= new Label(String.valueOf(m)+" /8 ");
         table.add(g[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception y){
      //Handle errors for Class.forName
      y.printStackTrace();
   } 


table.add(dsgt);
Label h[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM studenttable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("dsgt");
         h[i]= new Label(String.valueOf(m)+" /8 ");
         table.add(h[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception z){
      //Handle errors for Class.forName
      z.printStackTrace();
   } 



table.add(total);

i=1; k=9;
while(i<=10)
         {b[i]= new Label(String.valueOf(k));
         table.add(b[i]);
       i++;
k++;}

mainFrame.setVisible(true);  
   }
}

 class Att3{
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/narayan";
    static final String USER = "root";
   static final String PASS = "1234";
Connection conn;
Statement stmt;
int i,m,n;
   private Frame mainFrame;
  private Panel table; 
   private Panel controlPanel;
   private Panel menu;
   public Att3(){
      att3GUI();
   }
   public void att3GUI(){
      mainFrame = new Frame("teacher attendence");
      mainFrame.setSize(900,900);
      mainFrame.setLayout(new GridLayout(7, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
     table = new Panel();
      table.setLayout(new GridLayout(9, 11));
     
      

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());
      menu = new Panel();
      menu.setLayout(new FlowLayout());
      mainFrame.add(menu);
 
      mainFrame.add(controlPanel);
      
      mainFrame.add(table);
      mainFrame.setVisible(true);  
   }

   public void showatt3(){
      
      Label user = new Label("                 username");
      Button details = new Button("details");
      Button student =new Button("Student");
      Button teacher=new Button("teacher");
      Button authlogin = new Button("authority login");
      Button studentlogin = new Button("student login");
      Button teacherlogin =  new Button("teacher login");
      Button parentlogin = new Button("parent login");
Label A=new Label("A   T");
Label name=new Label("name");
Label id=new Label("id");
Label sub=new Label("subject");
Label oopm=new Label("oopm");
Label ds=new Label("ds");
Label dd=new Label("dd");
Label coa=new Label("coa");
Label maths3=new Label("maths3");
Label dsgt=new Label("dsgt");
Label total=new Label("days present");


      details.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     
         Detail1 d1=new Detail1();
           d1.showdetail1();
           mainFrame.dispose();   
        }
      }); 
      student.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent be) {     
            Att1 a1=new Att1();
         a1.showatt1();
        mainFrame.dispose();
        }
      }); 
      teacher.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ce) {     
              Att3 a3=new Att3();
         a3.showatt3();
        mainFrame.dispose();
        }
      }); 
authlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login1 lg1 = new Login1();
lg1.showlogin1();
 mainFrame.dispose();
        }
      }); 

  studentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login2 obj = new Login2();
obj.showlogin2();
 mainFrame.dispose();
        }
      }); 

 teacherlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login3 lg3 = new Login3();
lg3.showlogin3();
 mainFrame.dispose();
        }
      }); 

parentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login4 lg4 = new Login4();
lg4.showlogin4();
 mainFrame.dispose();
        }
      }); 
      menu.add(authlogin);
     menu.add(studentlogin);
     menu.add(teacherlogin);
     menu.add(parentlogin);
    
controlPanel.add(student);
controlPanel.add(teacher);
controlPanel.add(user);
controlPanel.add(details);

table.add(name);
Label a[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM teachertable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         a[i]= new Label(rs.getString("name"));
         table.add(a[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }           
table.add(id);
Label b[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM teachertable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         b[i]= new Label(rs.getString("id"));
         table.add(b[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
table.add(oopm);
Label c[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM teachertable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("oopm");
         c[i]= new Label(String.valueOf(m));
         table.add(c[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception t){
      //Handle errors for Class.forName
      t.printStackTrace();
   } 

table.add(dd);
Label d[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM teachertable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("dd");
         d[i]= new Label(String.valueOf(m));
         table.add(d[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception w){
      //Handle errors for Class.forName
      w.printStackTrace();
   } 
table.add(ds);
Label e[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM teachertable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("ds");
         e[i]= new Label(String.valueOf(m));
         table.add(e[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception u){
      //Handle errors for Class.forName
      u.printStackTrace();
   } 
table.add(coa);
Label f[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM teachertable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("coa");
         f[i]= new Label(String.valueOf(m));
         table.add(f[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception x){
      //Handle errors for Class.forName
      x.printStackTrace();
   } 

table.add(maths3);
Label g[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM teachertable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("maths3");
         g[i]= new Label(String.valueOf(m));
         table.add(g[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception y){
      //Handle errors for Class.forName
      y.printStackTrace();
   } 


table.add(dsgt);
Label h[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM teachertable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("dsgt");
         h[i]= new Label(String.valueOf(m));
         table.add(h[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception z){
      //Handle errors for Class.forName
      z.printStackTrace();
   } 

table.add(total);
Label u[]=new Label[14];
i=0;  
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM teachertable";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        m=rs.getInt("dp");
         u[i]= new Label(String.valueOf(m));
         table.add(u[i]);
       i++;
}
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception p){
      //Handle errors for Class.forName
      p.printStackTrace();
   } 
mainFrame.setVisible(true);  
   }
}


 class Detail1{

   private Frame mainFrame;
 
   private Panel controlPanel;
   private Panel menu;
   public Detail1(){
      detail1GUI();
   }

   
   public void detail1GUI(){
      mainFrame = new Frame("student detail");
      mainFrame.setSize(900,900);
      mainFrame.setLayout(new GridLayout(7, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
     final Scrollbar scr=new Scrollbar(Scrollbar.VERTICAL);
      scr.setMaximum(100);
      scr.setMinimum(1);
      
     
      

      controlPanel = new Panel();
      controlPanel.setLayout(new GridLayout(5,1));
      menu = new Panel();
      menu.setLayout(new FlowLayout());
      mainFrame.add(menu);
 
      mainFrame.add(controlPanel);
      mainFrame.add(scr);
      mainFrame.setVisible(true);  
   }

   public void showdetail1(){
      Button loginButton = new Button("Login"); 
      Label user = new Label("                 username");
      Button back = new Button("back");
      Label mail=new Label("mail:"+" mail will be here",Label.LEFT);
       Label id=new Label("id:"+"id will be here");
       Label number=new Label("number:"+" number will be here");
       Label pmail=new Label("parents mail:"+" parents mail will be here");
        Label name=new Label("name:"+" name will be here");
      Button authlogin = new Button("admin login");
      Button studentlogin = new Button("student login");
      Button teacherlogin =  new Button("teacher login");
      Button parentlogin = new Button("parent login");
back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent k) {    
 Att3 a3=new Att3();
a3.showatt3();
mainFrame.dispose();
 }
      }); 

  authlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) {     
Login1 lg1 = new Login1();
lg1.showlogin1();
 mainFrame.dispose();
        }
      }); 

  studentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login2 obj = new Login2();
obj.showlogin2();
 mainFrame.dispose();
        }
      }); 

 teacherlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login3 lg3 = new Login3();
lg3.showlogin3();
 mainFrame.dispose();
        }
      }); 

parentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login4 lg4 = new Login4();
lg4.showlogin4();
 mainFrame.dispose();
        }
      }); 
      menu.add(authlogin);
     menu.add(studentlogin);
     menu.add(teacherlogin);
     menu.add(parentlogin);
    menu.add(back);
controlPanel.add(name);
controlPanel.add(mail);
controlPanel.add(id);
controlPanel.add(number);
controlPanel.add(pmail);

mainFrame.setVisible(true);  
   }
}

class Detail2{

   private Frame mainFrame;
 
   private Panel controlPanel;
   private Panel menu;
   public Detail2(){
      detail2GUI();
   }
   public void detail2GUI(){
      mainFrame = new Frame("author login");
      mainFrame.setSize(900,900);
      mainFrame.setLayout(new GridLayout(7, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
     final Scrollbar scr=new Scrollbar(Scrollbar.VERTICAL);
      scr.setMaximum(100);
      scr.setMinimum(1);
      
     
      

      controlPanel = new Panel();
      controlPanel.setLayout(new GridLayout(5,1));
      menu = new Panel();
      menu.setLayout(new FlowLayout());
      mainFrame.add(menu);
 
      mainFrame.add(controlPanel);
      mainFrame.add(scr);
      mainFrame.setVisible(true);  
   }

   public void showdetail2(){
      Button loginButton = new Button("Login"); 
      Label user = new Label("                 username");
      Button back = new Button("back");
      Label mail=new Label("mail:"+" mail will be here",Label.LEFT);
       Label id=new Label("id:"+"id will be here");
       Label number=new Label("number:"+" number will be here");
       Label name=new Label("name:"+" name will be here");
      Button authlogin = new Button("admin login");
      Button studentlogin = new Button("student login");
      Button teacherlogin =  new Button("teacher login");
      Button parentlogin = new Button("parent login");
   back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent k) {    
 Att3 a3=new Att3();
a3.showatt3();
mainFrame.dispose();
 }
      }); 

authlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) {     
Login1 lg1 = new Login1();
lg1.showlogin1();
 mainFrame.dispose();
        }
      }); 

  studentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent b) { 

Login2 obj = new Login2();
obj.showlogin2();
 mainFrame.dispose();
        }
      }); 

 teacherlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login3 lg3 = new Login3();
lg3.showlogin3();
 mainFrame.dispose();
        }
      }); 

parentlogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent c) { 

Login4 lg4 = new Login4();
lg4.showlogin4();
 mainFrame.dispose();
        }
      }); 
      menu.add(authlogin);
     menu.add(studentlogin);
     menu.add(teacherlogin);
     menu.add(parentlogin);
    menu.add(back);
controlPanel.add(name);
controlPanel.add(mail);
controlPanel.add(id);
controlPanel.add(number);

mainFrame.setVisible(true);  
   }
}


