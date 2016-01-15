package controller.dao;

import com.toedter.calendar.JDateChooser;
import controller.resources.Operaciones;
import model.Invoice;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

public class InvoiceDao extends AdapterDao {

    private Invoice invoice;

    public InvoiceDao() {
        super(Invoice.class, new Conexion().getEm());
    }

    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.invoice);
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
            this.modificar(this.invoice);
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
        this.invoice = null;
    }

    /**
     * @return the invoice
     */
    public Invoice getInvoice() {
        if (this.invoice == null) {
            this.invoice = new Invoice();
        }
        return invoice;
    }

    /**
     * @param invoice the invoice to set
     */
    public void setInstance(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<Invoice> getInvoiceList() {
        List<Invoice> invoiceList = new ArrayList<>();
        try {
            String query = "select c from Invoice c";
            Query q = this.getEntityManager().createQuery(query);
            invoiceList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return invoiceList;
    }

    //Esto solo es para pruebas
    public Invoice getInvoicePerPerson(Long InvoiceId) {
        Invoice invoices = new Invoice();
        try {
            String query = "select c from Invoice c where c.invoiceId='" + InvoiceId + "'";
            Query q = this.getEntityManager().createQuery(query);
            invoices = (Invoice) q.getSingleResult();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return invoices;
    }

    public List<Invoice> listInvoicePerDateRange(JDateChooser initialDate, JDateChooser finalDate) {
        List<Invoice> invoiceList = new ArrayList<>();
        String ini = Operaciones.formatDate(initialDate.getDate());
        String fin = Operaciones.formatDate(finalDate.getDate());
        try {
            String query = "select c from Invoice c where c.inIssueDate >= '" + ini + "' and c.inIssueDate <= '" + fin + "'";
            Query q = this.getEntityManager().createQuery(query);
            invoiceList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return invoiceList;
    }

    public String getLastInvoice() {
        String invNumber;
        String query = "select max(d.inNumber) from Invoice d";
        Query q = this.getEntityManager().createQuery(query);
        invNumber = (String) q.getSingleResult();

        return invNumber;
    }

    public static void main(String args[]) {
//        Invoice inv = new Invoice();
//        inv.setNumber("12345");
//        String [] prueba = inv.getParameters();
//        System.out.println(""+inv.getClass().getSimpleName().toLowerCase());
//        System.out.println(""+inv.getClass().getSimpleName().toLowerCase()+"."+prueba[1]);
//        System.out.println(""+prueba[1]);
    }

}
