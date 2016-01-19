/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.SalaryPayment;

/**
 *
 * @author eyetive
 */
public class SalaryPaymentTableModel extends AbstractTableModel {

    private List<SalaryPayment> list = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.list.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SalaryPayment salaryPayment = this.list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return salaryPayment.getSalaryPaymentValue();
            case 2:
                return salaryPayment.getSalaryPaymentDate();
            case 3:
                return salaryPayment.getSalaryPaymentDescription();
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Valor";
            case 2:
                return "Fecha";
            case 3:
                return "Descripción";
            default:
                return null;
        }
    }

    /**
     * @return the list
     */
    public List<SalaryPayment> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<SalaryPayment> list) {
        this.list = list;
    }

}
