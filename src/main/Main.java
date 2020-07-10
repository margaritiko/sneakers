package main;

public class Main {

    public static void main(String[] args) {

        int numberOfBoxes = 3;
        int percentageOfIncome = 20;

        BoutiqueComponent boutiqueComponent = DaggerBoutiqueComponent
                .builder()
                .numberOfBoxes(numberOfBoxes)
                .percentageOfIncome(percentageOfIncome)
                .build();
        
        boutiqueComponent.getBoutique().showStock();
    }
}
