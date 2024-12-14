package attendance.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String chooseFunction() {
        return input();
    }

    public static String nickname() {
        return input();
    }

    public static String goTime() {
        return input();
    }

    public static String modifyDate() {
        return input();
    }

    public static String modifyTime() {
        return input();
    }

    public static String input() {
        return Console.readLine();
    }
}
