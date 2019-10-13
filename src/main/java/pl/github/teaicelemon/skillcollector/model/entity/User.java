package pl.github.teaicelemon.skillcollector.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String fistName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username", nullable = false, unique = true)
    private String userName;
    @Column(name = "password",nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(
            name = "users_known_sources",
            joinColumns = @JoinColumn(name = "user_id"  ),
            inverseJoinColumns = @JoinColumn(name = "sources_id")
    )
    private List<Source> sourceList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Source> getSourceList() {
        return sourceList;
    }

    public void setSourceList(List<Source> sourceList) {
        this.sourceList = sourceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                Objects.equals(fistName, user.fistName) &&
                Objects.equals(lastName, user.lastName) &&
                userName.equals(user.userName) &&
                password.equals(user.password) &&
                Objects.equals(sourceList, user.sourceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fistName, lastName, userName, password, sourceList);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sourceList=" + sourceList +
                '}';
    }
}

