package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            String[] names = getNamesFromUser();
            int rounds = getRoundsFromUser();
            RacingGame game = new RacingGame(names, rounds);
            game.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private static String[] getNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        validateNames(names);
        return names;
    }

    private static void validateNames(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static int getRoundsFromUser() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요.");
        }
    }
}
