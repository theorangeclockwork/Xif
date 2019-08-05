package fix.task;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean checkParams(String width, String height, String start, String end) {
        if (checkParamsFormat(width, height, start, end)) {
            return checkParamsCompatibility(width, height, start, end);
        } else {
            System.out.println("checkParamsFormat error");
            return false;
        }
    }

    public boolean checkParamsFormat(String width, String height, String start, String end) {
        return width.matches("^(\\d+)$") && height.matches("^(\\d+)$") && end.matches("^([a-zA-Z]+\\d+)$") && start.matches("^([a-zA-Z]+\\d+)$");
    }

    public boolean checkParamsCompatibility(String width, String height, String start, String end) {
        int startVer = Util.convertToDecimal(Util.extractVertical(start), 26);
        int startHor = Util.extractHorizontal(start);

        int endVer = Util.convertToDecimal(Util.extractVertical(end), 26);
        int endHor = Util.extractHorizontal(end);

        int widthInt = Integer.parseInt(width);
        int heightInt = Integer.parseInt(height);

        return (startVer <= widthInt) && (startHor <= heightInt) && (endVer <= widthInt) && (endHor <= heightInt);
    }

}
