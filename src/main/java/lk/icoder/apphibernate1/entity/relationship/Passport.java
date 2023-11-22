package lk.icoder.apphibernate1.entity.relationship;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Passport implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    // Student is the owning side of the relationship
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    public Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    public Passport(Long id, String number) {
        this.id = id;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return String.format("Passport[%s]", number);
    }
}
