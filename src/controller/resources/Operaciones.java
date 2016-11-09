package controller.resources;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class Operaciones {

    //Para saber que JRadioButton esta seleccionado del button group
    public static JRadioButton getSelection(ButtonGroup group) {
        for (Enumeration e = group.getElements(); e.hasMoreElements();) {
            JRadioButton b = (JRadioButton) e.nextElement();
            if (b.getModel() == group.getSelection()) {
                return b;
            }
        }

        return null;
    }

    public static JButton getSelectionButton(ButtonGroup group) {
        for (Enumeration e = group.getElements(); e.hasMoreElements();) {
            JButton b = (JButton) e.nextElement();
            if (b.getModel() == group.getSelection()) {
                b.setSelected(true);
                return b;
            } else {
                b.setSelected(false);
                return b;
            }
        }

        return null;
    }

    public static java.sql.Date formatearDate(String fecha) {
        int dd, mm, yy;

        dd = Integer.parseInt(fecha.charAt(0) + "" + fecha.charAt(1));
        mm = Integer.parseInt(fecha.charAt(3) + "" + fecha.charAt(4)) - 1;
        yy = Integer.parseInt(fecha.charAt(6) + "" + fecha.charAt(7) + "" + fecha.charAt(8) + "" + fecha.charAt(9)) - 1900;

        return (new java.sql.Date(yy, mm, dd));
    }

    public static String formatearFecha(JDateChooser fec) {
        String aux;
        Date s = fec.getDate();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String cadenafecha = formato.format(s);
        aux = cadenafecha;
        return aux;
    }

    public static Time getTime() {
        Calendar Calendario = Calendar.getInstance();

//        String año = Integer.toString(Calendario.get(Calendar.YEAR));
//        String mes = Integer.toString(Calendario.get(Calendar.MONTH) + 1);
//        String dia = Integer.toString(Calendario.get(Calendar.DATE));
        int hora = Calendario.get(Calendar.HOUR);
        int minuto = Calendario.get(Calendar.MINUTE);
        int segundo = Calendario.get(Calendar.SECOND);
        return (new Time(hora, minuto, segundo));
    }

    public static Time formatearHora(String hora) {
        int h, m, s;
        h = Integer.parseInt(hora.charAt(0) + "" + hora.charAt(1));
        m = Integer.parseInt(hora.charAt(3) + "" + hora.charAt(4));
        s = Integer.parseInt(hora.charAt(6) + "" + hora.charAt(7));
        return (new Time(h, m, s));
    }

    public static void soloNumerosDecimales(java.awt.event.KeyEvent evt, String s) {
        if (evt.getKeyChar() == '.' && s.contains(".")) {
            evt.consume();
            return;
        }
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)) {
            if (caracter != '.') {
                evt.consume();
            }
        }
    }

    public static String parteDecimal(double d, int numDecimal) {
        String este = d + "";
        String val = "";
        for (int i = 0; i < numDecimal; i++) {
            val = val + 1;
        }
        //System.out.println("El valor es:" + val);
        int num = Integer.parseInt(val);
        for (int i = 0; i < este.length(); i++) {
            if (este.charAt(i) == '.') {
                int n = Integer.parseInt(este.substring(i + 1));
                if (n < num && este.substring(i + 1).length() < numDecimal) {
                    for (int j = este.substring(i + 1).length(); j < numDecimal; j++) {
                        este = este + "0";
                    }
                }
                break;
            }
        }
        return este;
    }

    public static double formatToDecimales(double valor, int numberDecimal) {
        BigDecimal big = new BigDecimal(valor);
        big = big.setScale(numberDecimal, RoundingMode.HALF_UP);
        return big.doubleValue();
    }

    /**
     * Da formato a una fecha recibida, en el siguiente orden 'Dddddd dd de
     * Mmmmm de yyyy'
     *
     * @param fecha
     * @return
     */
    public static String formFechaToLarge(Date fecha) {
        int dia = fecha.getDate();
        int mes = fecha.getMonth();
        int año = fecha.getYear() + 1900;
        int diasem = fecha.getDay();

        String fec = getDia(diasem) + " " + dia + " de " + getMes(mes) + " de " + año;

        return fec;
    }

    public static String getDia(int dia) {
        switch (dia) {
            case 1:
                return "Lunes";
            case 2:
                return "Martes";
            case 3:
                return "Miércoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            case 6:
                return "Sábado";
            case 0:
                return "Domingo";
            default:
                return "Error";
        }
    }

    public static String getMes(int mes) {
        switch (mes) {
            case 0:
                return "Enero";
            case 1:
                return "Febrero";
            case 2:
                return "Marzo";
            case 3:
                return "Abril";
            case 4:
                return "Mayo";
            case 5:
                return "Junio";
            case 6:
                return "Julio";
            case 7:
                return "Agosto";
            case 8:
                return "Septiembre";
            case 9:
                return "Octubre";
            case 10:
                return "Noviembre";
            case 11:
                return "Diciembre";
            default:
                return "Error";
        }
    }

    /**
     * Da formato a la fecha recibida en el siguiente orden 'yyyy-mm-dd'
     */
    public static String formatDate(Date date) {
        int dia = date.getDate();
        int mes = date.getMonth() + 1;
        int año = date.getYear() + 1900;
        String fecha = año + "-" + mes + "-" + dia;
        return fecha;
    }

    public static TableCellRenderer getRenderCellToRigth() {
        TableCellRenderer render = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                //aqui obtengo el render de la calse superior
                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                //Alineo, puedes alinear cambiar fondo etc, solo seria cuention de validar fia, columna
                //si esta seleccionana, depende de tu necesidad
                l.setHorizontalAlignment(SwingConstants.RIGHT);
                if (hasFocus) {
                    l.setForeground(Color.RED);
                } else {
                    l.setForeground(Color.BLACK);
                }
                return l;
            }
        };
        return render;
    }

    public static TableCellRenderer getRenderCellCenter() {
        TableCellRenderer render = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                //aqui obtengo el render de la calse superior
                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                //Alineo, puedes alinear cambiar fondo etc, solo seria cuention de validar fia, columna
                //si esta seleccionana, depende de tu necesidad
                l.setHorizontalAlignment(SwingConstants.CENTER);
                if (hasFocus) {
                    l.setForeground(Color.RED);
                } else {
                    l.setForeground(Color.BLACK);
                }
                return l;
            }
        };
        return render;
    }

    public static TableCellRenderer getRenderCellToLeft() {
        TableCellRenderer render = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                //aqui obtengo el render de la calse superior
                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                //Alineo, puedes alinear cambiar fondo etc, solo seria cuention de validar fia, columna
                //si esta seleccionana, depende de tu necesidad
                l.setHorizontalAlignment(SwingConstants.LEFT);
                if (hasFocus) {
                    l.setForeground(Color.RED);
                } else {
                    l.setForeground(Color.BLACK);
                }
                return l;
            }
        };
        return render;
    }

    public static TableCellRenderer getRenderCellToColor(final Color color) {
        TableCellRenderer render = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                //aqui obtengo el render de la calse superior
                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                //Alineo, puedes alinear cambiar fondo etc, solo seria cuention de validar fia, columna
                //si esta seleccionana, depende de tu necesidad
                //l.setHorizontalAlignment(SwingConstants.RIGHT);
                if (hasFocus) {
                    l.setBackground(new Color(255, 60, 255));
                } else {
                    l.setForeground(Color.BLACK);
                }
                l.setBackground(color);

                return l;
            }
        };
        return render;
    }

    //Para obtener el ultimo día del mes
    public static int lastDayOfTheMonth(int year, int month) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    }

    public static int workedDays() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    public static Double iessContribution(Double basicSalary, Double extraHours) {
        return formatToDecimales(((basicSalary + extraHours) * GeneralParameter.PERSONAL_INSURANCE_CONTRIBUTION) / 100, GeneralParameter.ACCURACY_VALUE);
    }
    
    public static Double thirtheenSalary(Double salary, Double extraHours){
        return formatToDecimales((salary + extraHours) / 12, GeneralParameter.ACCURACY_VALUE);
    }

    public static Double fourteenthSalary() {
        Double fourteenthSalaryValue = GeneralParameter.BASIC_SALARY / 12;
        //Controlamos si los dias trabajados son mayores a 30 y si el valor es
        //31 fijamos el valor en 30
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        //Verificamos si el mes es Febrero y si es el ultimo día del mes y
        //igualamos el valor del dia a 30
        if (month == 2 && day == 28) {
            day = 30;
        }
        //Verficamos si el dia es mayor a 30, si lo es fijamos el valor a 30
        if (day > 30) {
            day = 30;
        }
        Double fourteenthSalaryDayValue = (fourteenthSalaryValue / 30) * day;
        return formatToDecimales(fourteenthSalaryDayValue, GeneralParameter.ACCURACY_VALUE);
    }
    
    public static Double totalSalaryIncome(Double salary, Double extraHours, Double otherIncomes){
        return formatToDecimales((salary + extraHours + thirtheenSalary(salary, extraHours) + fourteenthSalary() + otherIncomes), GeneralParameter.ACCURACY_VALUE);
    }
}
