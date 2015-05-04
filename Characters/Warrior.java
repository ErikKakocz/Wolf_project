package Characters;


import static java.lang.Math.min;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author shadowwolf
 */
public class Warrior extends Game_Character{
    
    public Warrior(){
        super(100,10,8,3,false);
        
    }
    
    @Override
    public void Attack(Game_Character enemy,int x,int y,int ex,int ey) throws Exceptions.CannotAttackException{
        if (Math.abs(x-ex)>1 || Math.abs(y-ey)>1) throw new Exceptions.CannotAttackException();
        Random r=new Random();
        enemy.Health_points-=Attack_points-enemy.Defense_points*min(r.nextDouble()+wisdom/10,2.0);
    }
}
