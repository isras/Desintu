/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.service;

import controller.dao.PetitionDao;
import java.util.List;
import model.Petition;

/**
 *
 * @author Jhoe
 */
public class PetitionService {

    private final PetitionDao pdao;

    public PetitionService() {
        this.pdao = new PetitionDao();
    }
    
    public boolean savePetition(){
        return this.pdao.save();
    }
    
    public boolean updatePetition(){
        return this.pdao.update();
    }
    
    public boolean removePetition(){
        return this.pdao.remove();
    }
    
    public void newInstace(){
        this.pdao.newInstance();
    }

    public void setInstance(Petition petition) {
        this.pdao.setInstance(petition);
    }

    public Petition getPetition() {
        return this.pdao.getPetition();
    }
    
    public Petition getPetitionPerName(String pName) {
        return this.pdao.getPetitionPerName(pName);
    }
    
    public List<Petition> getPetitionList(){
        return this.pdao.getPetitionList();
    }
    
    public List<Petition> getPetitionListPerName(String petitionName){
        return this.pdao.getPetitionListPerName(petitionName);
    }
    
    public Petition getPetitionPerson(Long personId){
        return this.pdao.getPetitionPerPersonId(personId);
    }
}
