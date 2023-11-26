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
        repository.save(course);
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
}