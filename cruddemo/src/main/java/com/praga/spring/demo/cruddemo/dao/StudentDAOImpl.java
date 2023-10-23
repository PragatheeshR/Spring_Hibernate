package com.praga.spring.demo.cruddemo.dao;

import com.praga.spring.demo.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{


    private final EntityManager entityManager;


    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student student) {
        System.out.println(entityManager.toString());
        entityManager.persist(student);
    }

    @Override
    public Student getRecord(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findbyLastName(String lastname) {

        TypedQuery<Student> namedQuery = entityManager.createQuery("from Student where lastName=:data", Student.class);
        namedQuery.setParameter("data", lastname);

        return namedQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateLastName(String lastName) {

        TypedQuery<Student> namedQuery = entityManager.createQuery("from Student where lastName=:data", Student.class);
        namedQuery.setParameter("data", lastName);

        List<Student> data =  namedQuery.getResultList();

        for(Student st : data){
            st.setLastName("Mariot");
            entityManager.merge(st);
        }
    }

    @Override
    @Transactional
    public int deletebyLastName(String lastName) {

       Query namedQuery = entityManager.createQuery("DELETE FROM Student WHERE lastName=:data"); // for delete query Student.class arg is
                                                                                                    // not needed. Dont forget
        namedQuery.setParameter("data", lastName);
        int op = namedQuery.executeUpdate();

       // List<Student> data =  namedQuery.getResultList();

        return op;
    }
}
