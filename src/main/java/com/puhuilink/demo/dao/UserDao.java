package com.puhuilink.demo.dao;

import com.puhuilink.demo.bean.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {
   private static Map<Integer, User> users = null;
static{
        users=new HashMap<Integer, User>();
        users.put(1,new User(1,"王一"));
        users.put(2,new User(2,"李二"));
        users.put(3,new User(3,"张三"));
    }
    private static Integer initId=4;
   public  void save(User user){
        if(user.getId()==null)
            user.setId(initId++);
        users.put(initId,user);
    }



    public Collection<User> getAll(){
        return users.values();
    }

    public User get(Integer id){
        return users.get(id);
    }

    public void delete(Integer id){
        users.remove(id);
    }
}
