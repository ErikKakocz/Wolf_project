/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

/**
 *
 * @author shadowwolf
 */
public class Weapon extends Item{
    
    
    
    double damage,defense,speed;
    int range;
    String name;
    
    
    public Weapon(Item_Base.weapon fajta,Item_Base.fabric anyag)
    {
        super(Item_Base.item_type.WEAPON);
        name=anyag.toString()+' '+fajta.toString();
        
    }
    @Override
    public String toString(){
        return name;
    }
    
    
    
}
