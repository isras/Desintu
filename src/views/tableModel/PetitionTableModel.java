package views.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Petition;

public class PetitionTableModel extends AbstractTableModel {

    private List<Petition> list = new ArrayList<>();

    public List<Petition> getList() {
        return list;
    }

    public void setList(List<Petition> list) {
        this.list = list;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        Petition petition = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return petition.getPtName();
            case 1:
                return petition.getPerson().toString();
            case 2:
                return petition.getPtIssueDate() + "";
            case 3:
                return petition.getPtState();
            case 4:
                return petition.getPtTotal() + "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Cliente";
            case 2:
                return "Fecha";             
            case 3:
                return "Estado";
            case 4:
                return "Total";
            default:
                return null;
        }
    }
}
