/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.service.AccountRecordService;
import controller.service.AccountingEntryService;
import controller.service.PersonService;
import controller.service.ReceivableAccountService;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import views.tableModel.AccountRecordTableModel;
import views.tableModel.PersonComboBoxModel;

/**
 *
 * @author eyetive
 */
public class ReceivableAccountView extends javax.swing.JDialog {
    
    private JTextField searchNameText;
    private final PersonService personService;
    private final ReceivableAccountService receivableAccountService;
    private final AccountRecordService accountRecordService;
    private final AccountRecordTableModel accountRecordTableModel;
    private final AccountingEntryService accountingEntryService;

    public ReceivableAccountView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.personService = new PersonService();
        this.receivableAccountService = new ReceivableAccountService();
        this.accountRecordService = new AccountRecordService();
        this.accountRecordTableModel = new AccountRecordTableModel();
        this.accountingEntryService = new AccountingEntryService();
        initComponents();
        paymentPanel.setVisible(false);
        chargePersonCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accountRecordTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        receivableAccountBalanceLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        paymentsLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        addPaymentButton = new javax.swing.JButton();
        paymentPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        paymentValueTextField = new javax.swing.JTextField();
        savePaymentButton = new javax.swing.JButton();
        searchCustomerComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        accountRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(accountRecordTable);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setText("SALDO:");

        receivableAccountBalanceLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        receivableAccountBalanceLabel.setForeground(new java.awt.Color(255, 51, 0));
        receivableAccountBalanceLabel.setText("0.00");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setText("PAGOS:");

        paymentsLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        paymentsLabel.setForeground(new java.awt.Color(255, 51, 0));
        paymentsLabel.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receivableAccountBalanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(receivableAccountBalanceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(paymentsLabel))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel1.setText("Buscar");

        addPaymentButton.setText("AGREGAR PAGO");
        addPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPaymentButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Valor:");

