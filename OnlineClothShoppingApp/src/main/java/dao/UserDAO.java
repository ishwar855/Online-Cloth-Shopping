package dao;

import java.util.List;

import model.User;

public interface UserDAO {
     public int insert(User u);
     List<User> fetchAll();
     User fetchUserByEmailAndPassword(String email, String password);

}
