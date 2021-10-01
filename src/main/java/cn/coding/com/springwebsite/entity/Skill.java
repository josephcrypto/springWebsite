package cn.coding.com.springwebsite.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "skill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String label;
    private String description;

    public Skill(String label, String description) {

        this.label = label;
        this.description = description;
    }
}
