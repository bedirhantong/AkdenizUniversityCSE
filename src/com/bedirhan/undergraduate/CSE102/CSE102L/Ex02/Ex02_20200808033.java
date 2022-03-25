package com.bedirhan.undergraduate.CSE102.CSE102L.Ex02;

import java.util.ArrayList;
public class Ex02_20200808033 {
    public static void main(String[] args) {

    }
}
class Engine {


    int gearCount;
    int currentGear;

    public Engine(int numberOfGears) {
        this.gearCount = numberOfGears;
        this.currentGear = 0 ;
    }

    public int getGearCount() {
        return gearCount;
    }

    public int getCurrentGear() {

        return currentGear;
    }
    public void shiftUp(){
        this.currentGear++;
    }
    public void shiftDown(){
        this.currentGear--;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "gearCount=" + gearCount +
                ", currentGear=" + currentGear +
                '}';
    }
}
class Vehicle{
    Engine engine;
    int speed;
    int maxSpeed;
    int changeInSpeed;
    int gasTankCapacity;
    double currentGasInTank;

    public void setCurrentGasInTank(double currentGasInTank) {
        this.currentGasInTank = currentGasInTank;
    }

    public Vehicle(int numberOfGears, int maxSpeed, int changeInSpeed, int gasTankCapacity) {
        this.maxSpeed = maxSpeed;
        this.changeInSpeed = changeInSpeed;
        this.gasTankCapacity = gasTankCapacity;
        this.engine = new Engine(numberOfGears);
        this.currentGasInTank = gasTankCapacity-((int) (Math.random() * 10)+5);
    }

    public Vehicle() {
    }
    public final void setGear(){
        int gear= (int) Math.floor((double) (getSpeed())/20);

        if (engine.getCurrentGear() > gear){
            for (int i = gear; i < engine.getCurrentGear(); i++) {
                engine.shiftDown();
            }
        }
        else if (engine.getCurrentGear() < gear){
            for (int i = gear; i > engine.getCurrentGear(); i--) {
                engine.shiftUp();
            }
        }
    }

    public void accelerate(){
        consumeGas();
    }
    public void decelerate(){
        consumeGas();
    }
    public int getSpeed() {
        return speed;
    }
    public double refuel(){
        return 0.0;
    }

    public void consumeGasHelper(int num){
        setCurrentGasInTank(currentGasInTank-num*engine.getCurrentGear());
    }

    public final void consumeGas(){
        if( this instanceof Car){
            consumeGasHelper(2);
        }
        else if(this instanceof Bus){
            consumeGasHelper(5);
        }
        else if (this instanceof Motorcycle){
            consumeGasHelper(3);
        }
    }


    public int getChangeInSpeed() {
        return changeInSpeed;
    }

    public void setChangeInSpeed(int changeInSpeed) {
        this.changeInSpeed = changeInSpeed;
    }

    public double getGasPercentage(){
        return (100*(currentGasInTank))/gasTankCapacity;
    }

    @Override
    public String toString() {
        return getClass().getName()+
                ", speed=" + getSpeed() +
                ", changeInSpeed=" + getChangeInSpeed() +
                ", maximum speed=" + maxSpeed +
                ",gas percentage="+getGasPercentage()+
                "engine=" + engine +
                '}';
    }
}
class Car extends Vehicle{
    static final int NUMBER_OF_GEARS = 6;
    static final int GAS_TANK_CAPACITY = 50;
    int doorCount = 4;

    public Car() {
        super();
        super.changeInSpeed = 20;
        super.maxSpeed = 120;
    }

    public Car(int maxSpeed,int changeInSpeed){
        super(NUMBER_OF_GEARS,maxSpeed,changeInSpeed,GAS_TANK_CAPACITY);
    }

    public Car(int maxSpeed,int changeInSpeed,int doorCount){
        this.doorCount = doorCount;
        super.maxSpeed = maxSpeed;
        super.changeInSpeed = changeInSpeed;
    }

