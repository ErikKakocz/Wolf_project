/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Inventory.Item_Base;

/**
 *
 * @author shadowwolf
 */


public interface Comparable_By {
    
    abstract int compareTo(Item_Base.compare_base alap,Inventory.Item o);
    
}
