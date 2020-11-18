/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author rh
 */
@Entity
public class Superhero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Sh_name;
    private String power;

    public Superhero(String Sh_name, String power) {
        this.id = id;
        this.Sh_name = Sh_name;
        this.power = power;
    }

    public Superhero() {
    }

    public String getSh_name() {
        return Sh_name;
    }

    public void setSh_name(String Sh_name) {
        this.Sh_name = Sh_name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}
