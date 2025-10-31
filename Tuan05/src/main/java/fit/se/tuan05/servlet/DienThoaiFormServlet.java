package fit.se.tuan05.servlet;

import fit.se.tuan05.dao.DienThoaiDAO;
import fit.se.tuan05.dao.NhaCungCapDAO;
import fit.se.tuan05.model.DienThoai;
import fit.se.tuan05.model.NhaCungCap;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

@WebServlet("/dienthoai-form")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 5 * 1024 * 1024,   // 5MB
        maxRequestSize = 10 * 1024 * 1024
)
public class DienThoaiFormServlet extends HttpServlet {
    private final DienThoaiDAO dtDao = new DienThoaiDAO();
    private final NhaCungCapDAO nccDao = new NhaCungCapDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            List<NhaCungCap> dsNCC = nccDao.findAll();
            req.setAttribute("dsNCC", dsNCC);

            String madt = req.getParameter("madt");
            if (madt != null && !madt.isBlank()) {
                DienThoai dt = dtDao.findById(madt);
                req.setAttribute("dt", dt);
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }

        req.getRequestDispatcher("/views/DienThoaiForm.jsp").forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String madt = req.getParameter("madt");
        String tendt = req.getParameter("tendt");
        String nams = req.getParameter("namsanxuat");
        String cauhinh = req.getParameter("cauhinh");
        String mancc = req.getParameter("mancc");
        Part hinhanhPart = req.getPart("hinhanh");

        String error = null;
        String fileName = null;

        // Upload ảnh (nếu có)
        if (hinhanhPart != null && hinhanhPart.getSize() > 0) {
            String submittedName = Path.of(hinhanhPart.getSubmittedFileName()).getFileName().toString();
            String ext = submittedName.substring(submittedName.lastIndexOf(".") + 1).toLowerCase();

            if (!List.of("jpg", "jpeg", "png").contains(ext)) {
                error = "Chỉ chấp nhận file ảnh .jpg, .jpeg, .png";
            } else {
                fileName = System.currentTimeMillis() + "_" + submittedName;
                String uploadDir = getServletContext().getRealPath("/") + "uploads";
                Files.createDirectories(Paths.get(uploadDir));
                hinhanhPart.write(uploadDir + File.separator + fileName);
            }
        }

        if (error != null) {
            req.setAttribute("error", error);
            doGet(req, resp);
            return;
        }

        try {
            int namSX = Integer.parseInt(nams);
            DienThoai old = dtDao.findById(madt);

            // Nếu không upload ảnh mới → giữ lại ảnh cũ
            if (fileName == null && old != null) {
                fileName = old.getHinhanh();
            }

            DienThoai dt = new DienThoai(madt, tendt, namSX, cauhinh, mancc, fileName);

            if (old == null) {
                dtDao.insert(dt); // thêm mới
            } else {
                dtDao.update(dt); // cập nhật
            }

            resp.sendRedirect(req.getContextPath() + "/danh-sach?mancc=" + mancc);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
