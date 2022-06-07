package taxi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(LogoutController.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("Driver logged out. Params: driver id = {}",
                req.getSession().getAttribute("driver_id"));
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
