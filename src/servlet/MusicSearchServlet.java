package servlet;

import model.Page;
import service.SongService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MusicSearchServlet", value = "/MusicSearchServlet")
public class MusicSearchServlet extends HttpServlet {
    private SongService gService = new SongService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Page p = new Page();
        String keyword = request.getParameter("keyword");
        p = gService.getSearchMusic(keyword);
        request.setAttribute("p", p);
        request.setAttribute("keyword",keyword);
        request.getRequestDispatcher("/music_search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
