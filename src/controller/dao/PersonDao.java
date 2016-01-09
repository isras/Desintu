package controller.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.Person;

public class PersonDao extends AdapterDao {

    private Person person;

    public PersonDao() {
        super(Person.class, new Conexion().getEm());
    }

    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.person);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public boolean edit() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.modificar(this.person);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        if (this.person == null) {
            this.person = new Person();
        }
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setInstance(Person person) {
        this.person = person;
    }

    public void newInstance() {
        this.person = null;
    }

    public List<Person> list() {
        List<Person> personList = new ArrayList<>();
        try {
            String query = "select c from Person c";
            Query q = this.getEntityManager().createQuery(query);
            personList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return personList;
    }

    public List<Person> getPersonsByCriteria(String criteria) {
        List<Person> personList = new ArrayList<>();
        try {
            String query = "select c from Person c where c.prFirstName like '" + criteria + "%' or c.prLastName like '" + criteria + "%' or c.prIdentification like '" + criteria + "%'";
            Query q = this.getEntityManager().createQuery(query);
            personList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(personList);
        return personList;
    }
    
    public List<Person> getPersonsByCriteriaType(String criteria) {
        List<Person> personList = new ArrayList<>();
        try {
            String query = "select c from Person c where (c.prType = 'Cliente' or c.prType = 'Publicista') and (c.prFirstName like '%" + criteria + "%' or c.prLastName like '%" + criteria + "%' or c.prIdentification like '%" + criteria + "%')"
                    ;
            Query q = this.getEntityManager().createQuery(query);
            personList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(personList);
        return personList;
    }

    public boolean personExists(String identification) {
        boolean flag = false;
        Person p;
        try {
            String query = "select c from Person c where c.prIdentification='" + identification + "'";
            Query q = this.getEntityManager().createQuery(query);
            //p = (Person) q.getSingleResult()
            flag = !q.getResultList().isEmpty(); //una obtener todos los objetos que estan guardados en la tabla de la base de datos
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

}
