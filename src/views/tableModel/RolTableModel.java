package views.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Rol;
/**
 *
 * @author Isra
 */
public class RolTableModel extends AbstractTableModel {

    private List<Rol> list = new ArrayList<>();
    
    /**
     * @return the list
     */
    public List<Rol> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Rol> list) {
        this.list = list;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        Rol rol = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return String.valueOf(rowIndex + 1);
            case 1:
                return rol.getRolName();
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
            default:
                return null;
        }
    }
}