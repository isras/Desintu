package views.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Person;

public class PersonTableModel extends AbstractTableModel {

    private List<Person> list = new ArrayList<>();

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        Person person = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return person.toString();
            case 1:
                return person.getPrIdentification();
            case 2:
                return person.getPrPhone();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "Nombres";
            case 1:
                return "Identificación";
            case 2:
                return "Teléfono";
            default:
                return null;
        }
    }
}
