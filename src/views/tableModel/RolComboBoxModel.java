package views.tableModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Rol;

public class RolComboBoxModel extends AbstractListModel implements ComboBoxModel {

    boolean loEncontro;
    private List<Rol> rolList = null;//cadena q recibira los datos a mostrar.
    Rol rol = null;
    
    public RolComboBoxModel(List<Rol> list){
        this.rolList = list;
    }

    @Override
    public Rol getElementAt(int index) {
        return rolList.get(index);
    }

    @Override
    public int getSize() {
        return rolList.size();
    }

    @Override
    public void setSelectedItem(Object item) {
        try{
            rol = (Rol) item;
            fireContentsChanged(this, -1, -1);
        }catch(Exception ex){            
        }        
    }     

    @Override
    public Rol getSelectedItem() { //metodo implementado por la interface  JComboBoxModel
        return rol;
    } 
}