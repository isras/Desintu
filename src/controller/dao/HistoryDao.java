package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.History;
import controller.resources.Operaciones;

public class HistoryDao {
    private History history;
    ConexionBd cone = new ConexionBd();
    Connection conex = null;
    
//    public boolean save(){
//        conex = cone.conectate();
//        boolean band = false;
//        PreparedStatement pst = null;
//        try {
//            pst = conex.prepareStatement("INSERT INTO history VALUES (?,?,?,?)");
//            
//            pst.setLong(1, history.getHistory_id());
//            pst.setDate(2, Operaciones.formatearDate(history.getDate().toString()));
//            pst.setString(3, history.getType());
//            pst.setLong(4, history.getUser().getUser_account_id());
//            
//            pst.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(HistoryDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return band;
//    }
    
    public boolean edit(){
        boolean band =false;
        
        return band;
    }
    
//    public History getHistoryPerUser(Long user_id){
//        conex = cone.conectate();
//        PersonDao pd = new PersonDao();
//        History h = null;
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        try {
//            pst = conex.prepareStatement("SELECT * FROM history WHERE user_iduser=?");
//            pst.setLong(1, user_id);
//            rs = pst.executeQuery();
//            while(rs.next()){
//                h = new History();
//                h.setHistory_id(rs.getLong("idhistory"));
//                h.setDate(rs.getDate("date"));
//                h.setType(rs.getString("type"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UserAccountDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return h;
//    }
    
    public List<History> get_history_list(){
        List<History> history_list = new ArrayList<>();
        
        
        return history_list;
    }

    /**
     * @return the history
     */
    public History getHistory() {
        if(this.history == null){
            this.history = new History();
        }
        return history;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(History history) {
        this.history = history;
    }
}
