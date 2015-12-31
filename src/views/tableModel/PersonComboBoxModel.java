package views.tableModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Person;

public class PersonComboBoxModel extends AbstractListModel implements ComboBoxModel {

    boolean loEncontro;
    private List<Person> personList = null;//cadena q recibira los datos a mostrar.
    Person person = null;
    
    public PersonComboBoxModel(List<Person> list){
        this.personList = list;
    }

    @Override
    public Person getElementAt(int index) {
        return personList.get(index);
    }

    @Override
    public int getSize() {
        return personList.size();
    }

    @Override
    public void setSelectedItem(Object item) {
        try{
            person = (Person) item;
            fireContentsChanged(this, -1, -1);
        }catch(Exception ex){            
        }        
    }     

    @Override
    public Person getSelectedItem() { //metodo implementado por la interface  JComboBoxModel
        return person;
    } 
}