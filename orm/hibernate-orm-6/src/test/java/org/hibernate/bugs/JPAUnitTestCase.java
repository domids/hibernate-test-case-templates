package org.hibernate.bugs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@BeforeEach
	void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@AfterEach
	void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		// Do stuff...
		entityManager.createQuery("select ke1_0 " +
						"from Foo ke1_0 " +
						"where ke1_0.tenantId = :tenant " +
						"  and (lower(case " +
						"                                                                when (ke1_0.contactType='company') then ( " +
						"                                                                    coalesce((ke1_0.companyName1||''), '') || " +
						"                                                                    coalesce(ke1_0.companyName2, '')) " +
						"                                                                else ((coalesce((ke1_0.personLastName|| ''),  '') || " +
						"                                                                       coalesce((ke1_0.personFirstName|| ''),  '')) || " +
						"                                                                      coalesce(ke1_0.personPrefixTitle,  '')) end) like " +
						"                                                      :searchTerm escape '!' or lower(((((case " +
						"                                                                                           when (character_length(ke1_0.markCare) <> 0) " +
						"                                                                                               then (''||coalesce(ke1_0.markCare, '')) " +
						"                                                                                           else 'true' end || " +
						"                                                                                       (ke1_0.street || " +
						"                                                                                        coalesce(ke1_0.buildingNumber, ''))) || " +
						"                                                                                      (ke1_0.postalCode || " +
						"                                                                                       coalesce(ke1_0.city, ''))) || " +
						"                                                                                     coalesce(ke1_0.postOfficeBox, '')) || " +
						"                                                                                    (coalesce(ke1_0.countryIdentificationCode, '') || " +
						"                                                                                     coalesce(ke1_0.countryName, '')))) like " +
						"                                                                             :searchTerm escape '!' or lower(( " +
						"                                                                              coalesce((ke1_0.line||''), '') )) like " +
						"                                                                                             :searchTerm escape '!' or " +
						"                                                                                                               lower(ke1_0.state) like " +
						"                                                                                                               :searchTerm escape " +
						"                                                                                                               '!' or " +
						"                                                                                                               lower(ke1_0.externalNumber) like " +
						"                                                                                                               :searchTerm escape " +
						"                                                                                                               '!' or " +
						"                                                                                                               lower(ke1_0.customerReferenceNumber) like " +
						"                                                                                                               :searchTerm escape " +
						"                                                                                                               '!' or " +
						"                                                                                                               lower(ke1_0.baseAddressGLN) like " +
						"                                                                                                               :searchTerm escape " +
						"                                                                                                               '!') ")
				.setParameter("tenant", "tenant")
				.setParameter("searchTerm", "foo")
				.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
