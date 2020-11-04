package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

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
		
		// create a query ... sort by last name
		Query theQuery = entityManager.createQuery("from Student");
		
		// execute query and get result list
		List<Student> students = theQuery.getResultList();
				
		// return the results		
		return students;
	}

	@Override
	public Student findById(int theId) {

		// now retrieve/read from database using the primary key
		Student theStudent = entityManager.find(Student.class, theId);
		
		return theStudent;
	}

	@Override
	public void addOrUpdate(Student theStudent) {

		// save/update the student
		// id == 0 || id == null => insert
		// id != 0 && id != null => update
		Student dbStudent = entityManager.merge(theStudent);
		
		// Trong TH muon them moi Student thi id cua theStudent  phai = 0 
		//	|| = null
		// Khi them vao thi Student moi se tu co id la AUTO_INCREAMENT 
		//	vi vay ta se update lai id cho theStudent theo Student trong DB
		//	sau khi duoc them moi
		// > Thuc chat khong quan trong lam: No chi co tac dung hien thi len
		//		thong tin theStudent len thoi sau khi them thoi, 
		//		neu khong dung ham nay thi
		//		thong tin hien thi len bi sai la id cua theStudent = 0
		//		nhung trong DB van duoc them dung. Nen thuc chat no dung
		//		de hien thi 
		theStudent.setId(dbStudent.getId());
		
	}

	@Override
	public void deleteById(int theId) {

		// delete object with primary key
		Query theQuery = 
				entityManager.createQuery("delete from Student where id=:studentId");
		theQuery.setParameter("studentId", theId);
		
		theQuery.executeUpdate();		
	}

}
