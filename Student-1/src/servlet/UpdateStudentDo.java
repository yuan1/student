package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.StudentSer;

/**
 * Servlet implementation class UpdateStudentDo
 */
@WebServlet("/UpdateStudentDo")
public class UpdateStudentDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentDo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); 	//设置编码格式，防止中文乱码
		Student stu = new Student();
		stu.setId(Integer.valueOf(request.getParameter("id")));
		stu.setNum(request.getParameter("num"));
		stu.setName(request.getParameter("name"));
		stu.setMajor(request.getParameter("major"));
		stu.setPhone(request.getParameter("phone"));
		StudentSer stuSer= new StudentSer();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		if(stuSer.updateStudent(stu)){
			response.getWriter().print("成功");
		}else{
			response.getWriter().print("失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
