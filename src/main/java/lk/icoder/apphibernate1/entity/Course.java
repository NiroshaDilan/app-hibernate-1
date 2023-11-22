package lk.icoder.apphibernate1.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NamedQuery(name = "get_all_courses", query = "Select c From Course c")
//@NamedQueries(
//        value = {
//                @NamedQuery(name = , query = ),
//                @NamedQuery(name = , query = )
//        }
//)
//@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

//    @Column(name = "fullName", nullable = false, length = 255)
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdData;

    public Course() {
    }

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
