package lk.icoder.apphibernate1;

import lk.icoder.apphibernate1.entity.relationship.FullTimeEmployee;
import lk.icoder.apphibernate1.entity.relationship.PartTimeEmployee;
import lk.icoder.apphibernate1.repository.CourseRepository;
import lk.icoder.apphibernate1.repository.EmployeeRepository;
import lk.icoder.apphibernate1.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class AppHibernate1Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppHibernate1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Course course = courseRepository.findById(10001L);
//        logger.info("Course 10001 -> {}", course.getName());
//
////        courseRepository.deleteById(10001L);
//        courseRepository.save(new Course(10002L, "Microservices 1000"));

//        studentRepository.saveStudentWithPassport();

        // ==== Many to One =====
//        List<Review> reviews = new ArrayList<>();
//        reviews.add(new Review("5", "Great Hands on Stuff"));
//        reviews.add(new Review("5", "Hats off"));
//        courseRepository.addReviewsForCourse(10001L, reviews);
//        studentRepository.insertStudentAndCourse();

        employeeRepository
                .insert(new FullTimeEmployee("Amal", new BigDecimal("1000")));
        employeeRepository
                .insert(new PartTimeEmployee("Juroo", new BigDecimal("5000")));

//        logger.info("All Employees -> {}", employeeRepository.retrieveAllEmployees()); // getting error when @MappedSuperclass
//        using
        logger.info("All Full Time Employees -> {}", employeeRepository.retrieveAllFullTimeEmployees());
        logger.info("All Part Time Employees -> {}", employeeRepository.retrieveAllPartTimeEmployees());
    }
}
