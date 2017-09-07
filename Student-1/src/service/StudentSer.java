package service;

import java.util.List;

import dao.StudentDAO;
import model.Student;

public class StudentSer {
	StudentDAO stuDao=new StudentDAO();
	
	public boolean addStudent(Student stu){
		
		return stuDao.addStu(stu);
	}
	
	public List<Student> getStudentList(){
		return stuDao.getStudentList();
	}
	
	
	public Student getStuById(int id){
		return stuDao.getStuById(id);
	}
	
	public boolean updateStudent(Student stu){
		return stuDao.updateStu(stu);
	}
	
	public boolean delStuById(int id){
		return stuDao.delStuById(id);
	}
	
	

}
