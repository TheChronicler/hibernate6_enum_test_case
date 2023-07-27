package org.hibernate.bugs;

import jakarta.persistence.*;
//import javax.persistence.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();


		// This works
		Query query = entityManager.createQuery("SELECT t from TestTbl AS t WHERE t.testEnum IS NULL AND :testEnum IS NULL");
		query.setParameter("testEnum", null);
		query.getResultList();

		// This fails
		Query query2 = entityManager.createQuery("SELECT t from TestTbl AS t WHERE t.testEnum IS NULL AND :testEnum IS NULL");
		query2.setParameter("testEnum", TestEnum.VALUE_1);
		query2.getResultList();



		// Do stuff...
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
