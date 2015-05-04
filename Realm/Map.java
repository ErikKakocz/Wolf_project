/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Realm;

import java.util.Random;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Set;
/**
 *
 * @author shadowwolf
 */
public class Map {
    private static final int MERET_X=100,MERET_Y=100;
    Dictionary<Integer,Characters.Game_Character> jatszo_karakterek;
    
    Field terkep[][];
    
    
    public Map()
    {
        terkep=new Field[MERET_X][MERET_Y];
    }
    
    public void init_map()
    {
        Random r=new Random();
        Field.field_type t;
        for(int i=0;i<MERET_X;i++)
            for(int j=0;j<MERET_Y;j++){
                
                switch(r.nextInt(5))
                {
                    case 0:{
                            t=Field.field_type.FOREST;
                            break;
                           }
                    case 1:{
                            t=Field.field_type.GRASSLAND;
                            break;
                           }
                    case 2:{
                            t=Field.field_type.HILL;
                            break;
                           }
                    case 3:{
                            t=Field.field_type.MOUNTAIN;
                            break;
                           }
                    default:{
                            t=Field.field_type.WATER;                            
                           }
                }
                terkep[i][j]=new Field(t);
            }
    }
    
    public void init_map(String s)
    {
        try{
        BufferedReader reader=new BufferedReader(new FileReader(s));
            
        }catch(IOException e){
        System.out.print(e);
        }
    }
    
    public void kiir()
    {
        for(int i=0;i<MERET_X;i++)
        {    
            for(int j=0;j<MERET_Y;j++)
                System.out.print(terkep[i][j].tipus.toString().substring(0, 1)+' ');
            System.out.print("\n\n");
        }
    }
    
    public void savemap()
    {
        //implementálásra vár
    }
    
    
}
