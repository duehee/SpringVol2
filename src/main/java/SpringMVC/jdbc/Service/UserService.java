package SpringMVC.jdbc.Service;

import SpringMVC.jdbc.Domain.User;
import java.util.List;

public interface UserService {
    public User createUser(User user);
    public List<User> findAllUser();
    public User findById(String userId);
    public User updateUserName(String userId, String userName);
    public void deleteUser(String userId);
}