package com.company;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();
        director.setCarBuilder(new FordMondeoBuilder());
        Car car = director.buildCar();
        System.out.println(car);
        
        director.setCarBuilder(new SubaruImprezaBuilder());
        car = director.buildCar();
        System.out.println(car);
    }
}

enum Transmission{
    MANUAL, AUTO
}

class Car{
    private String make;
    private Transmission transmission;
    private int maxSpeed;

    public void setMake(String make){
        this.make = make;
    }
    public void setTransmission(Transmission transmission){
        this.transmission = transmission;
    }
    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car [make=" + make + ", transmission=" + transmission
                + ", maxSpeed=" + maxSpeed + "]";
    }
}

abstract class CarBuilder{
    protected Car car;
    public void create(){
        car = new Car();
    }

    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    public Car getCar(){
        return car;
    }
}

class FordMondeoBuilder extends CarBuilder{

    @Override
    public void buildMake() {
        car.setMake("Ford Mondeo");
    }

    @Override
    public void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    public void buildMaxSpeed() {
        car.setMaxSpeed(180);
    }
}

class SubaruImprezaBuilder extends CarBuilder{

    @Override
    public void buildMake() {
        car.setMake("Subaru Impreza");
    }

    @Override
    public void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    public void buildMaxSpeed() {
        car.setMaxSpeed(260);
    }
}

class Director{
    private CarBuilder carBuilder;

    void setCarBuilder(CarBuilder b){
        carBuilder = b;
    }

    public Car buildCar(){
        carBuilder.create();
        carBuilder.buildMake();
        carBuilder.buildTransmission();
        carBuilder.buildMaxSpeed();
        Car car = carBuilder.getCar();
        return car;
    }
}