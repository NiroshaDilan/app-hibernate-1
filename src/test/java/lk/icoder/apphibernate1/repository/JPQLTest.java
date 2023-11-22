package lk.icoder.apphibernate1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lk.icoder.apphibernate1.entity.Course;
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

}
