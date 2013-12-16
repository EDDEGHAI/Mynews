package mynews;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Booking {
	
	private static Connection conn;
	public String[] strings2=new String[400];
	public String[] strings3=new String[200];
    private static final String Client="create table if not exists Client("
    		+"id int NOT NULL AUTO_INCREMENT,"
    		+"user_name VARCHAR(255) ,"
    		+"passeword VARCHAR(255) ,"
    		+"email VARCHAR(255),"
    		+ "PRIMARY KEY (id));";
    private static final String Booking="create table if not exists Booking("
    		+"id int NOT NULL AUTO_INCREMENT,"
    		+"id_user INT NOT NULL,"
    		+"id_news INT NOT NULL,"
    		+"PRIMARY KEY (id),"
    		+"INDEX (id_news),"
    		+"CONSTRAINT FOREIGN KEY (id_user) REFERENCES Client (id) ON DELETE CASCADE ON UPDATE CASCADE, "
    	    +"CONSTRAINT FOREIGN KEY (id_news) REFERENCES Journal2 (id) ON DELETE CASCADE ON UPDATE CASCADE "
            +")ENGINE = Innodb; ";
    private static final String Booking2="create table if not exists Booking("
    		+"id int NOT NULL AUTO_INCREMENT,"
    		+"id_user INT NOT NULL,"
    		+"id_news INT NOT NULL,"
    		+"PRIMARY KEY (id));";
    		//+"INDEX (id_news),"
    		//+"CONSTRAINT FOREIGN KEY (id_user) REFERENCES Client (id) ON DELETE CASCADE ON UPDATE CASCADE, "
    	    //+"CONSTRAINT FOREIGN KEY (id_news) REFERENCES Journal2 (id) ON DELETE CASCADE ON UPDATE CASCADE "
            //+")ENGINE = Innodb; ";  
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
    	//ClientAddNews("liu2",3);
    	//ClientAddNews("liu2",4);
    	//ClientAddNews("liu3",3);
    	//ShowBooking("liu2");
    	//ShowTheme("NYT");
    	//ShowTheme("20MINUTES");
    	//ShowTheme("MONDE");
    	//ShowTheme("FIGARO");
    	//Booking b=new Booking();
    	//ShowTous();
    	//ShowTous2(b);
    	//Show("20minutes");
    	//Show("le monde");
    	//Client();
    	//ClientAddNews("liu2", "Sonia");
    	//ClientAddNews("liu", "Quatre");
    	ShowBooking("liu2");
    	//AddClient("liu2","xxxyyy","liuyimeilym@gmail.com");
    	//AddClient("liu3","xxxyyy","liuyimeilym@gmail.com");
    	//AddClient("liu4","xxxyyy","liuyimeilym@gmail.com");
    	//for (int i=0;i<b.strings2.length;i++)
    	//{System.out.println(b.strings2[i]);}
    	
    }
//le methode client est pour create table de Client et le table de Booking (pour LIKE) 
    public static void Client() throws ClassNotFoundException, SQLException{ 
    	
    	Class.forName("com.mysql.jdbc.Driver"); 
  	   conn = DriverManager
  		     .getConnection("jdbc:mysql://localhost/tse?user=root");
         java.sql.Statement stmt = conn.createStatement();
  	    stmt.executeUpdate(Client);
  	    stmt.executeUpdate(Booking);
  	    stmt.executeUpdate(Booking2);
    }
//ce methode est pour add Client
    public static void AddClient(String s, String pass, String email ) throws ClassNotFoundException, SQLException
{ 
    	
    	Class.forName("com.mysql.jdbc.Driver"); 
  	   conn = DriverManager
  		     .getConnection("jdbc:mysql://localhost/tse?user=root");
        
  	    
  	  Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet r=stmt.executeQuery("select * from  Client  where user_name='"+s+"'"); 
    r.last();   
          if(r.getRow()==1)                                                          
          {  System.out.println("Ce client existe deja !");}        
          else if(s.equals("")){          
        	  System.out.println("Veuillez entrer un nom d'utilisateur valide");}                 
          else{    stmt.executeUpdate("insert into Client(user_name,passeword, email )values ('"+s+"','"+pass+"','"+email+"');"); }   
stmt.close();conn.close();

}

 
public static void  ClientAddNews(String user_name,String news) throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver"); 
 	   conn = DriverManager
 		     .getConnection("jdbc:mysql://localhost/tse?user=root");
        java.sql.Statement stmt = conn.createStatement();
       String s="insert into Booking (id_user,id_news) "
			   +"select Client.id, Journal2.id from Client,Journal2 WHERE Journal2.titre like '"+news+"%' AND Client.user_name='"+user_name+"';";
      
	   stmt.executeUpdate (s);
	   stmt.close();conn.close(); 
    }
