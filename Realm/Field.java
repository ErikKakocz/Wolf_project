/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Realm;

/**
 *
 * @author shadowwolf
 */
public class Field {
    
    enum field_type{GRASSLAND,FOREST,WATER,HILL,MOUNTAIN};
    protected static final int max_jatekosok=50;
    
    protected field_type tipus;
    protected Characters.Game_Character jatekos_lista[];
    
    public Field()
    {
        this.tipus=field_type.GRASSLAND;
        jatekos_lista=new Characters.Game_Character[max_jatekosok];
        
    }
    
    public Field(field_type tipus)
    {
        this.tipus=tipus;
        jatekos_lista=new Characters.Game_Character[max_jatekosok];
        
    }
    
    
    
}
