package ru.rapapum.recipes.model;

import com.googlecode.objectify.annotation.Unindexed;

import javax.persistence.Embedded;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 27/02/11
 * Time: 21:25
 */
@Unindexed
public final class Ingredient {
    
    String title;

    @Embedded
    Quantity quantity;
}
