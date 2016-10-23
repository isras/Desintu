package views.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Employee;

public class EmployeeTableModel extends AbstractTableModel {

    private List<Employee> list = new ArrayList<>();

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
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
        Employee employee = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return employee.toString();
            case 1:
                if(employee.getSalaryList().isEmpty()){
                  System.out.println("0.00");                    
                }
                return employee.getEmployeeIdentification();
                
            case 2:
                return employee.getEmployeePhone();
            case 3:
                return employee.getEmployeeAddress();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "NOMBRE";
            case 1:
                return "IDENTIFICACIÓN";
            case 2:
                return "TELÉFONO";             
            case 3:
                return "DIRECCIÓN";
            default:
                return null;
        }
    }
}