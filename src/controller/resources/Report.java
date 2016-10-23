package controller.resources;

import controller.Sessions;
import controller.service.CashClosingService;
import controller.service.InvoiceService;
import controller.service.QuotationService;
import controller.service.SalaryService;
import controller.service.WorkOrderService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import views.tableModel.InventoryTableModel;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import views.tableModel.DetailTableModel;
import views.tableModel.SalaryPaymentTableModel;

public class Report {

    private Connection conn;

    public Report() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //se carga el driver
            String url = "jdbc:mysql://localhost/desintu";
            conn = DriverManager.getConnection(url, "root", "Eyetive@2015");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("errrrrrrrrrrrrrrrrrror: " + ex);
        }
    }

    public void printInvoice(InvoiceService invs, DetailTableModel dtm) {

        String path = System.getProperty("user.dir") + "/reports/InvoiceEyetiveReport.jasper";

        Map parameters = new HashMap();
        parameters.put("nombreCliente", "" + invs.getInvoice().getPerson().toString());
        parameters.put("rucCliente", "" + invs.getInvoice().getPerson().getPrIdentification());
        parameters.put("dirCliente", "" + invs.getInvoice().getPerson().getPrAddress());
        parameters.put("telfCliente", "" + invs.getInvoice().getPerson().getPrPhone());
        parameters.put("subtotal", String.valueOf(invs.getInvoice().getInSubtotal()));
        parameters.put("subtotalIvaZero", String.valueOf(invs.getInvoice().getInSubtotalIvazero()));
        parameters.put("subtotalIva", String.valueOf(invs.getInvoice().getInSubtotalIva()));
        parameters.put("iva", String.valueOf(invs.getInvoice().getInIva()));
        parameters.put("total", String.valueOf(invs.getInvoice().getInTotal()));
        parameters.put("efectivo", String.valueOf(invs.getInvoice().getInCash()));
        parameters.put("cambio", String.valueOf(invs.getInvoice().getInChange()));

        JRTableModelDataSource dataSource = new JRTableModelDataSource(dtm);
        AbstractJasperReports.createReport(conn, path, parameters, dataSource);
        AbstractJasperReports.showViewer("FACTURA DE VENTA - PREVIEW");

    }

    public void printWorkOrder(WorkOrderService wos, DetailTableModel dtm) {

        String path = System.getProperty("user.dir") + "/reports/Invoice360Report.jasper";

        Map parameters = new HashMap();
        parameters.put("orderNumber",wos.getWorkOrder().getWorkOrderNumber());
        parameters.put("nombreCliente", wos.getWorkOrder().getPerson().toString());
        parameters.put("rucCliente", wos.getWorkOrder().getPerson().getPrIdentification());
        parameters.put("dirCliente", wos.getWorkOrder().getPerson().getPrAddress());
        parameters.put("telfCliente", wos.getWorkOrder().getPerson().getPrPhone());
        parameters.put("subtotal", String.valueOf(wos.getWorkOrder().getWorkOrderAdvance()));
        parameters.put("subtotalIva", String.valueOf(wos.getWorkOrder().getWorkOrderBalance()));
        parameters.put("total", String.valueOf(wos.getWorkOrder().getWorkOrderTotal()));
        parameters.put("orderDiscount",String.valueOf(wos.getWorkOrder().getWorkOrderDiscount()));
        parameters.put("efectivo",String.valueOf(wos.getWorkOrder().getWorkOrderCash()));
        parameters.put("cambio", String.valueOf(wos.getWorkOrder().getWorkOrderChange()));

        JRTableModelDataSource dataSource = new JRTableModelDataSource(dtm);
        AbstractJasperReports.createReport(conn, path, parameters, dataSource);
        AbstractJasperReports.showViewer("ORDEN DE TRABAJO - PREVIEW");
    }
    
    public void printEmployeeSalary(SalaryService salaryService, SalaryPaymentTableModel salaryPaymentTableModel) {

        String path = System.getProperty("user.dir") + "/reports/EmployeePaymentRol.jasper";

        Map parameters = new HashMap();
        parameters.put("employee_name",salaryService.getSalary().getEmployee().toString());
        parameters.put("employee_address", salaryService.getSalary().getEmployee().getEmployeeAddress());
        parameters.put("employee_phone", salaryService.getSalary().getEmployee().getEmployeePhone());
        parameters.put("employee_salary", salaryService.getSalary().toString());
        parameters.put("employee_salary_balance", salaryService.getSalary().getSalaryBalance().toString());
        parameters.put("employee_payment_month", salaryService.getSalary().getSalaryDate().toString());

        JRTableModelDataSource dataSource = new JRTableModelDataSource(salaryPaymentTableModel);
        AbstractJasperReports.createReport(conn, path, parameters, dataSource);
        AbstractJasperReports.showViewer("ROL DE PAGOS - PREVIEW");
    }

    public void printQuotation(QuotationService quotationService, DetailTableModel dtm) {

        String path = System.getProperty("user.dir") + "/reports/QuotationReport.jasper";
        String imagePath = System.getProperty("user.dir");

        Map parameters = new HashMap();
        parameters.put("customer_name", quotationService.getQuotation().getPerson().toString());
        parameters.put("customer_identification", quotationService.getQuotation().getPerson().getPrIdentification());
        parameters.put("customer_address", quotationService.getQuotation().getPerson().getPrAddress());
        //parameters.put("telfCliente", quotationService.getQuotation().getPerson().getPrPhone());
        parameters.put("quotation_date", quotationService.getQuotation().getQuotationDate());
        parameters.put("IMAGE_PATH", imagePath);
        parameters.put("QUOTATION_NUMBER", quotationService.getQuotation().getQuotationNumber());
        parameters.put("SUBTOTAL", String.valueOf(quotationService.getQuotation().getQuotationSubtotal()));
        parameters.put("IVA", String.valueOf(quotationService.getQuotation().getQuotationIva()));
        parameters.put("TOTAL", String.valueOf(quotationService.getQuotation().getQuotationTotal()));

        JRTableModelDataSource dataSource = new JRTableModelDataSource(dtm);
        AbstractJasperReports.createReport(conn, path, parameters, dataSource);
        AbstractJasperReports.showViewer("PROFORMA - PREVIEW");
    }

    public void printClosingCash(CashClosingService ccs) {

        String path = System.getProperty("user.dir") + "/reports/CashClosingReport.jasper";

        Map parameters = new HashMap();
        parameters.put("fromDate", Operaciones.formatDate(ccs.getCashClosing().getCcDateFrom()));
        parameters.put("upToDate", Operaciones.formatDate(ccs.getCashClosing().getCcDateTo()));
        parameters.put("cashInitValue", String.valueOf(ccs.getCashClosing().getCcInitialCashValue()));
        parameters.put("cashBillTotal", String.valueOf(ccs.getCashClosing().getCcTotalCash()));
        parameters.put("checksTotal", String.valueOf(ccs.getCashClosing().getCcTotalCheks()));
        parameters.put("creditCardTotal", String.valueOf(ccs.getCashClosing().getCcTotalCreditCard()));
        parameters.put("debitCardTotal", String.valueOf(ccs.getCashClosing().getCcTotalDebitCard()));
        parameters.put("inflowTotal", String.valueOf(ccs.getCashClosing().getCcTotalInflow()));
        parameters.put("outflowTotal", String.valueOf(ccs.getCashClosing().getCcTotalOutflow()));
        parameters.put("receivableAccountsTotal", String.valueOf(ccs.getCashClosing().getCcTotalReceivableAccounts()));
        parameters.put("cashTotal", String.valueOf(ccs.getCashClosing().getCcTotal()));
        parameters.put("user", Sessions.getUser().getUsrName());

        JRTableModelDataSource dataSource = new JRTableModelDataSource(null);
        AbstractJasperReports.createReport(conn, path, parameters, dataSource);
        AbstractJasperReports.showViewer("CIERRE DE CAJA - PREVIEW");
    }

    public void printInventory(InventoryTableModel itm) {

        String path = System.getProperty("user.dir") + "/reports/CashClosingReport.jasper";

        Map parameters = new HashMap();

        parameters.put("enterpriseName", "REPORTE DE INVENTARIO");

        JRTableModelDataSource dataSource = new JRTableModelDataSource(itm);
        AbstractJasperReports.createReport(conn, path, parameters, dataSource);
        AbstractJasperReports.showViewer("INVENTARIO - PREVIEW");
    }
}