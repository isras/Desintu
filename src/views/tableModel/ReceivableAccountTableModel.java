package views.tableModel;

import controller.resources.GeneralParameter;
import controller.resources.Operaciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.ReceivableAccount;

public class ReceivableAccountTableModel extends AbstractTableModel {

    private List<ReceivableAccount> list = new ArrayList<>();
    private final double accuracyVal = Math.pow(10, GeneralParameter.ACCURACY_VALUE);

    /**
     * @return the list
     */
    public List<ReceivableAccount> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<ReceivableAccount> list) {
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
        ReceivableAccount receivableAccount = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return String.valueOf(rowIndex + 1);
            case 1:
                return Operaciones.formFechaToLarge(receivableAccount.getReceivableAccountDate());
            case 2:
                return Operaciones.formFechaToLarge(receivableAccount.getReceivableAccountUpdateDate());
            case 3:
                return Operaciones.parteDecimal(Math.rint(receivableAccount.getReceivableAccountTotal() * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE);
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
                return "FECHA ACTUALIZACIÓN";
            case 3:
                return "TOTAL";
            default:
                return null;
        }
    }
}
