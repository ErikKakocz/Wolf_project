/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Realm;

import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 *
 * @author shadowwolf
 */
public class InteriorFieldBase {
    
    class koord{
        public int x,y;
        
        public koord(int a,int b){
            x=a;
            y=b;
        }
    }
    
    enum ItemType{Road,} //
    int mapx, mapy;
    
    class InteriorObject{
        int posx,posy;
        
        public InteriorObject(int posx,int posy){
            this.posx=posx;
            this.posy=posy;
            
        }
    }
    
    ArrayList<koord> utkeres(int x,int y,int cel_x,int cel_y){
        ArrayList koordok=new ArrayList();
        //TODO: útkeresésnek utánnanézni!!!!
        return koordok;
    }
    
    class InteriorCharacter extends InteriorObject{
            
        Characters.Game_Character karakter;
            
        public InteriorCharacter(int x, int y,Characters.Game_Character kar){
            super(x,y);
            karakter=kar;
        }
        
        //TODO: moveneigh vagy move metódusban akadályokat kezelni.
        
        public void moveneigh(int mx,int my){
            if(((abs(mx-this.posx))<=1)&&((abs(my-posy))<=1)){
                posx=mx;
                posy=my;
            }
        }
        
        public void move(int mx,int my){
            ArrayList<koord> utvonal=utkeres(posx,posy,mx,my);
            while(posx!=mx && posy!=my){
                
                moveneigh(mx,my);
            }
        }
        
        public void attack(int ax,int ay,InteriorCharacter k2){
            try{
            karakter.Attack(k2.karakter,posx,posy,k2.posx,k2.posy);
            }catch(Exceptions.CannotAttackException e){
                System.out.println("érvénytelen támadás");
            }
            //átdolgozni
        }
    }
    
    class InteriorBuilding extends InteriorObject{
        //bal felső koordináták
        Building building;
        int offset_x,offset_y;
        
        public InteriorBuilding(int x,int y,Building b){
            super(x,y);
            building=b;
        }
    }
    
    class InteriorItem extends InteriorObject{
    
        ItemType tip;
        
        public InteriorItem(int x,int y,ItemType t){
            super(x,y);
            tip=t;
        }
    }
}
