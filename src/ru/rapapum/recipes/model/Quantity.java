package ru.rapapum.recipes.model;

import com.googlecode.objectify.annotation.Unindexed;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 27/02/11
 * Time: 21:25
 */
@Unindexed
public final class Quantity {

    Integer quantity;
    
    String measure;
}
