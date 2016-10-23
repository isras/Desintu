package controller.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.Product;

public class ProductDao extends AdapterDao {

    private Product product;
    private List<Product> productListPrintMaterial;
    private List<Product> productListFinished;
    private List<Product> productListService;
    private List<Product> productList;

    public ProductDao() {
        super(Product.class, new Conexion().getEm());
    }

    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.product);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public boolean update() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.modificar(this.product);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }
    
    public boolean delete(){
        boolean flag = false;
        try{
            this.getEntityManager().getTransaction().begin();
            this.eliminar(this.product);
            this.getEntityManager().getTransaction().commit();
            flag = true;
        }catch (Exception e){
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        if (this.product == null) {
            this.product = new Product();
        }
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setInstance(Product product) {
        this.product = product;
    }

    public void newInstance() {
        this.product = null;
    }

    public List<Product> list() {
        List<Product> list = new ArrayList<>();
        try {
            String query = "select c from Product c";
            Query q = this.getEntityManager().createQuery(query);
            list = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductsByCriteria(String criteria) {
        List<Product> list = new ArrayList<>();
        try {
            String query = "select c from Product c where c.pdName like '" + criteria + "%' or c.pdCode like '" + criteria + "%' or c.pdBarcode like '" + criteria + "%'";
            Query q = this.getEntityManager().createQuery(query);
            list = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductsByType(String criteria) {
        List<Product> list = new ArrayList<>();
        try {
            String query = "select p from Product p where p.pdType ='" + criteria + "'";
            Query q = this.getEntityManager().createQuery(query);
            list = q.getResultList();
            System.out.println(list);
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    /**
     * @return the productListPrintMaterial
     */
    public List<Product> getProductListPrintMaterial() {
        if(this.productListPrintMaterial == null){
            this.productListPrintMaterial = new ArrayList<>();
        }
        return productListPrintMaterial;
    }
    

    /**
     * @param productListPrintMaterial the productListPrintMaterial to set
     */
    public void setProductListPrintMaterial(List<Product> productListPrintMaterial) {
        this.productListPrintMaterial = productListPrintMaterial;
    }

    /**
     * @return the productListFinished
     */
    public List<Product> getProductListFinished() {
        if(this.productListFinished == null){
            this.productListFinished = new ArrayList<>();
        }
        return productListFinished;
    }

    /**
     * @param productListFinished the productListFinished to set
     */
    public void setProductListFinished(List<Product> productListFinished) {
        this.productListFinished = productListFinished;
    }

    /**
     * @return the productListService
     */
    public List<Product> getProductListService() {
        if(this.productListService == null){
            this.productListService = new ArrayList<>();
        }
        return productListService;
    }

    /**
     * @param productListService the productListService to set
     */
    public void setProductListService(List<Product> productListService) {
        this.productListService = productListService;
    }

    /**
     * @return the productList
     */
    public List<Product> getProductList() {
        if(this.productList == null){
            this.productList = new ArrayList<>();
        }
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
