package controller.service;

import controller.dao.ProductDao;
import java.util.List;
import model.Product;

public class ProductService {
    private final ProductDao pDao;
    
    public ProductService(){
        this.pDao = new ProductDao();
    }
    
    public boolean saveProduct(){
        return this.pDao.save();
    }
    
    public boolean updateProduct(){
        return this.pDao.update();
    }
    
    public void newInstance(){
        this.pDao.newInstance();
    }
    
    public void setInstance(Product product){
        this.pDao.setInstance(product);
    }
    
    public Product getProduct(){
        return this.pDao.getProduct();
    }
    
    public List<Product> list(){
        return this.pDao.list();
    }
    
    public List<Product> getProductsByCriteria(String criteria){
        return this.pDao.getProductsByCriteria(criteria);
    }
    
    public List<Product> getProductByType(String criteria){
        return this.pDao.getProductsByType(criteria);
    }
    
    public List<Product> getProductListPrintMaterial(){
        return this.pDao.getProductListPrintMaterial();
    }
    
    public void setProductListPrintMaterial(List<Product> list){
        this.pDao.setProductListPrintMaterial(list);
    }
    
    public List<Product> getProductListFinished(){
        return this.pDao.getProductListFinished();
    }
    
    public void setProductListFinished(List<Product> list){
        this.pDao.setProductListFinished(list);
    }
    
    public List<Product> getProductListService(){
        return this.pDao.getProductListService();
    }
    
    public void setProductListService(List<Product> list){
        this.pDao.setProductListService(list);
    }
    
    public List<Product> getProductList(){
        return this.pDao.getProductList();
    }
    
    public void setProductList(List<Product> list){
        this.pDao.setProductList(list);
    }
    
}
