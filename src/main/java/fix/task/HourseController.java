package fix.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HourseController {

    private final HourseService hourseService;

    @Autowired
    public HourseController(HourseService hourseService) {
        this.hourseService = hourseService;
    }

    @RequestMapping(value = "/hourse/rest/count", method = RequestMethod.GET)
    @ResponseBody
    public int getCount(
            @RequestParam(value = "width") String width,
            @RequestParam(value = "height") String height,
            @RequestParam(value = "start") String start,
            @RequestParam(value = "end") String end
    ) {
        List<Position> passedSteps = new ArrayList<>();
        passedSteps.add(new Position(start));
        return hourseService.findAndCount(passedSteps, new Position(end), 1, Integer.parseInt(width), Integer.parseInt(height), 1);
    }

}
