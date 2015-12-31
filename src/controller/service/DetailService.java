package controller.service;

import controller.dao.DetailDao;
import java.util.ArrayList;
import java.util.List;
import model.Detail;
import model.Petition;

/**
 *
 * @author Usuario
 */
public class DetailService {

    private final DetailDao dDao;

    public DetailService() {
        this.dDao = new DetailDao();
    }

    public boolean saveDetail() {
        return this.dDao.save();
    }

    public boolean updateDetail() {
        return this.dDao.update();
    }
    
    public boolean removeDetail(){
        return this.dDao.remove();
    }
    
    public void newInstance() {
        this.dDao.newInstance();
    }

    public void setIntance(Detail detail) {
        this.dDao.setInstance(detail);
    }

    public Detail getDetail() {
        return dDao.getDetail();
    }

    public List<Detail> getDetailList() {
        return dDao.getDetailList();
    }

    public void setDetailList(List<Detail> detailList) {
        this.dDao.setDetailList(detailList);
    }

    public void addDetailList(Detail detail) {
        this.dDao.addDetailList(detail);
    }
    
    public List<Detail> getItemsFactureToPetition(List<Detail> itf, Petition pe, ProductService ps) {
        List<Detail> itfa = new ArrayList<>();
        for (int i = 0; i < itf.size(); i++) {
            Detail item = new Detail();
            item.setDetQuantity(itf.get(i).getDetQuantity());
            item.setDetDescription(itf.get(i).getDetDescription());
            item.setDetSalePrice(itf.get(i).getDetSalePrice());
            item.setDetTotal(itf.get(i).getDetTotal());
            item.setPetition(pe);
            item.setProduct(itf.get(i).getProduct());            //prods.get(i).getItemFactures().add(item);                        
            itfa.add(item);
        }
        return itfa;
    }
}
