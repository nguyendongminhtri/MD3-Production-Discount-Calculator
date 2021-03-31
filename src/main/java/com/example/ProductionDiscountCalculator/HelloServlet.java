package com.example.ProductionDiscountCalculator;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/calculator")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        double discount_percent = Double.parseDouble(request.getParameter("percent"));
        double discount_amount = price * discount_percent * 0.01;
        double discount_price = price - discount_amount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Description: " + description + "</h1>");
        writer.println("<h1>Price: " + price + "USD" + "</h1>");
        writer.println("<h1>Discount Percent: " + discount_percent + "%" + "</h1>");
        writer.println("<h1>Discount Amount: " + discount_amount + "USD" + "</h1>");
        writer.println("<h1>Discount Price: " + discount_price + "USD" + "</h1>");
    }
    public void destroy() {
    }
}