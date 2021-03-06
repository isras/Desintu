package views;

import controller.resources.ValidateEmptyFields;
import controller.service.PersonService;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class PersonView extends javax.swing.JDialog {

    private final int personOption;
    private final PersonService psr;

    public PersonView(java.awt.Frame parent, boolean modal, int ind) {
        super(parent, modal);
        this.psr = new PersonService();
        this.personOption = ind;
        initComponents();
        this.dialogControl();
//        this.getRootPane().setOpaque(false);
//        this.getContentPane().setBackground(new Color(0, 0, 0, 0));
//        this.setBackground(new Color(0, 0, 0, 0));
        //this.setLocationRelativeTo(null);
    }

    public PersonView(java.awt.Frame parent, boolean modal, int ind, PersonService psr) {
        super(parent, modal);
        this.personOption = ind;
        this.psr = psr;
        initComponents();
        this.dialogControl();
//        this.getRootPane().setOpaque(false);
//        this.getContentPane().setBackground(new Color(0, 0, 0, 0));
//        this.setBackground(new Color(0, 0, 0, 0));
        //this.setLocationRelativeTo(null);

    }

    private void dialogControl() {
        if (this.personOption == 1) {//Indicador uno cuando son nuevos clientes
            this.setTitle("NUEVO CLIENTE");
            this.psr.newInstance();//Creamos una nueva instancia de nuestro objeto persona
        }
        if (this.personOption == 2) {//Indicador dos para modificar un cliente
            this.setTitle("EDITAR CLIENTE");
            this.personChargeView();//Cargamos el objeto persona en la vista
            personSaveBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/editButton.png")));
            personSaveBt.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/editButtonHover.png")));
        }
        if (this.personOption == 3) {//Indicador tres para desactivar un cliente
            this.setTitle("ELIMINAR CLIENTE");
            personFirstNameTxtf.setEnabled(false);
            personLastNameTxtf.setEnabled(false);
            personIdentificationFtxtf.setEnabled(false);
            personPhoneFtxtf.setEnabled(false);
            personAddress.setEnabled(false);
            personEmail.setEnabled(false);
            personTypeCb.setEnabled(false);

            this.personChargeView();//Cargamos el objeto persona en la vista

            personSaveBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/deleteButton.png")));
            personSaveBt.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/deleteButtonHover.png")));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        personSaveBt = new javax.swing.JButton();
        personCancelBt = new javax.swing.JButton();
        personIdentificationFtxtf = new javax.swing.JFormattedTextField();
        personAddress = new javax.swing.JTextField();
        personPhoneFtxtf = new javax.swing.JFormattedTextField();
        personEmail = new javax.swing.JTextField();
        personLastNameTxtf = new javax.swing.JTextField();
        personFirstNameTxtf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        personTypeCb = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setPreferredSize(new java.awt.Dimension(524, 303));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(484, 186));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(244, 151, 25));
        jLabel1.setText("NOMBRES:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(244, 151, 25));
        jLabel2.setText("APELLIDOS:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(244, 151, 25));
        jLabel3.setText("CÉDULA o RUC:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(244, 151, 25));
        jLabel4.setText("DIRECCIÓN:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(244, 151, 25));
        jLabel5.setText("TELÉFONO:");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(244, 151, 25));
        jLabel7.setText("EMAIL:");

        personSaveBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/saveButton.png"))); // NOI18N
        personSaveBt.setToolTipText("");
        personSaveBt.setBorderPainted(false);
        personSaveBt.setContentAreaFilled(false);
        personSaveBt.setName("GUARDAR"); // NOI18N
        personSaveBt.setPreferredSize(new java.awt.Dimension(114, 47));
        personSaveBt.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/saveButtonHover.png"))); // NOI18N
        personSaveBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personSaveBtActionPerformed(evt);
            }
        });

        personCancelBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/cancelButtonGeneral.png"))); // NOI18N
        personCancelBt.setBorderPainted(false);
        personCancelBt.setContentAreaFilled(false);
        personCancelBt.setPreferredSize(new java.awt.Dimension(114, 47));
        personCancelBt.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/cancelButtonGeneralHover.png"))); // NOI18N
        personCancelBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personCancelBtActionPerformed(evt);
            }
        });

        personIdentificationFtxtf.setForeground(new java.awt.Color(51, 51, 51));
        personIdentificationFtxtf.setPreferredSize(new java.awt.Dimension(247, 22));
        personIdentificationFtxtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                personIdentificationFtxtfKeyTyped(evt);
            }
        });

        personAddress.setForeground(new java.awt.Color(51, 51, 51));
        personAddress.setPreferredSize(new java.awt.Dimension(247, 22));

        personPhoneFtxtf.setForeground(new java.awt.Color(51, 51, 51));
        personPhoneFtxtf.setPreferredSize(new java.awt.Dimension(247, 22));
        personPhoneFtxtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personPhoneFtxtfActionPerformed(evt);
            }
        });

        personEmail.setForeground(new java.awt.Color(51, 51, 51));
        personEmail.setPreferredSize(new java.awt.Dimension(247, 22));

        personLastNameTxtf.setForeground(new java.awt.Color(51, 51, 51));
        personLastNameTxtf.setPreferredSize(new java.awt.Dimension(247, 22));
        personLastNameTxtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                personLastNameTxtfKeyTyped(evt);
            }
        });

        personFirstNameTxtf.setPreferredSize(new java.awt.Dimension(247, 22));
        personFirstNameTxtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personFirstNameTxtfActionPerformed(evt);
            }
        });
        personFirstNameTxtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                personFirstNameTxtfKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(244, 151, 25));
        jLabel6.setText("TIPO:");

        personTypeCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Cliente", "Publicista", "Proveedor" }));
        personTypeCb.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                personTypeCbPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(personIdentificationFtxtf, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(personAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(personPhoneFtxtf, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(personEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(personLastNameTxtf, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(personFirstNameTxtf, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(personTypeCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(personSaveBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(personCancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)))
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(personFirstNameTxtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(personLastNameTxtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(personIdentificationFtxtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(personAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(personPhoneFtxtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(personTypeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(personCancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personSaveBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void personPhoneFtxtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personPhoneFtxtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personPhoneFtxtfActionPerformed
    //Método para cargar los datos de una persona en la vista

    private void personChargeView() {
        if (this.psr.getPerson().getPrType() != null) {
            personTypeCb.setSelectedItem(this.psr.getPerson().getPrType());

        }
        personFirstNameTxtf.setText(this.psr.getPerson().getPrFirstName());
        personLastNameTxtf.setText(this.psr.getPerson().getPrLastName());
        personIdentificationFtxtf.setText(this.psr.getPerson().getPrIdentification());
        personPhoneFtxtf.setText(this.psr.getPerson().getPrPhone());
        personAddress.setText(this.psr.getPerson().getPrAddress());
        personEmail.setText(this.psr.getPerson().getPrEmail());
    }

    //Método para crear un objeto de una person, sirve tanto para una nueva persona como para editar
    private void personCharge() {
        this.psr.getPerson().setPrType(this.personTypeCb.getSelectedItem().toString());
        this.psr.getPerson().setPrFirstName(this.personFirstNameTxtf.getText());
        this.psr.getPerson().setPrLastName(this.personLastNameTxtf.getText());
        this.psr.getPerson().setPrIdentification(this.personIdentificationFtxtf.getText());
        this.psr.getPerson().setPrPhone(this.personPhoneFtxtf.getText());
        this.psr.getPerson().setPrAddress(this.personAddress.getText());
        this.psr.getPerson().setPrEmail(this.personEmail.getText());
    }

    //Método para limpiar los campos de la vista cuando se completa una operación
    private void cleanFields() {
        personFirstNameTxtf.setText("");
        personLastNameTxtf.setText("");
        personIdentificationFtxtf.setText("");
        personPhoneFtxtf.setText("");
        personAddress.setText("");
        personEmail.setText("");
        personTypeCb.setSelectedItem("Seleccione...");
        this.psr.newInstance();
    }

    //Método encargado de cerrar todos los procesos de un JDialog
    private void closeWindow() {
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void personSaveBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personSaveBtActionPerformed
        // TODO add your handling code here:
        if (ValidateEmptyFields.requerido(personFirstNameTxtf, personFirstNameTxtf.getText())
                && ValidateEmptyFields.requerido(personLastNameTxtf, personLastNameTxtf.getText())
                && ValidateEmptyFields.requerido(personIdentificationFtxtf, personIdentificationFtxtf.getText())
                && ValidateEmptyFields.requerido(personAddress, personAddress.getText())) {
            switch (personOption) {
                case 1:
                    this.personCharge();//Cargamos el objeto persona
                    if (this.psr.personExists(personIdentificationFtxtf.getText()) == false) {
                        if (this.psr.savePerson()) {//Guardamos el objeto persona
                            JOptionPane.showMessageDialog(this, "El cliente ha sido guardado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(this, "Hubo un error al guardar el cliente");
                        }
                        this.cleanFields();//Limpiamos los campos
                    } else {
                        JOptionPane.showMessageDialog(this, "El cliente ya se encuentra registrado");
                    }
                    break;
                case 2:
                    this.personCharge();
                    if (this.psr.updatePerson()) {
                        JOptionPane.showMessageDialog(this, "El cliente ha sido modificado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(this, "Hubo un error al modificar el cliente");
                    }
                    this.closeWindow();
                    break;
                case 3:
                    //uccclient.saveClient(ci, 3, clientFirstNameTxtf, clientLastNameTxtf, clientAddress, clientEmail, clientTelephoneFtxtf, clientIdentificationFtxtf);
                    this.closeWindow();
                    break;
                default:
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Existen campos vacios");
        }
    }//GEN-LAST:event_personSaveBtActionPerformed

    private void personCancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personCancelBtActionPerformed
        this.closeWindow();
    }//GEN-LAST:event_personCancelBtActionPerformed

    private void personFirstNameTxtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personFirstNameTxtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personFirstNameTxtfActionPerformed

    private void personIdentificationFtxtfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_personIdentificationFtxtfKeyTyped
        // TODO add your handling code here:
        ValidateEmptyFields.validarNumeor(evt);
    }//GEN-LAST:event_personIdentificationFtxtfKeyTyped

    private void personFirstNameTxtfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_personFirstNameTxtfKeyTyped
        // TODO add your handling code here:
        ValidateEmptyFields.validarLetras(evt);
    }//GEN-LAST:event_personFirstNameTxtfKeyTyped

    private void personLastNameTxtfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_personLastNameTxtfKeyTyped
        // TODO add your handling code here:
        ValidateEmptyFields.validarLetras(evt);
    }//GEN-LAST:event_personLastNameTxtfKeyTyped

    private void personTypeCbPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_personTypeCbPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_personTypeCbPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField personAddress;
    private javax.swing.JButton personCancelBt;
    private javax.swing.JTextField personEmail;
    private javax.swing.JTextField personFirstNameTxtf;
    private javax.swing.JFormattedTextField personIdentificationFtxtf;
    private javax.swing.JTextField personLastNameTxtf;
    private javax.swing.JFormattedTextField personPhoneFtxtf;
    private javax.swing.JButton personSaveBt;
    private javax.swing.JComboBox<String> personTypeCb;
    // End of variables declaration//GEN-END:variables
}