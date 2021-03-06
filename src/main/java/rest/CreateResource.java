/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.HeroDTO;
import entities.Role;
import entities.Superhero;
import entities.User;
import facades.SuperHeroFacade;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author rh
 */
@Path("create")
public class CreateResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static SuperHeroFacade FACADE = SuperHeroFacade.getHeroFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    /**
     * Creates a new instance of CreateResource
     */
    public CreateResource() {
    }

    /**
     * Retrieves representation of an instance of rest.CreateResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/heros")
    
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllHeros() {
        String data = GSON.toJson(FACADE.getAllheros());
        return data;
    }

    /**
     * PUT method for updating or creating an instance of CreateResource
     *
     * @param content representation for the resource
     */
    @POST
    @Path("/newHero")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addHobby(HeroDTO hDTO) {
        return GSON.toJson(FACADE.createHero(hDTO));
     
    }
    
    @GET
    @Path("/createusers")
    @Produces(MediaType.APPLICATION_JSON)
    public void createuser() {
        
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        User user = new User("user", "123");
        User admin = new User("admin", "1234");
        User both = new User("user_admin", "12345");
        
        Superhero sh = new Superhero("Superman", "Stregth");


        try {
        em.getTransaction().begin();
        Role userRole = new Role("user");
        Role adminRole = new Role("admin");
        user.addRole(userRole);
        admin.addRole(adminRole);
        both.addRole(userRole);
        both.addRole(adminRole);
        em.persist(userRole);
        em.persist(adminRole);
        em.persist(user);
        em.persist(admin);
        em.persist(both);
        em.persist(sh);
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        
    }
    
}
