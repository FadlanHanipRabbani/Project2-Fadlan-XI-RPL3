package classes;

/**
 *
 * @author Fadlanbray
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DataSiswa extends javax.swing.JFrame {

    /**
     * Creates new form DataSiswa
     */
    
    Connection koneksi;
            
    public DataSiswa() {
        initComponents();
        koneksi = DatabaseConnection.getKoneksi("localhost", "3306", "root", "", "db_sekolah");
        showData();
    }

    DefaultTableModel dtm;
    
    public void showData(){
        String[] kolom = {"No", "NIS", "Nama", "Kelas", "Jurusan"};
        
        dtm = new DefaultTableModel(null, kolom);
        
        try{
            Statement stmt = koneksi.createStatement();
            String query = "SELECT * FROM t_siswa";
            ResultSet rs = stmt.executeQuery(query);
            
            int no = 1;
            while (rs.next()){
                String nis = rs.getString("nis");
                String nama = rs.getString("nama");
                String kelas = rs.getString("kelas");
                String jurusan = rs.getString("jurusan");
                
                dtm.addRow(new String[]{no+"", nis, nama, kelas, jurusan});
                no++;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        tbl_siswa.setModel(dtm);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdRefresh = new javax.swing.JButton();
        cmdHapus = new javax.swing.JButton();
        cmdEdit = new javax.swing.JButton();
        cmdTambah = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_siswa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmdRefresh.setText("Refresh");

        cmdHapus.setText("Hapus");
        cmdHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHapusActionPerformed(evt);
            }
        });

        cmdEdit.setText("Ubah");

        cmdTambah.setText("Tambah");
        cmdTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTambahActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Siswa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        tbl_siswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "NIS", "Nama", "Kelas", "Jurusan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_siswa.getTableHeader().setReorderingAllowed(false);
        tbl_siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_siswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_siswa);
        if (tbl_siswa.getColumnModel().getColumnCount() > 0) {
            tbl_siswa.getColumnModel().getColumn(0).setResizable(false);
            tbl_siswa.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbl_siswa.getColumnModel().getColumn(1).setResizable(false);
            tbl_siswa.getColumnModel().getColumn(1).setPreferredWidth(75);
            tbl_siswa.getColumnModel().getColumn(2).setResizable(false);
            tbl_siswa.getColumnModel().getColumn(3).setResizable(false);
            tbl_siswa.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(cmdRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addComponent(cmdTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdHapus)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdRefresh)
                    .addComponent(cmdHapus)
                    .addComponent(cmdEdit)
                    .addComponent(cmdTambah))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTambahActionPerformed
        // TODO add your handling code here:
        TambahData tambahData = new TambahData(this, true);
        tambahData.setVisible(true);
    }//GEN-LAST:event_cmdTambahActionPerformed

    int baris;
    private void tbl_siswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_siswaMouseClicked
        // TODO add your handling code here:
        baris = tbl_siswa.getSelectedRow();
    }//GEN-LAST:event_tbl_siswaMouseClicked

    private void cmdHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHapusActionPerformed
        // TODO add your handling code here:
        String idWhoWantToBeDelete = tbl_siswa.getValueAt(baris, 1).toString();
        try{
            Statement stmt = koneksi.createStatement();
            String query = "DELETE FROM t_siswa WHERE nis = '"+idWhoWantToBeDelete+"';";
            int berhasil = stmt.executeUpdate(query);   
            
            if(berhasil == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                dtm.getDataVector().removeAllElements();
                showData();
            } else {
               JOptionPane.showMessageDialog(null, "Data Tidak Berhasil Dihapus");
            } 
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cmdHapusActionPerformed

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
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdEdit;
    private javax.swing.JButton cmdHapus;
    private javax.swing.JButton cmdRefresh;
    private javax.swing.JButton cmdTambah;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_siswa;
    // End of variables declaration//GEN-END:variables
}