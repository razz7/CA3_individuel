/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author rh
 */
public class SwapiPeopleDtp {
    
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String[] films;
    private String[] species;
    private String[] vehicles;
    private String[] starchips;
    private String created;
    private String edited;
    private String Url;

    public SwapiPeopleDtp(String name, String height, String mass, String hair_color, String skin_color, String eye_color, String birth_year, String gender, String homeworld, String[] films, String[] species, String[] vehicles, String[] starchips, String created, String edited, String Url) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld = homeworld;
        this.films = films;
        this.species = species;
        this.vehicles = vehicles;
        this.starchips = starchips;
        this.created = created;
        this.edited = edited;
        this.Url = Url;
    }
    
    
    public String getName() {
        return name;
    }
    
    
}
