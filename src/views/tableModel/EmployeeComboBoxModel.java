package views.tableModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Employee;

public class EmployeeComboBoxModel extends AbstractListModel implements ComboBoxModel {

    boolean loEncontro;
    private List<Employee> employeeList = null;//cadena q recibira los datos a mostrar.
    Employee employee = null;

    public EmployeeComboBoxModel(List<Employee> list) {
        this.employeeList = list;
    }

    @Override
    public Employee getElementAt(int index) {
        return employeeList.get(index);
    }

    @Override
    public int getSize() {
        return employeeList.size();
    }

    @Override
    public void setSelectedItem(Object item) {

        if ((employee != null && !employee.equals(item))
                || employee == null && item != null) {
            employee = (Employee) item;
            fireContentsChanged(this, -1, -1);
        }

    }
    public int getIndexOf(Object anObject) {
        return employeeList.indexOf(anObject);
    }
    
    public void setSelectedIndex(){
        
    }

    @Override
    public Employee getSelectedItem() { //metodo implementado por la interface  JComboBoxModel
        return employee;
    }
}
