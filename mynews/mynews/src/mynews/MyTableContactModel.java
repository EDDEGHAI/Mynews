package mynews;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MyTableContactModel extends AbstractTableModel { 
    /**
	 * 
	 */
	String Lien[] = new String[5000];
	private static final long serialVersionUID = 1L;
	private ArrayList<Object[]> resultSets; 
    private String[] columnNames = { 
        "Titre", "Date", "Like !"
    }; 
    
    
    public MyTableContactModel() throws SQLException { 
    	
        resultSets = new ArrayList<Object[]>(); 
        String url = "jdbc:mysql://localhost/tse?user=root";
        //String user = "root";
        
        Connection con = (Connection) DriverManager.getConnection(url);
        String queryString = "SELECT * FROM journal2";
        Statement stm = (Statement) con.createStatement();
        ResultSet rs = stm.executeQuery(queryString);
        int i=0;
        try { 
            while (rs.next()) { 
                Object[] row = { 
                		rs.getString("titre"),
                        rs.getString("datepub"), Boolean.FALSE};
                
                        Lien[i] = rs.getString("lien");
                		i++;
            
                

                
				
				resultSets.add(row); 
            } 
        } catch (Exception e) { 
            System.out.println("Exception in MyTableContactModel"); 
        } 
    } 
    
    
    
    @Override 
    public Class<? extends Object> getColumnClass(final int column) { 
        return getValueAt(0, column).getClass(); 
    } 
    public int getColumnCount() { 
        return columnNames.length; 
    } 
    @Override 
    public String getColumnName(final int column) { 
        return columnNames[column]; 
    } 
    public Object getValueAt(final int rowindex, final int columnindex) { 
        Object[] row = resultSets.get(rowindex); 
        return row[columnindex]; 
    } 
    @Override 
    public boolean isCellEditable(final int row, final int column) { 
        if (column < 2) { 
            return false; 
        } else { 
            return true; 
        } 
    } 
    @Override 
    public void setValueAt(final Object value, final int row, final int column) { 
        resultSets.get(row)[column] = value; 
        fireTableCellUpdated(row, column); 
    } 
    @Override 
    public int getRowCount() { 
        return resultSets.size(); 
    } 
}