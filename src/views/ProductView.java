package views;

import controller.service.ProductService;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ProductView extends javax.swing.JDialog {

    private final int productOption;
    private final ProductService ps;

    public ProductView(java.awt.Frame parent, boolean modal, int productOption) {
        super(parent, modal);
        this.productOption = productOption;
        this.ps = new ProductService();
        initComponents();
        barCodeJtf.setVisible(false);
        productReaderBt.setVisible(false);

//        this.getRootPane().setOpaque(false);
//        this.getContentPane().setBackground(new Color(0, 0, 0, 0));
//        this.setBackground(new Color(0, 0, 0, 0));
    }

    public ProductView(java.awt.Frame parent, boolean modal, int productOption, ProductService ps) {
        super(parent, modal);
        this.productOption = productOption;
        this.ps = ps;
        initComponents();
        barCodeJtf.setVisible(false);
        productReaderBt.setVisible(false);

//        this.getRootPane().setOpaque(false);
//        this.getContentPane().setBackground(new Color(0, 0, 0, 0));
//        this.setBackground(new Color(0, 0, 0, 0));
        switch (this.productOption) {
            case 1:
                this.setTitle("NUEVO PRODUCTO");
                this.ps.newInstance();
                break;
            case 2:
                this.setTitle("EDITAR PRODUCTO");
                this.chargeProductView();
                this.saveProductBt.setName("EDITAR");
                this.saveProductBt.setIcon(new ImageIcon(getClass().getResource("/images/buttons/editButton.png")));
                this.saveProductBt.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/editButtonHover.png")));
                break;
            case 3:
                this.disableProductFields();
                this.chargeProductView();
                this.saveProductBt.setName("ELIMINAR");
                this.setTitle("ELIMINAR PRODUCTO");
                this.saveProductBt.setIcon(new ImageIcon(getClass().getResource("/images/buttons/deleteButton.png")));
                this.saveProductBt.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/deleteButtonHover.png")));
                break;
            default:
                break;
        }
    }
    
    private void clearProductFields(){
        this.productNameTxt.setText("");
        this.productCodeTxt.setText("");
        this.barCodeChekB.setSelected(false);
        this.barCodeChekB.setSelected(false);
        this.productDescriptionTxt.setText("");
        this.productPvpTxt.setText("0.00");
        this.productStockSp.setValue(1);
        //this.productIVAChB.setSelected(false);
        this.productTypeCb.setSelectedItem("Seleccione...");
        this.ps.newInstance();
    }

    private void disableProductFields() {
        this.productNameTxt.setEditable(false);
        this.productCodeTxt.setEditable(false);
        this.barCodeChekB.setEnabled(false);
        this.barCodeChekB.setEnabled(false);
        this.productReaderBt.setEnabled(false);
        this.productDescriptionTxt.setEditable(false);
        this.productPvpTxt.setEditable(false);
        this.productStockSp.setEnabled(false);
        //this.productIVAChB.setEnabled(false);
        this.productTypeCb.setEnabled(false);
    }

    private void chargeProductView() {
        this.productNameTxt.setText(this.ps.getProduct().getPdName());
        this.productCodeTxt.setText(this.ps.getProduct().getPdCode());
        if (this.ps.getProduct().getPdBarcode().equals("scb")) {
            this.barCodeChekB.setSelected(false);
        } else {
            this.barCodeChekB.setSelected(true);
            this.barCodeJtf.setText(this.ps.getProduct().getPdCode());
            this.barCodeJtf.setVisible(true);
            this.productReaderBt.setVisible(true);
        }
        this.productDescriptionTxt.setText(this.ps.getProduct().getPdDescription());
        this.productPvpTxt.setText("" + this.ps.getProduct().getPdSalePrice());
        this.productStockSp.setValue(this.ps.getProduct().getPdStock());
        
        //En este bloque de código cargamos el tipo de producto en el combobox
        switch (this.ps.getProduct().getPdType()) {
            case "mp":
                this.productTypeCb.setSelectedItem("Material Puro");
                break;
            case "mi":
                this.productTypeCb.setSelectedItem("Material Impreso");
                break;
            case "s":
                this.productTypeCb.setSelectedItem("Servicio");
                break;
            case "t":
                this.productTypeCb.setSelectedItem("Terminado");
                break;
            case "a":
                this.productTypeCb.setSelectedItem("Articulo");
                break;
            case "cl":
                this.productTypeCb.setSelectedItem("Corte Láser");
                break;
            default:
                break;
        }

//        if (this.ps.getProduct().getPdIvaState() == 1) {
//            this.productIVAChB.setSelected(true);
//        } else {
//            this.productIVAChB.setSelected(false);
//        }
    }

    //Método para crear un objeto producto
    private void chargeProduct() {
        this.ps.getProduct().setPdName(this.productNameTxt.getText());
        
        //Este bloque de código controla si el producto tiene código de barras
        if (this.barCodeChekB.isSelected()) {
            this.ps.getProduct().setPdBarcode(this.barCodeJtf.getText());
        } else {
            this.ps.getProduct().setPdCode(this.productCodeTxt.getText());
            this.ps.getProduct().setPdBarcode("scb");
        }
        this.ps.getProduct().setPdSalePrice(Double.parseDouble(this.productPvpTxt.getText()));
        this.ps.getProduct().setPdStock(Double.parseDouble(String.valueOf(this.productStockSp.getValue())));
        
        //En esta sección de código controlamos el tipo con el que va a ser guardado el producto
        switch(this.productTypeCb.getSelectedItem().toString()){
            case "Material Puro":
                this.ps.getProduct().setPdType("mp");
                break;
            case "Material Impreso":
                this.ps.getProduct().setPdType("mi");
                break;
            case "Servicio":
                this.ps.getProduct().setPdType("s");
                break;
            case "Terminado":
                this.ps.getProduct().setPdType("t");
                break;
            case "Articulo":
                this.ps.getProduct().setPdType("a");
                break;
            case "Corte Láser":
                this.ps.getProduct().setPdType("cl");
            default:
                break;
        }
        
        //Controlamos si la opción del iva esta seleccionada para guardar el producto con iva 12 o iva 0
        //if (this.productIVAChB.isSelected()) {
          //  this.ps.getProduct().setPdIvaState(1);
        //} else {
            this.ps.getProduct().setPdIvaState(0);
        //}
        this.ps.getProduct().setPdDescription(this.productDescriptionTxt.getText());
    }
    
    private void closeWindow(){
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        backgroundPanel = new javax.swing.JPanel();
        contentPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productDescriptionTxt = new javax.swing.JTextArea();
        productCodeTxt = new javax.swing.JTextField();
        productNameTxt = new javax.swing.JTextField();
        cancelProductTxt = new javax.swing.JButton();
        saveProductBt = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        barCodeJtf = new javax.swing.JTextField();
        productReaderBt = new javax.swing.JButton();
        productPvpTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        productStockSp = new javax.swing.JSpinner();
        barCodeChekB = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        productTypeCb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRODUCTO");
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(580, 340));

        contentPanel.setOpaque(false);
        contentPanel.setPreferredSize(new java.awt.Dimension(539, 212));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("NOMBRE:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("CÓDIGO:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("DESCRIPCIÓN:");

        productDescriptionTxt.setColumns(20);
        productDescriptionTxt.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        productDescriptionTxt.setRows(5);
        productDescriptionTxt.setPreferredSize(new java.awt.Dimension(257, 84));
        jScrollPane1.setViewportView(productDescriptionTxt);

        productCodeTxt.setPreferredSize(new java.awt.Dimension(256, 22));

        productNameTxt.setPreferredSize(new java.awt.Dimension(256, 22));

        cancelProductTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/cancelButtonGeneral.png"))); // NOI18N
        cancelProductTxt.setBorder(null);
        cancelProductTxt.setBorderPainted(false);
        cancelProductTxt.setContentAreaFilled(false);
        cancelProductTxt.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/cancelButtonGeneralHover.png"))); // NOI18N
        cancelProductTxt.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/cancelButtonGeneralHover.png"))); // NOI18N
        cancelProductTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelProductTxtActionPerformed(evt);
            }
        });

        saveProductBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/saveButton.png"))); // NOI18N
        saveProductBt.setBorder(null);
        saveProductBt.setBorderPainted(false);
        saveProductBt.setContentAreaFilled(false);
        saveProductBt.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/saveButtonHover.png"))); // NOI18N
        saveProductBt.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/saveButtonHover.png"))); // NOI18N
        saveProductBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveProductBtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("CÓDIGO DE BARRAS:");

        barCodeJtf.setEnabled(false);
        barCodeJtf.setPreferredSize(new java.awt.Dimension(147, 22));

        productReaderBt.setText("Lector");
        productReaderBt.setPreferredSize(new java.awt.Dimension(80, 22));
        productReaderBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productReaderBtActionPerformed(evt);
            }
        });

        productPvpTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        productPvpTxt.setText("0.00");
        productPvpTxt.setPreferredSize(new java.awt.Dimension(60, 22));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("CANTIDAD:");

        productStockSp.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        productStockSp.setPreferredSize(new java.awt.Dimension(60, 22));

        barCodeChekB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barCodeChekBActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("PVP:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("TIPO:");

        productTypeCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Material Puro", "Material Impreso", "Servicio", "Terminado", "Articulo", "Corte Láser" }));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(productNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(barCodeChekB)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(barCodeJtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(productReaderBt, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(productCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(saveProductBt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelProductTxt))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(5, 5, 5))
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(6, 6, 6)))
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(productPvpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(productStockSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(productTypeCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(5, 5, 5)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(productCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(barCodeJtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productReaderBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5))
                    .addComponent(barCodeChekB, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productPvpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(productStockSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(13, 13, 13)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(productTypeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveProductBt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelProductTxt, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveProductBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveProductBtActionPerformed
        // TODO add your handling code here:
        switch (this.productOption) {
            case 1:
                this.chargeProduct();
                if(this.ps.saveProduct()){
                    JOptionPane.showMessageDialog(this, "El producto ha sido guardado correctamente");
                }else{
                    JOptionPane.showMessageDialog(this, "Hubo un error al guardar el producto");
                }   this.clearProductFields();
                break;
            case 2:
                this.chargeProduct();
                if(this.ps.updateProduct()){
                    JOptionPane.showMessageDialog(this, "El producto ha sido modificado correctamente");
                }else{
                    JOptionPane.showMessageDialog(this, "Hubo un error al modificar el producto");
                }   this.closeWindow();
                break;
            case 3:
                this.chargeProduct();
                if(this.ps.deleteProduct()){
                JOptionPane.showMessageDialog(this, "El producto se ha eliminado");
                }else{
                    JOptionPane.showMessageDialog(this, "Hubo un error al modificar el producto");
                }   this.closeWindow();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_saveProductBtActionPerformed

    private void cancelProductTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelProductTxtActionPerformed
        // TODO add your handling code here:
        this.closeWindow();
    }//GEN-LAST:event_cancelProductTxtActionPerformed

    private void productReaderBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productReaderBtActionPerformed
        // TODO add your handling code here:
        String s = JOptionPane.showInputDialog(this, "Ingrese el código de barras", "Armoire 2015", JOptionPane.INFORMATION_MESSAGE);

        if (s != null && !s.equals("")) {
            if (s.contains("'")) {
                s = s.replaceAll("'", "-");
            }
            this.barCodeJtf.setText(s);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Sin código de barras", "Armoire 2015", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_productReaderBtActionPerformed

    private void barCodeChekBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barCodeChekBActionPerformed
        // TODO add your handling code here:
       if (this.barCodeChekB.isSelected()) {
            this.barCodeJtf.setVisible(true);
            this.productReaderBt.setVisible(true);
        } else {
            this.barCodeJtf.setVisible(false);
            this.productReaderBt.setVisible(false);
        }

    }//GEN-LAST:event_barCodeChekBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JCheckBox barCodeChekB;
    private javax.swing.JTextField barCodeJtf;
    private javax.swing.JButton cancelProductTxt;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField productCodeTxt;
    private javax.swing.JTextArea productDescriptionTxt;
    private javax.swing.JTextField productNameTxt;
    private javax.swing.JTextField productPvpTxt;
    private javax.swing.JButton productReaderBt;
    private javax.swing.JSpinner productStockSp;
    private javax.swing.JComboBox<String> productTypeCb;
    private javax.swing.JButton saveProductBt;
    // End of variables declaration//GEN-END:variables
}
