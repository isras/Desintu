package views.tableModel;

import controller.resources.GeneralParameter;
import controller.resources.Operaciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.AccountingEntry;

public class AccountingEntryTableModel extends AbstractTableModel {

    private List<AccountingEntry> list = new ArrayList<>();
    private final double accuracyVal = Math.pow(10, GeneralParameter.ACCURACY_VALUE);

    /**
     * @return the list
     */
    public List<AccountingEntry> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<AccountingEntry> list) {
        this.list = list;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        AccountingEntry aEntry = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return String.valueOf(rowIndex + 1);
            case 1:
                return Operaciones.formFechaToLarge(aEntry.getAeCreatedDate());
            case 2:
                return aEntry.getAeDescription();
            case 3:
                if (aEntry.getAeType() == 0) {//Cuando es un ingreso
                    return Operaciones.parteDecimal(Math.rint(aEntry.getAeValue() * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE);
                } else {
                    return "0.00";
                }
            case 4:
                if (aEntry.getAeType() == 1) {//Cuando es un egreso
                    return Operaciones.parteDecimal(Math.rint(aEntry.getAeValue() * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE);
                } else {
                    return "0.00";
                }
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
                return "FECHA";
            case 2:
                return "DESCRIPCIÓN";
            case 3:
                return "INGRESO";
            case 4:
                return "EGRESO";
            default:
                return null;
        }
    }
}
