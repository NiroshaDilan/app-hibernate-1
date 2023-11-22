package lk.icoder.apphibernate1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lk.icoder.apphibernate1.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NativeQueryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void nativeQueries() {
        Query nativeQuery = em.createNativeQuery("Select * From course where id = ?");
//        Query nativeQuery = em.createNativeQuery("Select * From course where id = :id");
        nativeQuery.setParameter(1, 10001L);
//        nativeQuery.setParameter("id", 10001L);
        List resultList = nativeQuery.getResultList();
        logger.info("Select c From Course c -> {}", resultList.get(0));
    }

}
