package fix.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HourseController {

    private final HourseService hourseService;
    private final ValidationService validationService;

    @Autowired
    public HourseController(HourseService hourseService, ValidationService validationService) {
        this.hourseService = hourseService;
        this.validationService = validationService;
    }

    @RequestMapping(value = "/hourse/rest/count", method = RequestMethod.GET)
    public int getCount(
            @RequestParam(value = "width") String width,
            @RequestParam(value = "height") String height,
            @RequestParam(value = "start") String start,
            @RequestParam(value = "end") String end
    ) {
        if (validationService.checkParams(width, height, start, end)) {
        return hourseService.findAndCount(new Position(start), new Position(end), 1, Integer.parseInt(width), Integer.parseInt(height), 1);
        } else {
            return -2;
        }
    }

}
