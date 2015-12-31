package views.tableModel;

import model.Invoice;
import controller.resources.Operaciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CCFactureTableModel extends AbstractTableModel{
    
    private List<Invoice> list = new ArrayList<>();
/**
     * @return the list
     */
    public List<Invoice> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Invoice> list) {
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
        Invoice invoice = this.list.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return invoice.getInNumber();
            case 1:
                return invoice.getPerson().toString();
            case 2:
                return Operaciones.formFechaToLarge(invoice.getInIssueDate());
            case 3:
                return String.valueOf(Operaciones.parteDecimal(invoice.getInTotal(), 2));
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
                return "Clente";
            case 2:
                return "Fecha";
            case 3:
                return "Total";
            default:
                return null;
        }
    } 
}
