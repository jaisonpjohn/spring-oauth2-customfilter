package demo;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TosFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println(request.getRequestURI());

        // In realworld scenario HelloWorldController.acceptedTOS is a persisted value rather than a static variable
        if(!HelloWorldController.acceptedTOS){
            //response.sendRedirect("/no-tos");
            request.getRequestDispatcher("error-no-tos").forward(request, response);
        }
        filterChain.doFilter(request,response);
    }
}