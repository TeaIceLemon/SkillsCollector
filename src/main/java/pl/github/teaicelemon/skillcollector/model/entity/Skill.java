package pl.github.teaicelemon.skillcollector.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "sources_attached_skills",
            joinColumns = @JoinColumn(name = "skills_id"  ),
            inverseJoinColumns = @JoinColumn(name = "sources_id")
    )
    private List<Source> sourceList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Skill skill = (Skill) o;
        return id.equals(skill.id) &&
                name.equals(skill.name) &&
                sourceList.equals(skill.sourceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sourceList);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sourceList=" + sourceList +
                '}';
    }
}
