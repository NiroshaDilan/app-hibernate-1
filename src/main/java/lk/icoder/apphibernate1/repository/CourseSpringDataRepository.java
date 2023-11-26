package lk.icoder.apphibernate1.repository;

import lk.icoder.apphibernate1.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
}
