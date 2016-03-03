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
public class SalaryPrincipalTableModel extends AbstractTableModel {
    
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
        
        Double salaryPaymentTotal = 0.00;
        for (int i = 0; i < salaryPayment.getSalary().getSalaryPaymentList().size(); i++) {
            salaryPaymentTotal += salaryPayment.getSalary().getSalaryPaymentList().get(i).getSalaryPaymentValue();
        }

        switch (columnIndex) {
            case 0:
                return salaryPayment.getSalary().getEmployee().getPerson().toString();
            case 1:
                return salaryPayment.getSalary().getSalaryDate();
            case 2:
                return salaryPayment.getSalary().getSalaryValue();
            case 3:
                return salaryPaymentTotal;
            case 4:
                return salaryPayment.getSalary().getSalaryBalance();
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Fecha";
            case 2:
                return "Sueldo";
            case 3:
                return "Adelantos";
            case 4:
                return "Saldo";
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
