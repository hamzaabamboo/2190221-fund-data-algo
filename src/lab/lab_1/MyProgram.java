package lab.lab_1;

public class MyProgram {

    public static void main(String[] args) {
        // Initial State

        // Planes
        Aircraft jaguar = new Aircraft();
        Aircraft bear = new Aircraft();
        Aircraft eagle = new Aircraft(50, 100);
        // Carriers
        Carrier ship1 = new Carrier();
        Carrier ship2 = new Carrier(new Aircraft[]{jaguar, bear, null, null, null});

        // State Change 1
        ship2.planeTakeoff(jaguar);
        ship2.planeTakeoff(bear);

        jaguar.setCurrentSpeed(105);
        bear.setCurrentSpeed(90);

        // State Change 2
        ship1.planeLand(jaguar);
        ship1.planeLand(bear);
        ship2.planeLand(eagle);

    }
}
