package fit.se.tuan05.servlet;

import fit.se.tuan05.dao.DienThoaiDAO;
import fit.se.tuan05.dao.NhaCungCapDAO;
import fit.se.tuan05.model.DienThoai;
import fit.se.tuan05.model.NhaCungCap;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/danh-sach")
public class DanhSachServlet extends HttpServlet {
    private final NhaCungCapDAO nccDao = new NhaCungCapDAO();
    private final DienThoaiDAO dtDao = new DienThoaiDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            List<NhaCungCap> dsNCC = nccDao.findAll();
            req.setAttribute("dsNCC", dsNCC);

            String mancc = req.getParameter("mancc");
            if (mancc != null && !mancc.isBlank()) {
                List<DienThoai> dsDT = dtDao.findByMancc(mancc);
                req.setAttribute("dsDT", dsDT);

                // Lấy thông tin NCC hiện tại để hiển thị tiêu đề
                NhaCungCap ncc = nccDao.findAll().stream()
                        .filter(x -> x.getMancc().equals(mancc))
                        .findFirst().orElse(null);
                req.setAttribute("ncc", ncc);

                req.getRequestDispatcher("/views/DanhSachDienThoaiNCC.jsp").forward(req, resp);
                return;
            }

            req.getRequestDispatcher("/views/QuanLyForm.jsp").forward(req, resp);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
