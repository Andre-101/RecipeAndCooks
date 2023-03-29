import exceptions.Exceptions;
import model.Ingredient;
import model.Recipe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestRecipeAndCooks {

    //Relationship
    private Ingredient setupStage1;
    private Recipe setupStage2;
    private Recipe setupStage3;


    @BeforeEach
    public void setup(){
        setupStage1 = new Ingredient("Tomate", 245);
        setupStage2 = new Recipe();
        setupStage3 = new Recipe();
        setupStage3.addIngredient(
                new Ingredient("Cebolla", 315),
                new Ingredient("Ajo", 58),
                new Ingredient("Arroz", 520)
        );
    }

    @Test
    public void addWeightTheWayCorrect(){
        assertDoesNotThrow(()-> setupStage1.addWeight(245, 54));
    }

    @Test
    public void addWeightMistakeOldWeight(){
        assertThrows(Exceptions.NotEqualsOldWeight.class, ()-> setupStage1.addWeight(315, 54));
    }

    @Test
    public void addWeightWithNegativeNumbers(){
        assertThrows(Exceptions.NegativeNumbers.class, ()-> setupStage1.addWeight(245, -100), "Don't use negative numbers");
    }

    @Test
    public void removeWeightMistakeOldWeight(){
        assertThrows(Exceptions.NotEqualsOldWeight.class, ()-> setupStage1.removeWeight(345, 45));
    }

    @Test
    public void removeWeightWithNegativeNumbers(){
        assertThrows(Exceptions.NegativeNumbers.class, ()-> setupStage1.removeWeight(245, -100), "Don't use negative numbers");
    }

    @Test
    public void removeWeightWithNumberBiggerThanWeight(){
        assertThrows(Exceptions.NegativeWeight.class, ()-> setupStage1.removeWeight(245, 300), "The final weight can't negative");
    }

    @Test
    public void addOneIngredient() {

        setupStage2.addIngredient(new Ingredient("Sal",12));

        assertEquals(1,setupStage2.sizeRecipe());
    }

    @Test
    public void addIngredientAndHaveFour() {

        setupStage3.addIngredient(new Ingredient("Pimienta", 6));

        assertEquals(4, setupStage3.sizeRecipe());
    }

    @Test
    public void updateIngredient() {

        setupStage3.addIngredient(new Ingredient("Ajo",21));

        assertEquals(79, setupStage3.searchIngredient("Ajo").getWeight());
    }

    @Test
    public void removeOneIngredient(){
        setupStage3.removeIngredient("Ajo");
        assertEquals(2,setupStage3.sizeRecipe());
    }
}
