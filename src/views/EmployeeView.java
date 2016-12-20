package views;

import controller.resources.GeneralParameter;
import controller.resources.Operaciones;
import controller.resources.Report;
import controller.service.AccountingEntryService;
import controller.service.EmployeeService;
import controller.service.PayrollService;
import controller.service.PersonService;
import controller.service.SalaryPaymentService;
import controller.service.SalaryService;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import views.tableModel.EmployeeTableModel;
import views.tableModel.SalaryPaymentTableModel;
import views.tableModel.SalaryTableModel;

/**
 *
 * @author eyetive
 */
public class EmployeeView extends javax.swing.JDialog {

    private final EmployeeService employeeService;
    private final SalaryService salaryService;
    private final PersonService personService;
    private final EmployeeTableModel employeeTableModel;
    private final SalaryTableModel salaryTableModel;
    private final SalaryPaymentService salaryPaymentService;
    private final AccountingEntryService accountingEntryService;
    private final SalaryPaymentTableModel salaryPaymentTableModel;
    private final PayrollService payrollService;
    private final Double auxTot;
    private final Integer actualMonth;
    private final Integer actualYear;
    private final Integer lastDayMonth;
    private final Integer actualDay;

    public EmployeeView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.employeeService = new EmployeeService();
        this.salaryService = new SalaryService();
        this.personService = new PersonService();
        this.employeeTableModel = new EmployeeTableModel();
        this.salaryTableModel = new SalaryTableModel();
        this.salaryPaymentService = new SalaryPaymentService();
        this.accountingEntryService = new AccountingEntryService();
        this.salaryPaymentTableModel = new SalaryPaymentTableModel();
        this.payrollService = new PayrollService();
        initComponents();
        this.auxTot = Math.pow(10, GeneralParameter.ACCURACY_VALUE);
        this.getEmployeeList();
        //Para calcular el ultimo día del mes
        Calendar calendar = Calendar.getInstance();
        actualDay = calendar.get(Calendar.DAY_OF_MONTH);
        actualMonth = calendar.get(Calendar.MONTH) + 1;
        actualYear = calendar.get(Calendar.YEAR);
        lastDayMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        //Controlamos que el boton de generar rol de pago se habilite el ultimo día del mes
        
