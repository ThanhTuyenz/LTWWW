<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration Form</title>
    <style>
        body {
            background-color: #aee1f9;
            font-family: Arial, sans-serif;
        }
        form {
            background-color: #d9f1fc;
            padding: 20px;
            width: 600px;
            margin: auto;
            border-radius: 10px;
        }
        input[type="text"], input[type="email"], select, textarea {
            width: 95%;
            padding: 8px;
            margin: 5px 0 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        th, td {
            padding: 5px;
            text-align: center;
        }
        input[type="submit"], input[type="reset"] {
            padding: 10px 20px;
            background-color: #0077cc;
            color: white;
            border: none;
            border-radius: 5px;
        }
        input[type="submit"]:hover, input[type="reset"]:hover {
            background-color: #005fa3;
        }
    </style>
</head>
<body>

<h2 style="text-align:center;">Student Registration Form</h2>

<form action="registration-form" name="formDangKy" method="GET">
    <label>First name:</label>
    <input type="text" name="firstName" maxlength="30" required />

    <label>Last name:</label>
    <input type="text" name="lastName" maxlength="30" required />

    <label>Date of Birth:</label>
    <select name="dobDay">
        <% for(int i=1; i<=31; i++) { %>
        <option value="<%=i%>"><%=i%></option>
        <% } %>
    </select>
    <select name="dobMonth">
        <% String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
            for(String m : months) { %>
        <option value="<%=m%>"><%=m%></option>
        <% } %>
    </select>
    <select name="dobYear">
        <% for(int y=1980; y<=2025; y++) { %>
        <option value="<%=y%>"><%=y%></option>
        <% } %>
    </select>

    <label>Email:</label>
    <input type="email" name="email" required />

    <label>Mobile number:</label>
    <input type="text" name="mobileNumber" maxlength="10" required />

    <label>Gender:</label>
    <input type="radio" name="gender" value="Male" required /> Male
    <input type="radio" name="gender" value="Female" required /> Female

    <label>Address:</label>
    <textarea name="address" rows="3" required></textarea>

    <label>City:</label>
    <input type="text" name="city" maxlength="30" required />

    <label>Pin code:</label>
    <input type="text" name="pinCode" maxlength="6" required />

    <label>State:</label>
    <input type="text" name="state" maxlength="30" required />

    <label>Country:</label>
    <input type="text" name="country" required />

    <label>Hobbies:</label><br/>
    <input type="checkbox" name="hobbies" value="Drawing" /> Drawing
    <input type="checkbox" name="hobbies" value="Singing" /> Singing
    <input type="checkbox" name="hobbies" value="Dancing" /> Dancing
    <input type="checkbox" name="hobbies" value="Sketching" /> Sketching
    <input type="checkbox" name="hobbies" value="Others" /> Others:
    <input type="text" name="otherHobby" />

    <h3>Qualification</h3>
    <table>
        <tr>
            <th>Sl.No.</th>
            <th>Examination</th>
            <th>Board</th>
            <th>Percentage</th>
            <th>Year of Passing</th>
        </tr>
        <tr>
            <td>1</td>
            <td>Class X</td>
            <td><input type="text" name="board1" maxlength="10" /></td>
            <td><input type="text" name="percent1" maxlength="5" /></td>
            <td><input type="text" name="year1" maxlength="4" /></td>
        </tr>
        <tr>
            <td>2</td>
            <td>Class XII</td>
            <td><input type="text" name="board2" maxlength="10" /></td>
            <td><input type="text" name="percent2" maxlength="5" /></td>
            <td><input type="text" name="year2" maxlength="4" /></td>
        </tr>
        <tr>
            <td>3</td>
            <td>Graduation</td>
            <td><input type="text" name="board3" maxlength="10" /></td>
            <td><input type="text" name="percent3" maxlength="5" /></td>
            <td><input type="text" name="year3" maxlength="4" /></td>
        </tr>
        <tr>
            <td>4</td>
            <td>Masters</td>
            <td><input type="text" name="board4" maxlength="10" /></td>
            <td><input type="text" name="percent4" maxlength="5" /></td>
            <td><input type="text" name="year4" maxlength="4" /></td>
        </tr>
    </table>

    <label>Course applies for:</label><br/>
    <input type="radio" name="course" value="BCA" required /> BCA
    <input type="radio" name="course" value="B.Com" /> B.Com
    <input type="radio" name="course" value="B.Sc" /> B.Sc
    <input type="radio" name="course" value="B.A" /> B.A

    <br/><br/>
    <input type="submit" value="Submit" />
    <input type="reset" value="Reset" />
</form>

</body>
</html>
