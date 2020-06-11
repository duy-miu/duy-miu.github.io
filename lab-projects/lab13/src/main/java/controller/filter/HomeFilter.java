package controller.filter;

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

public class HomeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Instant start = Instant.now();

        HttpServletRequest httprequest =(HttpServletRequest) request;
        HttpServletResponse httpresponse =(HttpServletResponse) response;
        HttpSession session = ((HttpServletRequest) request).getSession();

        Object userObj = httprequest.getSession().getAttribute("user");
        String path = httprequest.getServletPath();
        System.out.println("path " + path);

        try {
            if( path.equals("/")){
                httprequest.getRequestDispatcher("home?page=product").forward(request,response);
            }else if(path.equals("/checkout")){
                if(userObj==null) {
                    httprequest.getRequestDispatcher("home?page=login").forward(request, response);
                }else{
                    httprequest.getRequestDispatcher("home?page=checkout").forward(request, response);
                }
            }else if(path.indexOf("/view/user/") > 0){
                if(userObj==null) {
                    httprequest.getRequestDispatcher("home?page=login").forward(request, response);
                }else {
                    chain.doFilter(request, response);
                }
            }else {
                if(userObj==null){
                    httprequest.getRequestDispatcher("home?page=login").forward(request,response);
                }else {
                    chain.doFilter(request, response);
                }
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