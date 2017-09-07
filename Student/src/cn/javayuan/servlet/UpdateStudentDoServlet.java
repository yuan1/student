package cn.javayuan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.javayuan.model.Student;
import cn.javayuan.service.StudentSer;

/**
 * Servlet implementation class UpdateStudentDoServlet
 */
@WebServlet("/UpdateStudentDoServlet")
public class UpdateStudentDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudentDoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Student stu = new Student();
		stu.setId(Integer.valueOf(request.getParameter("id")));
		stu.setNum(request.getParameter("num"));
		stu.setName(request.getParameter("name"));
		stu.setPhone(request.getParameter("phone"));
		stu.setMajor(request.getParameter("major"));
		StudentSer stuSer = new StudentSer();
		String info = "";
		if (stuSer.updateStu(stu)) {
			info = "修改成功！";
		} else {
			info = "修改失败！";
		}
		request.setAttribute("info", info);
		request.getRequestDispatcher("info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
