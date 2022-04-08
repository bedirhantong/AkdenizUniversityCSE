package com.bedirhan.undergraduate.CSE102.CSE102L;

public class Main{
    public static void main(String[] args) {
        // TODO: Find what's the difference between them
        System.out.println(Plant.class.getSimpleName()+" "+Plant.class.getName());




    }
}

abstract class Plant {
    private String genus;
    private String species;
    private boolean isAnnual;

    public Plant() {

    }


    public void printPlant(){
        System.out.println(getClass().toString());
    }

    @Override
    public String toString() {
        return this.getClass().getName() +
                "genus='" + genus + '\'' +
                ", species='" + species + '\'' +
                ", isAnnual=" + isAnnual;
    }

    public void setAnnual(boolean annual) {
        isAnnual = annual;
    }

    public String getGenus() {
        return genus;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isAnnual() {
        return isAnnual;
    }

    public Plant(String genus, String species, boolean isAnnual) {
        this.genus = genus;
        this.species = species;
        this.isAnnual = isAnnual;
    }

}

class Tree extends Plant{
    private String barkColor;
    private String leafType;
    Tree(String genus, String species, boolean isAnnual){
        super(genus,species,isAnnual);
        this.barkColor = "brown";
        this.leafType = "round";

    }
    Tree(String genus, String species, boolean isAnnual,String barkColor,String leafType){
        super(genus,species,isAnnual);
        this.leafType = leafType;
        this.barkColor = barkColor;
    }


    public String getBarkColor() {
        return barkColor;
    }

    public void setBarkColor(String barkColor) {
        this.barkColor = barkColor;
    }

    public String getLeafType() {
        return leafType;
    }

    public void setLeafType(String leafType) {
        this.leafType = leafType;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+
                "barkColor='" + barkColor + '\'' +
                ", leafType='" + leafType + '\'';
    }
}

class Flower extends Plant{
    String petalColor;
    Flower(String genus, String species, boolean isAnnual){
        super(genus,species,isAnnual);
        String petalColor = "brown";

    }
    Flower(String genus, String species, boolean isAnnual, String petalColor){
        super(genus,species,isAnnual);
       this.petalColor = petalColor;
    }


    public String getPetalColor() {
        return petalColor;
    }

    public void setPetalColor(String petalColor) {
        this.petalColor = petalColor;
    }

    @Override
    public String toString() {
        return this.getClass().getName() +
                "petalColor='" + petalColor;
    }
}
class Rose extends Flower{
    boolean isHybrid;

    Rose(String genus, String species, boolean isAnnual) {
        super(genus, species, isAnnual);
    }

    Rose(String genus, String species, boolean isAnnual, String petalColor) {
        super(genus, species, isAnnual, petalColor);
    }
}

