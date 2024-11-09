package org.example.lab09_20192434.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "favoriteCoctel")
public class FavoriteCoctel {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "idDrink", nullable = false, length = 50)
    private String idDrink;

    @Column(name = "strDrink", length = 255)
    private String strDrink;

    @Column(name = "strDrinkThumb", length = 255)
    private String strDrinkThumb;

    @Column(name = "strDrinkAlternate", length = 255)
    private String strDrinkAlternate;

    @Column(name = "strTags", length = 255)
    private String strTags;

    @Column(name = "strVideo", length = 255)
    private String strVideo;

    @Column(name = "strCategory", length = 100)
    private String strCategory;

    @Column(name = "strIBA", length = 100)
    private String strIBA;

    @Column(name = "strAlcoholic", length = 50)
    private String strAlcoholic;

    @Column(name = "strGlass", length = 100)
    private String strGlass;

    @Column(name = "strInstructions", columnDefinition = "TEXT")
    private String strInstructions;

    @Column(name = "strInstructionsES", columnDefinition = "TEXT")
    private String strInstructionsES;

    @Column(name = "strIngredient1", length = 100)
    private String strIngredient1;

    @Column(name = "strIngredient2", length = 100)
    private String strIngredient2;

    @Column(name = "strIngredient3", length = 100)
    private String strIngredient3;

    @Column(name = "strIngredient4", length = 100)
    private String strIngredient4;

    @Column(name = "strIngredient5", length = 100)
    private String strIngredient5;

    @Column(name = "strIngredient6", length = 100)
    private String strIngredient6;

    @Column(name = "strIngredient7", length = 100)
    private String strIngredient7;

    @Column(name = "strIngredient8", length = 100)
    private String strIngredient8;

    @Column(name = "strIngredient9", length = 100)
    private String strIngredient9;

    @Column(name = "strIngredient10", length = 100)
    private String strIngredient10;

    @Column(name = "strMeasure1", length = 50)
    private String strMeasure1;

    @Column(name = "strMeasure2", length = 50)
    private String strMeasure2;

    @Column(name = "strMeasure3", length = 50)
    private String strMeasure3;

    @Column(name = "strMeasure4", length = 50)
    private String strMeasure4;

    @Column(name = "strMeasure5", length = 50)
    private String strMeasure5;

    @Column(name = "strMeasure6", length = 50)
    private String strMeasure6;

    @Column(name = "strMeasure7", length = 50)
    private String strMeasure7;

    @Column(name = "strMeasure8", length = 50)
    private String strMeasure8;

    @Column(name = "strMeasure9", length = 50)
    private String strMeasure9;

    @Column(name = "strMeasure10", length = 50)
    private String strMeasure10;

    @Column(name = "strImageSource", length = 255)
    private String strImageSource;

    @Column(name = "strImageAttribution", length = 255)
    private String strImageAttribution;

    @Column(name = "dateModified")
    private String dateModified;

}
