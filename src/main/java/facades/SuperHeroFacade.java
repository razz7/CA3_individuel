/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import static com.mysql.cj.protocol.x.XProtocolDecoder.instance;
import dto.HeroDTO;
import entities.Superhero;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rh
 */
public class SuperHeroFacade {

    private static EntityManagerFactory emf;
    private static SuperHeroFacade instance;

    public SuperHeroFacade() {

    }

    public static SuperHeroFacade getHeroFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new SuperHeroFacade();
        }
        return instance;
    }
    
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public ArrayList<HeroDTO> getAllheros() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Superhero> query = em.createQuery("SELECT s FROM Superhero S", Superhero.class);
            ArrayList<HeroDTO> heros = new ArrayList();
            for (Superhero s : query.getResultList()) {
                heros.add(new HeroDTO(s));
            }
            System.out.println("Size persons" + heros.size());
            return heros;
        } finally {
            em.close();
        }
    }
    
    
    public String createHero(HeroDTO hero) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Superhero SH = new Superhero(hero.getSH_name(), hero.getPower());
            em.persist(SH);
            em.getTransaction().commit();
            return "Hero created";
        } finally {
            em.close();
        }
            
            
        }
    }



