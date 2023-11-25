package lk.icoder.apphibernate1.entity.relationship;

import jakarta.persistence.*;

@MappedSuperclass // if we use this, we cannot use @Entity
//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // store in a single table.
//@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Employee[%s]", name);
    }
}
