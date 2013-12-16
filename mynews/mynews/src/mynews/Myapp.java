package mynews;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

public class Myapp extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
	    try {
	      String url = "jdbc:mysql://localhost/tse?user=root";
	      //String user = "root";
	      
	      Connection con = DriverManager.getConnection(url);
	      String queryString = "SELECT * FROM journal2";
	      Statement stm = (Statement) con.createStatement();
	      ResultSet rs = stm.executeQuery(queryString);
	      String col[] = { "Titre", "Date", "Lien", "Like !" };
	      String cont[][] = new String[500][3];
	      int i = 0;
	      while (rs.next()) {
	        String Lien = rs.getString("lien");
	        String Titre = rs.getString("titre");
	        String Date = rs.getString("datepub");
	        
	        //cont[i][0] = id + "";
	        cont[i][0] = Titre;
	        cont[i][1] = Date;
	        cont[i][2] = Lien;
	        i++;
	      }
	      DefaultTableModel model = new DefaultTableModel(cont, col);
	      JTable table = new JTable(model);
	      table.setShowGrid(true);
	      table.setShowVerticalLines(true);
	      JScrollPane pane = new JScrollPane(table);
	      JFrame frame = new JFrame("Affichage JTable");
	      JPanel panel = new JPanel();
	      panel.add(pane);
	      frame.add(panel);
	      frame.setSize(500, 500);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setVisible(true);
	    } catch (SQLException ex) {
	      ex.printStackTrace();
	    }
	  }
	}


