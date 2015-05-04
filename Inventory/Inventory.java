/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import Exceptions.NoSuchItemException;
import Exceptions.FullInventoryException;




public class Inventory {

    
    
    Item[] cuccok;
    int cuccok_szama;
    
    public Inventory(){
        cuccok=new Item[64];
        cuccok_szama=0;
    }
    
    public int benneVan(Item cucc){
        for(int i=0;i<cuccok_szama;i++)
            if(cuccok[i]==cucc)return i;
        return -1;
    }
    
    public void add(Item cucc)throws FullInventoryException{
        if(cuccok_szama<64) cuccok[cuccok_szama++]=cucc;
        else throw new FullInventoryException();
    }
    
    public void remove(Item cucc)throws NoSuchItemException{
        if (benneVan(cucc)>=0){ 
            cuccok[benneVan(cucc)]=null;
            defrag();
            cuccok_szama--;
        }
        else throw new NoSuchItemException();
    }
    
    void defrag(){
        for(int i=0;i<cuccok.length-1;i++)
            if(cuccok[i]==null)
                for(int j=i;j<cuccok.length-1;j++){
                    cuccok[j]=cuccok[j+1];
                }
                    
    }
    
    public void kiir(){
        int i=0;
        if (cuccok_szama==0) System.out.println("üres");
        else
            while(i<cuccok_szama)
                System.out.println((i+1)+".:"+cuccok[i++]);
                
            
    }
}
