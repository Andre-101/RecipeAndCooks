package model;

import exceptions.Exceptions;

public class Ingredient {

    //Attribute
    private final String name;
    private int weight;


    //Builder
    public Ingredient(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public void addWeight(int oldWeight, int addingWeight) throws Exceptions {
        checkWeight(oldWeight, addingWeight);
        weight += addingWeight;
        System.out.println("The weight of ingredient was update to "+weight);
    }

    public void removeWeight(int oldWeight, int subtractWeight) throws Exceptions, Exceptions.NegativeWeight {
        checkWeight(oldWeight, subtractWeight);
        if (oldWeight < subtractWeight) throw new Exceptions.NegativeWeight();
        weight -= subtractWeight;
        System.out.println("The weight of ingredient was update to "+weight);
    }

    private void checkWeight(int weight, int operationWeight) throws Exceptions.NotEqualsOldWeight, Exceptions.NegativeNumbers {
        if (weight != this.weight) throw new Exceptions.NotEqualsOldWeight();
        if (operationWeight < 0) throw new Exceptions.NegativeNumbers();
    }

    //Getters

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

}
