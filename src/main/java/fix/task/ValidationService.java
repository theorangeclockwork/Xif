package fix.task;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean checkParams(String width, String height, String start, String end) {
        if (checkParamsFormat(width, height, start, end)) {
            return checkParamsCompatibility(width, height, start, end);
        } else return false;
    }

    public boolean checkParamsFormat(String width, String height, String start, String end) {
        return width.matches("^(\\d+)$") && height.matches("^(\\d+)$") && end.matches("^([a-zA-Z]+\\d+)$") && start.matches("^([a-zA-Z]+\\d+)$");
    }

    public boolean checkParamsCompatibility(String width, String height, String start, String end) {



        return true;
    }

}
