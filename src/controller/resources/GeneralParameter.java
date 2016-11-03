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
    public static int QUOTATION_NUMBER;
    public static int WORK_ORDER_NUMBER;
    public static boolean SHOW_PRINT_PREVIEW;
    public static int SIMPLE_SERVICE_VALUE;
    public static int MEDIUM_SERVICE_VALUE;
    public static int COMPLEX_SERVICE_VALUE;
    public static int PUBLICIST_PRINT_DISCOUNT_VALUE;
    public static int  PUBLICIST_FINISHED_DISCOUNT_VALUE;
    public static int PUBLICIST_SERVICE_DISCOUNT_VALUE;
    public static double PERSONAL_INSURANCE_CONTRIBUTION;
    public static double BASIC_SALARY;
    
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
            QUOTATION_NUMBER = ss.getSetting().getQUOTATION_NUMBER();
            WORK_ORDER_NUMBER = ss.getSetting().getWORK_ORDER_NUMBER();
            SHOW_PRINT_PREVIEW = ss.getSetting().getSHOW_PRINT_PREVIEW();
            SIMPLE_SERVICE_VALUE = ss.getSetting().getSIMPLE_SERVICE_VALUE();
            MEDIUM_SERVICE_VALUE = ss.getSetting().getMEDIUM_SERVICE_VALUE();
            COMPLEX_SERVICE_VALUE = ss.getSetting().getCOMPLEX_SERVICE_VALUE();
            PUBLICIST_PRINT_DISCOUNT_VALUE = ss.getSetting().getPUBLICIST_PRINT_DISCOUNT_VALUE();
            PUBLICIST_FINISHED_DISCOUNT_VALUE = ss.getSetting().getPUBLICIST_FINISHED_DISCOUNT_VALUE();
            PUBLICIST_SERVICE_DISCOUNT_VALUE = ss.getSetting().getPUBLICIST_SERVICE_DISCOUNT_VALUE();            
            PERSONAL_INSURANCE_CONTRIBUTION = ss.getSetting().getPERSONAL_INSURANCE_CONTRIBUTION();
            BASIC_SALARY = ss.getSetting().getBASIC_SALARY();
            
        } else {       
            JOptionPane.showMessageDialog(null, "Deberá configurar los parámetros del software\npara su correcto funcionamiento","SIN CONFIGURACIÓN",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}