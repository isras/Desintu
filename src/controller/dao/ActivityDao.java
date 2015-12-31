package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Activity;

public class ActivityDao {
    private Activity activity;
    ConexionBd cone = new ConexionBd();
    Connection conex = null;
    
    public boolean save(){
        boolean band = false;
        
        return band;
    }
    
    public boolean edit(){
        boolean band =false;
        
        return band;
    }
    
//    public Activity getActivityPerHistory(Long history_id){
//        conex = cone.conectate();
//        PersonDao pd = new PersonDao();
//        Activity a = null;
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        try {
//            pst = conex.prepareStatement("SELECT * FROM activity WHERE history_idhistory=?");
//            pst.setLong(1, history_id);
//            rs = pst.executeQuery();
//            while(rs.next()){
//                a = new Activity();
//                a.setActivity_id(rs.getLong("idactivity"));
//                a.setDate(rs.getDate("date"));
//                a.setDescription(rs.getString("description"));
//                //Agregar una historia pendiente
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UserAccountDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return a;
//    }
    
    public List<Activity> get_activity_list(){
        List<Activity> activity_list = new ArrayList<>();
        
        
        return activity_list;
    }

    /**
     * @return the activity
     */
    public Activity getActivity() {
        if(this.activity == null){
            this.activity = new Activity();
        }
        return activity;
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
