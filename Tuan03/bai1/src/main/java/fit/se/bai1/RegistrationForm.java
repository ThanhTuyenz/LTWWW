package fit.se.bai1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationForm() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.getWriter().append("Served at: ").append(request.getContextPath());

        String firstName = request.getParameter("txtFirstName");
        String lastName = request.getParameter("txtLastName");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String email = request.getParameter("txtEmail");
        String mobileNumber = request.getParameter("txtMobileNumber");
        String gender = request.getParameter("txtGender");
        String address = request.getParameter("txtAddress");
        String city = request.getParameter("txtCity");
        String pinCode = request.getParameter("txtPinCode");
        String state = request.getParameter("txtState");
        String country = request.getParameter("txtCountry");
        String[] hobbies = request.getParameterValues("chkHobbies");
        String qualificationData = request.getParameter("txtQualification");
        String course = request.getParameter("txtCourse");
        String birthDate = day + "/" + month + "/" + year;

        Student sv = new Student();
        sv.setFirstName(firstName);
        sv.setLastName(lastName);
        sv.setDateOfBirth(birthDate);
        sv.setEmail(email);
        sv.setGenDer(gender);

        request.setAttribute("student", sv);

        RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
        rd.forward(request, response);
    }
}
