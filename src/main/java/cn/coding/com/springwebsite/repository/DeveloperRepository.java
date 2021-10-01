package cn.coding.com.springwebsite.repository;

import cn.coding.com.springwebsite.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;




public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Developer getOne(Long id);



}
