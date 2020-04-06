package jpa.springjpa;

import jpa.springjpa.domain.Student;
import jpa.springjpa.repo.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SpringjpaApplication {
    private StudentRepo repo ;

    public SpringjpaApplication(StudentRepo repo) {
        this.repo = repo;
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringjpaApplication.class, args);

      //SpringjpaApplication application =   context.getBean(SpringjpaApplication.class);


    }
    @Bean
    public CommandLineRunner runner() {
        return args->{
            Student student = new Student(1L,"Denesh", "java");
            Student student2 = new Student(2L,"Alisha", "selenium");
            repo.save(student);
            repo.save(student2);

            Optional<Student> stu = repo.findByNameAndProgramName("Alisha", "selenium");
            stu.ifPresent(System.out::println);

            System.out.println(repo.countAll());
        };
    }

}
