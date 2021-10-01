package cn.coding.com.springwebsite.repository;

import cn.coding.com.springwebsite.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface SkillRepository extends JpaRepository<Skill, Long> {

    public List<Skill> findByLabel(String label);


    Skill getOne(Long skillId);
}