        if(Objects.equals(actualDay, lastDayMonth)){
            JOptionPane.showMessageDialog(null, "Hoy se debe generar el rol de pagos");
            //Cuando es el ultimo día del mes activamos el botón para generar el rol
            payrollGenerateButton.setEnabled(true);
            salaryPaymentExtraHoursTxt.setEditable(true);
            salaryPaymentOtherIncomesTxt.setEditable(true);
        }else{            
            System.out.println("El ultimo dia del mes es: " + lastDayMonth + " El dia de hoy es: " + actualDay);
        }
        

    }

    private void getEmployeeList() {
        this.employeeService.setEmployeeList(this.employeeService.list());
        this.employeeTableModel.setList(this.employeeService.getEmployeeList());
        this.employeeTable.setModel(this.employeeTableModel);
        this.employeeTable.updateUI();

        //this.salaryPaymentService.setSalaryPaymentList(salaryPaymentList);
    }

    private void chargePersonData() {
        this.personService.getPerson().setPrType("Empleado");
        this.personService.getPerson().setPrFirstName(this.employeeFirstNameTxt.getText());
        this.personService.getPerson().setPrLastName(this.employeeLastNameTxt.getText());
        this.personService.getPerson().setPrAddress(this.employeeAddressTxt.getText());
        this.personService.getPerson().setPrIdentification(this.employeeIdentificationTxt.getText());
        this.personService.getPerson().setPrPhone(this.employeePhoneTxt.getText());
        this.personService.getPerson().setPrEmail(this.employeeEmailTxt.getText());
    }

    private void chargeEmployeeData() {
        this.employeeService.getEmployee().setEmployeeFirstName(this.employeeFirstNameTxt.getText());
        this.employeeService.getEmployee().setEmployeeLastName(this.employeeLastNameTxt.getText());
        this.employeeService.getEmployee().setEmployeeAddress(this.employeeAddressTxt.getText());
        this.employeeService.getEmployee().setEmployeeIdentification(this.employeeIdentificationTxt.getText());
        this.employeeService.getEmployee().setEmployeePhone(this.employeePhoneTxt.getText());
        this.employeeService.getEmployee().setEmployeeEmail(this.employeeEmailTxt.getText());
        this.employeeService.getEmployee().setEmployeeJob(this.employeeJobTxt.getText());
        this.employeeService.getEmployee().setEmployeeHireDate(this.employeeHireDateDC.getDate());

        if (this.employeeDepartureDateDc.getDate() != null) {
            this.employeeService.getEmployee().setEmployeeDepartureDate(this.employeeDepartureDateDc.getDate());
        }

        //this.chargeSalaryData();
    }

    private void chargeSalaryData() {
        this.salaryService.getSalary().setSalaryValue(Double.valueOf(this.salaryValueTxt.getText()));
        this.salaryService.getSalary().setSalaryDate(this.salaryDateDc.getDate());
        this.salaryService.getSalary().setSalaryState(0);
        this.salaryService.getSalary().setSalaryBalance(Double.valueOf(this.salaryValueTxt.getText()));
        this.salaryService.getSalary().setEmployee(this.employeeService.getEmployee());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        employeeSalaryTableScroll = new javax.swing.JScrollPane();
        employeeSalaryTable = new javax.swing.JTable();
        employeePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        employeeFirstNameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        employeeLastNameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        employeeAddressTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        employeePhoneTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        employeeEmailTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        employeeJobTxt = new javax.swing.JTextField();
        employeeHireDateDC = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        employeeDepartureDateDc = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        employeeIdentificationTxt = new javax.swing.JTextField();
        employeeSaveButton = new javax.swing.JButton();
        employeeCloseButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        employeeSalaryTxt = new javax.swing.JTextField();
        addSalaryPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        salaryEmployeeNameTxt = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        salaryValueTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        salaryDateDc = new com.toedter.calendar.JDateChooser();
        testPanel = new javax.swing.JPanel();
        salaryPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        salaryEmployeeTxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        salaryEmployeeAddressTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        salaryEmployeePhoneTxt = new javax.swing.JTextField();
        salaryEmployeeJobTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        salaryEmployeeIdentificationTxt = new javax.swing.JTextField();
        salaryEmployeeTablePanel = new javax.swing.JPanel();
        salaryPaymentOptionsBtg = new javax.swing.ButtonGroup();
        salaryPaymentPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        salaryPaymentCompleteRb = new javax.swing.JRadioButton();
        salaryPaymentAdvanceRb = new javax.swing.JRadioButton();
        salaryPaymentAdvanceValueTxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        salaryPaymentDate = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        salaryPaymentObservationsTxt = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        salaryPaymentExtraHoursTxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        salaryPaymentOtherIncomesTxt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        salaryPaymentEmployeeTxt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        salaryPaymentValueTxt = new javax.swing.JTextField();
        salaryPaymentTablePanel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        closeSalaryPaymentButton = new javax.swing.JButton();
        printSalaryPaymentButton = new javax.swing.JButton();
        payrollGenerateButton = new javax.swing.JButton();
        demoCheck = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        salaryPaymentBalanceTxt = new javax.swing.JTextField();
        removeSalaryPaymentButton = new javax.swing.JButton();
        saveSalaryPaymentButton = new javax.swing.JButton();
        newSalaryPaymentButton = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        salaryPaymentMonthChooser = new com.toedter.calendar.JMonthChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        salaryPaymentTable = new javax.swing.JTable();
        employeeOptionsPopupMenu = new javax.swing.JPopupMenu();
        employeePaymentItem = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        employeeTabView = new javax.swing.JTabbedPane();
        employeeFirstPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        employeeNewBt = new javax.swing.JButton();
        payrollReportButton = new javax.swing.JButton();

        employeeSalaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        employeeSalaryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeSalaryTableMouseClicked(evt);
            }
        });
        employeeSalaryTableScroll.setViewportView(employeeSalaryTable);

        employeePanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Generales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 12), new java.awt.Color(0, 153, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel1.setText("Nombres:");

        employeeFirstNameTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setText("Apellidos:");

        employeeLastNameTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setText("Dirección:");

        employeeAddressTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setText("Teléfono:");

        employeePhoneTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setText("Correo:");

        employeeEmailTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setText("Cargo:");

        employeeJobTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        employeeHireDateDC.setBackground(new java.awt.Color(255, 255, 255));
        employeeHireDateDC.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("Fecha de ingreso:");

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel8.setText("Fecha de salida:");

        employeeDepartureDateDc.setBackground(new java.awt.Color(255, 255, 255));
        employeeDepartureDateDc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setText("Identificación:");

        employeeIdentificationTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        employeeSaveButton.setText("GUARDAR");
        employeeSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeSaveButtonActionPerformed(evt);
            }
        });

        employeeCloseButton.setText("CERRAR");
        employeeCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeCloseButtonActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 12), new java.awt.Color(0, 153, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 153, 255));

        jLabel25.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel25.setText("Sueldo:");

        employeeSalaryTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeSalaryTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employeeSalaryTxt)
                .addGap(352, 352, 352))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(employeeSalaryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(employeeHireDateDC, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeDepartureDateDc, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(employeeSaveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(employeeCloseButton))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeIdentificationTxt)
                            .addComponent(employeeAddressTxt)
                            .addComponent(employeeLastNameTxt)
                            .addComponent(employeeFirstNameTxt)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(employeePhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(employeeEmailTxt))
                            .addComponent(employeeJobTxt)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(employeeFirstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(employeeLastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(employeeAddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(employeeIdentificationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(employeePhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(employeeEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(employeeJobTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(employeeHireDateDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(employeeDepartureDateDc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeCloseButton)
                    .addComponent(employeeSaveButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout employeePanelLayout = new javax.swing.GroupLayout(employeePanel);
        employeePanel.setLayout(employeePanelLayout);
        employeePanelLayout.setHorizontalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        employeePanelLayout.setVerticalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addSalaryPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel18.setText("Empleado:");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 12), new java.awt.Color(0, 153, 255))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setText("Valor:");

        salaryValueTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryValueTxtActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel14.setText("Fecha:");

        salaryDateDc.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salaryValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salaryDateDc, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(salaryValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(salaryDateDc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout testPanelLayout = new javax.swing.GroupLayout(testPanel);
        testPanel.setLayout(testPanelLayout);
        testPanelLayout.setHorizontalGroup(
            testPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );
        testPanelLayout.setVerticalGroup(
            testPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout addSalaryPanelLayout = new javax.swing.GroupLayout(addSalaryPanel);
        addSalaryPanel.setLayout(addSalaryPanelLayout);
        addSalaryPanelLayout.setHorizontalGroup(
            addSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addSalaryPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(addSalaryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salaryEmployeeNameTxt))
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addComponent(testPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addSalaryPanelLayout.setVerticalGroup(
            addSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSalaryPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(addSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(salaryEmployeeNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        salaryPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 12), new java.awt.Color(0, 153, 255))); // NOI18N
        jPanel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel15.setText("Nombre:");

        salaryEmployeeTxt.setEditable(false);
        salaryEmployeeTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel17.setText("Dirección:");

        salaryEmployeeAddressTxt.setEditable(false);
        salaryEmployeeAddressTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel9.setText("Teléfono:");

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel10.setText("Cargo:");

        salaryEmployeePhoneTxt.setEditable(false);
        salaryEmployeePhoneTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        salaryEmployeeJobTxt.setEditable(false);
        salaryEmployeeJobTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel16.setText("Identificación:");

        salaryEmployeeIdentificationTxt.setEditable(false);
        salaryEmployeeIdentificationTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salaryEmployeeAddressTxt)
                    .addComponent(salaryEmployeeTxt)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(salaryEmployeePhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salaryEmployeeIdentificationTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                    .addComponent(salaryEmployeeJobTxt))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(salaryEmployeeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryEmployeeAddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(salaryEmployeePhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(salaryEmployeeIdentificationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(salaryEmployeeJobTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout salaryEmployeeTablePanelLayout = new javax.swing.GroupLayout(salaryEmployeeTablePanel);
        salaryEmployeeTablePanel.setLayout(salaryEmployeeTablePanelLayout);
        salaryEmployeeTablePanelLayout.setHorizontalGroup(
            salaryEmployeeTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        salaryEmployeeTablePanelLayout.setVerticalGroup(
            salaryEmployeeTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout salaryPanelLayout = new javax.swing.GroupLayout(salaryPanel);
        salaryPanel.setLayout(salaryPanelLayout);
        salaryPanelLayout.setHorizontalGroup(
            salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(salaryEmployeeTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        salaryPanelLayout.setVerticalGroup(
            salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salaryEmployeeTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        salaryPaymentPanel.setBackground(new java.awt.Color(255, 255, 255));

        salaryPaymentOptionsBtg.add(salaryPaymentCompleteRb);
        salaryPaymentCompleteRb.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        salaryPaymentCompleteRb.setText("Salario completo");
        salaryPaymentCompleteRb.setEnabled(false);
        salaryPaymentCompleteRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryPaymentCompleteRbActionPerformed(evt);
            }
        });

        salaryPaymentOptionsBtg.add(salaryPaymentAdvanceRb);
        salaryPaymentAdvanceRb.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        salaryPaymentAdvanceRb.setText("Adelanto");
        salaryPaymentAdvanceRb.setEnabled(false);
        salaryPaymentAdvanceRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryPaymentAdvanceRbActionPerformed(evt);
            }
        });

        salaryPaymentAdvanceValueTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        salaryPaymentAdvanceValueTxt.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel19.setText("Valor:");

        jLabel23.setText("Fecha:");

        salaryPaymentDate.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel27.setText("Observaciones:");

        salaryPaymentObservationsTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        salaryPaymentObservationsTxt.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel28.setText("Horas Extras:");

        salaryPaymentExtraHoursTxt.setEditable(false);
        salaryPaymentExtraHoursTxt.setText("0.00");

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel22.setText("Otros Ingresos:");

        salaryPaymentOtherIncomesTxt.setEditable(false);
        salaryPaymentOtherIncomesTxt.setText("0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(salaryPaymentCompleteRb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salaryPaymentAdvanceRb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salaryPaymentAdvanceValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salaryPaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salaryPaymentObservationsTxt)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(salaryPaymentExtraHoursTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salaryPaymentOtherIncomesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(salaryPaymentAdvanceValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(salaryPaymentCompleteRb)
                        .addComponent(salaryPaymentAdvanceRb)
                        .addComponent(jLabel19))
                    .addComponent(salaryPaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(salaryPaymentObservationsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(salaryPaymentExtraHoursTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(salaryPaymentOtherIncomesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel20.setText("Empleado:");

        salaryPaymentEmployeeTxt.setEditable(false);
        salaryPaymentEmployeeTxt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel21.setText("Salario:");

        salaryPaymentValueTxt.setEditable(false);
        salaryPaymentValueTxt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        salaryPaymentValueTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        closeSalaryPaymentButton.setText("CERRAR");
        closeSalaryPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeSalaryPaymentButtonActionPerformed(evt);
            }
        });

        printSalaryPaymentButton.setText("IMPRIMIR");
        printSalaryPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printSalaryPaymentButtonActionPerformed(evt);
            }
        });

        payrollGenerateButton.setText("GENERAR ROL");
        payrollGenerateButton.setEnabled(false);
        payrollGenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payrollGenerateButtonActionPerformed(evt);
            }
        });

        demoCheck.setText("Demo");
        demoCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demoCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout salaryPaymentTablePanelLayout = new javax.swing.GroupLayout(salaryPaymentTablePanel);
        salaryPaymentTablePanel.setLayout(salaryPaymentTablePanelLayout);
        salaryPaymentTablePanelLayout.setHorizontalGroup(
            salaryPaymentTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salaryPaymentTablePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(demoCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(payrollGenerateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printSalaryPaymentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeSalaryPaymentButton)
                .addContainerGap())
        );
        salaryPaymentTablePanelLayout.setVerticalGroup(
            salaryPaymentTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryPaymentTablePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(salaryPaymentTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(closeSalaryPaymentButton, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(printSalaryPaymentButton, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(demoCheck)
                    .addComponent(payrollGenerateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel24.setText("Saldo:");

        salaryPaymentBalanceTxt.setEditable(false);
        salaryPaymentBalanceTxt.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        salaryPaymentBalanceTxt.setForeground(new java.awt.Color(255, 51, 0));
        salaryPaymentBalanceTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        removeSalaryPaymentButton.setText("REMOVER");
        removeSalaryPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSalaryPaymentButtonActionPerformed(evt);
            }
        });

        saveSalaryPaymentButton.setText("GUARDAR");
        saveSalaryPaymentButton.setEnabled(false);
        saveSalaryPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSalaryPaymentButtonActionPerformed(evt);
            }
        });

        newSalaryPaymentButton.setText("NUEVO");
        newSalaryPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSalaryPaymentButtonActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel26.setText("Mes:");

        salaryPaymentMonthChooser.setEnabled(false);

        salaryPaymentTable.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        salaryPaymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(salaryPaymentTable);

        javax.swing.GroupLayout salaryPaymentPanelLayout = new javax.swing.GroupLayout(salaryPaymentPanel);
        salaryPaymentPanel.setLayout(salaryPaymentPanelLayout);
        salaryPaymentPanelLayout.setHorizontalGroup(
            salaryPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salaryPaymentTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(salaryPaymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salaryPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(salaryPaymentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salaryPaymentEmployeeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salaryPaymentMonthChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salaryPaymentPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(salaryPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(salaryPaymentPanelLayout.createSequentialGroup()
                                .addComponent(newSalaryPaymentButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveSalaryPaymentButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeSalaryPaymentButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salaryPaymentValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salaryPaymentBalanceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        salaryPaymentPanelLayout.setVerticalGroup(
            salaryPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryPaymentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(salaryPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(salaryPaymentEmployeeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(salaryPaymentMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(salaryPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryPaymentBalanceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(salaryPaymentValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(removeSalaryPaymentButton)
                    .addComponent(saveSalaryPaymentButton)
                    .addComponent(newSalaryPaymentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salaryPaymentTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        employeePaymentItem.setText("Realizar Pago");
        employeePaymentItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeePaymentItemActionPerformed(evt);
            }
        });
        employeeOptionsPopupMenu.add(employeePaymentItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EMPLEADOS");
        setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        employeeTabView.setBackground(new java.awt.Color(255, 255, 255));
        employeeTabView.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                employeeTabViewStateChanged(evt);
            }
        });

        employeeFirstPanel.setBackground(new java.awt.Color(255, 255, 255));

        employeeTable.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                employeeTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(employeeTable);

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setText("Buscar Empleado:");

        javax.swing.GroupLayout employeeFirstPanelLayout = new javax.swing.GroupLayout(employeeFirstPanel);
        employeeFirstPanel.setLayout(employeeFirstPanelLayout);
        employeeFirstPanelLayout.setHorizontalGroup(
            employeeFirstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeFirstPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(employeeFirstPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        employeeFirstPanelLayout.setVerticalGroup(
            employeeFirstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeFirstPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(employeeFirstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );

        employeeTabView.addTab("Empleados", employeeFirstPanel);

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        employeeNewBt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        employeeNewBt.setText("NUEVO EMPLEADO");
        employeeNewBt.setFocusable(false);
        employeeNewBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        employeeNewBt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        employeeNewBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNewBtActionPerformed(evt);
            }
        });
        jToolBar1.add(employeeNewBt);

        payrollReportButton.setText("REPORTE ROL DE PAGOS");
        payrollReportButton.setFocusable(false);
        payrollReportButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        payrollReportButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        payrollReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payrollReportButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(payrollReportButton);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(employeeTabView, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeTabView)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateSalaryBalance() {

        if (this.salaryPaymentCompleteRb.isSelected()) {
            this.salaryPaymentService.getSalaryPayment().setSalaryPaymentValue(Double.valueOf(salaryPaymentValueTxt.getText()));
        } else {
            this.salaryPaymentService.getSalaryPayment().setSalaryPaymentValue(Double.valueOf(salaryPaymentAdvanceValueTxt.getText()));
        }
        this.salaryService.getSalary().setSalaryBalance(this.salaryService.getSalary().getSalaryBalance() - this.salaryPaymentService.getSalaryPayment().getSalaryPaymentValue());
        if (this.salaryService.getSalary().getSalaryBalance() == 0) {
            this.salaryService.getSalary().setSalaryState(1);
        }
        this.salaryPaymentBalanceTxt.setText(Operaciones.parteDecimal(Math.rint(this.salaryService.getSalary().getSalaryBalance() * auxTot) / auxTot, GeneralParameter.ACCURACY_VALUE));

        this.salaryService.updateSalary();
    }

    private void clearAddSalaryButtons() {
        salaryValueTxt.setText("");
        salaryDateDc.setDate(null);
    }

    private void clearSalaryPaymentButtons() {
        salaryPaymentAdvanceValueTxt.setText("");
        salaryPaymentDate.setDate(null);
        salaryPaymentObservationsTxt.setText("");
    }

    private void employeeTabViewStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_employeeTabViewStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeTabViewStateChanged

    private void salaryValueTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryValueTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryValueTxtActionPerformed

    private void updateSalaryTable() {
        this.salaryTableModel.setList(this.salaryService.getSalaryList());
        employeeSalaryTable.setModel(salaryTableModel);
        employeeSalaryTable.updateUI();
    }

    private void updateSalaryPaymentTable() {
        this.salaryPaymentTableModel.setList(this.salaryPaymentService.getSalaryPaymentList());
        this.salaryPaymentTable.setModel(salaryPaymentTableModel);
        this.salaryPaymentTable.updateUI();
    }

    private void addSalaryButtonControl() {
        employeeNewBt.setVisible(false);
    }

    private void commonsButtonsControl() {
        employeeNewBt.setVisible(true);
    }

    private void employeeSalaryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeSalaryTableMouseClicked
        // TODO add your handling code here:
//        if(evt.getClickCount() == 1){
//            System.out.println("" + this.salaryTableModel.getList().get(employeeSalaryTable.getSelectedRow()).getSalaryValue());
//        }

    }//GEN-LAST:event_employeeSalaryTableMouseClicked

    private void employeeNewBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeNewBtActionPerformed
        //Creamos una nueva instancia para un nuevo empleado
        this.employeeService.newInstance();
        employeeTabView.add(employeePanel);
        employeeTabView.setSelectedIndex(employeeTabView.getComponentCount() - 1);

        employeeTabView.setEnabledAt(employeeTabView.indexOfComponent(employeeFirstPanel), false);

        employeeTabView.setTitleAt(employeeTabView.getSelectedIndex(), "Nuevo Empleado");

        employeeNewBt.setEnabled(false);


    }//GEN-LAST:event_employeeNewBtActionPerformed

    private void salaryPaymentCompleteRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryPaymentCompleteRbActionPerformed
        // TODO add your handling code here:
        if (this.salaryPaymentCompleteRb.isSelected()) {
            this.salaryPaymentAdvanceValueTxt.setEnabled(false);
        }

    }//GEN-LAST:event_salaryPaymentCompleteRbActionPerformed

    private void salaryPaymentAdvanceRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryPaymentAdvanceRbActionPerformed
        // TODO add your handling code here:
        if (this.salaryPaymentAdvanceRb.isSelected()) {
            this.salaryPaymentAdvanceValueTxt.setEnabled(true);
        }
    }//GEN-LAST:event_salaryPaymentAdvanceRbActionPerformed

    private void employeeSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeSaveButtonActionPerformed
        // TODO add your handling code here:
        this.chargeEmployeeData();
        if (this.employeeService.getEmployee().getEmployeeId() == null) {
            if (this.employeeService.saveEmployee()) {
                JOptionPane.showMessageDialog(this, "Empleado creado correctamente");
                this.employeeTabView.remove(this.employeeTabView.getSelectedIndex());
                this.employeeNewBt.setEnabled(true);
                this.commonsButtonsControl();
                this.employeeService.addEmployeeToList(this.employeeService.getEmployee());
                employeeTable.updateUI();
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear un empleado");
            }
        } else if (this.employeeService.getEmployee().getEmployeeId() != null) {
            this.chargeEmployeeData();
            if (this.employeeService.updateEmployee()) {
                JOptionPane.showMessageDialog(this, "Empleado modificado correctamente");
                this.employeeTabView.remove(this.employeeTabView.getSelectedIndex());
                this.commonsButtonsControl();
                employeeTable.updateUI();
            }

        }

    }//GEN-LAST:event_employeeSaveButtonActionPerformed

    private void employeeTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMousePressed
        // TODO add your handling code here:
        tableOptionsPopup(evt);
    }//GEN-LAST:event_employeeTableMousePressed

    private void employeePaymentItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeePaymentItemActionPerformed
        // TODO add your handling code here:

        if (employeeTable.getSelectedRow() != -1) {
            this.employeeTabView.add(salaryPaymentPanel);
            this.employeeTabView.setSelectedIndex(employeeTabView.getComponentCount() - 1);
            this.employeeTabView.setTitleAt(employeeTabView.getSelectedIndex(), "Pago");

            employeeTabView.setEnabledAt(employeeTabView.indexOfComponent(employeeFirstPanel), false);

            this.salaryService.setInstance(this.salaryService.getSalaryByEmployee(this.employeeService.getEmployee()));

            this.salaryPaymentEmployeeTxt.setText(this.salaryService.getSalary().getEmployee().toString());
            this.salaryPaymentValueTxt.setText(String.valueOf(this.salaryService.getSalary().getSalaryValue()));

            this.salaryPaymentService.setSalaryPaymentList(this.salaryPaymentService.getSalaryPaymentListBySalaryMonth(this.salaryService.getSalary(), (salaryPaymentMonthChooser.getMonth() + 1)));
            this.updateSalaryPaymentTable();

            if (this.salaryService.getSalary().getSalaryBalance() != null) {
                this.salaryBalanceCalculate();
            } else {
                this.salaryService.getSalary().setSalaryBalance(this.salaryService.getSalary().getSalaryValue());
                this.salaryPaymentBalanceTxt.setText(String.valueOf(this.salaryService.getSalary().getSalaryBalance()));
            }
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado un salario");
        }

    }//GEN-LAST:event_employeePaymentItemActionPerformed

    private void newSalaryPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSalaryPaymentButtonActionPerformed
        // TODO add your handling code here:

        if (this.salaryPaymentBalanceTxt.getText().trim().equals("0.0")) {
            JOptionPane.showMessageDialog(this, "El sueldo ha sido cancelado en su totalidad");
            this.removeSalaryPaymentButton.setEnabled(false);
        } else {
            this.salaryPaymentService.newInstance();

            this.salaryPaymentCompleteRb.setEnabled(true);
            this.salaryPaymentAdvanceRb.setEnabled(true);
            this.salaryPaymentAdvanceValueTxt.setEnabled(true);
            this.salaryPaymentDate.setEnabled(true);
            this.salaryPaymentObservationsTxt.setEnabled(true);

            this.saveSalaryPaymentButton.setEnabled(true);
            this.removeSalaryPaymentButton.setEnabled(false);
            this.newSalaryPaymentButton.setEnabled(false);

        }
    }//GEN-LAST:event_newSalaryPaymentButtonActionPerformed

    private void saveSalaryPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSalaryPaymentButtonActionPerformed
        // TODO add your handling code here:
        if (Double.valueOf(salaryPaymentAdvanceValueTxt.getText().trim()) <= Double.valueOf(salaryPaymentBalanceTxt.getText().trim())) {
            this.chargeSalaryPaymentData();
            if (this.salaryPaymentService.saveSalaryPayment()) {
                JOptionPane.showMessageDialog(this, "Pago agregado correctamente");

                this.salaryPaymentService.addSalaryPaymentToList(this.salaryPaymentService.getSalaryPayment());
                this.salaryPaymentTable.updateUI();
                //Actualizamos el saldo del sueldo cuando hay un pago
                //this.updateSalaryBalance();
                this.salaryBalanceCalculate();
                //Creamos una nueva instancia del asiento contable
                this.accountingEntryService.newInstance();
                //Creamos un asiento contable con el pago del salario
                this.chargeAccountingEntryData(1);
                if (this.accountingEntryService.saveAccountingEntry()) {
                    System.out.println("El asiento contable ha sido guardado correctamente");
                }
                //Limpiamos todos los campos de la vista del pago del salario
                this.clearSalaryPaymentButtons();

                this.salaryPaymentCompleteRb.setEnabled(false);
                this.salaryPaymentAdvanceRb.setEnabled(false);
                this.salaryPaymentAdvanceValueTxt.setEnabled(false);
                this.salaryPaymentDate.setEnabled(false);
                this.salaryPaymentObservationsTxt.setEnabled(false);

                this.newSalaryPaymentButton.setEnabled(true);
                this.saveSalaryPaymentButton.setEnabled(false);
                this.removeSalaryPaymentButton.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "El valor es mayor al saldo");
        }
    }//GEN-LAST:event_saveSalaryPaymentButtonActionPerformed

    private void chargeAccountingEntryData(Integer itemType) {
        if (itemType == 0) {
            this.accountingEntryService.getAccountingEntry().setAeType(0);
            this.accountingEntryService.getAccountingEntry().setAeDescription("Se elimino el anticipo de sueldo de: " + salaryPaymentEmployeeTxt.getText());
            this.accountingEntryService.getAccountingEntry().setAeValue(this.salaryPaymentService.getSalaryPayment().getSalaryPaymentValue());
        } else {
            this.accountingEntryService.getAccountingEntry().setAeType(1);
            this.accountingEntryService.getAccountingEntry().setAeDescription("Anticipo de sueldo de: " + salaryPaymentEmployeeTxt.getText());
            this.accountingEntryService.getAccountingEntry().setAeValue(Double.parseDouble(this.salaryPaymentAdvanceValueTxt.getText()));
        }
        this.accountingEntryService.getAccountingEntry().setAeCreatedDate(new Date());
    }

    //Para calcular el saldo del sueldo restando basado en los anticipos que se han venido haciendo.
    private Double salaryBalanceCalculate() {
        Double salaryBalanceTotal = 0.0;
        for (int i = 0; i < this.salaryPaymentTableModel.getList().size(); i++) {
            salaryBalanceTotal += this.salaryPaymentTableModel.getList().get(i).getSalaryPaymentValue();
        }
        this.salaryService.getSalary().setSalaryBalance(this.salaryService.getSalary().getSalaryValue() - salaryBalanceTotal);
        this.salaryPaymentBalanceTxt.setText((this.salaryService.getSalary().getSalaryValue() - salaryBalanceTotal) + " ");

        return salaryBalanceTotal;
    }

    private void printSalaryPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printSalaryPaymentButtonActionPerformed
        // TODO add your handling code here:
        Report print = new Report();
        print.printEmployeeSalary(salaryService, salaryPaymentTableModel);
    }//GEN-LAST:event_printSalaryPaymentButtonActionPerformed

    private void closeSalaryPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeSalaryPaymentButtonActionPerformed
        // TODO add your handling code here:
        this.employeeTabView.remove(salaryPaymentPanel);
        this.employeeTabView.setEnabledAt(employeeTabView.indexOfComponent(employeeFirstPanel), true);

    }//GEN-LAST:event_closeSalaryPaymentButtonActionPerformed

    private void removeSalaryPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSalaryPaymentButtonActionPerformed
        // TODO add your handling code here:
        if (salaryPaymentTable.getSelectedRow() != -1) {
            //Fijamos la instancia del pago seleccionado para poder eliminarlo
            this.salaryPaymentService.setInstance(this.salaryPaymentTableModel.getList().get(salaryPaymentTable.getSelectedRow()));
            //Eliminamos el pago seleccionado
            this.salaryPaymentTableModel.getList().remove(salaryPaymentTable.getSelectedRow());
            //Actualizamos la tabla con los nuevos valores
            this.updateSalaryPaymentTable();
            //Actualizamos el saldo del sueldo
            this.salaryBalanceCalculate();
            if (this.salaryPaymentService.removeSalaryPayment()) {
                System.out.println("El pago ha sido eliminado correctamente");
                //Creamos una nueva instancia del asiento contable
                this.accountingEntryService.newInstance();
                //Cuando eliminamos un pago creamos un asiento contable tipo ingreso con el valor del pago
                this.chargeAccountingEntryData(0);
                if (this.accountingEntryService.saveAccountingEntry()) {
                    System.out.println("El asiento contable ha sido guardado correctamente");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningún item");
        }
    }//GEN-LAST:event_removeSalaryPaymentButtonActionPerformed

    private void employeeCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeCloseButtonActionPerformed
        // TODO add your handling code here:
        this.employeeTabView.remove(employeePanel);
        this.employeeTabView.setEnabledAt(employeeTabView.indexOfComponent(employeeFirstPanel), true);
        employeeNewBt.setEnabled(true);
    }//GEN-LAST:event_employeeCloseButtonActionPerformed

    private void employeeSalaryTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeSalaryTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeSalaryTxtActionPerformed

    private void payrollReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payrollReportButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_payrollReportButtonActionPerformed

    private void payrollGenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payrollGenerateButtonActionPerformed
        
        if(demoCheck.isSelected()){
        JOptionPane.showMessageDialog( null, "EL CUARTO SUELDO ES: "+Operaciones.fourteenthSalary()+"\n"
                + "EL DECIMO TERCER SUELDO ES: "+Operaciones.thirtheenSalary(Double.parseDouble(salaryPaymentValueTxt.getText()), Double.parseDouble("0.00"))+"\n"
                + "LA CONTRIBUCIÓN AL IESS ES: " +Operaciones.iessContribution(Double.parseDouble(salaryPaymentValueTxt.getText()), Double.parseDouble(salaryPaymentExtraHoursTxt.getText()))+"\n"
                + "TOTAL DE INGRESOS ES: " + Operaciones.totalSalaryIncome(Double.parseDouble(salaryPaymentValueTxt.getText()), Double.parseDouble("0.00"), Double.valueOf("0.00")));
        
        }else{
            if(this.payrollService.getPayroll().getPayrollId() == null){
                //Cargamos los datos del rol de pagos
                payrollChargeData();
                if(this.payrollService.savePayroll()){
                    JOptionPane.showMessageDialog(null, "El rol de pagos se ha generado correctamente");
                    Report report = new Report();
                    report.printPayrollReport(payrollService);
                }
            }
        }


    }//GEN-LAST:event_payrollGenerateButtonActionPerformed

    private void demoCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demoCheckActionPerformed
        // TODO add your handling code here:
        if(demoCheck.isSelected()){
            payrollGenerateButton.setEnabled(true);
        }
    }//GEN-LAST:event_demoCheckActionPerformed

    private void payrollChargeData() {
        Double salaryBalanceValue = salaryBalanceCalculate();
        Double iessContributionValue = Operaciones.iessContribution(Double.parseDouble(salaryPaymentValueTxt.getText()), Double.parseDouble(salaryPaymentExtraHoursTxt.getText()));
        Double totalIncome = Operaciones.totalSalaryIncome(Double.valueOf(salaryPaymentValueTxt.getText()), Double.valueOf(salaryPaymentExtraHoursTxt.getText()), Double.valueOf(salaryPaymentOtherIncomesTxt.getText()));

        this.payrollService.getPayroll().setEmployee(this.employeeService.getEmployee());
        this.payrollService.getPayroll().setPayrollDate(new Date());
        this.payrollService.getPayroll().setPayrollMonth(actualMonth);
        //Obtenemos los días trabajados y lo fijamos al Rol de Pagos
        this.payrollService.getPayroll().setPayRollWorkedDays(Operaciones.workedDays());
        this.payrollService.getPayroll().setPayrollBasicSalary(Double.parseDouble(salaryPaymentValueTxt.getText()));
        this.payrollService.getPayroll().setPayrollExtraHours(Double.parseDouble(salaryPaymentExtraHoursTxt.getText()));
        this.payrollService.getPayroll().setPayrollThirtheenSalary(Operaciones.thirtheenSalary(Double.parseDouble(salaryPaymentValueTxt.getText()), Double.parseDouble(salaryPaymentExtraHoursTxt.getText())));
        this.payrollService.getPayroll().setPayrollFourtteenthSalary(Operaciones.fourteenthSalary());
        this.payrollService.getPayroll().setPayrollOtherIncome(Double.parseDouble(salaryPaymentOtherIncomesTxt.getText()));
        this.payrollService.getPayroll().setPayrollTotalIncome(totalIncome);
        this.payrollService.getPayroll().setPayrollIessContribution(iessContributionValue);
        this.payrollService.getPayroll().setPayrollSalaryAdvance(salaryBalanceValue);
        this.payrollService.getPayroll().setPayrollTotalSalary(totalIncome - iessContributionValue - salaryBalanceValue);

        System.out.println("EL TOTAL A RECIBIR ES: " + this.payrollService.getPayroll().getPayrollTotalSalary() + " EL VALOR DE LOS ANTICIPOS SON: " + this.payrollService.getPayroll().getPayrollSalaryAdvance() + " MES: " + actualMonth);

    }

    private void tableOptionsPopup(java.awt.event.MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON3) {
            Point p = evt.getPoint();
            int rowNumber = employeeTable.rowAtPoint(p);
            ListSelectionModel modelo = employeeTable.getSelectionModel();
            modelo.setSelectionInterval(rowNumber, rowNumber);

            System.out.println("fila presionada " + employeeTable.getSelectedRow());
            //Cargamos una nueva instancia de un empleado
            this.employeeService.setInstance(this.employeeTableModel.getList().get(this.employeeTable.getSelectedRow()));

            employeeOptionsPopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            employeeOptionsPopupMenu.setVisible(true);
        }
    }

    private void chargeSalaryPaymentData() {
        if (salaryPaymentCompleteRb.isSelected()) {
            this.salaryPaymentService.getSalaryPayment().setSalaryPaymentValue(this.salaryService.getSalary().getSalaryValue());
        } else {
            this.salaryPaymentService.getSalaryPayment().setSalaryPaymentValue(Double.valueOf(this.salaryPaymentAdvanceValueTxt.getText()));
        }
        this.salaryPaymentService.getSalaryPayment().setSalaryPaymentDate(salaryPaymentDate.getDate());
        this.salaryPaymentService.getSalaryPayment().setSalaryPaymentObservation(salaryPaymentObservationsTxt.getText());
        this.salaryPaymentService.getSalaryPayment().setSalary(this.salaryService.getSalary());
    }

    private void chargeEmployeeView() {
        this.employeeFirstNameTxt.setText(this.employeeService.getEmployee().getEmployeeFirstName());
        this.employeeLastNameTxt.setText(this.employeeService.getEmployee().getEmployeeLastName());
        this.employeeAddressTxt.setText(this.employeeService.getEmployee().getEmployeeAddress());
        this.employeePhoneTxt.setText(this.employeeService.getEmployee().getEmployeePhone());
        this.employeeEmailTxt.setText(this.employeeService.getEmployee().getEmployeeEmail());
        this.employeeIdentificationTxt.setText(this.employeeService.getEmployee().getEmployeeIdentification());
        this.employeeJobTxt.setText(this.employeeService.getEmployee().getEmployeeJob());
        this.employeeHireDateDC.setDate(this.employeeService.getEmployee().getEmployeeHireDate());
        if (this.employeeService.getEmployee().getEmployeeHireDate() != null) {
            this.employeeDepartureDateDc.setDate(this.employeeService.getEmployee().getEmployeeDepartureDate());
        }
    }

    private void addEmployeeSalaryTable(JPanel panel) {
        employeeSalaryTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {},
                    {},
                    {},
                    {}
                },
                new String[]{}
        ));
        employeeSalaryTableScroll.setViewportView(employeeSalaryTable);

        javax.swing.GroupLayout testPanelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(testPanelLayout);
        testPanelLayout.setHorizontalGroup(
                testPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(employeeSalaryTableScroll)
        );
        testPanelLayout.setVerticalGroup(
                testPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(testPanelLayout.createSequentialGroup()
                                .addComponent(employeeSalaryTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addSalaryPanel;
    private javax.swing.JButton closeSalaryPaymentButton;
    private javax.swing.JCheckBox demoCheck;
    private javax.swing.JTextField employeeAddressTxt;
    private javax.swing.JButton employeeCloseButton;
    private com.toedter.calendar.JDateChooser employeeDepartureDateDc;
    private javax.swing.JTextField employeeEmailTxt;
    private javax.swing.JTextField employeeFirstNameTxt;
    private javax.swing.JPanel employeeFirstPanel;
    private com.toedter.calendar.JDateChooser employeeHireDateDC;
    private javax.swing.JTextField employeeIdentificationTxt;
    private javax.swing.JTextField employeeJobTxt;
    private javax.swing.JTextField employeeLastNameTxt;
    private javax.swing.JButton employeeNewBt;
    private javax.swing.JPopupMenu employeeOptionsPopupMenu;
    private javax.swing.JPanel employeePanel;
    private javax.swing.JMenuItem employeePaymentItem;
    private javax.swing.JTextField employeePhoneTxt;
    private javax.swing.JTable employeeSalaryTable;
    private javax.swing.JScrollPane employeeSalaryTableScroll;
    private javax.swing.JTextField employeeSalaryTxt;
    private javax.swing.JButton employeeSaveButton;
    private javax.swing.JTabbedPane employeeTabView;
    private javax.swing.JTable employeeTable;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton newSalaryPaymentButton;
    private javax.swing.JButton payrollGenerateButton;
    private javax.swing.JButton payrollReportButton;
    private javax.swing.JButton printSalaryPaymentButton;
    private javax.swing.JButton removeSalaryPaymentButton;
    private com.toedter.calendar.JDateChooser salaryDateDc;
    private javax.swing.JTextField salaryEmployeeAddressTxt;
    private javax.swing.JTextField salaryEmployeeIdentificationTxt;
    private javax.swing.JTextField salaryEmployeeJobTxt;
    private javax.swing.JTextField salaryEmployeeNameTxt;
    private javax.swing.JTextField salaryEmployeePhoneTxt;
    private javax.swing.JPanel salaryEmployeeTablePanel;
    private javax.swing.JTextField salaryEmployeeTxt;
    private javax.swing.JPanel salaryPanel;
    private javax.swing.JRadioButton salaryPaymentAdvanceRb;
    private javax.swing.JTextField salaryPaymentAdvanceValueTxt;
    private javax.swing.JTextField salaryPaymentBalanceTxt;
    private javax.swing.JRadioButton salaryPaymentCompleteRb;
    private com.toedter.calendar.JDateChooser salaryPaymentDate;
    private javax.swing.JTextField salaryPaymentEmployeeTxt;
    private javax.swing.JTextField salaryPaymentExtraHoursTxt;
    private com.toedter.calendar.JMonthChooser salaryPaymentMonthChooser;
    private javax.swing.JTextField salaryPaymentObservationsTxt;
    private javax.swing.ButtonGroup salaryPaymentOptionsBtg;
    private javax.swing.JTextField salaryPaymentOtherIncomesTxt;
    private javax.swing.JPanel salaryPaymentPanel;
    private javax.swing.JTable salaryPaymentTable;
    private javax.swing.JPanel salaryPaymentTablePanel;
    private javax.swing.JTextField salaryPaymentValueTxt;
    private javax.swing.JTextField salaryValueTxt;
    private javax.swing.JButton saveSalaryPaymentButton;
    private javax.swing.JPanel testPanel;
    // End of variables declaration//GEN-END:variables
}
