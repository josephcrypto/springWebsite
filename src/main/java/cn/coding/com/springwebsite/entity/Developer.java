package cn.coding.com.springwebsite.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@Table(name = "developer")
@AllArgsConstructor
@NoArgsConstructor
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    @ManyToMany
    private List<Skill> skills;

    public Developer(String firstName, String lastName, String email, List<Skill> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.skills = skills;
    }

    public boolean hasSkill(Skill skill) {
        for (Skill containedSkill : getSkills()) {
            if (containedSkill.getId() == skill.getId()) {
                return true;
            }
        }
        return false;
    }
}
