package pl.github.teaicelemon.skillcollector.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sources")
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description" )
    private String description;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "courseList")
    private List<Skill> skillList;

    @ManyToMany(mappedBy = "sourceList")
    private List<User> userList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return id.equals(source.id) &&
                Objects.equals(description, source.description) &&
                name.equals(source.name) &&
                skillList.equals(source.skillList) &&
                userList.equals(source.userList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, name, skillList, userList);
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", skillList=" + skillList +
                ", userList=" + userList +
                '}';
    }
}
