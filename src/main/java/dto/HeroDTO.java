/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Superhero;

/**
 *
 * @author rh
 */
public class HeroDTO {
    
    private String SH_name;
    private String power;

    public HeroDTO(Superhero sh) {
        this.SH_name = sh.getSh_name();
        this.power = sh.getPower();
    }

    public HeroDTO() {
    }

    
    public String getSH_name() {
        return SH_name;
    }

    public void setSH_name(String SH_name) {
        this.SH_name = SH_name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
    
    
}
