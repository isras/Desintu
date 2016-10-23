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
import model.Salary;

/**
 *
 * @author eyetive
 */
public class SalaryTableModel extends AbstractTableModel {

    private List<Salary> list = new ArrayList<>();
    private final Double auxTot;
    
    public SalaryTableModel(){
        this.auxTot = Math.pow(10, GeneralParameter.ACCURACY_VALUE);
    }

    @Override
    public int getRowCount() {
        return this.list.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Salary salary = this.list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return salary.getSalaryDate();
                
            case 2:
                return salary.getSalaryValue();
                
            case 3:
                Double salaryPaymentTotal = 0.00;
                
                for (int i = 0; i < salary.getSalaryPaymentList().size(); i++) {
                    salaryPaymentTotal += salary.getSalaryPaymentList().get(i).getSalaryPaymentValue();
                }
                return salaryPaymentTotal;
                
                
            case 4:
                if(salary.getSalaryBalance() != null){
                    return Operaciones.parteDecimal(Math.rint(salary.getSalaryBalance()*auxTot)/auxTot, GeneralParameter.ACCURACY_VALUE);
                }else{
                    return "0.00";
                }
            case 5:
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
                return "Fecha";
                
            case 2:
                return "Sueldo";
            case 3:
                return "Adelantos";
                
            case 4:
                return "Saldo";
                
            case 5:
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
