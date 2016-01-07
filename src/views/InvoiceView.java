package views;

import controller.resources.GeneralParameter;
import java.awt.Color;
import controller.resources.Operaciones;
import controller.resources.PanelPersonalizado;
import controller.resources.Report;
import controller.resources.ValidateEmptyFields;
import controller.service.AccountingEntryService;
import controller.service.DetailService;
import controller.service.InvoiceService;
import controller.service.PersonService;
import controller.service.PetitionService;
import controller.service.ProductService;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import views.tableModel.DetailTableModel;
import views.tableModel.PersonComboBoxModel;
import views.tableModel.ProductComboBoxModel;

public class InvoiceView extends javax.swing.JDialog {

    private String petitionName;
    double accuracyVal;
    int contAddItem;
    int indicador;

    private final InvoiceService invs;
    private final PersonService pns;
    private final ProductService ps;
    private final DetailService ds;
    private final DetailTableModel dtm;
    private PetitionService pts;
    private final AccountingEntryService aes;
    private Report report;
    private double subtotalIvaTwelve = 0;
    private double subTotalivaZero = 0;
    private double iva = 0;
    private JTextField searchNameText;
    private JTextField searchProductText;

    public InvoiceView(java.awt.Frame parent, boolean modal, int indicador, String petitionName) {
        super(parent, modal);
        this.indicador = indicador;
        this.invs = new InvoiceService();
        this.pns = new PersonService();
        this.ps = new ProductService();
        this.dtm = new DetailTableModel();
        this.ds = new DetailService();
        this.aes = new AccountingEntryService();
        initComponents();
        this.getRootPane().setOpaque(false);
        this.getContentPane().setBackground(new Color(0, 0, 0, 0));
        this.setBackground(new Color(0, 0, 0, 0));

        accuracyVal = Math.pow(10, GeneralParameter.ACCURACY_VALUE);
        contAddItem = 0;
        //this.pts.newInstace();

        this.chargePersonCombo();
        this.chargeProductCombo();

        invoiceFirstNumberTxt.setText(GeneralParameter.FIRST_INVOICE_NUMBER);
        invoiceSecondNumberTxt.setText(GeneralParameter.SECOND_INVOICE_NUMBER);
        if (this.invs.getInvoiceList().isEmpty()) {
            invoiceThirdNumberTxt.setText(GeneralParameter.THIRD_INVOICE_NUMBRE);
        } else {
            invoiceThirdNumberTxt.setText(String.valueOf(Integer.valueOf(this.invs.getLastInvoice()) + 1));
        }
    }

    public void chargePetition(PetitionService pts) {
        this.pts = pts;
        if (this.pts.getPetition().getPetitionId() != null) {
            this.pns.setInstance(this.pts.getPetition().getPerson());
            chargePersonView();
            for (int i = 0; i < this.pts.getPetition().getDetailList().size(); i++) {
                this.ds.newInstance();//Fijamos la nueva instancia de la factura
                this.ds.getDetail().setDetType("invoiceDetail");
                this.ds.getDetail().setDetQuantity(this.pts.getPetition().getDetailList().get(i).getDetQuantity());
                this.ds.getDetail().setDetDescription(this.pts.getPetition().getDetailList().get(i).getDetDescription());
                this.ds.getDetail().setDetSalePrice(this.pts.getPetition().getDetailList().get(i).getDetSalePrice());
                this.ds.getDetail().setDetTotal(this.pts.getPetition().getDetailList().get(i).getDetTotal());
                this.ds.getDetail().setProduct(this.pts.getPetition().getDetailList().get(i).getProduct());
                this.ds.getDetail().setInvoice(this.invs.getInvoice());
                this.ds.addDetailList(this.ds.getDetail());
            }

            this.dtm.setList(this.ds.getDetailList());
            invoiceDetailTable.setModel(dtm);

            this.invoiceDetailTable.getColumnModel().getColumn(1).setPreferredWidth(310);
            this.invoiceDetailTable.getColumnModel().getColumn(2).setCellRenderer(Operaciones.getRenderCellToRigth());
            this.invoiceDetailTable.getColumnModel().getColumn(3).setCellRenderer(Operaciones.getRenderCellToRigth());

            invoiceDetailTable.updateUI();
            this.totalInvoiceCalculate();

            invoiceRemoveItemButton.setEnabled(Boolean.TRUE);
            invoicePaidButton.setEnabled(Boolean.TRUE);
        }
    }

    private void chargeProductCombo() {

        searchProductText = (JTextField) productComboSearch.getComponent(2);
        searchProductText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == 27) {
                    productComboSearch.setPopupVisible(false);
                    return;
                }
                if (evt.getKeyCode() == 10) {
                    if (productComboSearch.getSelectedIndex() != - 1) {
                        ProductComboBoxModel pcm = (ProductComboBoxModel) productComboSearch.getModel();
                        ps.setInstance(pcm.getSelectedItem());
                        chargeProductView();
                    }
                    productComboSearch.setPopupVisible(false);
                    return;
                }

                if (evt.getKeyCode() == 40 || evt.getKeyCode() == 39 || evt.getKeyCode() == 38 || evt.getKeyCode() == 37
                        || evt.getKeyCode() == 36 || evt.getKeyCode() == 16 || evt.getKeyCode() == 35) {
                    return;
                }

                int position = searchProductText.getCaretPosition();
                String s = searchProductText.getText();
                productComboSearch.setModel(new ProductComboBoxModel(ps.getProductsByCriteria(searchProductText.getText())));
                searchProductText.setText(s);

