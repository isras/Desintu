package controller.dao;

import java.util.List;
import model.Payroll;

public class PayrollDao extends AdapterDao {
    
    private Payroll payroll;
    private List<Payroll> payrollList;
    
    public PayrollDao(){
        super(Payroll.class, new Conexion().getEm());
    }
    
    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.payroll);
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
            this.guarda(this.payroll);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos
            this.detach(this.payroll);
            this.modificar(this.payroll);
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    /**
     * @return the payroll
     */
    public Payroll getPayroll() {
        if (this.payroll == null) {
            this.payroll = new Payroll();
        }
        return payroll;
    }

    /**
     * @param payroll the salary to set
     */
    public void setInstance(Payroll payroll) {
        this.payroll = payroll;
    }

    public void newInstance() {
        this.payroll = null;
    }    
}
