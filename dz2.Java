import java.util.*;

public class Main {

    public static void main(String[] args) {
        Queue<Passenger> pier = new LinkedList<>();
        List<Boat> boats = new ArrayList<>();
        Random random = new Random();

        int maxPeople = 10; 

        for (int i = 0; i < 5; i++) {
            boats.add(new Boat(5 + random.nextInt(6), random.nextBoolean()));
        }

        int totalWaitTime = 0;
        int servedPeople = 0;

        for (int time = 0; time < 10; time++) {

            int newPeople = random.nextInt(4); 
            for (int i = 0; i < newPeople; i++) {
                if (pier.size() < maxPeople) {
                    pier.add(new Passenger(time));
                }
            }

            if (random.nextBoolean()) {
                Boat boat = boats.get(random.nextInt(boats.size()));
                int seats = boat.capacity;

                while (seats > 0 && !pier.isEmpty()) {
                    Passenger p = pier.poll();
                    totalWaitTime += (time - p.arrivalTime);
                    servedPeople++;
                    seats--;
                }
            }
        }

        if (servedPeople > 0) {
            System.out.println("Середній час очікування: " + (double) totalWaitTime / servedPeople);
        } else {
            System.out.println("Немає обслужених пасажирів.");
        }

        System.out.println("Кількість людей, що залишились на причалі: " + pier.size());
    }
}

class Passenger {
    int arrivalTime;

    public Passenger(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}

class Boat {
    int capacity;
    boolean isFinalStop;

    public Boat(int capacity, boolean isFinalStop) {
        this.capacity = capacity;
        this.isFinalStop = isFinalStop;
    }
}