package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(String[] names, int rounds) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.rounds = rounds;
    }

    public void start() {
        for (int i = 0; i < rounds; i++) {
            race();
            printRaceResult();
        }
        printWinners();
    }

    private void race() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    private void printRaceResult() {
        for (Car car : cars) {
            StringBuilder result = new StringBuilder();
            result.append(car.getName()).append(" : ");
            for (int i = 0; i < car.getPosition(); i++) {
                result.append("-");
            }
            System.out.println(result);
        }
        System.out.println();
    }

    private void printWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
