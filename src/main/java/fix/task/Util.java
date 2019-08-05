package fix.task;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static int convertToDecimal(String str, int base) {
        int value = 0;
        int result = 0;
        int power = 0;
        str = str.toLowerCase();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            value = (int) c - 96;
            result += value * Math.pow(base, power);
            power++;
        }
        return result;
    }

    public static String extractVertical(String pos) {
        Pattern pattern = Pattern.compile("([a-zA-Z]+)");
        Matcher matcher = pattern.matcher(pos);
            return matcher.group(1);
    }

    public static int extractHorizontal(String pos) {
        Pattern pattern = Pattern.compile("([\\d]+)");
        Matcher matcher = pattern.matcher(pos);
            return Integer.parseInt(matcher.group(1));
    }

}
