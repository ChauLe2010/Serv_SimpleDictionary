import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SimpleDictionaryServlet", urlPatterns = "/search")
public class SimpleDictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("Hello", "Xin chào");
        dictionary.put("How", "Thế nào");
        dictionary.put("Computer", "Máy tính");

        String keyword = request.getParameter("keyword");

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");

        String result=dictionary.get(keyword);
        if(result!=null){
            printWriter.println("<h1>Word: " + keyword+"</h1>");
            printWriter.println("<h1>Result: "+result+"</h1>");
        }else{
            printWriter.println("<h1>Not fount!</h1>");
        }

        printWriter.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