                searchProductText.setCaretPosition(position);
                productComboSearch.setPopupVisible(true);
            }
        });
    }

    private void chargePersonCombo() {

        searchNameText = (JTextField) searchNameComboText.getComponent(2);
        searchNameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == 27) {
                    searchNameComboText.setPopupVisible(false);
                    return;
                }
                if (evt.getKeyCode() == 10) {
                    if (searchNameComboText.getSelectedIndex() != - 1) {
                        PersonComboBoxModel pcm = (PersonComboBoxModel) searchNameComboText.getModel();
                        pns.setInstance(pcm.getSelectedItem());
                        chargePersonView();
                    }
                    searchNameComboText.setPopupVisible(false);
                    return;
                }

                if (evt.getKeyCode() == 40 || evt.getKeyCode() == 39 || evt.getKeyCode() == 38 || evt.getKeyCode() == 37
                        || evt.getKeyCode() == 36 || evt.getKeyCode() == 16 || evt.getKeyCode() == 35) {
                    return;
                }

                int position = searchNameText.getCaretPosition();
                String s = searchNameText.getText();
                searchNameComboText.setModel(new PersonComboBoxModel(pns.getPersonsByCriteria(searchNameText.getText())));
                searchNameText.setText(s);

                searchNameText.setCaretPosition(position);
                searchNameComboText.setPopupVisible(true);
            }
        });
    }

