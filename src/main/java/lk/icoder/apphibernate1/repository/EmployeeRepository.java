package lk.icoder.apphibernate1.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lk.icoder.apphibernate1.entity.Course;
import lk.icoder.apphibernate1.entity.relationship.Employee;
import lk.icoder.apphibernate1.entity.relationship.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public void insert(Employee employee) {
        entityManager.persist(employee);
    }

    public List<Employee> retrieveAllEmployees() {
        return entityManager.createQuery("Select e from Employee e", Employee.class)
                .getResultList();
    }
}
