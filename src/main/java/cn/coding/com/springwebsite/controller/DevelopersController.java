package cn.coding.com.springwebsite.controller;

import cn.coding.com.springwebsite.entity.Developer;
import cn.coding.com.springwebsite.entity.Skill;
import cn.coding.com.springwebsite.repository.DeveloperRepository;
import cn.coding.com.springwebsite.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DevelopersController {

     DeveloperRepository repository;

     SkillRepository skillRepository;

    @Autowired
    public DevelopersController(DeveloperRepository repository, SkillRepository skillRepository) {
        this.repository = repository;
        this.skillRepository = skillRepository;
    }

    //Get By ID
    @RequestMapping("/developer/{id}")
    public String developer(@PathVariable Long id, Model model) {
        model.addAttribute("developer", repository.getOne(id));
        model.addAttribute("skills", skillRepository.findAll());
        return "developer";
    }

    //Get All Developers List
    @RequestMapping(value = "/developers", method = RequestMethod.GET)
    public String developersList(Model model) {
        model.addAttribute("developers", repository.findAll());
        return "developers";
    }

    //Add New Developer
    @RequestMapping(value = "/developers", method = RequestMethod.POST)
    public String developersAdd(@RequestParam String email, @RequestParam String firstName,
                                @RequestParam String lastName, Model model) {
        Developer newDeveloper = new Developer();
        newDeveloper.setEmail(email);
        newDeveloper.setFirstName(firstName);
        newDeveloper.setLastName(lastName);
        repository.save(newDeveloper);

        model.addAttribute("developer", newDeveloper);
        model.addAttribute("skills", skillRepository.findAll());
        return "redirect:/developer/" + newDeveloper.getId();
    }

    //Add Skills to Developer
    @RequestMapping(value = "/developer/{id}/skills", method = RequestMethod.POST)
    public String developersAddSkill(@PathVariable Long id, @RequestParam Long skillId, Model model) {
        Skill skill = skillRepository.getOne(skillId);
        Developer developer = repository.getOne(id);

        if (developer != null) {
            if (!developer.hasSkill(skill)) {
             developer.getSkills().add(skill);
            }
            repository.save(developer);
            model.addAttribute("developer", repository.getOne(id));
            model.addAttribute("skills", skillRepository.findAll());
            return "redirect:/developer/" + developer.getId();
        }
        model.addAttribute("developers", repository.findAll());
        return "redirect:/developers";
    }
}