//    public void chargingPetition(Orders petition) {
//        order = petition;
//        for (Item order_item : order.getOrder_items()) {
//            order_item.setFacture(f);
//            order_item.setItem_Type("FactureItem");
//            itemsFacture.add(order_item);
//            pAux = order_item.getProduct();
//
//            itemsFactureTable.setModel(new ItemsTableModel(itemsFacture));
//            itemsFactureTable.getColumnModel().getColumn(1).setPreferredWidth(310);
//            itemsFactureTable.getColumnModel().getColumn(2).setCellRenderer(Operaciones.getRenderCellToRigth());
//            itemsFactureTable.getColumnModel().getColumn(3).setCellRenderer(Operaciones.getRenderCellToRigth());
//            itemsFactureTable.revalidate();
//        }
//        totalCalculate();
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desksGroup = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        String dir = "";
        if(indicador == 1){
            dir = "/images/backgrounds/invoiceNewBackground.png";
        }else if(indicador == 2){
            dir = "/images/backgrounds/invoiceEditBackground.png";
        }else if(indicador == 3){
            dir = "/images/backgrounds/invoiceRemoveBackground.png";
        }
        jPanel3 = new PanelPersonalizado(dir);
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceDetailTable = new javax.swing.JTable();
        invoiceCancelButton = new javax.swing.JButton();
        invoicePaidButton = new javax.swing.JButton();
        jPanel2 = new PanelPersonalizado("/images/backgrounds/contentPanel.png");
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        invoiceProductNameTxt = new javax.swing.JTextField();
        invoiceProductDescriptionTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        invoiceProductCodeTxt = new javax.swing.JTextField();
        invoiceProductQuantitySp = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        invoiceProductSalePriceTxt = new javax.swing.JTextField();
        invoiceAddItemButton = new javax.swing.JButton();
        invoiceRemoveItemButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        invoiceStockLabel = new javax.swing.JLabel();
        jPanel1 = new PanelPersonalizado("/images/backgrounds/contentPanel.png");
        jLabel2 = new javax.swing.JLabel();
        invoiceDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        invoicePhoneNumberTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        invoicePersonNameTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        invoiceAddressTxt = new javax.swing.JTextField();
        invoiceNewPersonButton = new javax.swing.JButton();
        invoiceEditPersonButton = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        invoiceFirstNumberTxt = new javax.swing.JTextField();
        invoiceSecondNumberTxt = new javax.swing.JTextField();
        invoiceThirdNumberTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new PanelPersonalizado("/images/backgrounds/invoiceDetail.png");
        invoiceIvaTxt = new javax.swing.JTextField();
        invoiceTotalTxt = new javax.swing.JTextField();
        invoiceDiscountJS = new javax.swing.JSpinner();
        invoiceDiscountTxt = new javax.swing.JTextField();
        invoiceSubtotalTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        invoiceSubtotalIvaZeroTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        invoiceSubtotalIvaTwelveTxt = new javax.swing.JTextField();
        closeJB = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        productComboSearch = new javax.swing.JComboBox();
        searchNameComboText = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(867, 648));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(867, 648));

        invoiceDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invoiceDetailTable.setGridColor(Color.white);
        invoiceDetailTable.setOpaque(false);
        invoiceDetailTable.setPreferredSize(new java.awt.Dimension(798, 117));
        invoiceDetailTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceDetailTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(invoiceDetailTable);

        invoiceCancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/cancelButton.png"))); // NOI18N
        invoiceCancelButton.setContentAreaFilled(false);
        invoiceCancelButton.setPreferredSize(new java.awt.Dimension(109, 49));
        invoiceCancelButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/cancelButtonHover.png"))); // NOI18N
        invoiceCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceCancelButtonActionPerformed(evt);
            }
        });

        invoicePaidButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/makeSellButton.png"))); // NOI18N
        invoicePaidButton.setContentAreaFilled(false);
        invoicePaidButton.setEnabled(false);
        invoicePaidButton.setPreferredSize(new java.awt.Dimension(109, 49));
        invoicePaidButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/makeSellButtonHover.png"))); // NOI18N
        invoicePaidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoicePaidButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(392, 208));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(244, 151, 25));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Labels/nameProductInvoiceLabel.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(244, 151, 25));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Labels/descriptionProductInvoiceLabel.png"))); // NOI18N

        invoiceProductNameTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceProductNameTxt.setBorder(null);
        invoiceProductNameTxt.setPreferredSize(new java.awt.Dimension(276, 22));

        invoiceProductDescriptionTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceProductDescriptionTxt.setBorder(null);
        invoiceProductDescriptionTxt.setPreferredSize(new java.awt.Dimension(276, 22));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(244, 151, 25));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Labels/codeProductInvoiceLabel.png"))); // NOI18N

        invoiceProductCodeTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceProductCodeTxt.setBorder(null);
        invoiceProductCodeTxt.setPreferredSize(new java.awt.Dimension(133, 22));

        invoiceProductQuantitySp.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(244, 151, 25));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Labels/quantityProductInvoiceLabel.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Labels/pvpProductInvoiceLabel.png"))); // NOI18N
        jLabel9.setPreferredSize(new java.awt.Dimension(35, 22));

        invoiceProductSalePriceTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceProductSalePriceTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        invoiceProductSalePriceTxt.setText("0.00");
        invoiceProductSalePriceTxt.setBorder(null);
        invoiceProductSalePriceTxt.setPreferredSize(new java.awt.Dimension(102, 22));

        invoiceAddItemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/addItemButton.png"))); // NOI18N
        invoiceAddItemButton.setContentAreaFilled(false);
        invoiceAddItemButton.setPreferredSize(new java.awt.Dimension(109, 49));
        invoiceAddItemButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/addItemButtonHover.png"))); // NOI18N
        invoiceAddItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceAddItemButtonActionPerformed(evt);
            }
        });

        invoiceRemoveItemButton.setBackground(new java.awt.Color(65, 65, 66));
        invoiceRemoveItemButton.setFont(new java.awt.Font("Myriad Pro", 0, 15)); // NOI18N
        invoiceRemoveItemButton.setForeground(new java.awt.Color(244, 151, 25));
        invoiceRemoveItemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/removeItemButton.png"))); // NOI18N
        invoiceRemoveItemButton.setContentAreaFilled(false);
        invoiceRemoveItemButton.setEnabled(false);
        invoiceRemoveItemButton.setPreferredSize(new java.awt.Dimension(109, 49));
        invoiceRemoveItemButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/removeItemButtonHover.png"))); // NOI18N
        invoiceRemoveItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceRemoveItemButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("STOCK:");

        invoiceStockLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        invoiceStockLabel.setText("...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(invoiceProductCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(invoiceProductSalePriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(invoiceProductQuantitySp, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invoiceStockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(invoiceProductNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invoiceProductDescriptionTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(invoiceAddItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(invoiceRemoveItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceProductNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(invoiceProductDescriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceProductSalePriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceProductCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(invoiceProductQuantitySp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(invoiceStockLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(invoiceAddItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceRemoveItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(392, 208));

        jLabel2.setBackground(new java.awt.Color(65, 65, 66));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(244, 151, 25));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Labels/dateInvoiceLabel.png"))); // NOI18N

        invoiceDateChooser.setBackground(new java.awt.Color(233, 233, 233));
        invoiceDateChooser.setDate(new java.util.Date());
        invoiceDateChooser.setOpaque(false);
        invoiceDateChooser.setPreferredSize(new java.awt.Dimension(116, 22));

        jLabel3.setText("Teléfono:");

        invoicePhoneNumberTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoicePhoneNumberTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        invoicePhoneNumberTxt.setBorder(null);
        invoicePhoneNumberTxt.setPreferredSize(new java.awt.Dimension(108, 22));
        invoicePhoneNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoicePhoneNumberTxtActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(65, 65, 66));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(244, 151, 25));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Labels/nameInvoiceLabel.png"))); // NOI18N

        invoicePersonNameTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoicePersonNameTxt.setBorder(null);
        invoicePersonNameTxt.setPreferredSize(new java.awt.Dimension(285, 22));

        jLabel6.setBackground(new java.awt.Color(65, 65, 66));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(244, 151, 25));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Labels/addressInvoiceLabel.png"))); // NOI18N

        invoiceAddressTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceAddressTxt.setBorder(null);
        invoiceAddressTxt.setPreferredSize(new java.awt.Dimension(285, 22));

        invoiceNewPersonButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/newClient.png"))); // NOI18N
        invoiceNewPersonButton.setToolTipText("");
        invoiceNewPersonButton.setContentAreaFilled(false);
        invoiceNewPersonButton.setPreferredSize(new java.awt.Dimension(109, 49));
        invoiceNewPersonButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/newClientHover.png"))); // NOI18N
        invoiceNewPersonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceNewPersonButtonActionPerformed(evt);
            }
        });

        invoiceEditPersonButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/editClient.png"))); // NOI18N
        invoiceEditPersonButton.setContentAreaFilled(false);
        invoiceEditPersonButton.setPreferredSize(new java.awt.Dimension(109, 49));
        invoiceEditPersonButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/editClientHover.png"))); // NOI18N
        invoiceEditPersonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceEditPersonButtonActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(65, 65, 66));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(244, 151, 25));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Labels/factureNumberInvoiceLabel.png"))); // NOI18N

        invoiceFirstNumberTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceFirstNumberTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        invoiceFirstNumberTxt.setBorder(null);
        invoiceFirstNumberTxt.setPreferredSize(new java.awt.Dimension(42, 22));

        invoiceSecondNumberTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceSecondNumberTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        invoiceSecondNumberTxt.setBorder(null);
        invoiceSecondNumberTxt.setPreferredSize(new java.awt.Dimension(42, 22));

        invoiceThirdNumberTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceThirdNumberTxt.setBorder(null);
        invoiceThirdNumberTxt.setPreferredSize(new java.awt.Dimension(162, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoiceFirstNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoiceSecondNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoiceThirdNumberTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(invoiceNewPersonButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(invoiceEditPersonButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoiceDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoicePhoneNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoicePersonNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invoiceAddressTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(invoicePersonNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(invoiceAddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invoiceDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(invoicePhoneNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(invoiceFirstNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(invoiceSecondNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(invoiceThirdNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(invoiceEditPersonButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceNewPersonButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel7.setBackground(new java.awt.Color(65, 65, 66));
        jLabel7.setForeground(new java.awt.Color(244, 151, 25));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/searchLogo.png"))); // NOI18N
        jLabel7.setOpaque(true);
        jLabel7.setPreferredSize(new java.awt.Dimension(65, 52));

        jLabel1.setBackground(new java.awt.Color(65, 65, 66));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/searchLogo.png"))); // NOI18N
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(65, 52));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(265, 176));

        invoiceIvaTxt.setEditable(false);
        invoiceIvaTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceIvaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        invoiceIvaTxt.setText("0.00");
        invoiceIvaTxt.setPreferredSize(new java.awt.Dimension(109, 22));

        invoiceTotalTxt.setEditable(false);
        invoiceTotalTxt.setBackground(new java.awt.Color(65, 65, 66));
        invoiceTotalTxt.setForeground(new java.awt.Color(255, 255, 255));
        invoiceTotalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        invoiceTotalTxt.setText("0.00");
        invoiceTotalTxt.setBorder(null);
        invoiceTotalTxt.setPreferredSize(new java.awt.Dimension(109, 22));

        invoiceDiscountTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceDiscountTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        invoiceDiscountTxt.setText("0.00");

        invoiceSubtotalTxt.setEditable(false);
        invoiceSubtotalTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceSubtotalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        invoiceSubtotalTxt.setText("0.00");
        invoiceSubtotalTxt.setPreferredSize(new java.awt.Dimension(109, 22));

        jLabel16.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(244, 151, 25));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("DESCUENTO %:");

        jLabel12.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(244, 151, 25));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("SUBTOTAL:");

        jLabel13.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(244, 151, 25));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("IVA 12%:");

        jLabel14.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(244, 151, 25));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("VALOR TOTAL:");

        invoiceSubtotalIvaZeroTxt.setEditable(false);
        invoiceSubtotalIvaZeroTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceSubtotalIvaZeroTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        invoiceSubtotalIvaZeroTxt.setText("0.00");
        invoiceSubtotalIvaZeroTxt.setPreferredSize(new java.awt.Dimension(109, 22));

        jLabel18.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(244, 151, 25));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("SUBTOTAL IVA 0%:");

        jLabel19.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(244, 151, 25));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("SUBTOTAL IVA 12%:");

        invoiceSubtotalIvaTwelveTxt.setEditable(false);
        invoiceSubtotalIvaTwelveTxt.setBackground(new java.awt.Color(233, 233, 233));
        invoiceSubtotalIvaTwelveTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        invoiceSubtotalIvaTwelveTxt.setText("0.00");
        invoiceSubtotalIvaTwelveTxt.setBorder(null);
        invoiceSubtotalIvaTwelveTxt.setPreferredSize(new java.awt.Dimension(109, 22));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel12)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceSubtotalIvaZeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invoiceSubtotalTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(invoiceDiscountJS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoiceDiscountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(invoiceSubtotalIvaTwelveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(invoiceTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(invoiceIvaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceSubtotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceDiscountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceDiscountJS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceSubtotalIvaZeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(invoiceSubtotalIvaTwelveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceIvaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        closeJB.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        closeJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/closeWindowButton.png"))); // NOI18N
        closeJB.setContentAreaFilled(false);
        closeJB.setFocusable(false);
        closeJB.setMargin(new java.awt.Insets(2, 2, 2, 2));
        closeJB.setPreferredSize(new java.awt.Dimension(21, 20));
        closeJB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/closeWindowButtonHover.png"))); // NOI18N
        closeJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJBActionPerformed(evt);
            }
        });

        productComboSearch.setEditable(true);
        productComboSearch.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        productComboSearch.setPreferredSize(new java.awt.Dimension(318, 52));
        productComboSearch.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                productComboSearchPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        productComboSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productComboSearchActionPerformed(evt);
            }
        });

        searchNameComboText.setEditable(true);
        searchNameComboText.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        searchNameComboText.setPreferredSize(new java.awt.Dimension(318, 52));
        searchNameComboText.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                searchNameComboTextPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchNameComboText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(productComboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(invoiceCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invoicePaidButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(closeJB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(closeJB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productComboSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchNameComboText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(invoicePaidButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoiceCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(357, 357, 357))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void invoiceEditPersonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceEditPersonButtonActionPerformed
        // TODO add your handling code here:
        if (searchNameComboText.getItemCount() != 0) {
            new PersonView(null, true, 2, this.pns).setVisible(true);
            this.chargePersonView();
        } else {
            JOptionPane.showMessageDialog(searchNameComboText, "NO HA ELEGIDO CLIENTE");
        }


    }//GEN-LAST:event_invoiceEditPersonButtonActionPerformed

    private void invoiceNewPersonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceNewPersonButtonActionPerformed
        // TODO add your handling code here:
        new PersonView(null, Boolean.TRUE, 1).setVisible(true);
    }//GEN-LAST:event_invoiceNewPersonButtonActionPerformed

    private void invoiceCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceCancelButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_invoiceCancelButtonActionPerformed

    private void totalInvoiceCalculate() {
        for (int i = 0; i < this.ds.getDetailList().size(); i++) {
            if (this.ds.getDetailList().get(i).getProduct().getPdIvaState() == 1) {
                subtotalIvaTwelve += this.ds.getDetailList().get(i).getDetSalePrice() * this.ds.getDetailList().get(i).getDetQuantity();
            } else {
                subTotalivaZero += this.ds.getDetailList().get(i).getDetSalePrice() * this.ds.getDetailList().get(i).getDetQuantity();
            }
        }
        iva = subtotalIvaTwelve * (GeneralParameter.IVA_VALUE - 1);

        double totalVenta = subTotalivaZero + subtotalIvaTwelve + iva;
        this.invoiceSubtotalTxt.setText(Operaciones.parteDecimal(Math.rint((subtotalIvaTwelve + subTotalivaZero) * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE));
        this.invoiceSubtotalIvaZeroTxt.setText(Operaciones.parteDecimal(Math.rint(subTotalivaZero * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE));
        this.invoiceSubtotalIvaTwelveTxt.setText(Operaciones.parteDecimal(Math.rint(subtotalIvaTwelve * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE));
        this.invoiceIvaTxt.setText(Operaciones.parteDecimal(Math.rint(iva * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE));
        this.invoiceTotalTxt.setText(Operaciones.parteDecimal(Math.rint(totalVenta * 100) / 100, GeneralParameter.ACCURACY_VALUE));
    }

    private void totalCalculate() {

        if (this.ps.getProduct().getPdIvaState() == 1) {
            subtotalIvaTwelve += (this.ps.getProduct().getPdSalePrice() / GeneralParameter.IVA_VALUE) * Double.parseDouble(String.valueOf(invoiceProductQuantitySp.getValue()));
            iva = subtotalIvaTwelve * (GeneralParameter.IVA_VALUE - 1);
        } else {
            subTotalivaZero += this.ps.getProduct().getPdSalePrice() * Double.parseDouble(String.valueOf(invoiceProductQuantitySp.getValue()));
            if (subtotalIvaTwelve == 0) {
                iva = 0;
            }
        }
        double totalVenta = subTotalivaZero + subtotalIvaTwelve + iva;
        this.invoiceSubtotalTxt.setText(Operaciones.parteDecimal(Math.rint((subtotalIvaTwelve + subTotalivaZero) * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE));
        this.invoiceSubtotalIvaZeroTxt.setText(Operaciones.parteDecimal(Math.rint(subTotalivaZero * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE));
        this.invoiceSubtotalIvaTwelveTxt.setText(Operaciones.parteDecimal(Math.rint(subtotalIvaTwelve * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE));
        this.invoiceIvaTxt.setText(Operaciones.parteDecimal(Math.rint(iva * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE));
        this.invoiceTotalTxt.setText(Operaciones.parteDecimal(Math.rint(totalVenta * 100) / 100, GeneralParameter.ACCURACY_VALUE));
    }

    private void invoiceAddItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceAddItemButtonActionPerformed
        // TODO add your handling code here: 
        if (this.ps.getProduct().getProductId() != null) {
            if (this.ps.getProduct().getPdStock() < Double.parseDouble(String.valueOf(this.invoiceProductQuantitySp.getValue()))) {
                JOptionPane.showMessageDialog(this, "Producto sin stock");
            } else {
                if (!isAdded()) {
                    this.addDetail();
                    this.ps.getProduct().setPdStock(this.ps.getProduct().getPdStock() - Double.parseDouble(String.valueOf(this.invoiceProductQuantitySp.getValue())));
                    this.invoiceStockLabel.setText(String.valueOf(this.ps.getProduct().getPdStock()));
                    this.ds.addDetailList(this.ds.getDetail());
                }
                this.updateInvoiceDetailTable();
                this.totalCalculate();
                this.invoiceRemoveItemButton.setEnabled(Boolean.TRUE);
                this.invoicePaidButton.setEnabled(Boolean.TRUE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningún producto");
        }


    }//GEN-LAST:event_invoiceAddItemButtonActionPerformed

    private boolean isAdded() {
        for (int i = 0; i < this.ds.getDetailList().size(); i++) {
            if (Objects.equals(this.ps.getProduct().getProductId(), this.ds.getDetailList().get(i).getProduct().getProductId())) {
                this.ds.getDetailList().get(i).setDetQuantity(this.ds.getDetailList().get(i).getDetQuantity() + Double.parseDouble(String.valueOf(this.invoiceProductQuantitySp.getValue())));
                this.ds.getDetailList().get(i).setDetTotal(this.ds.getDetailList().get(i).getDetQuantity() * this.ds.getDetailList().get(i).getDetSalePrice());
                //Método para reducir el stock
                this.ps.getProduct().setPdStock(this.ps.getProduct().getPdStock() - Double.parseDouble(String.valueOf(this.invoiceProductQuantitySp.getValue())));
                this.invoiceStockLabel.setText(String.valueOf(this.ps.getProduct().getPdStock()));
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private void saveAccountingEntry() {
        this.aes.getAccountingEntry().setAeCreatedDate(invoiceDateChooser.getDate());
        this.aes.getAccountingEntry().setAeDescription("Factura de venta Nro: " + invoiceThirdNumberTxt.getText());
        this.aes.getAccountingEntry().setAeType(0);
        this.aes.getAccountingEntry().setAeValue(Double.valueOf(invoiceTotalTxt.getText()));

        if (this.aes.getAccountingEntry().getAccountingEntryId() == null) {
            if (this.aes.saveAccountingEntry()) {
                System.out.println("Asiento guardado correctamente");
            }
        }

    }

    private void addDetail() {
        Double salePrice;
        this.ds.getDetail().setDetType("invoiceDetail");
        this.ds.getDetail().setDetDescription(this.invoiceProductNameTxt.getText());
        if (this.ps.getProduct().getPdIvaState() == 1) {//Si el producto tiene iva se desglosa del precio de venta
            salePrice = Double.parseDouble(this.invoiceProductSalePriceTxt.getText()) / GeneralParameter.IVA_VALUE;//Poner como parametro el valor de iva para que cambie automaticamente
        } else {
            salePrice = Double.parseDouble(this.invoiceProductSalePriceTxt.getText());
        }
        this.ds.getDetail().setDetSalePrice(salePrice);
        this.ds.getDetail().setDetQuantity(Double.parseDouble(String.valueOf(this.invoiceProductQuantitySp.getValue())));
        this.ds.getDetail().setDetTotal(this.ds.getDetail().getDetQuantity() * this.ds.getDetail().getDetSalePrice());

        this.ds.getDetail().setProduct(this.ps.getProduct());
        //Para asociar el pedido con el detalle cuando existe un pedido pendiente
        this.ds.getDetail().setInvoice(this.invs.getInvoice());

    }

    private void chargeInvoiceData() {
        this.invs.getInvoice().setInAuthorizationDate(null);

        //this.invs.getInvoice().setInCash(Double.valueOf("0"));//Incializamos los valores con 0
        //this.invs.getInvoice().setInChange(Double.valueOf("0"));
        this.invs.getInvoice().setInIssueDate(invoiceDateChooser.getDate());
        this.invs.getInvoice().setInIssueTime(invoiceDateChooser.getDate());

        this.invs.getInvoice().setInNumber(invoiceThirdNumberTxt.getText());
        this.invs.getInvoice().setInPetitionName(petitionName);
        this.invs.getInvoice().setInState("REALIZADA");
        this.invs.getInvoice().setInSubtotal(Double.valueOf(invoiceSubtotalTxt.getText()));
        this.invs.getInvoice().setInDiscount(Double.valueOf(invoiceDiscountTxt.getText()));
        this.invs.getInvoice().setInSubtotalIvazero(Double.valueOf(invoiceSubtotalIvaZeroTxt.getText()));
        this.invs.getInvoice().setInSubtotalIva(Double.valueOf(invoiceSubtotalIvaTwelveTxt.getText()));
        this.invs.getInvoice().setInIva(Double.valueOf(invoiceIvaTxt.getText()));
        this.invs.getInvoice().setInTotal(Double.valueOf(invoiceTotalTxt.getText()));
        this.invs.getInvoice().setDetailList(this.ds.getDetailList());// agregamos los detalles a la factura para poder persistir el detalle
        this.invs.getInvoice().setPerson(this.pns.getPerson());
    }

    private void updateInvoiceDetailTable() {
        this.dtm.setList(this.ds.getDetailList());
        this.invoiceDetailTable.setModel(this.dtm);
        this.invoiceDetailTable.updateUI();
    }

    private void updateStock() {
        for (int i = 0; i < this.ds.getDetailList().size(); i++) {
            if (this.ps.getProduct().getProductId() != null) {//Mientras exista una instancia del producto actualizamos el stock.
                this.ps.updateProduct();
            }
        }
    }

    private void closeWindow() {
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void invoicePaidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicePaidButtonActionPerformed
        // TODO add your handling code here:

        if (ValidateEmptyFields.requerido(invoicePersonNameTxt, invoicePersonNameTxt.getText())) {
            new CambioV(null, true, Double.parseDouble(invoiceTotalTxt.getText()), this.invs).setVisible(true);
            if (this.invs.getInvoice().getInCash() != null) {
                System.out.println("EL VUELTO ES: " + this.invs.getInvoice().getInChange());

                if (this.pns.getPerson().getPersonId() == null) {
                    javax.swing.JOptionPane.showMessageDialog(this, "No ha seleccionado ningún cliente");
                } else if (this.invs.getInvoice().getInvoiceId() == null) {
                    this.chargeInvoiceData();
                    System.out.println("EL PEDIDO ES NUEVO");
                    if (this.invs.saveInvoice()) {
                        this.updateStock();//Si ya se guarda la factura actualizamos el stock del producto
                        this.saveAccountingEntry();//Guardamos el asiento contable de la venta
                        JOptionPane.showMessageDialog(this, "FACTURA GUARDADA CORRECTAMENTE");
                        report = new Report();
                       
                            report.printInvoice(this.invs, this.dtm);
                        
                        this.closeWindow();
                        if (this.pts.getPetition() != null) {
                            if (!this.pts.removePetition()) {
                                JOptionPane.showMessageDialog(this, "Error al eliminar el pedido");
                            }
                        }
                    }
                }
            } else {
                System.out.println("LA VENTANA SE HA CERRADO");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Campos vacíos");
        }
    }//GEN-LAST:event_invoicePaidButtonActionPerformed

    private void invoiceRemoveItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceRemoveItemButtonActionPerformed
        if (invoiceDetailTable.getSelectedRow() >= 0) {
            if (Double.parseDouble(String.valueOf(invoiceProductQuantitySp.getValue())) > this.ds.getDetailList().get(invoiceDetailTable.getSelectedRow()).getDetQuantity()) {
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad inferior al detalle", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (this.ds.getDetailList().get(invoiceDetailTable.getSelectedRow()).getProduct().getPdIvaState().equals(1)) {
                subtotalIvaTwelve -= this.ds.getDetailList().get(invoiceDetailTable.getSelectedRow()).getDetSalePrice() * Double.parseDouble(String.valueOf(invoiceProductQuantitySp.getValue()));
            } else {
                subTotalivaZero -= this.ds.getDetailList().get(invoiceDetailTable.getSelectedRow()).getDetSalePrice() * Double.parseDouble(String.valueOf(invoiceProductQuantitySp.getValue()));
            }

            iva = subtotalIvaTwelve * (GeneralParameter.IVA_VALUE - 1);

            double totalVenta = subTotalivaZero + subtotalIvaTwelve + iva;
            this.invoiceSubtotalTxt.setText(Operaciones.parteDecimal(Math.rint((subtotalIvaTwelve + subTotalivaZero) * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE));
            this.invoiceSubtotalIvaZeroTxt.setText(Operaciones.parteDecimal(Math.rint(subTotalivaZero * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE));
            this.invoiceSubtotalIvaTwelveTxt.setText(Operaciones.parteDecimal(Math.rint(subtotalIvaTwelve * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE));
            this.invoiceIvaTxt.setText(Operaciones.parteDecimal(Math.rint(iva * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE));
            this.invoiceTotalTxt.setText(Operaciones.parteDecimal(Math.rint(totalVenta * 100) / 100, GeneralParameter.ACCURACY_VALUE));

            if (Double.parseDouble(String.valueOf(invoiceProductQuantitySp.getValue())) == this.ds.getDetailList().get(invoiceDetailTable.getSelectedRow()).getDetQuantity()) {
                this.ds.getDetailList().remove(invoiceDetailTable.getSelectedRow());
                this.ps.getProduct().setPdStock(this.ps.getProduct().getPdStock() + Double.parseDouble(String.valueOf(invoiceProductQuantitySp.getValue())));
                invoiceStockLabel.setText(String.valueOf(this.ps.getProduct().getPdStock()));
            } else {
                double quantity = this.ds.getDetailList().get(invoiceDetailTable.getSelectedRow()).getDetQuantity();
                this.ds.getDetailList().get(invoiceDetailTable.getSelectedRow()).setDetQuantity(quantity - Double.parseDouble(String.valueOf(invoiceProductQuantitySp.getValue())));
                this.ps.getProduct().setPdStock(this.ps.getProduct().getPdStock() + Double.parseDouble(String.valueOf(invoiceProductQuantitySp.getValue())));
                invoiceStockLabel.setText(String.valueOf(this.ps.getProduct().getPdStock()));
                quantity = this.ds.getDetailList().get(invoiceDetailTable.getSelectedRow()).getDetQuantity();
                this.ds.getDetailList().get(invoiceDetailTable.getSelectedRow()).setDetTotal(quantity * this.ds.getDetailList().get(invoiceDetailTable.getSelectedRow()).getDetSalePrice());
            }
            if (this.ds.getDetailList().isEmpty()) {
                invoiceRemoveItemButton.setEnabled(Boolean.FALSE);
                invoicePaidButton.setEnabled(Boolean.FALSE);
            }
            //calcularDescuento();
            this.updateInvoiceDetailTable();
        } else {
            JOptionPane.showMessageDialog(this, "Escoja una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_invoiceRemoveItemButtonActionPerformed

    private void closeJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJBActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeJBActionPerformed

    private void invoicePhoneNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicePhoneNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoicePhoneNumberTxtActionPerformed

    private void searchNameComboTextPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_searchNameComboTextPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.searchNameComboText.getItemCount() != 0) {
            PersonComboBoxModel pcbm = (PersonComboBoxModel) searchNameComboText.getModel();
            this.pns.setInstance(pcbm.getSelectedItem());
            if (this.pns.getPerson() != null) {
                this.chargePersonView();
            }
        }
    }//GEN-LAST:event_searchNameComboTextPopupMenuWillBecomeInvisible

    private void chargePersonView() {
        this.invoicePersonNameTxt.setText(this.pns.getPerson().toString());
        this.invoiceAddressTxt.setText(this.pns.getPerson().getPrAddress());
        this.invoicePhoneNumberTxt.setText(this.pns.getPerson().getPrPhone());
    }

    private void productComboSearchPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_productComboSearchPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.searchNameComboText.getItemCount() != 0) {
            ProductComboBoxModel pcm = (ProductComboBoxModel) productComboSearch.getModel();
            this.ps.setInstance(pcm.getSelectedItem());
            if (this.ps.getProduct() != null) {
                this.chargeProductView();
            }
        }
    }//GEN-LAST:event_productComboSearchPopupMenuWillBecomeInvisible

    private void chargeProductView() {
        this.invoiceProductNameTxt.setText(this.ps.getProduct().getPdName());
        this.invoiceProductSalePriceTxt.setText(String.valueOf(this.ps.getProduct().getPdSalePrice()));
        this.invoiceProductDescriptionTxt.setText(this.ps.getProduct().getPdDescription());
        this.invoiceProductCodeTxt.setText(this.ps.getProduct().getPdCode());
        this.invoiceStockLabel.setText(String.valueOf(this.ps.getProduct().getPdStock()));
    }

    private void invoiceDetailTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceDetailTableMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.ps.setInstance(this.ds.getDetailList().get(invoiceDetailTable.getSelectedRow()).getProduct());
            this.chargeProductView();
        }
    }//GEN-LAST:event_invoiceDetailTableMouseClicked

    private void productComboSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productComboSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productComboSearchActionPerformed

    private boolean lectorDeBarras() {
//        if (searchProductTxt.getText().trim().equals("")) {
//            return false;
//        }
//        if (searchProductTxt.getText().contains("'")) {
//            searchProductTxt.setText(searchProductTxt.getText().replaceAll("'", "-"));
//        }
//        //Product p 
//        pAux = uccproduct.getProductPerBarCode(searchProductTxt.getText());
//
//        if (pAux != null) {
//            invoiceProductNameTxt.setText(pAux.getNombreProducto());
//            invoiceSalePriceTxt.setText("" + pAux.getPvpProducto());
//            invoiceProductDescriptionTxt.setText(pAux.getDescripcionProducto());
//            if (pAux.getBarCode() == null || pAux.getBarCode().trim().equals("")) {
//                invoiceProductCodeTxt.setText(pAux.getCodigoProducto());
//            } else {
//                invoiceProductCodeTxt.setText(pAux.getBarCode());
//            }
//            codeBarActive = true;
//            indicador = 1;
//            contAddItem = contAddItem + 1;
//            addProductToFacture(indicador);
//            searchProductTxt.setText("");
//            return true;
//        }

        return false;
    }

    private void busquedaNormal() {
//        isClient = false;
//        codeBarActive = false;
//        tablaClientes.setModel(new ProductTableModel(uccproduct.buscarPorCriterio(searchProduct.getText(), 2, true, enterprisePrincipal), 2));
//        tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(250);
//        tablaClientes.getSelectionModel().addSelectionInterval(0, 0);
//        searchClientXId.show(searchProduct, searchProductLabel.getX(), searchProductLabel.getY());
    }

    private void ejecutaAccion() {
        try {
            if (!lectorDeBarras()) {
                busquedaNormal();
            }
        } catch (Exception ex) {
            System.out.println("akiiiiiiiiiiiiiiiiiiiiier: " + ex);
        }
    }

    boolean indica = true;
    Thread hilo;
    HopeLector hl = new HopeLector();

    public class HopeLector implements Runnable {

        int indic;

        public void ejecuta(int ind) {
            indica = false;
            indic = ind;
            hilo = new Thread(this);
            hilo.start();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(200);
                //ejecutaAccion();
                if (indic == 0) {
                    ejecutaAccion();
                } else {
                    //ejecutaAccionCombo();
                }
                indica = true;

            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeJB;
    private javax.swing.ButtonGroup desksGroup;
    private javax.swing.JButton invoiceAddItemButton;
    public javax.swing.JTextField invoiceAddressTxt;
    private javax.swing.JButton invoiceCancelButton;
    public com.toedter.calendar.JDateChooser invoiceDateChooser;
    private javax.swing.JTable invoiceDetailTable;
    private javax.swing.JSpinner invoiceDiscountJS;
    private javax.swing.JTextField invoiceDiscountTxt;
    private javax.swing.JButton invoiceEditPersonButton;
    public javax.swing.JTextField invoiceFirstNumberTxt;
    private javax.swing.JTextField invoiceIvaTxt;
    private javax.swing.JButton invoiceNewPersonButton;
    private javax.swing.JButton invoicePaidButton;
    public javax.swing.JTextField invoicePersonNameTxt;
    public javax.swing.JTextField invoicePhoneNumberTxt;
    public javax.swing.JTextField invoiceProductCodeTxt;
    public javax.swing.JTextField invoiceProductDescriptionTxt;
    public javax.swing.JTextField invoiceProductNameTxt;
    public javax.swing.JSpinner invoiceProductQuantitySp;
    public javax.swing.JTextField invoiceProductSalePriceTxt;
    private javax.swing.JButton invoiceRemoveItemButton;
    public javax.swing.JTextField invoiceSecondNumberTxt;
    private javax.swing.JLabel invoiceStockLabel;
    private javax.swing.JTextField invoiceSubtotalIvaTwelveTxt;
    private javax.swing.JTextField invoiceSubtotalIvaZeroTxt;
    private javax.swing.JTextField invoiceSubtotalTxt;
    public javax.swing.JTextField invoiceThirdNumberTxt;
    private javax.swing.JTextField invoiceTotalTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JComboBox productComboSearch;
    public javax.swing.JComboBox searchNameComboText;
    // End of variables declaration//GEN-END:variables

}
