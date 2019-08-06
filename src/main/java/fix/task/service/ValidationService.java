package fix.task.service;

import fix.task.util.Util;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean checkParams(String width, String height, String start, String end) {
        if (width != null && height != null && start != null && end != null) {
            if (checkParamsFormat(width, height, start, end)) {
                return checkParamsCompatibility(width, height, start, end);
            } else {
                return false;
            }
        } else return false;
    }

    public boolean checkParamsFormat(String width, String height, String start, String end) {
        return width.matches("^([0-9]*[1-9][0-9]*)$") && height.matches("^([0-9]*[1-9][0-9]*)$") && end.matches("^([a-zA-Z]+[0-9]*[1-9][0-9]*)$") && start.matches("^([a-zA-Z]+[0-9]*[1-9][0-9]*)$");
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
