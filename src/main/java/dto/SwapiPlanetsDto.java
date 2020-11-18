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
public class SwapiPlanetsDto {

    private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private String[] residents;
    private String[] films;
    private String created;
    private String edited;
    private String url;

    public SwapiPlanetsDto(String name, String rotation_period, String orbital_period, String diameter, String climate, String gravity, String terrain, String surface_water, String population, String[] residents, String[] films, String created, String edited, String url) {
        this.name = name;
        this.rotation_period = rotation_period;
        this.orbital_period = orbital_period;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surface_water = surface_water;
        this.population = population;
        this.residents = residents;
        this.films = films;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    
    public String getName() {
        return name;
    }

}
