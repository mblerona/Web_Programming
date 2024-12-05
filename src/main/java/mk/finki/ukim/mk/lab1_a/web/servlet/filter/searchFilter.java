//package mk.finki.ukim.mk.lab1_a.web.servlet.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletResponse;
//
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = {"/"})
//public class searchFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Initialization code, if needed
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        String eventName = request.getParameter("eventName");
//        String minRatingStr = request.getParameter("minRating");
//
//
//        if (eventName == null) {
//            eventName = "";
//        }
//        if (minRatingStr == null || minRatingStr.isEmpty()) {
//            request.setAttribute("minRating", 0.0); // Default minimum rating
//        } else {
//            try {
//                // Try to parse minRating, or default to 0.0 if invalid
//                double minRating = Double.parseDouble(minRatingStr);
//                request.setAttribute("minRating", minRating);
//            } catch (NumberFormatException e) {
//                request.setAttribute("minRating", 0.0);
//            }
//        }
//
//
//        request.setAttribute("eventName", eventName);
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        // Cleanup code, if needed
//    }
//}
