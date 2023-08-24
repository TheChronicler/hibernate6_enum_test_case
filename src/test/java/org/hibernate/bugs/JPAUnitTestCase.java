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

		OtherTbl otherTbl = new OtherTbl();
		entityManager.persist(otherTbl);

		TestTbl testTbl1 = new TestTbl();
		testTbl1.setOtherTbl(otherTbl);
		entityManager.persist(testTbl1);

		TestTbl testTbl2 = new TestTbl();
		testTbl2.setOtherTbl(otherTbl);

		// This should work as the index is set to have unique = false
		entityManager.persist(testTbl2);

		// Do stuff...
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
