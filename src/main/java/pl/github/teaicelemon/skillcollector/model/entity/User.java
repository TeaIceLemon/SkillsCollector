package pl.github.teaicelemon.skillcollector.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String fistname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @ManyToMany
    @JoinTable(
            name = "users_known_sources",
            joinColumns = @JoinColumn(name = "users_id"  ),
            inverseJoinColumns = @JoinColumn(name = "sources_id")
    )
    private Set<Source> sourceList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistName) {
        this.fistname = fistName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Source> getSourceList() {
        return sourceList;
    }

    public void setSourceList(Set<Source> sourceList) {
        this.sourceList = sourceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                Objects.equals(fistname, user.fistname) &&
                Objects.equals(lastname, user.lastname) &&
                username.equals(user.username) &&
                password.equals(user.password) &&
                Objects.equals(sourceList, user.sourceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fistname, lastname, username, password, sourceList);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fistName='" + fistname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sourceList=" + sourceList +
                '}';
    }
}

