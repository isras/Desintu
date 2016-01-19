package views.tableModel;

import controller.resources.Operaciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Sellnote;

public class PetitionNoteTableModel extends AbstractTableModel{
     private List<Sellnote> list = new ArrayList<>();

   public List<Sellnote> getList() {
        return list;
    }
    /**
     * @param list the list to set
     */
    public void setList(List<Sellnote> list) {
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
        Sellnote sellNote = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sellNote.getSnNumber();
            case 1:
                return sellNote.getPerson().toString();
            case 2:
                return Operaciones.formFechaToLarge(sellNote.getSnIssueDate());
            case 3:
                return String.valueOf(Operaciones.parteDecimal(sellNote.getSnAdvance(), 2));
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
                return "Clente";
            case 2:
                return "Fecha";
            case 3:
                return "Anticipo";
            default:
                return null;
        }
    } 
}
