package lk.icoder.apphibernate1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lk.icoder.apphibernate1.entity.Course;
import lk.icoder.apphibernate1.entity.relationship.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CriteriaQueryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void jpql_basic() {
        // Select c From Course c
//        1. Use Criteria Builder to create a Criteria Query returning the expected result Object

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

//        2. Define roots for tables which are involved in the query

        Root<Course> courseRoot = cq.from(Course.class); // from Course c
//        3. Define Predicates etc using Criteria Builder

//        4. Add Predicates etc to the Criteria Query
//        5. Build the TypedQuery using the entity manager and criteria query
//        TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
//        List<Course> resultList = query.getResultList();
//        logger.info("Typed Query -> {}", resultList);

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    void all_courses_having_100_steps() {
        // Select c From Course c where like '%100'
//        1. Use Criteria Builder to create a Criteria Query returning the expected result Object

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

//        2. Define roots for tables which are involved in the query

        Root<Course> courseRoot = cq.from(Course.class); // from Course c
//        3. Define Predicates etc using Criteria Builder
        Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");

//        4. Add Predicates etc to the Criteria Query
        cq.where(like100Steps);
//        5. Build the TypedQuery using the entity manager and criteria query

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

}
