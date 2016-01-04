package controller.service;

import controller.dao.PersonDao;
import java.util.List;
import model.Person;

public class PersonService {

    private final PersonDao pd;

    public PersonService() {
        pd = new PersonDao();
    }

    public boolean savePerson() {
        return this.pd.save();
    }

    public boolean updatePerson() {
        return this.pd.edit();
    }

    public Person getPerson() {
        return this.pd.getPerson();
    }

    public void setInstance(Person person) {
        this.pd.setInstance(person);
    }

    public void newInstance() {
        this.pd.newInstance();
    }

    public List<Person> list() {
        return this.pd.list();
    }
    
    public List<Person> getPersonsByCriteria(String criteria){
        return this.pd.getPersonsByCriteria(criteria);
    }
    public List<Person> getPersonsByCriteriaType(String criteria){
        return this.pd.getPersonsByCriteriaType(criteria);
    }
    
    public boolean personExists(String identification){
        return this.pd.personExists(identification);
    }

}
