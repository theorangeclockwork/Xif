package fix.task.controller;

import fix.task.service.HourseService;
import fix.task.model.Position;
import fix.task.service.ValidationService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HourseServlet extends HttpServlet {

    private final HourseService hourseService;
    private final ValidationService validationService;

    public HourseServlet(HourseService hourseService, ValidationService validationService) {
        this.hourseService = hourseService;
        this.validationService = validationService;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        if (validationService.checkParams(request.getParameter("width"), request.getParameter("height"), request.getParameter("start"), request.getParameter("end"))) {
            out.println(hourseService.findAndCount(new Position(request.getParameter("start")),
                    new Position(request.getParameter("end")),
                    1, Integer.parseInt(request.getParameter("width")),
                    Integer.parseInt(request.getParameter("height")),
                    1));
        } else System.out.println("CheckParamsError");

    }

}
