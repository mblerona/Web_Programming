//package mk.finki.ukim.mk.lab1_a.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab1_a.model.Category;
//import mk.finki.ukim.mk.lab1_a.model.Event;
//import mk.finki.ukim.mk.lab1_a.service.EventService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@WebServlet(name = "event-List", urlPatterns = "/listEvents")
//public class EventListServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//    private final EventService eventServiceService;
//
//
//    public EventListServlet(SpringTemplateEngine springTemplateEngine, EventService eventServiceService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.eventServiceService = eventServiceService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//
//
//        String eventName = req.getParameter("eventName");
//        double minRating = parseDoubleOrDefault(req.getParameter("minRating"));
//        String categoryStr = req.getParameter("category");
//
//        Category category = categoryStr != null ? Category.valueOf(categoryStr) : null;
//
//
//        List<Event> filteredEvents = eventServiceService.listAll().stream()
//                .filter(event -> (eventName == null || event.getName().toLowerCase().contains(eventName.toLowerCase())))
//                .filter(event -> event.getPopularityScore() >= minRating)
//                .filter(event -> (category == null || event.getCategory() == category))
//                .collect(Collectors.toList());
//
//
//        context.setVariable("events", filteredEvents);
//        context.setVariable("categories", Category.values());
//        springTemplateEngine.process("listEvents.html", context, resp.getWriter());
//    }
//
//
//    private double parseDoubleOrDefault(String value) {
//        try {
//            return value != null && !value.isEmpty() ? Double.parseDouble(value) : 0.0;
//        } catch (NumberFormatException e) {
//            return 0.0;
//        }
//    }
//
////    @Override
////    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        IWebExchange webExchange = JakartaServletWebApplication
////                .buildApplication(getServletContext())
////                .buildExchange(req, resp);
////
////        WebContext context = new WebContext(webExchange);
////
////        context.setVariable("events", this.eventServiceService.listAll());
////
////        this.springTemplateEngine.process("listEvents.html", context, resp.getWriter());
////    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String eventName = req.getParameter("eventName");
//
//        String attendeeName = "Petko Petkov";  // This could be dynamically obtained, hardcoded for this example.
//        String clientIpAddress = req.getRemoteAddr();
//        int numberOfTickets = Integer.parseInt(req.getParameter("numTickets"));
//
//        req.getSession().setAttribute("eventName", eventName);
//        req.getSession().setAttribute("attendeeName", attendeeName);
//        req.getSession().setAttribute("clientIpAddress", clientIpAddress);
//        req.getSession().setAttribute("numberOfTickets", numberOfTickets);
//
//        // Redirect to the EventBookingServlet to handle confirmation display
//        resp.sendRedirect("/eventBooking");
//    }
//}