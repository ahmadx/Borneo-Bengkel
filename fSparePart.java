/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borneomotor;

import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
//import javafx.scene.input.KeyCode;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Ahmad
 */
public class fSparePart extends javax.swing.JFrame {
String id_item;
Double harga;
String uang;

public static String id_kategori;
public static String id_satuan;
    /**
     * Creates new form fSparePart
     */
    public fSparePart() {
        initComponents();
        setLocationRelativeTo(this);
        KosongkanForm();
        BikinJudulKolom();
       
    }
    
    
            
    private void KosongkanForm() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("0");
        jTextField5.setText("0");
        jTextField1.requestFocus();
        id_item="";
        id_kategori="";
        id_satuan="";
     
    }
    
    
    
    private void BikinJudulKolom(){
        Object[] judul_kolom={("ID"),("Nama Item"),("Kategori"),("Satuan"),("Harga Satuan"),("Stok")};
        DefaultTableModel model = new DefaultTableModel(null,judul_kolom);
        jTable1.setModel(model);
        model.getDataVector().removeAllElements();
        
        try 
        {
            koneksiDB.koneksi();
            koneksiDB.rs=koneksiDB.st.executeQuery("select i.id_item, i.nm_item, k.nm_kategori, s.nm_satuan, i.harga_satuan, "+
                                                    "i.stok from item i, kategori k, satuan s "+
                                                    "where k.id_kategori=i.id_kategori and s.id_satuan=i.id_satuan "+
                                                    "order by i.id_item asc");
            while (koneksiDB.rs.next()) {

                harga=Double.parseDouble(koneksiDB.rs.getString("harga_satuan"));
                customFormat("###,###,###", harga);

                model.addRow(new Object[]{koneksiDB.rs.getString("id_item"),
                                koneksiDB.rs.getString("nm_item"),
                                koneksiDB.rs.getString("nm_kategori"),
                                koneksiDB.rs.getString("nm_satuan"),
                                uang,
                                koneksiDB.rs.getString("stok")});
            }
            koneksiDB.putuskoneksi();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Menampilkan data gagal! Error: "+e);
        }
        lebarkolom();
        
    }
    
    public void customFormat(String pattern, double value ) {
      DecimalFormat myFormatter = new DecimalFormat(pattern);
      String output = myFormatter.format(value);
      uang=output;
      
    }
    
    private void lebarkolom(){
        TableColumn column;
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = jTable1.getColumnModel().getColumn(0); 
        column.setPreferredWidth(40);
        column = jTable1.getColumnModel().getColumn(1); 
        column.setPreferredWidth(200); 
        column = jTable1.getColumnModel().getColumn(2); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(3); 
        column.setPreferredWidth(50); 
        column = jTable1.getColumnModel().getColumn(4); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(5); 
        column.setPreferredWidth(75); 
        
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
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        //jTable1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        
        //rata kanan untuk kolom duit-duitan.
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        
        
        
        
       
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

        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Item");
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jButton4.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jButton4.setMnemonic('k');
        jButton4.setText("Keluar");
        jButton4.setMaximumSize(new java.awt.Dimension(80, 30));
        jButton4.setMinimumSize(new java.awt.Dimension(80, 30));
        jButton4.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton4, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel7.setText("Klik pada Daftar Item untuk Edit Data.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        getContentPane().add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(filler1, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 300));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("/media/ahmad/DATA2/BORNEO SOFTWARE/SOURCE CODE BDM/Borneo Motor/gambar/begkel2.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 20);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel2.setText("Nama Item");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel3.setText("Kategori");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel4.setText("Satuan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel5.setText("Harga Satuan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel6.setText("Stok");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel6, gridBagConstraints);

        jTextField1.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jTextField1.setText("jTextField1");
        jTextField1.setMaximumSize(new java.awt.Dimension(200, 20));
        jTextField1.setMinimumSize(new java.awt.Dimension(200, 20));
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jTextField1, gridBagConstraints);

        jTextField2.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jTextField2.setText("jTextField2");
        jTextField2.setEnabled(false);
        jTextField2.setMaximumSize(new java.awt.Dimension(200, 20));
        jTextField2.setMinimumSize(new java.awt.Dimension(200, 20));
        jTextField2.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jTextField2, gridBagConstraints);

        jTextField3.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jTextField3.setText("jTextField3");
        jTextField3.setEnabled(false);
        jTextField3.setMaximumSize(new java.awt.Dimension(200, 20));
        jTextField3.setMinimumSize(new java.awt.Dimension(200, 20));
        jTextField3.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jTextField3, gridBagConstraints);

        jTextField4.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jTextField4.setText("jTextField4");
        jTextField4.setMaximumSize(new java.awt.Dimension(200, 20));
        jTextField4.setMinimumSize(new java.awt.Dimension(200, 20));
        jTextField4.setPreferredSize(new java.awt.Dimension(200, 20));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jTextField4, gridBagConstraints);

        jTextField5.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jTextField5.setText("jTextField5");
        jTextField5.setMaximumSize(new java.awt.Dimension(200, 20));
        jTextField5.setMinimumSize(new java.awt.Dimension(200, 20));
        jTextField5.setPreferredSize(new java.awt.Dimension(200, 20));
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jTextField5, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon("/media/ahmad/DATA2/BORNEO SOFTWARE/SOURCE CODE BDM/Borneo Motor/gambar/cari.png")); // NOI18N
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jButton1, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon("/media/ahmad/DATA2/BORNEO SOFTWARE/SOURCE CODE BDM/Borneo Motor/gambar/cari.png")); // NOI18N
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        jPanel1.add(jButton2, gridBagConstraints);

        jButton3.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jButton3.setMnemonic('s');
        jButton3.setText("Simpan");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jButton3, gridBagConstraints);

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
        jTable1.setFocusable(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 508;
        gridBagConstraints.ipady = 130;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 8, 8);
        jPanel1.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField2.setText("");
        id_kategori = "";
        new fDaftarKategori().show();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField3.setText("");
        id_satuan = "";
        new fDaftarSatuan().show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField5.requestFocus();
        }
        
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        FilterHanyaAngka(evt);
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jButton3.doClick();
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        FilterHanyaAngka(evt);
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if ("".equals(jTextField1.getText())) 
        {
            JOptionPane.showMessageDialog(null, "Nama Item tidak boleh kosong!");
            jTextField1.requestFocus(); 
            return;
        } 
        if ("".equals(jTextField2.getText())) 
        {
            JOptionPane.showMessageDialog(null, "Kategori Item tidak boleh kosong!");
            jButton1.requestFocus(); 
            return;
            
        }
        if ("".equals(jTextField3.getText())) 
        {
            JOptionPane.showMessageDialog(null, "Satuan Item tidak boleh kosong!");
            jButton2.requestFocus(); 
            return;
            
        }
         if ("".equals(jTextField4.getText())) 
        {
            JOptionPane.showMessageDialog(null, "Harga Satuan Item tidak boleh kosong! Isi dengan 0 (nol).");
            jTextField4.requestFocus(); 
            return;
            
        }
          if ("".equals(jTextField5.getText())) 
        {
            JOptionPane.showMessageDialog(null, "Stok Item tidak boleh kosong! Isi dengan 0 (nol).");
            jTextField5.requestFocus(); 
            return;
            
        }
        if (!"".equals(id_item))
        {   
            CekData2();
        }else{
            CekData(); 
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row=jTable1.getSelectedRow();
        String hargax=jTable1.getModel().getValueAt(row,4).toString();
        
        hargax=hargax.replace(".", "");
        
        id_item=jTable1.getModel().getValueAt(row,0).toString();
        jTextField1.setText(jTable1.getModel().getValueAt(row,1).toString());
        jTextField2.setText(jTable1.getModel().getValueAt(row,2).toString());
        jTextField3.setText(jTable1.getModel().getValueAt(row,3).toString());
        jTextField4.setText(hargax);
        jTextField5.setText(jTable1.getModel().getValueAt(row,5).toString());
        AmbilKodeKategori();
        AmbilKodeSatuan();
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void AmbilKodeSatuan() {
    try {
        koneksiDB.koneksi();
        koneksiDB.rs=koneksiDB.st.executeQuery("select id_satuan from satuan where nm_satuan='"+jTextField3.getText()+"'");
        //JOptionPane.showMessageDialog(null, "Hasil Query: "+rs.toString());
        if (koneksiDB.rs.next()) {
            id_satuan=koneksiDB.rs.getString("id_satuan");
            koneksiDB.putuskoneksi();
            
        }else {
            koneksiDB.putuskoneksi();
            JOptionPane.showMessageDialog(null, "Gagal ambil data Kode Satuan."); 
        }
        
    } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null, "Gagal ambil kode satuan. Keterangan error: "+e);
        
    }
        
    }    
    
    private void AmbilKodeKategori() {
    try {
        koneksiDB.koneksi();
        koneksiDB.rs=koneksiDB.st.executeQuery("select id_kategori from kategori where nm_kategori='"+jTextField2.getText()+"'");
        //JOptionPane.showMessageDialog(null, "Hasil Query: "+rs.toString());
        if (koneksiDB.rs.next()) {
            id_kategori=koneksiDB.rs.getString("id_kategori");
            koneksiDB.putuskoneksi();
            
        }else {
            koneksiDB.putuskoneksi();
            JOptionPane.showMessageDialog(null, "Gagal ambil data Kode Kategori."); 
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal ambil kode kategori. Keterangan error: "+e);
        
    }
        
    }    
    
    private void CekData(){
    try {
        koneksiDB.koneksi();
        koneksiDB.rs=koneksiDB.st.executeQuery("select * from item where nm_item='"+jTextField1.getText()+"'");
        //JOptionPane.showMessageDialog(null, "Hasil Query: "+rs.toString());
        if (koneksiDB.rs.next()) {
            koneksiDB.putuskoneksi();
            JOptionPane.showMessageDialog(null, "Nama Item "+jTextField1.getText()+" sudah ada. Masukkan nama lainnya.");
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
        koneksiDB.st.executeUpdate("insert into item (nm_item, id_kategori, id_satuan, harga_satuan, stok) "+
                                    "values ('"+jTextField1.getText()+"','"+id_kategori+"','"+id_satuan+"',"+
                                            "'"+jTextField4.getText()+"','"+jTextField5.getText()+"')");
        
        JOptionPane.showMessageDialog(null, "Data Item berhasil disimpan...");
        KosongkanForm();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data Item gagal disimpan. Keterangan error: "+e);
        
    }
        
    }
    
    private void CekData2(){
    try {
        koneksiDB.koneksi();
        koneksiDB.rs=koneksiDB.st.executeQuery("select * from item "+
                                    "where nm_item='"+jTextField1.getText()+"' "+
                                    "and id_item<>'"+id_item+"'");
        //JOptionPane.showMessageDialog(null, "Hasil Query: "+rs.toString());
        if (koneksiDB.rs.next()) {
            koneksiDB.putuskoneksi();
            JOptionPane.showMessageDialog(null, "Nama Item "+jTextField1.getText()+" sudah ada. Masukkan nama lainnya.");
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
    
    private void EditData(){
    try {
        koneksiDB.koneksi();
        koneksiDB.st.executeUpdate("update item set nm_item='"+jTextField1.getText()+"',"+
                                    "id_kategori='"+id_kategori+"', "+
                                    "id_satuan='"+id_satuan+"', "+
                                    "harga_satuan='"+jTextField4.getText()+"', "+
                                    "stok='"+jTextField5.getText()+"' "+
                                    "where id_item='"+id_item+"'");
        JOptionPane.showMessageDialog(null, "Data Item berhasil diedit...");
        KosongkanForm();
        //koneksiDB.putuskoneksi();
        BikinJudulKolom();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data Item gagal diedit. Keterangan error: "+e);
        
    }
        
    }
    
    public void FilterHanyaAngka(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if (! ((Character.isDigit(c) ||
                (c == KeyEvent.VK_BACK_SPACE) ||
                (c == KeyEvent.VK_DELETE))
                )
            )
        {
            evt.consume();
        }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fSparePart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater() {
            new fSparePart().setVisible(true);
        //};
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    

  
}
