package com.udemy.composition;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("personal_jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Address address = new Address("mainstreet", 25000);

		Employee employee = new Employee("wang");

		employee.setAddress(address);
		address.setEmployee(employee);

		entityManager.persist(address);
		entityManager.persist(employee);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}
}
