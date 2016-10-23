package controller.dao;

import java.util.ArrayList;
import java.util.List;
import model.BuyInvoice;

public class BuyInvoiceDao extends AdapterDao {
    
    private BuyInvoice buyInvoice;
    private List<BuyInvoice> buyInvoiceList;
    
    public BuyInvoiceDao(){
        super(BuyInvoice.class, new Conexion().getEm());
    }
    
    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.buyInvoice);
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
            this.modificar(this.buyInvoice);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }
    
    public boolean delete() {
        return true;
    }

    public void newInstance() {
        this.buyInvoice = null;
    }
    
    /**
     * @return La factura de compra
     */
    public BuyInvoice getBuyInvoice() {
        if (this.buyInvoice == null) {
            this.buyInvoice = new BuyInvoice();
        }
        return buyInvoice;
    }

    /**
     * @param buyInvoice the invoice to set
     */
    public void setInstance(BuyInvoice buyInvoice) {
        this.buyInvoice = buyInvoice;
    }
    
    public List<BuyInvoice> getBuyInvoiceList() {
        if (this.buyInvoiceList == null) {
            this.buyInvoiceList = new ArrayList<>();
        }
        return this.buyInvoiceList;
    }

    public void addBuyInvoiceItemList(BuyInvoice buyInvoice) {
        if (this.buyInvoiceList == null) {
            this.buyInvoiceList = new ArrayList<>();
        }
        this.buyInvoiceList.add(buyInvoice);
        this.buyInvoice = new BuyInvoice();
    }

    /**
     * @param buyInvoiceList the detailList to set
     */
    public void setBuyInvoiceList(List<BuyInvoice> buyInvoiceList) {
        this.buyInvoiceList = buyInvoiceList;
    }   
}