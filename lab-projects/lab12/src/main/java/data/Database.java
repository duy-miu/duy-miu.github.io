package data;

import java.util.HashMap;
import java.util.Map;

public class Database {
    Map<String, User> db;
    public Database(){
        db = new HashMap<String,User>();
        for(int i=0;i<1000;i++){
            User u = new User("user"+i,"pass"+i);
            db.put(u.getUsername(),u);
        }
    }
    public boolean checkLogin(User u){
        boolean isExisted = false;

        if(u!=null){
            if(db.containsKey(u.getUsername())){
                Object objUser = db.get(u.getUsername());
                if(objUser != null){
                    User user = (User) objUser;
                    if( user.getPassword().equals(u.getPassword())) {
                        isExisted = true;
                    }
                }
            }
        }

        return  isExisted;
    }
}
