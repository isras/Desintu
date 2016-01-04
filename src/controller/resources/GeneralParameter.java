/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.resources;

import controller.service.SettingService;
import javax.swing.JOptionPane;

public class GeneralParameter {

    public static double IVA_VALUE;
    public static int ACCURACY_VALUE;
    public static String AUTHORIZATION_NUMBER;
    public static String FIRST_INVOICE_NUMBER;
    public static String SECOND_INVOICE_NUMBER;
    public static String THIRD_INVOICE_NUMBRE;
    public static boolean SHOW_PRINT_PREVIEW;
    public static double CANVAS_PRINT_VALUE;
    public static double VYNIL_PRINT_VALUE;
    public static int SIMPLE_SERVICE_VALUE;
    public static int MEDIUM_SERVICE_VALUE;
    public static int COMPLEX_SERVICE_VALUE;
    public static int PUBLICIST_PRINT_DISCOUNT_VALUE;
    public static int  PUBLICIST_FINISHED_DISCOUNT_VALUE;
    public static int PUBLICIST_SERVICE_DISCOUNT_VALUE;

    public static void chargeSetting() {
        SettingService ss = new SettingService();
        if (ss.getUniqueSetting().getSettingId() != null) {
            
            ss.setInstance(ss.getUniqueSetting());

            IVA_VALUE = Double.valueOf("1." + ss.getSetting().getIVA_VALUE().intValue());
            ACCURACY_VALUE = ss.getSetting().getACCURACY_VALUE();
            AUTHORIZATION_NUMBER = ss.getSetting().getAUTHORIZATION_NUMBER();
            FIRST_INVOICE_NUMBER = ss.getSetting().getFIRST_INVOICE_NUMBER();
            SECOND_INVOICE_NUMBER = ss.getSetting().getSECOND_INVOICE_NUMBER();
            THIRD_INVOICE_NUMBRE = ss.getSetting().getTHIRD_INVOICE_NUMBER();
            SHOW_PRINT_PREVIEW = ss.getSetting().getSHOW_PRINT_PREVIEW();
            CANVAS_PRINT_VALUE = ss.getSetting().getCANVAS_PRINT_VALUE();
            VYNIL_PRINT_VALUE = ss.getSetting().getVYNIL_PRINT_VALUE();
            SIMPLE_SERVICE_VALUE = ss.getSetting().getSIMPLE_SERVICE_VALUE();
            MEDIUM_SERVICE_VALUE = ss.getSetting().getMEDIUM_SERVICE_VALUE();
            COMPLEX_SERVICE_VALUE = ss.getSetting().getCOMPLEX_SERVICE_VALUE();
            PUBLICIST_PRINT_DISCOUNT_VALUE = ss.getSetting().getPUBLICIST_PRINT_DISCOUNT_VALUE();
            PUBLICIST_FINISHED_DISCOUNT_VALUE = ss.getSetting().getPUBLICIST_FINISHED_DISCOUNT_VALUE();
            PUBLICIST_SERVICE_DISCOUNT_VALUE = ss.getSetting().getPUBLICIST_SERVICE_DISCOUNT_VALUE();
            
        } else {       
            JOptionPane.showMessageDialog(null, "Deberá configurar los parámetros del software\npara su correcto funcionamiento","SIN CONFIGURACIÓN",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
