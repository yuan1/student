package cn.javayuan.service;

import java.util.List;

import cn.javayuan.dao.StudentDAO;
import cn.javayuan.model.Student;

/**
 * @author 李明元
 *
 * @email:limingyuan1996@outlook.com
 *
 */
public class StudentSer {
	
	StudentDAO stuDao = new StudentDAO(); //实例化学生数据库操作类
	
	/**
	 * @Title: getStuList 
	 * @Description: 获取全部全部学生信息
	 * @return List<Student>    返回类型 
	 * @throws
	 */
	public List<Student> getStuList(){
		return stuDao.getStuList();
	} 
	/**
	 * @Title: addStu 
	 * @Description: 添加学生信息
	 * @param @param stu 封装好的学生对象
	 * @param @return  参数说明 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean addStu(Student stu){
		//这里可以进行业务操作，比如记录一下操作日志 或者 进行其他数据库操作
		return stuDao.addStu(stu);
	}
	/**
	 * @Title: getStuById 
	 * @Description: 通过id获取学生
	 * @param @param id 
	 * @param @return  参数说明 
	 * @return Student    返回类型 
	 * @throws
	 */
	public Student getStuById(int id){
		return stuDao.getStuById(id);
	}
	/**
	 * @Title: updateStu 
	 * @Description: 更新学生信息
	 * @param @param stu
	 * @param @return  参数说明 
	 * @return boolean    返回类型 
	 * @throws
	 */
	
	public boolean updateStu(Student stu) {
		return  stuDao.updateStu(stu);
	}
	/**
	 * @Title: delStuById 
	 * @Description: 通过id删除学生信息
	 * @param @param id
	 * @param @return  参数说明 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean delStuById(int id) {
		return stuDao.delStuById(id);
	}

}
