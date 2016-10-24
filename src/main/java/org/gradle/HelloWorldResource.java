package org.gradle;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("service")
public class HelloWorldResource {
	
    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayhello() {
        return "hello";
    }
    
    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona getPersona(){
    	return new Persona("Jhonatan", "Giraldo");
    }
    
    @GET
    @Path("json2")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona getPersona2(){
    	return new Persona("Jhonatannn", "Giraldo");
    }
    
    @GET
    @Path("entidad")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEntidad(){
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		Entidad entidad = new Entidad();
		entidad.setId(1L);
		entidad.setNombre("Jhonatan");
		manager.persist(entidad);
		
		manager.getTransaction().commit();
		return manager.find(Entidad.class, 1L).getNombre();
    }
    
    @GET
    @Path("entidad2")
    @Produces(MediaType.APPLICATION_JSON)
    public Entidad getEntidad2(){
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		Entidad entidad = new Entidad();
		entidad.setId(1L);
		entidad.setNombre("Jhonatan");
		manager.persist(entidad);
		
		manager.getTransaction().commit();
		return manager.find(Entidad.class, 1L);
    }

}