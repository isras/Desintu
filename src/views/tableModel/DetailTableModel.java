package views.tableModel;


import controller.resources.GeneralParameter;
import controller.resources.Operaciones;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Detail;

/**
 *
 * @author michael
 */
public class DetailTableModel extends AbstractTableModel{

   private List<Detail> list;
   private final Double auxTot;

    public DetailTableModel() {
        this.auxTot = Math.pow(10, GeneralParameter.ACCURACY_VALUE);
    }
   
   /**
     * @return the list
     */
    public List<Detail> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Detail> list) {
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
        Detail detail = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return String.valueOf(detail.getDetQuantity());
            case 1:
                return detail.getDetDescription();
            case 2:
                return String.valueOf(Operaciones.parteDecimal(Math.rint(detail.getDetSalePrice()*auxTot)/auxTot, GeneralParameter.ACCURACY_VALUE));
            case 3:
                return String.valueOf(Operaciones.parteDecimal(Math.rint(detail.getDetTotal()*auxTot)/auxTot, GeneralParameter.ACCURACY_VALUE));
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "Cantidad";
            case 1:
                return "Descripcion";
            case 2:
                return "Precio";             
            case 3:
                return "Total";
            default:
                return null;
        }
    }
}