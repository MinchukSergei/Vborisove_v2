package by.bsu.famcs.minchuk.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "E_MAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