        savePaymentButton.setText("Guardar");
        savePaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePaymentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paymentPanelLayout = new javax.swing.GroupLayout(paymentPanel);
        paymentPanel.setLayout(paymentPanelLayout);
        paymentPanelLayout.setHorizontalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paymentValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(savePaymentButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paymentPanelLayout.setVerticalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(paymentValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(savePaymentButton))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addPaymentButton)
                .addGap(18, 18, 18)
                .addComponent(paymentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addPaymentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paymentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchCustomerComboBox.setEditable(true);
        searchCustomerComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                searchCustomerComboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchCustomerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchCustomerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(137, 137, 137))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchCustomerComboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_searchCustomerComboBoxPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (searchCustomerComboBox.getItemCount() != 0) {
            PersonComboBoxModel pcbm = (PersonComboBoxModel) searchCustomerComboBox.getModel();
            this.personService.setInstance(pcbm.getSelectedItem());
            if (this.personService.getPerson() != null) {
                this.chargeAccountRecordsInTable();
            }
        }
    }//GEN-LAST:event_searchCustomerComboBoxPopupMenuWillBecomeInvisible

    private void addPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPaymentButtonActionPerformed
        // TODO add your handling code here:
        paymentValueTextField.setText("");
        paymentPanel.setVisible(true);
    }//GEN-LAST:event_addPaymentButtonActionPerformed

    private void chargeAccountRecordData(){
        this.accountRecordService.getAccountRecord().setAccountRecordType(0);
        this.accountRecordService.getAccountRecord().setAccountRecordDate(new Date());
        this.accountRecordService.getAccountRecord().setAccountRecordDescription("Pago a la cuenta");
        this.accountRecordService.getAccountRecord().setAccountRecordValue(Double.parseDouble(this.paymentValueTextField.getText()));
        this.accountRecordService.getAccountRecord().setReceivableAccount(this.receivableAccountService.getReceivableAccount());
    }
    
    private void savePaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePaymentButtonActionPerformed
        // TODO add your handling code here:
        if(this.accountRecordService.getAccountRecord().getAccountRecordId() == null){
            this.chargeAccountRecordData();
            if(this.accountRecordService.saveAccountRecord()){
                JOptionPane.showMessageDialog(null, "Pago agregado correctamente");
                //Agregamos el pago a la lista y la mostramos en la tabla
                this.accountRecordService.addAccountRecord(this.accountRecordService.getAccountRecord());
                //Actualizamos la vista de la tabla
                this.accountRecordTable.updateUI();
                
                
                
                 //this.receivableAccountService.setInstance(this.receivableAccountService.getReceivableAccountByPerson(this.personService.getPerson()));
                
                Double newValue = this.receivableAccountService.getReceivableAccount().getReceivableAccountTotal() - Double.valueOf(this.paymentValueTextField.getText());
                
                System.out.println("Actualizado correctamente: " + newValue);
                
                //chargeReceivableAccountData();                
                this.receivableAccountService.getReceivableAccount().setReceivableAccountTotal(newValue);
                
                if(this.receivableAccountService.updateReceivableAccount()){
                    System.out.println("Actualizado correctamente");
                    this.totalUpdate();
                    //Para agregar un asiento contable
                    this.chargeAccountingEntry("Abono a la cuenta de : " + this.personService.getPerson().toString(), Double.valueOf(this.paymentValueTextField.getText()));
                    if(this.accountingEntryService.saveAccountingEntry()){
                        System.out.println("Asiento guardado correctamente");
                    }
                }
            }
        }
        this.paymentPanel.setVisible(false);
        
    }//GEN-LAST:event_savePaymentButtonActionPerformed

    //Para cargar los clientes en el combobox
    private void chargePersonCombo() {

        searchNameText = (JTextField) searchCustomerComboBox.getComponent(2);
        searchNameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == 27) {
                    searchCustomerComboBox.setPopupVisible(false);
                    return;
                }
                if (evt.getKeyCode() == 10) {
                    if (searchCustomerComboBox.getSelectedIndex() != - 1) {
                        PersonComboBoxModel pcm = (PersonComboBoxModel) searchCustomerComboBox.getModel();
                        personService.setInstance(pcm.getSelectedItem());
                        chargeAccountRecordsInTable();
                    }
                    searchCustomerComboBox.setPopupVisible(false);
                    return;
                }

                if (evt.getKeyCode() == 40 || evt.getKeyCode() == 39 || evt.getKeyCode() == 38 || evt.getKeyCode() == 37
                        || evt.getKeyCode() == 36 || evt.getKeyCode() == 16 || evt.getKeyCode() == 35) {
                    return;
                }

                int position = searchNameText.getCaretPosition();
                String s = searchNameText.getText();
                searchCustomerComboBox.setModel(new PersonComboBoxModel(personService.getPersonsByCriteriaType(searchNameText.getText())));
                searchNameText.setText(s);

                searchNameText.setCaretPosition(position);
                searchCustomerComboBox.setPopupVisible(true);
            }
        });
    }
    
    private void chargeAccountRecordsInTable(){
        this.receivableAccountService.setInstance(this.receivableAccountService.getReceivableAccountByPerson(this.personService.getPerson()));
        this.accountRecordService.setAccountRecordList(this.receivableAccountService.getReceivableAccount().getAccountRecordList());
        accountRecordTableModel.setList(this.accountRecordService.getAccountRecordList());
        accountRecordTable.setModel(this.accountRecordTableModel);
        this.accountRecordTable.updateUI();
        
        this.totalUpdate();
        
    }
    
    private void chargeAccountingEntry(String description, Double value){
        accountingEntryService.getAccountingEntry().setAeType(0);
        accountingEntryService.getAccountingEntry().setAeCreatedDate(new Date());
        accountingEntryService.getAccountingEntry().setAeDescription(description);
        accountingEntryService.getAccountingEntry().setAeValue(value);
    }
    
    private void totalUpdate(){
        Double total = 0.00;
        
        for (int i = 0; i < this.accountRecordService.getAccountRecordList().size(); i++) {
            total += this.accountRecordService.getAccountRecordList().get(i).getAccountRecordValue();
        }
        
        this.paymentsLabel.setText(String.valueOf(total));
        this.receivableAccountBalanceLabel.setText(String.valueOf(this.receivableAccountService.getReceivableAccount().getReceivableAccountTotal()));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accountRecordTable;
    private javax.swing.JButton addPaymentButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JTextField paymentValueTextField;
    private javax.swing.JLabel paymentsLabel;
    private javax.swing.JLabel receivableAccountBalanceLabel;
    private javax.swing.JButton savePaymentButton;
    private javax.swing.JComboBox<String> searchCustomerComboBox;
    // End of variables declaration//GEN-END:variables
}
