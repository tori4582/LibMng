package org;

import com.Book;
import com.BookIndex;
import com.BookStorage;
import com.Market;
import com.MarketIndex;
import com.ReaderNode;
import com.ReaderTree;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MarketManager extends javax.swing.JFrame {
    
    ReaderTree readerTree = ReaderTree.getTree();
    BookStorage storage = BookStorage.getStorage();
    Market market = Market.getMarket();
    
    ReaderNode loadedReader = null;
    
    DefaultTableModel tableModel;
    DefaultTableModel topModel;
    ArrayList<ReaderNode> readerList;
    ArrayList<BookIndex> bookIndexList;
    ArrayList<MarketIndex> readerTrades;

    public MarketManager() {
        initComponents();
        fetch();
    }
    
    //Remember to use this function everywhen you want to get something from
    // the existing lists
    private void fetch() {
        readerList = readerTree.toArrayList();
        bookIndexList = storage.toArrayList();
    }

    private void ranking() {
        
        topModel = (DefaultTableModel) this.topTable.getModel();
        topModel.setRowCount(0);
        
        fetch();
        
        ArrayList<Integer> counterList = new ArrayList();
        ArrayList<Book> bookList = market.getListOfBook();
        bookList.forEach((Book book) -> {
            counterList.add(market.countReaderOfBook(book));
        }); 
        System.out.println(counterList.toString());
        System.out.println(bookList.toString());
        //sorting
        for (int i = 0; i < bookList.size() - 1; i++) {
            for (int j = i + 1; j < bookList.size(); j++) {
                if (counterList.get(i) < counterList.get(j)) {      // swappings
                    Integer tempCounter = counterList.get(i);
                    counterList.set(i, counterList.get(j));
                    counterList.set(j, tempCounter);
                    
                    Book tempBook = bookList.get(i);
                    bookList.set(i, bookList.get(j));
                    bookList.set(j, tempBook);
                }
            }
        }
        //displaying
        for (int i = 0; i < ((bookList.size() < 10) ? bookList.size() : 10) ; i++) {
            topModel.addRow(new Object[] {bookList.get(i).getName(),
                                          counterList.get(i)});
        }
    }
    
    private void updateBoard() {
        
        tableModel = (DefaultTableModel) this.displayTable.getModel();

        tableModel.setRowCount(0);
        
        fetch();
        readerTrades = market.findByReader(loadedReader.getReader());
        //displaying
        for (MarketIndex trade : readerTrades) {
            
            tableModel.addRow(new Object[] {trade.getBookIndex().getIndex(),
                                            trade.getBookIndex().getBookInstance().getName(),
                                            trade.getPickDate(),
                                            trade.getReturnDate(),
                                            trade.getStatus()
                                           });
        }
        
        ranking();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        inputCode = new javax.swing.JTextField();
        btnLoad = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        readerName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        readerCode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        boxActivated = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        topTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        inputBookIndex = new javax.swing.JTextField();
        btnAction = new javax.swing.JButton();
        btnLost = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Market Manager");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Reader Loader"));

        jLabel2.setText("Reader code");

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 143, Short.MAX_VALUE))
                    .addComponent(inputCode)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLoad)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoad)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Reader Information"));

        jLabel3.setText("Reader Name");

        readerName.setEnabled(false);

        jLabel4.setText("Reader Code");

        readerCode.setEnabled(false);

        jLabel5.setText("Reader Status");

        boxActivated.setText("Activated");
        boxActivated.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(readerName)
                            .addComponent(readerCode)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(boxActivated)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(readerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(readerCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(boxActivated))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "BookIndex", "BookName", "PickedDate", "ReturnDate", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(displayTable);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Top 10 Picked Book"));

        topTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "BookName", "Picked Times"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(topTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Book Picking - Returning"));

        jLabel6.setText("Book Index");

        inputBookIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBookIndexActionPerformed(evt);
            }
        });
        inputBookIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputBookIndexKeyTyped(evt);
            }
        });

        btnAction.setText("Pick / Return");
        btnAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionActionPerformed(evt);
            }
        });

        btnLost.setText("Lost");
        btnLost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputBookIndex))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnLost, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAction, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputBookIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAction)
                    .addComponent(btnLost))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                        .addGap(265, 265, 265))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        if (inputCode.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "There is no code in the box", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            
            fetch();
            int code = Integer.parseInt(inputCode.getText());
            boolean found = false;
            for (ReaderNode node : readerList) {
                if (node.getReader().getComparableCode() == code) {
                    loadedReader = node;
                    
                    this.readerName.setText(loadedReader.getReader().getFirstName() 
                        + " " + loadedReader.getReader().getLastName());
                    this.readerCode.setText(loadedReader.getReader().getCode());
                    this.boxActivated.setSelected(loadedReader.getReader().getCardStatus());
                    
                    updateBoard();
                    found = true;
                    
                    JOptionPane.showMessageDialog(null, "Expected reader is found", "Information", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }    
            if (!found) {
                JOptionPane.showMessageDialog(null, "There is no such reader in the Reader Tree", "Reader is not found", JOptionPane.ERROR_MESSAGE);
            }   
        }
    }//GEN-LAST:event_btnLoadActionPerformed

    private void inputBookIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBookIndexActionPerformed
        
    }//GEN-LAST:event_inputBookIndexActionPerformed

    private void inputBookIndexKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputBookIndexKeyTyped
        
    }//GEN-LAST:event_inputBookIndexKeyTyped

    private void btnActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionActionPerformed
        String indexCode = inputBookIndex.getText();
        boolean flag = false;   //TRUE when returning and FALSE when picking
        
        //check state, if already picked, changes the flag
        for (MarketIndex trade : readerTrades) {
            if (trade.getBookIndex().getIndex().equalsIgnoreCase(indexCode)) {
                flag = true;
            }
        }
        
        fetch();
        
        if (flag) {     //returning action
            BookIndex instance = null;
            for (MarketIndex trade : readerTrades) {
                if (trade.getBookIndex().getIndex().equalsIgnoreCase(indexCode)) {
                    instance = trade.getBookIndex();
                }
            }
            
            if (instance == null) {
                 JOptionPane.showMessageDialog(null, 
                                              "Given Book Index Code is not found !",
                                              "Error",
                                              JOptionPane.ERROR_MESSAGE);
            } else {
                market.delete(market.indexOf(instance, loadedReader.getReader()));
                updateBoard();
                JOptionPane.showMessageDialog(null, 
                                              "Book Returned",
                                              "Action complete",
                                              JOptionPane.INFORMATION_MESSAGE);
            }
        } else {        //picking action 
            BookIndex instance = null;
            for (BookIndex index : bookIndexList) {
                if (index.getIndex().equalsIgnoreCase(indexCode)) {
                    instance = index;
                }
            }
            //check limitation
            
            int numOfBook = market.countBookOfReader(loadedReader.getReader());
            
            if (numOfBook > 2) {
                instance = null;
            } 
            
            if (instance == null) {     // wrong index code
                
                String message;
                
                if (numOfBook > 2) {
                    message = "You can't pick more book";
                } else {
                    message = "Given Book Index Code is not found !";
                }
                
                JOptionPane.showMessageDialog(null, 
                                              message,
                                              "Error",
                                              JOptionPane.ERROR_MESSAGE);
            } else {    // found
                
                //checking confliction  
                
                market.append(new MarketIndex(instance, loadedReader.getReader()));
                updateBoard();
                JOptionPane.showMessageDialog(null, 
                                              "Book Picked",
                                              "Action complete",
                                              JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_btnActionActionPerformed

    private void btnLostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLostActionPerformed
        String indexCode = inputBookIndex.getText();
        boolean picked = false;  
        MarketIndex marketIndex = null;
        
        //check state, if already picked, changes the flag
        for (MarketIndex trade : readerTrades) {
            if (trade.getBookIndex().getIndex().equalsIgnoreCase(indexCode)) {
                picked = true;
                marketIndex = trade;
            }
        }
        
        fetch();
        
        if (!picked) {     
             JOptionPane.showMessageDialog(null, 
                                          "Given Book Index Code is not found !",
                                          "Error",
                                          JOptionPane.ERROR_MESSAGE);

        } else {        //lost report
            marketIndex.reportLost();
            JOptionPane.showMessageDialog(null, 
                                          "Reader has lost the book",
                                          "Warning",
                                          JOptionPane.WARNING_MESSAGE);
            updateBoard(); 
        }
        
    }//GEN-LAST:event_btnLostActionPerformed

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
            java.util.logging.Logger.getLogger(MarketManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarketManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxActivated;
    private javax.swing.JButton btnAction;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnLost;
    private javax.swing.JTable displayTable;
    private javax.swing.JTextField inputBookIndex;
    private javax.swing.JTextField inputCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField readerCode;
    private javax.swing.JTextField readerName;
    private javax.swing.JTable topTable;
    // End of variables declaration//GEN-END:variables
}
