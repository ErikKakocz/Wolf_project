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
public class Item_Base {
    public enum item_type{NONE,LEGGING,CLOTH,WEAPON,HELMET}
    public enum cloth{NONE,ARMOR,ROBE,CLOAK,CLOTHING}
    public enum weapon{NONE,SWORD,LONGBOW,CROSSBOW,STAFF,DAGGERS,MACE,AXE}
    public enum helmet{NONE,CAP,HOOD,HELMET}  
    public enum fabric{CLOTH,BRONZE,IRON,LEAD,DIAMOND,WOOD}
    
    public enum compare_base{PRICE,STATE,TYPE}
}
