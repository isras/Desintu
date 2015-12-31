package views.tableModel;

import controller.resources.GeneralParameter;
import controller.resources.Operaciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.ClosingCash;

public class ClosingCashTableModel extends AbstractTableModel {

    private List<ClosingCash> list = new ArrayList<>();
    private final double accuracyVal = Math.pow(10, GeneralParameter.ACCURACY_VALUE);

    /**
     * @return the list
     */
    public List<ClosingCash> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<ClosingCash> list) {
        this.list = list;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        ClosingCash cashClosing = this.list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return String.valueOf(rowIndex + 1);
            case 1:
                return Operaciones.formFechaToLarge(cashClosing.getCcDateFrom());
            case 2:
                return Operaciones.formFechaToLarge(cashClosing.getCcDateTo());
//            case 3:
//                return String.valueOf(Operaciones.parteDecimal(cashClosing.getCcInitialCashValue(), 2));
//            case 4:
//                return String.valueOf(Operaciones.parteDecimal(cashClosing.getCcTotalCash(), 2));
//            case 5:
//                return String.valueOf(Operaciones.parteDecimal(cashClosing.getCcTotalCheks(), 2));
//            case 6:
//                return String.valueOf(Operaciones.parteDecimal(cashClosing.getCcTotalCreditCard(), 2));
//            case 7:
//                return String.valueOf(Operaciones.parteDecimal(cashClosing.getCcTotalDebitCard(), 2));
            case 3:
                return String.valueOf(Operaciones.parteDecimal(Math.rint(cashClosing.getCcTotalInflow() * accuracyVal)/accuracyVal, GeneralParameter.ACCURACY_VALUE));
            case 4:
                return String.valueOf(Operaciones.parteDecimal(Math.rint(cashClosing.getCcTotalOutflow()*accuracyVal)/accuracyVal, GeneralParameter.ACCURACY_VALUE));
//            case 10:
//                return String.valueOf(Operaciones.parteDecimal(cashClosing.getCcTotalReceivableAccounts(), 2));
            case 5:
                return String.valueOf(Operaciones.parteDecimal(Math.rint(cashClosing.getCcTotal() * accuracyVal)/accuracyVal, GeneralParameter.ACCURACY_VALUE));
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "N°.";
            case 1:
                return "Desde";
            case 2:
                return "Hasta";
//            case 3:
//                return "Inicio Caja";
//            case 4:
//                return "Efectivo";
//            case 5:
//                return "Cheques";
//            case 6:
//                return "Tarjeta de Crédito";
//            case 7:
//                return "Tarjeta de Débito";
            case 3:
                return "Ingresos";
            case 4:
                return "Egresos";
//            case 10:
//                return "Cuentas por cobrar";
            case 5:
                return "Total";
            default:
                return null;
        }
    }
}
