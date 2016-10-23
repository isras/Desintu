package views.tableModel;

import java.util.ArrayList;
import model.Product;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Isra
 */
public class ProductTableModel extends AbstractTableModel {

    private List<Product> list = new ArrayList<>();

    /**
     * @return the list
     */
    public List<Product> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Product> list) {
        this.list = list;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        Product product = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return product.getPdName();
            case 1:
                switch (product.getPdType()) {
                    case "mi":
                        return "Material Impreso";
                    case "mp":
                        return "Material Puro";
                    case "s":
                        return "Servicio";
                    case "t":
                        return "Terminado";
                    case "a":
                        return "Articulo";
                    case "cl":
                        return "Corte Làser";
                    default:
                        break;
                }
            case 2:
                return String.valueOf(product.getPdSalePrice());
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Tipo";
            case 2:
                return "PVP";
            default:
                return null;
        }
    }
}
