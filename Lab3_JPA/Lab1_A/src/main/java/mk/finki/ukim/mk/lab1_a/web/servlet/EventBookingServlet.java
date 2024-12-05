//package mk.finki.ukim.mk.lab1_a.web.servlet;
//
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab1_a.model.EventBooking;
//import mk.finki.ukim.mk.lab1_a.service.EventBookingService;
//import mk.finki.ukim.mk.lab1_a.service.EventService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name="booking-servlet", urlPatterns= "/eventBooking")
//public class EventBookingServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//    private final EventBookingService eventBookingService;
//
//    public EventBookingServlet(SpringTemplateEngine springTemplateEngine, EventBookingService eventBookingService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.eventBookingService = eventBookingService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Retrieve booking details from session attributes
//        String eventName = (String) req.getSession().getAttribute("eventName");
//        String attendeeName = (String) req.getSession().getAttribute("attendeeName");
//        String clientIpAddress = (String) req.getSession().getAttribute("clientIpAddress");
//        int numberOfTickets = (int) req.getSession().getAttribute("numberOfTickets");
//
//        // Create an EventBooking object
//        EventBooking booking = eventBookingService.placeBooking(eventName, attendeeName, clientIpAddress, numberOfTickets);
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//        // Pass booking details to the Thymeleaf context
//        //WebContext context = new WebContext(req, resp, req.getServletContext());
//        context.setVariable("booking", booking);
//
//        // Render confirmation page
//        springTemplateEngine.process("bookingConfirmation.html", context, resp.getWriter());
//    }
//}