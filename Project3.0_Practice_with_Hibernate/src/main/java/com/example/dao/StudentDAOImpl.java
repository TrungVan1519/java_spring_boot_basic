package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO{

	// Automatically created by Spring Boot
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Student> findAll() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query ... sort by last name
		Query<Student> theQuery = 
				currentSession.createQuery("from Student", Student.class);
		
		// execute query and get result list
		List<Student> students = theQuery.getResultList();
				
		// return the results		
		return students;
	}

	@Override
	public Student findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// now retrieve/read from database using the primary key
		Student theStudent = currentSession.get(Student.class, theId);
		
		return theStudent;
	}

	@Override
	public void addOrUpdate(Student theStudent) {

		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save/update the student
		// id == 0 || id == null => insert
		// id != 0 && id != null => update
		currentSession.saveOrUpdate(theStudent);
	}

	@Override
	public void deleteById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Student where id=:studentId");
		theQuery.setParameter("studentId", theId);
		
		theQuery.executeUpdate();		
	}

}
