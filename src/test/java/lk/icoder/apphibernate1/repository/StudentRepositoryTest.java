package lk.icoder.apphibernate1.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lk.icoder.apphibernate1.entity.relationship.Passport;
import lk.icoder.apphibernate1.entity.relationship.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager em;


    @Test
    @Transactional
    void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 1);
        logger.info("Student -> {}", student);
//        logger.info("Passport -> {}", student.getPassport());
    }

    // Session & Session factory
    // EntityManager and Persistence Context
    // Transaction
    @Test
    @Transactional
    public void someTest() {
        // Database operation - retrieve Student.
        Student student = em.find(Student.class, 1);
        // Persistence Context (student)

        // Database operation 2 - Retrieve passport
        Passport passport = student.getPassport();
        // Persistence Context (student, passport)

        // Database operation 3 - update passport
        passport.setNumber("EN123456");
        // Persistence Context (student, passport++)

        // Database operation 4 - update student
        student.setName("Hello - Updated");
        // Persistence Context(student++, passport++)

    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 2);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());
    }

    @Test
    @Transactional
    public void retrieveStudentAndCourse() {
        Student student = em.find(Student.class, 1);
        logger.info("Student -> {}", student);
        logger.info("Courses -> {}", student.getCourses());
    }
}