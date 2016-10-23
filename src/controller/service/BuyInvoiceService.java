package controller.service;

import controller.dao.BuyInvoiceDao;
import java.util.List;
import model.BuyInvoice;

public class BuyInvoiceService {
    
    private final BuyInvoiceDao buyInvoiceDao;
    
    public BuyInvoiceService() {
        this.buyInvoiceDao = new BuyInvoiceDao();
    }
    
    public boolean saveBuyInvoice() {
        return this.buyInvoiceDao.save();
    }
    
    public boolean updateInvoice() {
        return this.buyInvoiceDao.update();
    }
    
    public void newInstance() {
        this.buyInvoiceDao.newInstance();
    }
    
    public void setInstance(BuyInvoice buyInvoice) {
        this.buyInvoiceDao.setInstance(buyInvoice);
    }
    
    public BuyInvoice getBuyInvoice() {
        return this.buyInvoiceDao.getBuyInvoice();
    }
    
    public List<BuyInvoice> getBuyInvoceList(){
        return this.buyInvoiceDao.getBuyInvoiceList();
    }
    
    public void addBuyInvoiceItemList(BuyInvoice buyInvoice){
       this.buyInvoiceDao.addBuyInvoiceItemList(buyInvoice);
    }
    
    public void setBuyInvoiceList(List<BuyInvoice> buyInvoiceList){
        this.buyInvoiceDao.setBuyInvoiceList(buyInvoiceList);
    }   
}