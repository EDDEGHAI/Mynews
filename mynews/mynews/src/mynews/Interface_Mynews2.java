package mynews;


import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Interface_Mynews2 extends javax.swing.JFrame {

    /**
         * 
         */
        String Lien[] = new String[5000];
        private static final long serialVersionUID = 1L;
        /**
     * Creates new form Interface_Mynews
     */
    public Interface_Mynews2() {
        try {
			initComponents();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws SQLException 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws SQLException {
    	
    	MouseListener mouseListenerEvents = new MouseAdapter(){
    		
            public void mouseClicked(MouseEvent e) {
            if (e.getClickCount()==1) { // simple click detection
            JTable target = (JTable)e.getSource();
            int row = target.getSelectedRow(); // i just care about rows but i imagine you can get collumns
            //column = jTable1.getRowSorter().convertRowIndexToModel(column); // sorter is my row sorter. need to map the sort model to the real. if you dont use a row sorter this step is not needed
            //int index = jTable1.rowAtPoint(e.getPoint());
            
            String url = "jdbc:mysql://localhost/tse?user=root";
            //String user = 
				
				
            
            
            if (target.getSelectedColumn()==0){
            try {
            	Connection con = (Connection) DriverManager.getConnection(url);
            	String queryString = "SELECT * FROM journal2";
            	Statement stm = (Statement) con.createStatement();
            	ResultSet rs = stm.executeQuery(queryString);
            	
            	    int i = 0;
                    while (rs.next()) { 
                     
                                Lien[i] = rs.getString("lien");
                        		i++;
                    }
                    URI uri = new URI(Lien[row]);
                                    //URL gameIndex = new URL((String)jTable1.getModel().getValueAt(0,column));
                                    Desktop.getDesktop().browse(uri);
                            
            } catch (MalformedURLException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                            } catch (IOException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                            } catch (URISyntaxException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                            } catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
            
            }
            }
            }
            };
        
    	
    	
        new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        

        
            jTable1.setModel(new MyTableContactModel());
            jTable1.setShowGrid(true);
            jTable1.setShowVerticalLines(true);
            jScrollPane1 = new JScrollPane(jTable1);
            //JFrame frame = new JFrame("Affichage JTable");
            //JPanel panel = new JPanel();
            //panel.add(pane);
            //frame.add(panel);
            //frame.setSize(500, 500);
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.setVisible(true);
        
        
        jTable2.setBackground(new java.awt.Color(255, 255, 204));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
                
            },
            new String [] {
                "Mots"
            }
        ) {
            /**
                         * 
                         */
                        private static final long serialVersionUID = 1L;
                        @SuppressWarnings("rawtypes")
                        Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            @SuppressWarnings("rawtypes")
                        public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Mincho", 0, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Amine\\Documents\\NetBeansProjects\\Interface_application\\src\\interface_application\\wikipedia.png")); // NOI18N
        jLabel2.setText("Wikipédia");

        jPanel2.setBackground(new java.awt.Color(230, 118, 43));

        jCheckBox1.setBackground(new java.awt.Color(255, 153, 0));
        jCheckBox1.setFont(new java.awt.Font("Yu Mincho", 0, 11)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Le Figaro");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(255, 153, 0));
        jCheckBox2.setFont(new java.awt.Font("Yu Mincho", 0, 11)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("20minutes");

        jCheckBox3.setBackground(new java.awt.Color(255, 153, 0));
        jCheckBox3.setFont(new java.awt.Font("Yu Mincho", 0, 11)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("Le Monde");

        jCheckBox4.setBackground(new java.awt.Color(255, 153, 0));
        jCheckBox4.setFont(new java.awt.Font("Yu Mincho", 0, 11)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("Google News");

        jCheckBox5.setBackground(new java.awt.Color(255, 153, 0));
        jCheckBox5.setFont(new java.awt.Font("Yu Mincho", 0, 11)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setText("Libération");

        jCheckBox6.setBackground(new java.awt.Color(255, 153, 0));
        jCheckBox6.setFont(new java.awt.Font("Yu Mincho", 0, 11)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setText("Rue89");

        jCheckBox7.setBackground(new java.awt.Color(255, 153, 0));
        jCheckBox7.setFont(new java.awt.Font("Yu Mincho", 0, 11)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setText("L'équipe");

        jCheckBox8.setBackground(new java.awt.Color(255, 153, 0));
        jCheckBox8.setFont(new java.awt.Font("Yu Mincho", 2, 11)); // NOI18N
        jCheckBox8.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox8.setText("Les Echos");

        jCheckBox9.setBackground(new java.awt.Color(255, 153, 0));
        jCheckBox9.setFont(new java.awt.Font("Yu Mincho", 0, 11)); // NOI18N
        jCheckBox9.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox9.setText("L'humanité");

        jCheckBox10.setBackground(new java.awt.Color(255, 153, 0));
        jCheckBox10.setFont(new java.awt.Font("Yu Mincho", 0, 11)); // NOI18N
        jCheckBox10.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox10.setText("New York Times");

        jLabel4.setFont(new java.awt.Font("Yu Mincho", 0, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Bienvenue !");

        jLabel1.setFont(new java.awt.Font("Yu Mincho", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 102));
        jLabel1.setText("Mes abonnements :");

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Amine\\Documents\\NetBeansProjects\\InterfaceGraphique\\src\\interfacegraphique\\logo.jpg")); // NOI18N

        jButton1.setFont(new java.awt.Font("Yu Mincho", 0, 11)); // NOI18N
        jButton1.setText("Mon profil");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox10)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Yu Mincho", 0, 10)); // NOI18N
        jLabel8.setText("© 2013-2014, Amine EDDEGHAI, Yimei LIU, Allachi AKE, Hiba EL MAHFOUDI");

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Mincho", 0, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Actualité mondiale");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Yu Mincho", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Mes news stockées :");

        jButton2.setText("Accéder");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(jLabel8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jTable1.addMouseListener(mouseListenerEvents);
        pack();
        
        
    }// </editor-fold>                        
    
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface_Mynews2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface_Mynews2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface_Mynews2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface_Mynews2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface_Mynews2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration                   
}