/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Salary;

/**
 *
 * @author eyetive
 */
public class SalaryTableModel extends AbstractTableModel {

    private List<Salary> list = new ArrayList<>();

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
        Salary salary = this.list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return salary.getSalaryValue();
            case 2:
                if(salary.getSalaryBalance() != null){
                    return salary.getSalaryBalance();
                }else{
                    return "0.00";
                }
            case 3:
                return salary.getSalaryDate();
            case 4:
                if(salary.getSalaryState() == 0){
                    return "Pendiente";
                }else{
                    return "Pagado";
                }
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
                return "Saldo";
            case 3:
                return "Fecha";
            case 4:
                return "Estado";
            default:
                return null;
        }
    }

    /**
     * @return the list
     */
    public List<Salary> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Salary> list) {
        this.list = list;
    }

}
