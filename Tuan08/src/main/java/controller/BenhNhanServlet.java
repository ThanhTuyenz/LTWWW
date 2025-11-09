package controller;

import dao.BenhNhanDAO;
import dao.KhoaDAO;
import dao.impl.BenhNhanDAOImpl;
import dao.impl.KhoaDAOImpl;
import model.BenhNhan;
import model.Khoa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/benhnhan")
public class BenhNhanServlet extends HttpServlet {

    private BenhNhanDAO benhNhanDAO;
    private KhoaDAO khoaDAO;

    @Override
    public void init() {
        benhNhanDAO = new BenhNhanDAOImpl();
        khoaDAO = new KhoaDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        List<BenhNhan> listBenhNhan;
        List<Khoa> listKhoa = khoaDAO.getAllKhoa(); // ✅ luôn lấy danh sách khoa

        try {
            if ("search".equals(action)) {
                // 🔍 Tìm kiếm theo tên bệnh nhân
                String name = request.getParameter("name");
                listBenhNhan = benhNhanDAO.searchByName(name);

            } else if ("byKhoa".equals(action)) {
                // 🏥 Lọc theo khoa điều trị
                int maKhoa = Integer.parseInt(request.getParameter("maKhoa"));
                listBenhNhan = benhNhanDAO.getByKhoa(maKhoa);

            } else {
                // 🧾 Mặc định: lấy toàn bộ danh sách
                listBenhNhan = benhNhanDAO.getAllBenhNhan();
            }

            // ✅ Gửi dữ liệu sang JSP
            request.setAttribute("listBenhNhan", listBenhNhan);
            request.setAttribute("listKhoa", listKhoa);

            request.getRequestDispatcher("benhnhan-list.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
// ✅ Lấy danh sách khoa để hiển thị trong dropdown
        dao.KhoaDAO khoaDAO = new dao.impl.KhoaDAOImpl();
        request.setAttribute("listKhoa", khoaDAO.getAllKhoa());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            try {
                int maBn = Integer.parseInt(request.getParameter("maBn"));
                String hoTen = request.getParameter("hoTen");
                String ngayNhapVienStr = request.getParameter("ngayNhapVien");
                String chuanDoan = request.getParameter("chuanDoan");
                int maKhoa = Integer.parseInt(request.getParameter("maKhoa"));

                // ⚠️ Kiểm tra dữ liệu không rỗng
                if (hoTen == null || hoTen.trim().isEmpty() ||
                        chuanDoan == null || chuanDoan.trim().isEmpty() ||
                        ngayNhapVienStr == null || ngayNhapVienStr.isEmpty()) {

                    request.setAttribute("error", "⚠️ Vui lòng nhập đầy đủ thông tin bệnh nhân!");
                    doGet(request, response);
                    return;
                }

                // ⏰ Chuyển chuỗi -> Date
                Date ngayNhapVien = new SimpleDateFormat("yyyy-MM-dd").parse(ngayNhapVienStr);

                // 🆕 Tạo đối tượng bệnh nhân
                BenhNhan bn = new BenhNhan(maBn, hoTen, ngayNhapVien, chuanDoan, maKhoa);

                // 💾 Lưu vào DB
                benhNhanDAO.addBenhNhan(bn);

                // 🔁 Quay lại danh sách
                response.sendRedirect("benhnhan");

            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
            }
        }
    }
}
