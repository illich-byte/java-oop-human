import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/quote")
public class QuoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Quote</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Цитата Лінуса Торвальдса</h2>");
        out.println("<p><i>");
        out.println("Bad programmers worry about the code. "
                + "Good programmers worry about data structures and their relationships");
        out.println("</i></p>");

        out.println("</body>");
        out.println("</html>");
    }
}