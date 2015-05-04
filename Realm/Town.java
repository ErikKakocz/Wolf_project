/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Realm;

import java.util.ArrayList;

/**
 *
 * @author shadowwolf
 */
public class Town extends Field{
    
    private String nev;
    private int level;
    private int epuletek_szama;
    ArrayList<Building> epuletek;
    
    
    public Town()
    {
    }
    
    public Town(String nev)
    {
        this.nev=nev;
        epuletek=new ArrayList();
        add_building(Building.Tipus.TOWN_HALL);        
    }
    
    private void add_building(Building.Tipus t)
    {        
        epuletek.add(new Building(++epuletek_szama,t,this));
    }
    
    public void Building_Function(Building.Tipus tipus)
    {
        for(Building b:epuletek)
        {
            if(b.get_Tipus().equals(tipus.toString())) b.Function();
        }
    }
    
    public void Get_Buildings()
    {
        int i=1;
        for(Building b:epuletek)
        {
            
            System.out.println(i+". "+b.get_Szint()+" "+b.get_Tipus());
            i++;
        } 
    }
    
    public boolean hasBuilding(Building.Tipus epulet)
    {
        
        for(Building e:epuletek)
        {
           if (e.get_Tipus().equals(epulet.toString())) return true;
        }
        return false;
    }
    
    public ArrayList<Building> getBuilding(Building.Tipus epulet)
    {
        ArrayList<Building> res=new ArrayList();
        for(Building e:epuletek)
        {
            if(e.get_Tipus().equals(epulet.toString())) res.add(e);
        }
        return res;
    }
}
