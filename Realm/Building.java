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
public class Building {
    
    public enum Tipus{TOWN_HALL,BARACKS,WALL,MARKETPLACE,HOUSE};
    private int ID;
    Tipus E_Epulet[]={Tipus.TOWN_HALL,Tipus.BARACKS,Tipus.WALL,Tipus.MARKETPLACE,Tipus.HOUSE};
    Tipus Epulet_tipus;
    Town varos;
    int szint;
    private final static int MAX_SZINT=20; 
    
    public Building()
    {
        
    }
    
    public Building(int id,Tipus ep,Town varos)
    {
        ID=id;
        Epulet_tipus=ep;
        this.varos=varos;
        szint=1;
        
    }
    
    public void fejleszt()
    {
        szint++;
    }
    
    public int get_ID()
    {
        return ID;
    }
    
    public void Function()
    {
        switch(Epulet_tipus)
        {
            case TOWN_HALL:
            {
                
           
                int i=1;
                System.out.println("Meglévő épületek:");
                varos.Get_Buildings();
                System.out.println("Építhető épületek:");
                for(Tipus t:E_Epulet)
                {
                    if(!(varos.hasBuilding(t)))
                        System.out.println(i+". :"+t);
                }
                System.out.println("Fejleszthető épületek:");
                for(Tipus t:E_Epulet)
                {
                    if((varos.hasBuilding(t)))
                    {
                        ArrayList<Building> temp_ep=new ArrayList();
                        temp_ep=varos.getBuilding(t);
                        for(Building b:temp_ep)
                        {
                            if (b.get_Szint()<MAX_SZINT)
                                System.out.println(i+". :"+t+" szint:"+b.get_Szint());
                        }
                    }
                    
                    
                        
                    
                    
                }
            }
        
        
        }
    }
    
    
    
    public String get_Tipus()
    {
        return Epulet_tipus.toString();
    }
    
    public int get_Szint()
    {
        return szint;
    }
}
