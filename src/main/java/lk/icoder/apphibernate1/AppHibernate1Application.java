package lk.icoder.apphibernate1;

import lk.icoder.apphibernate1.entity.relationship.Review;
import lk.icoder.apphibernate1.repository.CourseRepository;
import lk.icoder.apphibernate1.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AppHibernate1Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

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
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("5", "Great Hands on Stuff"));
        reviews.add(new Review("5", "Hats off"));
//        courseRepository.addReviewsForCourse(10001L, reviews);
    }
}
