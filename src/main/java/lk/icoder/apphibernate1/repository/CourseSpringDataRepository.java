package lk.icoder.apphibernate1.repository;

import lk.icoder.apphibernate1.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findCourseByName(String name);

    List<Course> findCourseByNameAndId(String name, Long id);

    @Query("Select c From Course c where c.name like '%100 Steps'")
    List<Course> coursersWith100StepsInName();

    @Query(value = "Select * From course where name like '%100 Steps'",
            nativeQuery = true)
    List<Course> coursersWith100StepsInNameNative();

    @Query(name = "get_all_courses")
    List<Course> coursersWith100StepsInNameUsingNamedQuery();

    @Query(value = "Select c From Course c where c.name = :name")
    List<Course> coursersWith100StepsInNameParam(@Param("name") String name);
}
