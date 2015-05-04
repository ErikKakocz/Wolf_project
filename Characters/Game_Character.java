package Characters;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author shadowwolf
 */
import Inventory.Inventory;
import Inventory.Item;
import Exceptions.FullInventoryException;
import Exceptions.NoSuchItemException;
import Exceptions.NotEnoughFundsException;

public abstract class Game_Character {
    

    
    /**
     *attributes - alap tulajdonsagok
     *
     *
     */
    protected int Basic_Health_points,Health_points;
    protected int Basic_Attack_points,Attack_points;
    protected int Basic_Defense_points,Defense_points;
    protected int wisdom;
    
    //skills - megszerezhető tulajdonságok --
    
    //inventory
    protected int Money;
    protected Inventory targyak;
    
    
    
    public Game_Character(int HP,int BA,int BD,int wis,boolean letezik){
        if(!letezik){
        Money=0;
        targyak=new Inventory();
        Basic_Health_points=HP;
        Basic_Attack_points=BA;
        Basic_Defense_points=BD;
        wisdom=wis;
        }else{
        //beolvasás valamiből
        
        }
    }
    
    public void Attack(Game_Character enemy,int x,int y,int ex,int ey) throws Exceptions.CannotAttackException{}
    
    public void buy(Game_Character seller,int price,Item cucc){
        try{
        targyak.add(cucc);
        if(Money>=price)
            Money-=price;
        else throw new NotEnoughFundsException();
        seller.targyak.remove(cucc);
        seller.Money+=price;
        }catch(FullInventoryException | NoSuchItemException | NotEnoughFundsException e){
            System.out.println("hibas csere!");
        }
    }
    
    public void sell(Game_Character buyer,int price,Item cucc){
        try{
        targyak.remove(cucc);
        Money+=price;
        buyer.targyak.add(cucc);
        if(buyer.Money>price)
            buyer.Money-=price;
        else throw new NotEnoughFundsException();
        }catch(FullInventoryException | NoSuchItemException | NotEnoughFundsException e){
            System.out.println("hibás csere");
        }
    
    }
    
    public void acquire(Item cucc){
        try{
        targyak.add(cucc);
        }catch(FullInventoryException e){
            System.out.println("nincs hely");
        }
    }
    
    public void setMoney(int i){
        Money=i;
    }
    
    public int getMoney(){
        return Money;
    }
    
    public void getInventory(){
        
        targyak.kiir();
    }
    
}
