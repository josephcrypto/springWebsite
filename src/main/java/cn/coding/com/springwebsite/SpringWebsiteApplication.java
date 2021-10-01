package cn.coding.com.springwebsite;

import cn.coding.com.springwebsite.entity.Developer;
import cn.coding.com.springwebsite.entity.Skill;
import cn.coding.com.springwebsite.repository.DeveloperRepository;
import cn.coding.com.springwebsite.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class SpringWebsiteApplication implements CommandLineRunner {

    @Autowired
    DeveloperRepository developerRepository;

    @Autowired
    SkillRepository skillRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringWebsiteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Skill javaScript = new Skill("javaScript", "JavaScript language skill");
        Skill ruby = new Skill("Ruby", "Ruby language skill");
        Skill php = new Skill("PHP", "PHP language skill");
        Skill go = new Skill("GO", "Go language skill");
        Skill java = new Skill("JAVA", "Java language skill");
        Skill python = new Skill("Python", "Python language skill");
        Skill nodejs = new Skill("Nodejs", "Nodejs language skill");
        Skill flutter = new Skill("Flutter", "Flutter language skill");
        Skill allInOne = new Skill("AllInOne", "Boss Get All Language ");

        skillRepository.save(javaScript);
        skillRepository.save(java);
        skillRepository.save(ruby);
        skillRepository.save(go);
        skillRepository.save(php);
        skillRepository.save(python);
        skillRepository.save(nodejs);
        skillRepository.save(flutter);
        skillRepository.save(allInOne);

        List<Developer> developers = new LinkedList<Developer>();
       developers.add(new Developer("Ko Moe", "Kyaw", "khunmoekyaw@abc.com", Arrays.asList(new Skill[] { javaScript, php, nodejs})));
       developers.add(new Developer("Ko Wunna", "Thu", "wunnathu@abc.com", Arrays.asList(new Skill[] { javaScript, php, nodejs})));
       developers.add(new Developer("Ko Yan", "Myo Kyaw", "yanmyokyaw@abc.com", Arrays.asList(new Skill[] { javaScript, go, java})));
       developers.add(new Developer("Ko Si", "Thu", "sithukyaw@abc.com", Arrays.asList(new Skill[] { javaScript, php, nodejs})));
       developers.add(new Developer("Rain", "Boss", "boss@abc.com", Arrays.asList(new Skill[] { allInOne})));
       developers.add(new Developer("Yee Mon", "Kyaw", "yeemonkyaw@abc.com", Arrays.asList(new Skill[] { javaScript, java, python})));
       developers.add(new Developer("Kaung", "Kham", "kaungkham@abc.com", Arrays.asList(new Skill[] { javaScript, java})));
       developers.add(new Developer("Nan", "Mon", "nanmon@abc.com", Arrays.asList(new Skill[] { javaScript, flutter})));
       developers.add(new Developer("Zar Chi", "Htwe", "zarchihtwe@abc.com", Arrays.asList(new Skill[] { javaScript, flutter})));
       developers.add(new Developer("Ei Phoo", "Hlaing", "eiphoohlaing@abc.com", Arrays.asList(new Skill[] { javaScript, php})));
    }
}
