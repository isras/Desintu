package views.tableModel;

import java.util.ArrayList;
import model.Product;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Isra
 */
public class InventoryTableModel extends AbstractTableModel {

    private List<Product> list = new ArrayList<>();
    
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
        return 7;
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
                return product.getPdCode();
            case 2:
                return product.getPdDescription();
            case 3:
                return String.valueOf(product.getPdSalePrice());
            case 4:
                return product.getPdBarcode();
            case 5:
                String iva;
                if(product.getPdIvaState() == 0){
                    iva = "NO";
                    return iva;
                }else{
                    iva = "SI";
                    return iva;
                }
            case 6:
                return String.valueOf(product.getPdStock());
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "NOMBRE";
            case 1:
                return "CÓDIGO";
            case 2:
                return "DESCRIPCIÓN";             
            case 3:
                return "PVP";
            case 4:
                return "CÓDIGO DE BARRAS";
            case 5:
                return "IVA";
            case 6:
                return "STOCK";
            default:
                return null;
        }
    }
}