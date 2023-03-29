package model;

import exceptions.Exceptions;

import java.util.ArrayList;

public class Recipe {

    //Relationship
    private final ArrayList<Ingredient> recipe;

    //Builder
    public Recipe() {
        this.recipe = new ArrayList<>();
    }

    //AddIngredient
    public void addIngredient(Ingredient...ingredients) {
        for (Ingredient ingredient : ingredients) {
            if (exist(ingredient)) {
                updateIngredient(ingredient);
            } else {
                recipe.add(ingredient);
            }
        }
    }

    public void removeIngredient(String name) throws Exceptions.NotExistIngredient {
        if (searchIngredient(name) == null) throw new Exceptions.NotExistIngredient();
        recipe.remove(searchIngredient(name));
    }

    private void updateIngredient(Ingredient ingredient) {
        for (Ingredient value : recipe) {
            if (value.getName().equals(ingredient.getName())) {
                value.addWeight(value.getWeight(), ingredient.getWeight());
                return;
            }
        }
    }

    private boolean exist(Ingredient current) {
        if (recipe.isEmpty() || current == null) return false;
        for (Ingredient ingredient : recipe) {
            if (current.getName().equals(ingredient.getName())) {
                return true;
            }
        }
        return false;
    }

    public Ingredient searchIngredient(String name) {
        for (Ingredient ingredient : recipe) {
            if (ingredient.getName().equals(name)) {
                return ingredient;
            }
        }
        return null;
    }

    public int sizeRecipe() {
        return recipe.size();
    }
}
