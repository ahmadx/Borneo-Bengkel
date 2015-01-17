/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borneomotor;

import static borneomotor.fSparePart.id_kategori;
import static borneomotor.fSparePart.id_satuan;
import static borneomotor.fSparePart.jTextField2;
import static borneomotor.fSparePart.jTextField3;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sun.swing.table.DefaultTableCellHeaderRenderer;
//import java.text.*;

/**
 *
 * @author Administrator
 */
public class fMekanik extends javax.swing.JFrame {
double harga;
String id_mekanik;
    /**
     * Creates new form fMekanik
     */
    public fMekanik() {
        initComponents();
        setLocationRelativeTo(this);
        KosongkanForm();
        BikinJudulKolom();
    }
    
    private void KosongkanForm() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        id_mekanik="";
        
        jTextField1.requestFocus();
//      
    }
    
     private void BikinJudulKolom(){
        Object[] judul_kolom={("ID"),("Nama Mekanik"),("Alamat"),("Kota"),("Kode POS"),("Telepon")};
        DefaultTableModel model = new DefaultTableModel(null,judul_kolom);
        jTable1.setModel(model);
        model.getDataVector().removeAllElements();
        
        try 
        {
            koneksiDB.koneksi();
            koneksiDB.rs=koneksiDB.st.executeQuery("select id_mekanik, nm_mekanik, alamat, kota, kd_pos, telepon "+
                                                    "from mekanik "+
                                                    "order by id_mekanik asc");
            while (koneksiDB.rs.next()) {

//                harga=Double.parseDouble(koneksiDB.rs.getString("harga_satuan"));
//                customFormat("###,###,###", harga);

                model.addRow(new Object[]{koneksiDB.rs.getString("id_mekanik"),
                                koneksiDB.rs.getString("nm_mekanik"),
                                koneksiDB.rs.getString("alamat"),
                                koneksiDB.rs.getString("kota"),
                                koneksiDB.rs.getString("kd_pos"),
                                koneksiDB.rs.getString("telepon")});
            }
            koneksiDB.putuskoneksi();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Menampilkan data gagal! Error: "+e);
        }
        lebarkolom();
        
    }
     
    private void lebarkolom(){
        TableColumn column;
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = jTable1.getColumnModel().getColumn(0); 
        column.setPreferredWidth(50);
        column = jTable1.getColumnModel().getColumn(1); 
        column.setPreferredWidth(150); 
        column = jTable1.getColumnModel().getColumn(2); 
        column.setPreferredWidth(250); 
        column = jTable1.getColumnModel().getColumn(3); 
        column.setPreferredWidth(150); 
        column = jTable1.getColumnModel().getColumn(4); 
        column.setPreferredWidth(75); 
        column = jTable1.getColumnModel().getColumn(5); 
        column.setPreferredWidth(150); 
        
        
        //rata tengah untuk judul kolom
        DefaultTableCellHeaderRenderer tengahRenderer = new DefaultTableCellHeaderRenderer();
        tengahRenderer.setHorizontalAlignment(DefaultTableCellHeaderRenderer.CENTER);
        jTable1.getColumnModel().getColumn(0).setHeaderRenderer(tengahRenderer);
        jTable1.getColumnModel().getColumn(1).setHeaderRenderer(tengahRenderer);
        jTable1.getColumnModel().getColumn(2).setHeaderRenderer(tengahRenderer);
        jTable1.getColumnModel().getColumn(3).setHeaderRenderer(tengahRenderer);
        jTable1.getColumnModel().getColumn(4).setHeaderRenderer(tengahRenderer);
        jTable1.getColumnModel().getColumn(5).setHeaderRenderer(tengahRenderer);
        
        
        //rata tengah untuk kolom 0 (ID Kategori)
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
//        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
//        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
//        jTable1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        
        //rata kanan untuk kolom duit-duitan.
//        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
//        jTable1.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Mekanik");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 400));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 400));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 400));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setMaximumSize(new java.awt.Dimension(785, 190));
        jPanel3.setMinimumSize(new java.awt.Dimension(785, 190));
        jPanel3.setPreferredSize(new java.awt.Dimension(785, 190));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jTable1.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jPanel3, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(785, 180));
        jPanel1.setMinimumSize(new java.awt.Dimension(785, 180));
        jPanel1.setPreferredSize(new java.awt.Dimension(785, 180));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("/media/ahmad/DATA2/BORNEO SOFTWARE/SOURCE CODE BDM/Borneo Motor/gambar/mekanik.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jLabel2.setText("Nama Mekanik");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jLabel3.setText("Alamat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Kota");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jLabel6.setText("Telepon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jLabel7.setText("Kode POS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel7, gridBagConstraints);

        jTextField1.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jTextField1.setText("jTextField1");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 300);
        jPanel1.add(jTextField1, gridBagConstraints);

        jTextField2.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jTextField2.setText("jTextField2");
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jTextField2, gridBagConstraints);

        jTextField3.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jTextField3.setText("jTextField3");
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jTextField3, gridBagConstraints);

        jTextField4.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jTextField4.setText("jTextField4");
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jTextField4, gridBagConstraints);

        jTextField5.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jTextField5.setText("jTextField5");
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jTextField5, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jButton1.setMnemonic('s');
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jButton1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel2, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jButton2.setMnemonic('k');
        jButton2.setLabel("Keluar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField4.requestFocus();
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField5.requestFocus();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jButton1.doClick();
            
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                if ("".equals(jTextField1.getText())) 
        {
            JOptionPane.showMessageDialog(null, "Nama Mekanik tidak boleh kosong!");
            jTextField1.requestFocus(); 
            return;
        } 
        if ("".equals(jTextField2.getText())) 
        {
            JOptionPane.showMessageDialog(null, "Alamat Mekanik tidak boleh kosong!");
            jTextField2.requestFocus(); 
            return;
            
        }
        if ("".equals(jTextField3.getText())) 
        {
            JOptionPane.showMessageDialog(null, "Kota tidak boleh kosong!");
            jTextField3.requestFocus(); 
            return;
            
        }
         if ("".equals(jTextField4.getText())) 
        {
            JOptionPane.showMessageDialog(null, "Kode Pos tidak boleh kosong! Isi dengan 0 (nol).");
            jTextField4.requestFocus(); 
            return;
            
        }
          if ("".equals(jTextField5.getText())) 
        {
            JOptionPane.showMessageDialog(null, "Telepon tidak boleh kosong! Isi dengan 0 (nol).");
            jTextField5.requestFocus(); 
            return;
            
        }
        if (!"".equals(id_mekanik))
        {   
            CekData2();
        }else{
            CekData(); 
        }
 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        KosongkanForm();
        int row=jTable1.getSelectedRow();
        
//        String duit=jTable1.getModel().getValueAt(row,4).toString();
//        duit = duit.replace(".", "");
        
        id_mekanik=jTable1.getModel().getValueAt(row,0).toString();
        jTextField1.setText(jTable1.getModel().getValueAt(row,1).toString());
        jTextField2.setText(jTable1.getModel().getValueAt(row,2).toString());
        jTextField3.setText(jTable1.getModel().getValueAt(row,3).toString());
        jTextField4.setText(jTable1.getModel().getValueAt(row,4).toString());
        jTextField5.setText(jTable1.getModel().getValueAt(row,5).toString());
//        AmbilKodeKategori();
//        AmbilKodeSatuan();
//        
    }//GEN-LAST:event_jTable1MouseClicked

    private void EditData(){
    try {
        koneksiDB.koneksi();
        koneksiDB.st.executeUpdate("update mekanik set nm_mekanik='"+jTextField1.getText()+"',"+
                                    "alamat='"+jTextField2.getText()+"', "+
                                    "kota='"+jTextField3.getText()+"', "+
                                    "kd_pos='"+jTextField4.getText()+"', "+
                                    "telepon='"+jTextField5.getText()+"' "+
                                    "where id_mekanik='"+id_mekanik+"'");
        JOptionPane.showMessageDialog(null, "Data Mekanik berhasil diedit...");
        KosongkanForm();
        //koneksiDB.putuskoneksi();
        BikinJudulKolom();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data Mekanik gagal diedit. Keterangan error: "+e);
        
    }
        
    }
    
    private void CekData2(){
    try {
        koneksiDB.koneksi();
        koneksiDB.rs=koneksiDB.st.executeQuery("select * from mekanik "+
                                    "where nm_mekanik='"+jTextField1.getText()+"' "+
                                    "and id_mekanik<>'"+id_mekanik+"'");
        //JOptionPane.showMessageDialog(null, "Hasil Query: "+rs.toString());
        if (koneksiDB.rs.next()) {
            koneksiDB.putuskoneksi();
            JOptionPane.showMessageDialog(null, "Nama Mekanik "+jTextField1.getText()+" sudah ada. Masukkan nama lainnya.");
            jTextField1.requestFocus();
            
            }else {
                EditData();
                koneksiDB.putuskoneksi();
                KosongkanForm();
                BikinJudulKolom();
                //BikinJudul2();
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal melakukan cek data. Keterangan error: "+e);

        }
        
    }
    
    private void CekData(){
    try {
        koneksiDB.koneksi();
        koneksiDB.rs=koneksiDB.st.executeQuery("select * from mekanik where nm_mekanik='"+jTextField1.getText()+"'");
        //JOptionPane.showMessageDialog(null, "Hasil Query: "+rs.toString());
        if (koneksiDB.rs.next()) {
            koneksiDB.putuskoneksi();
            JOptionPane.showMessageDialog(null, "Nama Mekanik "+jTextField1.getText()+" sudah ada. Masukkan nama lainnya.");
            jTextField1.requestFocus();
            
        }else {
            SimpanData();
            koneksiDB.putuskoneksi();
            KosongkanForm();
            BikinJudulKolom();
            //BikinJudul2();
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal melakukan cek data. Keterangan error: "+e);
        
    }
        
    }
    
    private void SimpanData(){
    try {
        //koneksi();
        koneksiDB.st.executeUpdate("insert into mekanik (nm_mekanik, alamat, kota, kd_pos, telepon) "+
                                    "values ('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"',"+
                                            "'"+jTextField4.getText()+"','"+jTextField5.getText()+"')");
        
        JOptionPane.showMessageDialog(null, "Data Mekanik berhasil disimpan...");
        KosongkanForm();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data Mekanik gagal disimpan. Keterangan error: "+e);
        
    }
        
    }
    
//    public void customFormat(String pattern, double value ) {
//      DecimalFormat myFormatter = new DecimalFormat(pattern);
//      String output = myFormatter.format(value);
//      //System.out.println(output);
//      //jTextField8.setText(output);
//   }

    
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
            java.util.logging.Logger.getLogger(fMekanik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fMekanik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fMekanik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fMekanik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fMekanik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
