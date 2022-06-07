package taxi.web.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(AuthenticationFilter.class);
    private final Set<String> allowedUrl = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("Init method was called");
        allowedUrl.add("/login");
        allowedUrl.add("/drivers/add");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        logger.info("doFilter method was called. Params: url = {}", req.getServletPath());
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        Long driverId = (Long) session.getAttribute("driver_id");
        if (driverId == null && !allowedUrl.contains(req.getServletPath())) {
            resp.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(req, resp);
    }
}
