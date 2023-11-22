package lk.icoder.apphibernate1.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lk.icoder.apphibernate1.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }

        return course;
    }

    public void deleteById(Long id) {
        Course entity = findById(id);
        entityManager.remove(entity);
    }

    public void playWithEntityManager() {
        Course course1 = new Course("Web Services in 100 Steps");
        entityManager.persist(course1);
        entityManager.flush();
        course1.setName("Web Services in 100 Steps - Updated");
        entityManager.flush();

        Course course2 = new Course("Angular Js in 100 steps");
        entityManager.persist(course2);
        entityManager.flush();

        entityManager.detach(course2); // detach and below statement is not persisting
//        entityManager.clear(); // after this statement, nothing will change after this.
        course2.setName("Angular Js in 100 Steps - Updated");
//        entityManager.flush();
    }

    void UpdateCreateTimestampTest() {
        Course course = new Course("Angular js- ");
        entityManager.persist(course);

        Course course1 = entityManager.find(Course.class, 10001L);
        course1.setName("Check whether timestamp is updated");
    }
    
}
