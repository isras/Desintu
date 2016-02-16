package controller.service;

import controller.dao.QuotationDao;
import java.util.List;
import model.Quotation;

public class QuotationService {
    
    private final QuotationDao quotationDao;
    
    public QuotationService(){
        this.quotationDao = new QuotationDao();
    }
    
    public boolean saveQuotation(){
        return this.quotationDao.save();
    }
    
    public boolean updateQuotation(){
        return this.quotationDao.update();
    }
    
    public void newInstance(){
        this.quotationDao.newInstance();
    }
    
    public void setInstance(Quotation quotation){
        this.quotationDao.setInstance(quotation);
    }
    
    public Quotation getQuotation(){
        return this.quotationDao.getQuotation();
    }
    
    public List<Quotation> getQuotationList(){
        return this.quotationDao.getQuotationList();
    }
    
    public List<Quotation> getQuotationListByNumber(String criteria){
        return this.quotationDao.getQuotationListByNumber(criteria);
    }
    
}
