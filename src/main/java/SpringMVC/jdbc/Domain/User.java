package SpringMVC.jdbc.Domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
public class User {
    @Id
    @Column(name = "userName")
    private String userName;
    @Column(name = "userId")
    private String userId;
    @Column(name ="userPw")
    private String userPw;

    @Builder
    public User(String userName, String userId, String userPw)
    {
        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
    }
}
