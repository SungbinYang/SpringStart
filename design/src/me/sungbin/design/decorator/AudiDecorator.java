package me.sungbin.design.decorator;

public class AudiDecorator implements ICar {

    protected ICar iCar;
    protected String modelName;
    protected int modelPrice;

    public AudiDecorator(ICar icar, String modelName, int modelPrice) {
        this.iCar = icar;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
    }

    @Override
    public int getPrice() {
        return iCar.getPrice() + modelPrice;
    }

    @Override
    public void showPrice() {
        System.out.println(modelName + "의 가격은 " + getPrice() + "원 입니다.");
    }
}