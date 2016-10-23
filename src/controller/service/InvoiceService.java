package controller.service;

import com.toedter.calendar.JDateChooser;
import controller.dao.InvoiceDao;
import model.Invoice;
import java.util.List;
import model.Person;

public class InvoiceService {

    private final InvoiceDao idao;

    public InvoiceService() {
        this.idao = new InvoiceDao();
    }
    
    public boolean saveInvoice(){
        return this.idao.save();
    }
    
    public boolean updateInvoice(){
        return this.idao.update();
    }
    
    public void newInstace(){
        this.idao.newInstance();
    }

    public void setInstance(Invoice invoice) {
        this.idao.setInstance(invoice);
    }

    public Invoice getInvoice() {
        return this.idao.getInvoice();
    }
    
    public List<Invoice> getInvoiceList(){
        return this.idao.getInvoiceList();
    }
    
    public List<Invoice> listInvoicePerDateRange(JDateChooser initialDate, JDateChooser finalDate) {
        return this.idao.listInvoicePerDateRange(initialDate, finalDate);
    }
    
    public Invoice getInvoicePerId(Long id){
        return this.idao.getInvoicePerPerson(id);
    }
    
    public List<Invoice> listInvoiceByPersonStateCount(Person person, Integer count){
        return this.idao.listInvoiceByPersonStateCount(person, count);
    }
    
    public String getLastInvoice(){
        return this.idao.getLastInvoice();
    }
    
    public List<Invoice> listInvoiceByState(){
        return this.idao.listInvoiceByState();
    } 
}