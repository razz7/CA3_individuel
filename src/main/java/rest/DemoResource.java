package rest;

import com.google.gson.Gson;
import dto.AllDto;
import dto.SwapiPeopleDtp;
import dto.SwapiPlanetsDto;
import entities.User;
import java.io.IOException;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;
import utils.HttpU;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class DemoResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery ("select u from User u",entities.User.class);
            List<User> users = query.getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public String getFromUser() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("fetch")
    public String getFtch() throws IOException {
    Gson gson = new Gson();
    String swapi1 = HttpU.fetchData("https://swapi.dev/api/people/1/");
    String swapi2 = HttpU.fetchData("https://swapi.dev/api/planets/3/");
    String swapi3 = HttpU.fetchData("https://swapi.dev/api/planets/4/");
    String swapi4 = HttpU.fetchData("https://swapi.dev/api/planets/6/");
    String swapi5 = HttpU.fetchData("https://swapi.dev/api/planets/8/");
    
    SwapiPeopleDtp result1 = gson.fromJson(swapi1, SwapiPeopleDtp.class);
    SwapiPlanetsDto result2 = gson.fromJson(swapi2, SwapiPlanetsDto.class);
    SwapiPlanetsDto result3 = gson.fromJson(swapi3, SwapiPlanetsDto.class);
    SwapiPlanetsDto result4 = gson.fromJson(swapi4, SwapiPlanetsDto.class);
    SwapiPlanetsDto result5 = gson.fromJson(swapi5, SwapiPlanetsDto.class);
    
    AllDto result = new AllDto(result1, result2, result3, result4, result5);
    String resultJson = gson.toJson(result);
    return resultJson;
    
}
    
    
    
    
    
}