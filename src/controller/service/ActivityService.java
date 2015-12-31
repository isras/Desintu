package controller.service;

import controller.dao.ActivityDao;
import model.Activity;

public class ActivityService {
    private final ActivityDao activityDao;
    
    public ActivityService(){
        activityDao = new ActivityDao();
    }
    
    public boolean save(){
        return this.activityDao.save();
    }
    
    public boolean edit(){
        return this.activityDao.edit();
    }
    
    public Activity getActivityPerHistory(Long history_id){
        return null; //this.activityDao.getActivityPerHistory(history_id);
    }
    
    public Activity getActivity(){
        return this.activityDao.getActivity();
    }
    
    public void newInstance(Activity activity){
        this.activityDao.setActivity(activity);
    } 
}
