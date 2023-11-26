package lk.icoder.apphibernate1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lk.icoder.apphibernate1.entity.Course;
import lk.icoder.apphibernate1.entity.relationship.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class JPQLTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void findAll() {
        List resultList = em.createQuery("Select c From Course c").getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    void findAllByType() {
        TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    void namedQuery() {
        TypedQuery<Course> query = em.createNamedQuery("get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    void jpqlWhere() {
        TypedQuery<Course> query = em.createQuery("Select c From Course c where name like '%100 Steps'", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    void jpql_courses_without_students() {
        TypedQuery<Course> query =
                em.createQuery("Select c From Course c where c.students is empty", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @Test
    void jpql_courses_with_at_least_2_students() {
        TypedQuery<Course> query =
                em.createQuery("Select c From Course c where size(c.students) >= 2", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @Test
    void jpql_courses_ordered_by_students() {
        TypedQuery<Course> query =
                em.createQuery("Select c From Course c order by size(c.students)", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @Test
    void jql_students_with_passports_in_a_certain_pattern() {
        TypedQuery<Student> query =
                em.createQuery("Select s From Student s where s.passport.number like '%1234%'", Student.class);
        List<Student> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

//    JOIN => Select c, s from Course c JOIN c.students s
//    LEFT JOIN => Select c, s from Course c LEFT JOI c.students s

    @Test
    public void join() {

    }
}
