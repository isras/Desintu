package views.tableModel;

import controller.resources.Operaciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.BuyInvoice;

public class BuyInvoiceTableModel extends AbstractTableModel {

    private List<BuyInvoice> lista = new ArrayList<>();

    public List<BuyInvoice> getLista() {
        return lista;
    }

    public void setLista(List<BuyInvoice> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        BuyInvoice buyInvoice = this.lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return buyInvoice.getSupplier().toString();
            case 1:
                return Operaciones.formatDate(buyInvoice.getBuyInvoiceDate());
            case 2:
                return buyInvoice.getBuyInvoiceNumber();                
            case 3:
                return buyInvoice.getBuyInvoiceDescription();
            case 4:
                return buyInvoice.getBuyInvoiceTotal() + "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "Proveedor";
            case 1:
                return "Fecha";
            case 2:
                return "Numero";             
            case 3:
                return "Descripción";
            case 4:
                return "Total";
            default:
                return null;
        }
    }
}