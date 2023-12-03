package lk.icoder.apphibernate1.repository;

import lk.icoder.apphibernate1.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
class CourseSpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    public void findById_CoursePresent() {
        Optional<Course> courseOptional = repository.findById(10001L);
        assertTrue(courseOptional.isPresent());
//        logger.info("{}", courseOptional.isPresent());

    }

    @Test
    public void findById_CourseNotPresent() {
        Optional<Course> courseOptional = repository.findById(20001L);
        assertFalse(courseOptional.isPresent());
//        logger.info("{}", courseOptional.isPresent());
    }

    @Test
    public void playingAroundWithSpringDataRepository() {
        Course course = new Course("Docker Course");
        repository.save(course);
        course.setName("Docker Course - Updated");
        repository.save(course); // update the course
    }

    @Test
    public void retrieveAllSpringDataRepository() {
        logger.info("find All Courses -> {}", repository.findAll());
    }

    @Test
    public void sortCourseSpringDataRepository() {
//        Sort sort = new Sort(Sort.Direction.DESC, "name");
//        logger.info("Sorted Courses -> {}", repository.findAll(sort));
    }

    @Test
    public void findCourseByName() {
        logger.info("FindByName -> {} ",
                repository.findCourseByName("Docker course - Updated"));
    }

    @Test
    void coursersWith100StepsInName() {
    }

    @Test
    void coursersWith100StepsInNameNative() {
        logger.info("native -> {}", repository.coursersWith100StepsInNameNative());
    }

    @Test
    void coursersWith100StepsInNameUsingNamedQuery() {
    }

    @Test
    void coursersWith100StepsInNameParam() {
        logger.info("param 1-> {}",
                repository.coursersWith100StepsInNameParam("Hibernate course 100 Steps"));
        logger.info("param 2-> {}",
                repository.coursersWith100StepsInNameParam("Docker course - Updated"));
        logger.info("param 3-> {}",
                repository.coursersWith100StepsInNameParam("HTML course"));
        logger.info("param 4-> {}",
                repository.coursersWith100StepsInNameParam("JPA 100 Steps"));
        logger.info("param 5-> {}",
                repository.coursersWith100StepsInNameParam("Java"));

    }
}