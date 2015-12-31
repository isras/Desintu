package views.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.UserAccount;

/**
 *
 * @author Isra
 */
public class UserAccountTableModel extends AbstractTableModel {

    private List<UserAccount> list = new ArrayList<>();
    
    /**
     * @return the list
     */
    public List<UserAccount> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<UserAccount> list) {
        this.list = list;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        UserAccount uAccount = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return String.valueOf(rowIndex + 1);
            case 1:
                return uAccount.getEmployee().toString();
            case 2:
                return uAccount.getUsrName();
            case 3:
                return uAccount.getRol().getRolName();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "Nro.";
            case 1:
                return "Nombre";
            case 2:
                return "Cuenta";             
            case 3:
                return "Rol";
            default:
                return null;
        }
    }
}