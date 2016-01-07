package controller.resources;

import controller.Sessions;
import controller.service.CashClosingService;
import controller.service.InvoiceService;
import controller.service.WorkOrderService;
import model.Person;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.Sellnote;
import net.sf.jasperreports.engine.JREmptyDataSource;
import views.tableModel.InventoryTableModel;
import views.tableModel.AccountingEntryTableModel;
import views.tableModel.CCDeliveryNoteTableModel;
import views.tableModel.CCFactureTableModel;
import views.tableModel.CCPetitionNoteTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import views.tableModel.DetailTableModel;

/**
 *
 * @author Isra
 */
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
        parameters.put("nombreCliente", wos.getWorkOrder().getPerson().toString());
        parameters.put("rucCliente", wos.getWorkOrder().getPerson().getPrIdentification());
        parameters.put("dirCliente", wos.getWorkOrder().getPerson().getPrAddress());
        parameters.put("telfCliente", wos.getWorkOrder().getPerson().getPrPhone());
        parameters.put("subtotal", String.valueOf(wos.getWorkOrder().getWorkOrderAdvance()));
        parameters.put("subtotalIva", String.valueOf(wos.getWorkOrder().getWorkOrderBalance()));
        parameters.put("total", String.valueOf(wos.getWorkOrder().getWorkOrderTotal()));

        JRTableModelDataSource dataSource = new JRTableModelDataSource(dtm);
        AbstractJasperReports.createReport(conn, path, parameters, dataSource);
        AbstractJasperReports.showViewer("ORDEN DE TRABAJO - PREVIEW");
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
