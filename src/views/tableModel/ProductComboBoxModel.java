package views.tableModel;

import model.Product;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ProductComboBoxModel extends AbstractListModel implements ComboBoxModel {

    boolean loEncontro;
    private List<Product> productList = null;//cadena q recibira los datos a mostrar.
    Product product = null;
    
    public ProductComboBoxModel(List<Product> list){
        this.productList = list;
    }

    @Override
    public Product getElementAt(int index) {
        return productList.get(index);
    }

    @Override
    public int getSize() {
        return productList.size();
    }

    @Override
    public void setSelectedItem(Object item) {
        try{
            product = (Product) item;
            fireContentsChanged(this, -1, -1);
        }catch(Exception ex){            
        }        
    }     

    @Override
    public Product getSelectedItem() { //metodo implementado por la interface  JComboBoxModel
        return product;
    } 
}