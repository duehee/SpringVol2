package SpringMVC.jdbc.Service;

import SpringMVC.jdbc.Domain.JPAUserRepository;
import SpringMVC.jdbc.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements UserService{
    private final JPAUserRepository jpaUserRepository;

    @Autowired
    public UserServiceImplement(JPAUserRepository jpaUserRepository)
    {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User createUser(User user)
    {
        jpaUserRepository.save(user.builder().userId(user.getUserId())
                .userName(user.getUserName()).userPw(user.getUserPw())
                .build());
        return user;
    }

    @Override
    public List<User> findAllUser()
    {
        return jpaUserRepository.findAll();
    }

    @Override
    public User findById(String userId)
    {
        return jpaUserRepository.findById(userId).orElse(new User(null, null, null));
    }

    @Override
    public User updateUserName(String userId, String userName)
    {
        User user = jpaUserRepository.findById(userId).orElse(null);
        jpaUserRepository.save(user.builder().userName(user.getUserName()).build());
        return user;
    }

    @Override
    public void deleteUser(String userId)
    {
        jpaUserRepository.deleteById(userId);
    }
}
