package org.gradle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		Entidad entidad = new Entidad();
		entidad.setId(1L);
		entidad.setNombre("Jhonatan");
		manager.persist(entidad);
		
		manager.getTransaction().commit();
		
		System.out.println(manager.find(Entidad.class, 1L).getNombre());
		
		manager.close();
			
	}

}
