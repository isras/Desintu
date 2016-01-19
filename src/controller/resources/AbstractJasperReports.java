/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.resources;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.Map;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author eyetive
 */
public abstract class AbstractJasperReports {

    private static JasperReport report;
    private static JasperPrint reportFilled;
    private static JasperViewer viewer;
    private static JDialog preview;

    public static void createReport(Connection connection, String path, Map<String, Object> parameters, JRTableModelDataSource dataSource) {
        try {
            report = (JasperReport) JRLoader.loadObjectFromFile(path);
            reportFilled = JasperFillManager.fillReport(report, parameters, dataSource);
        } catch (JRException e) {
            System.out.println(e);
        }
    }

    public static void showViewer(String title) {

        viewer = new JasperViewer(reportFilled, false);
        preview = new JDialog(viewer, true);
        preview.setTitle(title);
        preview.setContentPane(viewer.getContentPane());
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        preview.setBounds(100, 100, d.width - 200, d.height - 200);
        preview.setLocationRelativeTo(null);
        preview.validate();
        preview.setVisible(true);
        //viewer.setVisible(true);
    }

}
