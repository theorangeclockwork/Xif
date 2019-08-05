package fix.task;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HourseServlet extends HttpServlet {

    private final HourseService hourseService;

    public HourseServlet(HourseService hourseService) {
        this.hourseService = hourseService;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println(hourseService.findAndCount(new Position(request.getParameter("start")),
                new Position(request.getParameter("end")),
                1, Integer.parseInt(request.getParameter("width")),
                Integer.parseInt(request.getParameter("height")),
                1));
    }

}