//ce methode est pour voir tous les LIKEs qu'un client choisi  
  public static void ShowBooking(String user_name) throws ClassNotFoundException, SQLException
    {
    	try  
        {
    	 Class.forName("com.mysql.jdbc.Driver"); 
  	     conn = DriverManager
  		     .getConnection("jdbc:mysql://localhost/tse?user=root");
         java.sql.Statement stmt = conn.createStatement();
    	 String id_user="CREATE VIEW v_t AS select id_news from Booking WHERE Client.id = (select id from Client where user_name='"+user_name+"%' );" ;
    	 stmt.executeQuery(id_user);	 
    	
        }
    catch(Exception e) 
      {  }
    	}                  
    public static void ShowTheme(String nom_journal)
   {
	   try  
       {
   	   Class.forName("com.mysql.jdbc.Driver"); 
 	    conn = DriverManager
 		     .getConnection("jdbc:mysql://localhost/tse?user=root");
        java.sql.Statement stmt = conn.createStatement();
        String drop="Drop View if exists v_tem;";
        stmt.executeUpdate(drop);  
	    String show_theme="CREATE VIEW v_tem AS SELECT distinct source FROM Journal2 where UPPER(source) like '%"+nom_journal+"%' OR UPPER(source) like '"+nom_journal+"%';";
	    stmt.executeUpdate(show_theme);  
  	    stmt.close();conn.close();  
  	    
       }
     catch(Exception e) 
    { 
    	 
    	 System.out.println("Erreur de creation de vue..."); 
     }
   }
    public static void ShowTitre(String titre)
   {
	   try  
       {
   	   Class.forName("com.mysql.jdbc.Driver"); 
 	    conn = DriverManager
 		     .getConnection("jdbc:mysql://localhost/tse?user=root");
        java.sql.Statement stmt = conn.createStatement();
        String drop="Drop View if exists v_tem2;";
        stmt.executeUpdate(drop);  
        
	    String show_titre="CREATE VIEW v_tem2 AS SELECT titre FROM Journal2 WHERE UPPER(source) LIKE'"
			        +titre.toUpperCase()+"';"; 
	    stmt.executeUpdate(show_titre);  
	   
  	    stmt.close();conn.close();  
  	    
       }
     catch(Exception e) 
    { 
    	 
    	 System.out.println("Erreur de création de la vue des titres ..."); 
     }
   }  
	public static void ShowTous()
	   {
	   {
		   try  
	       {
	   	   Class.forName("com.mysql.jdbc.Driver"); 
	 	    conn = DriverManager
	 		     .getConnection("jdbc:mysql://localhost/tse?user=root");
	        java.sql.Statement stmt = conn.createStatement();
	        String drop="Drop View if exists v_tem_titre;";
	        stmt.executeUpdate(drop);  
		    String show_tous="CREATE VIEW v_tem_titre AS SELECT titre FROM Journal2;";
		    stmt.executeUpdate(show_tous);  
		    
		    stmt.close();conn.close();  
	  	    
	       }
	     catch(Exception e) 
	    { 
	    	 
	    	 System.out.println("Erreur de creation de la vue de tous les titres ..."); 
	     }
	   }
	   
   }
	public static void ShowTous2(Booking b) throws ClassNotFoundException, SQLException
	    {
		   
		   try  
	        {
	    	Class.forName("com.mysql.jdbc.Driver"); 
	  	   conn = DriverManager
	  		     .getConnection("jdbc:mysql://localhost/tse?user=root");
	         java.sql.Statement stmt = conn.createStatement();
	         String x="SELECT * FROM v_tem_titre;";
		       ResultSet r=stmt.executeQuery(x);
		        
		       int i=0;
		       while(r.next()) 
		       { 
		    	   b.strings2[i]=r.getString(1);
		        	//((Appendable) strings).append(r.getString(1));
		        	i=i+1;
		       }
	        }
	         catch(Exception e) 
	               { }
	        }  
	public static void Show2(Booking b) throws ClassNotFoundException, SQLException
	    {
		   
		   try  
	        {
	    	Class.forName("com.mysql.jdbc.Driver"); 
	  	   conn = DriverManager
	  		     .getConnection("jdbc:mysql://localhost/tse?user=root");
	         java.sql.Statement stmt = conn.createStatement();
	         String x="SELECT * FROM v_tem_ti2;";
		       ResultSet r=stmt.executeQuery(x);
		        
		       int i=0;
		       while(r.next()) 
		       { 
		    	   b.strings3[i]=r.getString(1);
		        	//((Appendable) strings).append(r.getString(1));
		        	i=i+1;
		       }
	        }
	         catch(Exception e) 
	               { }
	        }     
	   public static void Show(String nom_journal)
	   {
		   try  
	       {
	   	   Class.forName("com.mysql.jdbc.Driver"); 
	 	    conn = DriverManager
	 		     .getConnection("jdbc:mysql://localhost/tse?user=root");
	        java.sql.Statement stmt = conn.createStatement();
	       // String creat="CREATE VIEW if not exists v_tem_ti;";
	        //stmt.executeUpdate(creat);  
		    String show="CREATE OR REPLACE VIEW v_tem_ti2 AS SELECT titre FROM Journal2 where LOWER(source) like '%"+nom_journal+"%' OR LOWER(source) like '"+nom_journal+"%';";
		    stmt.executeUpdate(show);  
	  	    stmt.close();conn.close();  
	  	    
	       }
	     catch(Exception e) 
	    { 
	    	 
	    	 System.out.println("Erreur de creation de la vue des titres ..."); 
	     }
	   }
	    }
   
