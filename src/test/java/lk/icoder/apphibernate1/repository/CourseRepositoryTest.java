package lk.icoder.apphibernate1.repository;

import lk.icoder.apphibernate1.AppHibernate1Application;
import lk.icoder.apphibernate1.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest(classes = AppHibernate1Application.class)
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository repository;

    @Test
    @DirtiesContext // automatically reset the data
    void deleteById() {
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    void findById() {
        Course course = repository.findById(10002L);
        assertEquals("Spring boot", course.getName());
    }

    @Test
    void save() {
        // get a course
        Course course = repository.findById(10001L);
        assertEquals("JPA", course.getName());

        // update details.
        course.setName("Updated");
        repository.save(course);

        // check the value
        Course course1 = repository.findById(10001L);
        assertEquals("Updated", course1.getName());

    }

    @Test
    public void playWithEntityManager() {
        repository.playWithEntityManager();
    }

    @Test
    void updateCreateTimestampTest() {
        repository.UpdateCreateTimestampTest();
    }
}
