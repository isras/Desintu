/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.tableModel;

import controller.resources.GeneralParameter;
import controller.resources.Operaciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Quotation;

/**
 *
 * @author Eyetive
 */
public class QuotationTableModel extends AbstractTableModel {

    private List<Quotation> list = new ArrayList<>();
    private final double accuracyVal = Math.pow(10, GeneralParameter.ACCURACY_VALUE);

    /**
     * @return the list
     */
    public List<Quotation> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Quotation> list) {
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
        Quotation quotation = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return quotation.getQuotationNumber();
            case 1:
                return quotation.getPerson().toString();
            case 2:
                return Operaciones.formatDate(quotation.getQuotationDate());
            case 3:
                return quotation.getQuotationTotal();
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
                return "CLIENTE";
            case 2:
                return "FECHA";
            case 3:
                return "TOTAL";
            default:
                return null;
        }
    }

}