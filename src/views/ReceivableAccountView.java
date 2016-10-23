package views;

import controller.service.AccountRecordService;
import controller.service.AccountingEntryService;
import controller.service.InvoiceService;
import controller.service.PersonService;
import controller.service.ReceivableAccountService;
import controller.service.WorkOrderService;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import views.tableModel.AccountRecordTableModel;
import views.tableModel.PersonComboBoxModel;

public class ReceivableAccountView extends javax.swing.JDialog {

    private JTextField searchNameText;
    private final PersonService personService;
    private final ReceivableAccountService receivableAccountService;
    private final AccountRecordService accountRecordService;
    private final AccountRecordTableModel accountRecordTableModel;
    private final AccountingEntryService accountingEntryService;
    private final WorkOrderService workOrderService;
    private final InvoiceService invoiceService;
    private Integer receivableAccountPaymentType;

    public ReceivableAccountView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.personService = new PersonService();
        this.receivableAccountService = new ReceivableAccountService();
        this.accountRecordService = new AccountRecordService();
        this.accountRecordTableModel = new AccountRecordTableModel();
        this.accountingEntryService = new AccountingEntryService();
        this.workOrderService = new WorkOrderService();
        this.invoiceService = new InvoiceService();
        initComponents();
        paymentPanel.setVisible(false);
        chargePersonCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        receivableAccountButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accountRecordTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        balanceTitleLabel = new javax.swing.JLabel();
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
        advanceCheckBox = new javax.swing.JRadioButton();
        loanCheckBox = new javax.swing.JRadioButton();
        newReceivableAccountButton = new javax.swing.JButton();
        deletePaymentButton = new javax.swing.JButton();
        searchCustomerComboBox = new javax.swing.JComboBox<>();
        newCustomer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        balanceTitleLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        balanceTitleLabel.setText("SALDO:");

        receivableAccountBalanceLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        receivableAccountBalanceLabel.setForeground(new java.awt.Color(255, 51, 0));
        receivableAccountBalanceLabel.setText("0.00");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
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
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(balanceTitleLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(paymentsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(receivableAccountBalanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(paymentsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceTitleLabel)
                    .addComponent(receivableAccountBalanceLabel))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel1.setText("Buscar");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        addPaymentButton.setText("AGREGAR PAGO");
        addPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPaymentButtonActionPerformed(evt);
            }
        });

        paymentPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Valor:");

        savePaymentButton.setText("Guardar");
        savePaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePaymentButtonActionPerformed(evt);
            }
        });

        advanceCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        receivableAccountButtonGroup.add(advanceCheckBox);
        advanceCheckBox.setSelected(true);
        advanceCheckBox.setText("Abono");

        loanCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        receivableAccountButtonGroup.add(loanCheckBox);
        loanCheckBox.setText("Préstamo");

        javax.swing.GroupLayout paymentPanelLayout = new javax.swing.GroupLayout(paymentPanel);
        paymentPanel.setLayout(paymentPanelLayout);
        paymentPanelLayout.setHorizontalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(savePaymentButton)
                        .addContainerGap())
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(advanceCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(loanCheckBox)
                        .addGap(20, 20, 20))))
        );
        paymentPanelLayout.setVerticalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(advanceCheckBox)
                    .addComponent(loanCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(paymentValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(savePaymentButton))
                .addContainerGap())
        );

        newReceivableAccountButton.setText("CUENTA INICIAL");
        newReceivableAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newReceivableAccountButtonActionPerformed(evt);
            }
        });

        deletePaymentButton.setText("ELIMINAR");
        deletePaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePaymentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addPaymentButton)
                    .addComponent(newReceivableAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deletePaymentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(paymentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(paymentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(newReceivableAccountButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addPaymentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletePaymentButton))))
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

        newCustomer.setText("NUEVO CLIENTE");
        newCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCustomerActionPerformed(evt);
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
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchCustomerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchCustomerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, Short.MAX_VALUE)
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
                if (this.receivableAccountService.getReceivableAccountByPerson(this.personService.getPerson()).getReceivableAccountId() == null) {
                    this.addPaymentButton.setEnabled(false);
                } else {
                    this.chargeAccountRecordsInTable();
                    this.totalReceivableAccountCalculate();
                    this.addPaymentButton.setEnabled(true);
                }

            }
        }
    }//GEN-LAST:event_searchCustomerComboBoxPopupMenuWillBecomeInvisible

    private void addPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPaymentButtonActionPerformed
        // TODO add your handling code here:
        paymentValueTextField.setText("");
        paymentPanel.setVisible(true);
    }//GEN-LAST:event_addPaymentButtonActionPerformed

    //Para calcular el total de la cuenta por pagar del cliente de acuerdo a las facturas y las ordene de trabajo
    private void totalReceivableAccountCalculate() {
        Double total = 0.00;
        for (int i = 0; i < this.workOrderService.getWorkOrderByCustomerCountState(this.personService.getPerson(), this.receivableAccountService.getReceivableAccount().getReceivableAccountCount()).size(); i++) {
            total += this.workOrderService.getWorkOrderByCustomerCountState(this.personService.getPerson(), this.receivableAccountService.getReceivableAccount().getReceivableAccountCount()).get(i).getWorkOrderBalance();
        }
        System.out.println("Este es el total de las ordenes de trabajo " + total);
        System.out.println("Este es el valor del conteo de la base de datos " + this.receivableAccountService.getReceivableAccount().getReceivableAccountCount());
        Double invoicesTotal = 0.00;
        for (int i = 0; i < this.invoiceService.listInvoiceByPersonStateCount(this.personService.getPerson(), this.receivableAccountService.getReceivableAccount().getReceivableAccountCount()).size(); i++) {
            invoicesTotal += this.invoiceService.listInvoiceByPersonStateCount(this.personService.getPerson(), this.receivableAccountService.getReceivableAccount().getReceivableAccountCount()).get(i).getInTotal();
        }
        Double recordTotal = 0.00;
        Double recordTotales = 0.00;
        Double customerLoan = 0.00;
        //Aqui cargamos el total de todas los pagos de una cuenta de acuerdo a la persona
        for (int i = 0; i < this.receivableAccountService.getReceivableAccount().getAccountRecordList().size(); i++) {
            recordTotal += this.receivableAccountService.getReceivableAccount().getAccountRecordList().get(i).getAccountRecordValue();
        }

        for (int i = 0; i < this.accountRecordService.getAccountRecordListByReceivableAccountIdAndCount(this.receivableAccountService.getReceivableAccount()).size(); i++) {
            if(this.accountRecordService.getAccountRecordListByReceivableAccountIdAndCount(this.receivableAccountService.getReceivableAccount()).get(i).getAccountRecordType() == 0){
                recordTotales += this.accountRecordService.getAccountRecordListByReceivableAccountIdAndCount(this.receivableAccountService.getReceivableAccount()).get(i).getAccountRecordValue();
            }else{
                customerLoan += this.accountRecordService.getAccountRecordListByReceivableAccountIdAndCount(this.receivableAccountService.getReceivableAccount()).get(i).getAccountRecordValue();
            }
        }
        System.out.println("Este es el total de pagos hechos " + recordTotales);
        System.out.println("Este es el total de los pagos " + recordTotal);
        System.out.println("Este es el total de las facturas pendientes " + invoicesTotal);
        System.out.println("Este es el total prestamos del cliente " + customerLoan);

        System.out.println("El total de la cuenta por pagar es: " + ((total + invoicesTotal + customerLoan) - recordTotales));

        this.receivableAccountBalanceLabel.setText("" + ((total + invoicesTotal + customerLoan) - recordTotales));
    }

    private void chargeAccountRecordData() {
        if (advanceCheckBox.isSelected()) {
            this.accountRecordService.getAccountRecord().setAccountRecordType(0);
            this.accountRecordService.getAccountRecord().setAccountRecordDescription("Pago a la cuenta");
        } else {
            this.accountRecordService.getAccountRecord().setAccountRecordType(1);
            this.accountRecordService.getAccountRecord().setAccountRecordDescription("Préstamo al cliente");
        }
        //Obtenemos el contador de la cuenta por pagar y le asignamos al pago realizado
        this.accountRecordService.getAccountRecord().setAccountRecordCount(this.receivableAccountService.getReceivableAccount().getReceivableAccountCount());
        this.accountRecordService.getAccountRecord().setAccountRecordDate(new Date());

        this.accountRecordService.getAccountRecord().setAccountRecordValue(Double.parseDouble(this.paymentValueTextField.getText()));
        this.accountRecordService.getAccountRecord().setReceivableAccount(this.receivableAccountService.getReceivableAccount());
    }

    private void savePaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePaymentButtonActionPerformed
        // TODO add your handling code here:
        if (this.accountRecordService.getAccountRecord().getAccountRecordId() == null) {
            this.chargeAccountRecordData();
            if (this.accountRecordService.saveAccountRecord()) {
                JOptionPane.showMessageDialog(null, "Pago agregado correctamente");
                
                //Agregamos el pago a la lista y la mostramos en la tabla
                this.accountRecordService.addAccountRecord(this.accountRecordService.getAccountRecord());
                
                //Actualizamos la vista de la tabla
                this.accountRecordTable.updateUI();
                
                //Actualizamos el total cada vez que agregamos un pago a la cuenta
                this.totalReceivableAccountCalculate();      
               
                //Cargamos los nuevos valores de la cuenta por pagar               
                this.receivableAccountService.getReceivableAccount().setReceivableAccountTotal(Double.valueOf(this.receivableAccountBalanceLabel.getText()));
                this.receivableAccountService.getReceivableAccount().setReceivableAccountUpdateDate(new Date());
                if (this.receivableAccountBalanceLabel.getText().equals("0.0")) {
                    System.out.println("Aqui entro cuando el valor esta en cero:");
                    this.receivableAccountService.getReceivableAccount().setReceivableAccountCount(this.receivableAccountService.getReceivableAccount().getReceivableAccountCount() + 1);
                }
                //Actualizamos la cuenta por pagar
                if (this.receivableAccountService.updateReceivableAccount()) {
                    System.out.println("Actualizado correctamente");
                    //Actualizamos el total de la cuenta por cobrar en la vista
                    this.totalUpdate();
                    //Comprobamos que opcion esta seleccionada para poder crear el nuevo asiento contable ya sea para ingreso o egreso
                    String accountingEntryText = "";
                    if(this.loanCheckBox.isSelected()){
                        this.receivableAccountPaymentType = 1;
                        accountingEntryText = "Préstamo al cliente: ";
                    }else if(this.advanceCheckBox.isSelected()){
                        this.receivableAccountPaymentType = 0;
                        accountingEntryText = "Abono a la cuenta de: ";
                    }
                    //Creamos una nueva instancia del asiento contable
                    this.accountingEntryService.newInstance();
                    //Para agregar un asiento contable
                    this.chargeAccountingEntry(accountingEntryText + this.personService.getPerson().toString(), Double.valueOf(this.paymentValueTextField.getText()), this.receivableAccountPaymentType);
                    if (this.accountingEntryService.saveAccountingEntry()) {
                        System.out.println("Asiento guardado correctamente");
                    }
                }

            }
        }
        this.paymentPanel.setVisible(false);
    }//GEN-LAST:event_savePaymentButtonActionPerformed

    //Probando
    private void updateAccountRecordTable() {
        this.accountRecordTableModel.setList(this.accountRecordService.getAccountRecordList());
        this.accountRecordTable.setModel(this.accountRecordTableModel);
        this.accountRecordTable.updateUI();
    }

    private void newReceivableAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newReceivableAccountButtonActionPerformed
        // TODO add your handling code here:
        if (this.personService.getPerson().getPersonId() == null) {
            JOptionPane.showMessageDialog(this, "El cliente no existe");
        } else if (this.receivableAccountService.getReceivableAccountByPerson(this.personService.getPerson()).getReceivableAccountId() == null) {
            this.chargeReceivableAccountData();
            if (this.receivableAccountService.saveReceivableAccount()) {
                JOptionPane.showMessageDialog(null, "Cuenta creada correctamente");
                this.chargeAccountRecordsInTable();
                this.addPaymentButton.setEnabled(true);
            }

        } else {
            this.addPaymentButton.setEnabled(true);
            JOptionPane.showMessageDialog(this, "El empleado ya tiene una cuenta");
            System.out.println("" + this.receivableAccountService.getReceivableAccountByPerson(this.personService.getPerson()));
        }
    }//GEN-LAST:event_newReceivableAccountButtonActionPerformed

    private void chargeReceivableAccountData() {
        this.receivableAccountService.getReceivableAccount().setReceivableAccountDate(new Date());
        this.receivableAccountService.getReceivableAccount().setReceivableAccountUpdateDate(null);
        this.receivableAccountService.getReceivableAccount().setReceivableAccountTotal(0.00);
        this.receivableAccountService.getReceivableAccount().setReceivableAccountCount(1);

        this.receivableAccountService.getReceivableAccount().setPerson(this.personService.getPerson());
    }

    private void newCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCustomerActionPerformed
        // TODO add your handling code here:
        searchNameText.setText("");
        paymentsLabel.setText("0.00");
        balanceTitleLabel.setText("0.00");
        accountRecordTable.setModel(new DefaultTableModel());
        accountRecordTable.updateUI();
        new PersonView(null, true, 1).setVisible(true);
    }//GEN-LAST:event_newCustomerActionPerformed

    private void deletePaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePaymentButtonActionPerformed
        // TODO add your handling code here:

        if (accountRecordTable.getSelectedRowCount() == 1) {
            this.accountRecordService.setInstance(this.accountRecordTableModel.getList().get(this.accountRecordTable.getSelectedRow()));
            this.accountRecordTableModel.getList().remove(this.accountRecordTable.getSelectedRow());
            this.accountRecordTable.updateUI();

            if (this.accountRecordService.getAccountRecord().getAccountRecordId() != null) {
                if (this.accountRecordService.removeAccountRecord()) {
                    System.out.println("El detalle ha sido eliminado correctamente");
                    //Creamos el asiento contable como egreso para equilibrar la cuenta
                    this.chargeAccountingEntry("Se eliminio pago de : " + this.personService.getPerson().toString(), this.accountRecordService.getAccountRecord().getAccountRecordValue(), 1);
                    if (this.accountingEntryService.saveAccountingEntry()) {
                        System.out.println("Asiento guardado correctamente");
                    }
                }
            } else {
                System.out.println("No esta entrando en nada");
            }
            //Actualizamos el total de pagos
            this.totalReceivableAccountCalculate();
            this.totalUpdate();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un item para eliminar");
        }

    }//GEN-LAST:event_deletePaymentButtonActionPerformed

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

    private void chargeAccountRecordsInTable() {
        this.receivableAccountService.setInstance(this.receivableAccountService.getReceivableAccountByPerson(this.personService.getPerson()));
        this.accountRecordService.setAccountRecordList(this.accountRecordService.getAccountRecordListByReceivableAccountIdAndCount(this.receivableAccountService.getReceivableAccount()));//this.receivableAccountService.getReceivableAccount().getAccountRecordList());
        accountRecordTableModel.setList(this.accountRecordService.getAccountRecordList());
        accountRecordTable.setModel(this.accountRecordTableModel);
        this.accountRecordTable.updateUI();

        this.totalUpdate();

    }

    private void chargeAccountingEntry(String description, Double value, Integer type) {
        accountingEntryService.getAccountingEntry().setAeType(type);
        accountingEntryService.getAccountingEntry().setAeCreatedDate(new Date());
        accountingEntryService.getAccountingEntry().setAeDescription(description);
        accountingEntryService.getAccountingEntry().setAeValue(value);
    }

    private void totalUpdate() {
        Double total = 0.00;

        for (int i = 0; i < this.accountRecordService.getAccountRecordList().size(); i++) {
            if (this.accountRecordService.getAccountRecordList().get(i).getAccountRecordType() == 0) {
                total += this.accountRecordService.getAccountRecordList().get(i).getAccountRecordValue();
            }
        }
        this.paymentsLabel.setText(String.valueOf(total));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accountRecordTable;
    private javax.swing.JButton addPaymentButton;
    private javax.swing.JRadioButton advanceCheckBox;
    private javax.swing.JLabel balanceTitleLabel;
    private javax.swing.JButton deletePaymentButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton loanCheckBox;
    private javax.swing.JButton newCustomer;
    private javax.swing.JButton newReceivableAccountButton;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JTextField paymentValueTextField;
    private javax.swing.JLabel paymentsLabel;
    private javax.swing.JLabel receivableAccountBalanceLabel;
    private javax.swing.ButtonGroup receivableAccountButtonGroup;
    private javax.swing.JButton savePaymentButton;
    private javax.swing.JComboBox<String> searchCustomerComboBox;
    // End of variables declaration//GEN-END:variables
}
