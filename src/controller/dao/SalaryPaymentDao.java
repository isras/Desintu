package controller.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.Salary;
import model.SalaryPayment;

public class SalaryPaymentDao extends AdapterDao {

    private SalaryPayment salaryPayment;
    private List<SalaryPayment> salaryPaymentList;

    public SalaryPaymentDao() {
        super(SalaryPayment.class, new Conexion().getEm());
    }

    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.salaryPayment);
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
            this.modificar(this.salaryPayment);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public boolean remove() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            SalaryPayment ref = this.getEntityManager().getReference(SalaryPayment.class, salaryPayment.getSalaryPaymentId());
            this.eliminar(ref);
            this.getEntityManager().getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    /**
     * @return the salary
     */
    public SalaryPayment getSalaryPayemt() {
        if (this.salaryPayment == null) {
            this.salaryPayment = new SalaryPayment();
        }
        return salaryPayment;
    }

    /**
     * @param salaryPayment the salary to set
     */
    public void setInstance(SalaryPayment salaryPayment) {
        this.salaryPayment = salaryPayment;
    }

    public void newInstance() {
        this.salaryPayment = null;
    }

    public List<SalaryPayment> listAll() {
        List<SalaryPayment> list = new ArrayList<>();
        try {
            String query = "select c from SalaryPayment c";
            Query q = this.getEntityManager().createQuery(query);
            list = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<SalaryPayment> getSalaryPaymentListBySalaryMonth(Salary salary, int month) {
        List<SalaryPayment> list = new ArrayList<>();
        //System.out.println(SUBSTRING(Operaciones.formatDate(new Date()), 7, 2) + "  "+month);
        try {
            String query = "select c from SalaryPayment c where extract(month from c.salaryPaymentDate)=" + month + " and c.salary.salaryId = " + salary.getSalaryId();
            System.out.println(query);
            Query q = this.getEntityManager().createQuery(query);
            list = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    /**
     * @return the listAll
     */
    public List<SalaryPayment> getSalaryPaymentList() {
        if (this.salaryPaymentList == null) {
            this.salaryPaymentList = new ArrayList<>();
        }
        return salaryPaymentList;
    }

    /**
     * @param salaryPaymentList the listAll to set
     */
    public void setSalaryPaymentList(List<SalaryPayment> salaryPaymentList) {
        this.salaryPaymentList = salaryPaymentList;
    }

    public void addSalaryPaymentToList(SalaryPayment salaryPayment) {
        if (this.salaryPaymentList == null) {
            this.salaryPaymentList = new ArrayList<>();
        }
        this.salaryPaymentList.add(salaryPayment);
        this.salaryPayment = new SalaryPayment();
    }

}
