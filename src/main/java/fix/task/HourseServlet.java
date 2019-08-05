package fix.task;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class HourseServlet extends HttpServlet {

    private final HourseService hourseService;

    public HourseServlet(HourseService hourseService) {
        this.hourseService = hourseService;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
        List<Position> passedSteps = new ArrayList<>();
        passedSteps.add(new Position(request.getParameter("start")));
        out.println(hourseService.findAndCount(passedSteps,
                new Position(request.getParameter("end")),
                1, Integer.parseInt(request.getParameter("width")),
                Integer.parseInt(request.getParameter("height")),
                1));
    }

}
