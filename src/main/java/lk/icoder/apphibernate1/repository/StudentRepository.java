package lk.icoder.apphibernate1.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lk.icoder.apphibernate1.entity.Course;
import lk.icoder.apphibernate1.entity.relationship.Passport;
import lk.icoder.apphibernate1.entity.relationship.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }

        return student;
    }

    public void deleteById(Long id) {
        Student entity = findById(id);
        entityManager.remove(entity);
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        entityManager.persist(passport);

        Student student = new Student("Mikel");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    void UpdateCreateTimestampTest() {
        Student Student = new Student("Angular js- ");
        entityManager.persist(Student);

        Student Student1 = entityManager.find(Student.class, 10001L);
        Student1.setName("Check whether timestamp is updated");
    }

    public void insertStudentAndCourse() {
        Student student = new Student("Jack");
        Course course = new Course("React Js 100 steps");

        entityManager.persist(student);
        entityManager.persist(course);

        student.addCourses(course);
        course.addStudent(student);

        entityManager.persist(student);
    }
    
}
