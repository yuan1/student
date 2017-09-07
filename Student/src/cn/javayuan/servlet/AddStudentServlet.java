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
 * Servlet implementation class AddStudenServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 	//设置编码格式，防止中文乱码
		Student stu = new Student(); 	//实例化一个学生对象
		stu.setNum(request.getParameter("num")); 	//通过request根据name获取form表单中的输入数据
		stu.setName(request.getParameter("name"));
		stu.setPhone(request.getParameter("phone"));
		stu.setMajor(request.getParameter("major"));
		StudentSer stuSer = new StudentSer();
		String info = "";
		if (stuSer.addStu(stu)) {
			info = "添加成功！";
		} else {
			info = "添加失败！";
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
