package me.sungbin;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello JUnit");

        // 원초적인 방법
        Calculator calculator = new Calculator(new KrwCalculator());
        System.out.println(calculator.sum(10, 10));
        System.out.println(calculator.minus(20, 10));

        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator1 = new Calculator(dollarCalculator);

        System.out.println(calculator1.sum(10, 10));
    }
}