    public void accelerate(int changeInSpeed){
        super.accelerate();
        speed += Math.abs(changeInSpeed);
        if (getGasPercentage() < ((100)*(double)(speed/maxSpeed))){
            System.out.println("Fuel is low");
        }
    }
    public void decelerate(int changeInSpeed){
        super.decelerate();
        speed -= Math.abs(changeInSpeed);
    }
    public double refuel(){
        super.refuel();
        currentGasInTank +=  (50.0/GasStation.costPerLiter);
        return (50.0/GasStation.costPerLiter);
    }

    @Override
    public String toString() {
        return super.toString()+
                "doorCount=" + doorCount;
    }
}
class Motorcycle extends Vehicle{
    static final int NUMBER_OF_GEARS = 6;
    static final int GAS_TANK_CAPACITY = 50;
    String color;

    public Motorcycle() {
        super();
        super.changeInSpeed = 20;
        super.maxSpeed = 120;
    }

    public Motorcycle(int maxSpeed,int changeInSpeed){
        super(NUMBER_OF_GEARS,maxSpeed,changeInSpeed,GAS_TANK_CAPACITY);
    }

    public Motorcycle(int maxSpeed,int changeInSpeed,String color){
        this.color = color;
        super.maxSpeed = maxSpeed;
        super.changeInSpeed = changeInSpeed;
    }

    public void accelerate(int changeInSpeed){
        super.accelerate();
        speed += Math.abs(changeInSpeed);
        if (getGasPercentage() < ((100)*(double)(speed/maxSpeed))){
            System.out.println("Fuel is low");
        }
    }
    public void decelerate(int changeInSpeed){
        super.decelerate();
        speed -= Math.abs(changeInSpeed);
    }
    public double refuel(){
        super.refuel();
        double takenRefuel= gasTankCapacity-currentGasInTank;
        currentGasInTank = gasTankCapacity;
        return takenRefuel;
    }

    @Override
    public String toString() {
        return super.toString()+"Color="+color;
    }
}
class Bus extends Vehicle{
    static final int NUMBER_OF_GEARS = 6;
    static final int GAS_TANK_CAPACITY = 50;
    int standingPassengerCount;

    public Bus() {
        super();
        super.changeInSpeed = 20;
        super.maxSpeed = 120;
    }

    public Bus(int maxSpeed,int changeInSpeed){
        super(NUMBER_OF_GEARS,maxSpeed,changeInSpeed,GAS_TANK_CAPACITY);
    }

    public Bus(int maxSpeed,int changeInSpeed,int standingPassengerCount){
        this.standingPassengerCount = standingPassengerCount;
        super.maxSpeed = maxSpeed;
        super.changeInSpeed = changeInSpeed;
    }

    public void accelerate(int changeInSpeed){

        super.accelerate();
        speed += Math.abs(changeInSpeed);
        if (getGasPercentage() < ((100)*(double)(speed/maxSpeed))){
            System.out.println("Fuel is low");
        }
    }
    public void decelerate(int changeInSpeed){
        super.decelerate();
        speed -= Math.abs(changeInSpeed);
    }
    public double refuel(){
        super.refuel();
        double refuelTaken = gasTankCapacity*(0.8)-currentGasInTank;
        currentGasInTank =  gasTankCapacity*(0.8);
        return refuelTaken;
    }

    @Override
    public String toString() {
        return super.toString()+
                "standingPassengerCount=" + standingPassengerCount;
    }
}
class GasStation{
    ArrayList<Vehicle> vehicles;
    static final double costPerLiter =20.40;
    int vehicleLimit;

    public GasStation(int vehicleLimit) {
        this.vehicleLimit = vehicleLimit;
    }
    public GasStation() {
        this.vehicleLimit = 10;
    }

    public void fuelUpAll(){
        for (int i = 0; i < vehicleLimit; i++) {
            double gasPrice = vehicles.get(i).refuel()*costPerLiter;
            System.out.println(vehicles.get(i).toString()+"gasPrice="+gasPrice);
        }
    }
    public void fuelUpAll(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
        for (int i = 0; i < vehicleLimit; i++) {
            double gasPrice = vehicles.get(i).refuel()*costPerLiter;
            System.out.println(vehicles.get(i).toString()+"gasPrice="+gasPrice);
        }
    }
}

