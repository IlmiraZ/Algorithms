package lesson5.power;

import static java.lang.Math.abs;

public class Power {
    public static double power(double num, int power) {
        if (power == 0) {
            return 1;
        } else if (power == 1) {
            return num;
        } else if (power < 0) {
            return 1 / (power(num, abs(power)));
        } else {
            return num * power(num, power - 1);
        }
    }
}
