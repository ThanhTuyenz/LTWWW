package controller;

import dao.KhoaDAO;
import model.Khoa;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/khoa")
public class KhoaServlet extends HttpServlet {
    private KhoaDAO khoaDAO;

    @Override
    public void init() {
        khoaDAO = new dao.impl.KhoaDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Khoa> list = khoaDAO.getAllKhoa();
        request.setAttribute("listKhoa", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listKhoa.jsp");
        dispatcher.forward(request, response);
    }
}
