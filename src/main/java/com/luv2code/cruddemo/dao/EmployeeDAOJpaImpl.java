package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entity manager
    EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl (EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        // execute the query and get result list

        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get the employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        // return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // insert the employee

        Employee dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // get the employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // remove the employee
        entityManager.remove(theEmployee);
    }
}
