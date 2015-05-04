

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;
import java.util.Comparator;
/**
 *
 * @author shadowwolf
 */
class damage_comp implements Comparator
{
    @Override
    public int compare(Object a,Object b)
    {
        Item a1=(Item)a;
        Item b1=(Item)b;
        if (a1.state>b1.state) return 1;
        else if (a1.state<b1.state) return -1;
        else return 0;
    }

}

class price_comp implements Comparator
{
    @Override
    public int compare(Object a,Object b)
    {
        Item a1=(Item)a;
        Item b1=(Item)b;
        if (a1.price>b1.price) return 1;
        else if (a1.price<b1.price) return -1;
        else return 0;
        
    }

}

class type_comp implements Comparator
{
    @Override
    public int compare(Object a,Object b)
    {
        Item a1=(Item)a;
        Item b1=(Item)b;
        return a1.type.toString().compareToIgnoreCase(b1.type.toString());
    }

}

public class Item implements Interfaces.Comparable_By{
    
    
    protected int price;
    protected int state;
    protected Item_Base.item_type type;
    
    
    public Item()
    {
        type=Item_Base.item_type.NONE;
        state=0;
        price=0;
    }
    public Item(Item_Base.item_type fajta)
    {
        type=fajta;
        state=100;
    }
    
    public int sellPrice()
    {
        return (int)(this.price*0.25);
    }
    
    public int buyPrice()
    {
        return price;
    }
    
    private void setprice(int price)
    {
        this.price=price;
    
    }
    
    
    public Item getItem()
    {
        return this;
    }
    
    
    @Override
    public int compareTo(Item_Base.compare_base alap,Item o)
    {
        switch(alap)
        {
            case PRICE:
            {
                if (this.price<o.price) return 1;
                else if (this.price==o.price) return 0;
                else return -1;
            }
            case STATE:
            {
                if (this.state<o.state) return 1;
                else if (this.state==o.state) return 0;
                else return -1;
            }
            case TYPE:
            {
                if (this.type.compareTo(o.type)==1) return 1;
                else if (this.type.compareTo(o.type)==0) return 0;
                else return -1;
            }
            default:
                return -2;
        }
    }
   
    



}
