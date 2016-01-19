package views.tableModel;

import controller.resources.GeneralParameter;
import controller.resources.Operaciones;
import model.Invoice;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class InvoiceTableModel extends AbstractTableModel {

    private List<Invoice> lista = new ArrayList<>();

    public List<Invoice> getLista() {
        return lista;
    }

    public void setLista(List<Invoice> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        Invoice invoice = this.lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return GeneralParameter.FIRST_INVOICE_NUMBER + " - " + GeneralParameter.SECOND_INVOICE_NUMBER + " - " + invoice.getInNumber();
            case 1:
                return Operaciones.formFechaToLarge(invoice.getInIssueDate());
            case 2:
                return invoice.getPerson().getPrFirstName() + " " + invoice.getPerson().getPrLastName();
            case 3:
                return invoice.getInSubtotal() + "";
            case 4:
                return invoice.getInIva() + "";
            case 5:
                return invoice.getInTotal() + "";
            case 6:
                return invoice.getInState() + "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "Num. Factura";
            case 1:
                return "Fecha";
            case 2:
                return "Cliente";             
            case 3:
                return "Subtotal";
            case 4:
                return "Iva";
            case 5:
                return "Total";
            case 6:
                return "Estado";
            default:
                return null;
        }
    }
}
