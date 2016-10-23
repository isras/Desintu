/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.tableModel;

import controller.resources.Operaciones;
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
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SalaryPayment salaryPayment = this.list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return "" + (rowIndex + 1);
            case 1:
                return "" + Operaciones.formatDate(salaryPayment.getSalaryPaymentDate());
            case 2:
                return salaryPayment.getSalaryPaymentDescription();
            case 3:
                return "" + salaryPayment.getSalaryPaymentValue();
            case 4:
                return salaryPayment.getSalaryPaymentObservation();
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
                return "Fecha";
            case 2:
                return "Descripción";
            case 3:
                return "Valor";
            case 4:
                return "Observación";
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