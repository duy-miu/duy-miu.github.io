package filter;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestLogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Instant start = Instant.now();

        HttpServletRequest httprequest =(HttpServletRequest) request;
        HttpServletResponse httpresponse =(HttpServletResponse) response;
        HttpSession session = ((HttpServletRequest) request).getSession();

        Object usernameObj = session.getAttribute("username");

        try {
            if(usernameObj ==null){
                //System.out.println("usernameObj: " + usernameObj);
                httprequest.getRequestDispatcher("/login").forward(request,response);
            }else {
                chain.doFilter(request, response);
            }
        } finally {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            HttpServletRequest in = (HttpServletRequest) request;
            HttpServletResponse out = (HttpServletResponse) response;
            String length = out.getHeader("Content-Length");
            if (length == null || length.length() == 0)
                length = "-";
            System.out.println(in.getRemoteAddr() + " - - [" + start + "]" + " \"" + in.getMethod() + " "
                    + in.getRequestURI() + " " + in.getProtocol() + "\" " + out.getStatus() + " " + length + " "
                    + timeElapsed.toNanos() + " nano-seconds");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}