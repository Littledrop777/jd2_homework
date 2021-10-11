package by.academy.it;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet(name = "counterServlet", urlPatterns = "/counter")
public class CounterServlet extends HttpServlet {

    private String filePath;
    private int count;

    @Override
    public void init() throws ServletException {
        super.init();
        filePath = getServletContext().getRealPath("/logFile.txt");
        if (readCount() == 0) {
            count = 0;
        } else {
            count = readCount();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        count++;
        out.println("<html><head><title>Counter Servlet</title></head>");
        out.println("<body><h1 align=\"center\">Total number of visits</h1>");
        out.println("<h2 align=\"center\">" + count + "</h2>");
        out.println("</body></html>");
        writeCount(count);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private int readCount() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            count = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private void writeCount(int count) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(count + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
