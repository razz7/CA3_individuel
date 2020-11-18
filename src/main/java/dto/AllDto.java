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
public class AllDto {
    
    private String personName;
    private String planetName;
    private String planetName2;
    private String planetName3;
    private String planetName4;
 

    public AllDto(SwapiPeopleDtp personName, SwapiPlanetsDto planetName, SwapiPlanetsDto planetName2, SwapiPlanetsDto planetName3, SwapiPlanetsDto planetName4) {
        this.personName = personName.getName();
        this.planetName = planetName.getName();
        this.planetName2 = planetName2.getName();
        this.planetName3 = planetName3.getName();
        this.planetName4 = planetName4.getName();

    }

    public AllDto() {
    }
    
    
    
}
