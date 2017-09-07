package cn.javayuan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.javayuan.model.Student;
import cn.javayuan.util.DBHelper;

/**
 * @author 李明元
 *
 * @email:limingyuan1996@outlook.com
 *
 */
public class StudentDAO {
	Connection connection = null;	//数据库链接
	PreparedStatement statement = null;	//用于 实例包含已编译的 SQL 语句
	ResultSet set = null;	//数据库查询结果集
	
	/**
	 * @Title: getStuList 
	 * @Description: 获取全部全部学生信息
	 * @return List<Student>    返回类型 
	 * @throws
	 */
	public List<Student> getStuList(){
		List<Student> listStu = new ArrayList<Student>();
		connection = new DBHelper().getConn();
		String sql ="select * from student"; //定义SQL语句
		try {
			statement=connection.prepareStatement(sql);
			set =statement.executeQuery();	//执行SQL语句并取得结果集
			while (set.next()) {	//遍历结果集
				Student st = new Student();
				st.setId(set.getInt("id"));
				st.setName(set.getString("name"));
				st.setNum(set.getString("num"));
				st.setMajor(set.getString("major"));
				st.setPhone(set.getString("phone"));
				listStu.add(st);	//封装对象添加到List中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				set.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listStu;
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
		connection = new DBHelper().getConn();
		String sql ="insert into student(num,name,major,phone) values(?,?,?,?) ";	//使用?做占位符
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, stu.getNum());	//为第1个?号赋值
			statement.setString(2, stu.getName());
			statement.setString(3, stu.getMajor());
			statement.setString(4, stu.getPhone());
			int rs=statement.executeUpdate();	//执行并返回影响条数
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
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
		Student st =null;
		connection = new DBHelper().getConn();
		String sql ="select * from student where id=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			set =statement.executeQuery();
			while (set.next()) {
				st = new Student();
				st.setId(set.getInt("id"));
				st.setName(set.getString("name"));
				st.setNum(set.getString("num"));
				st.setMajor(set.getString("major"));
				st.setPhone(set.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				set.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return st;
	}
	/**
	 * @Title: updateStu 
	 * @Description:更新学生信息
	 * @param @param stu 封装好的学生对象
	 * @param @return  参数说明 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean updateStu(Student stu) {
		connection = new DBHelper().getConn();
		String sql ="update student set num=?,name=?,major=?,phone=? where id=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, stu.getNum());
			statement.setString(2, stu.getName());
			statement.setString(3, stu.getMajor());
			statement.setString(4, stu.getPhone());
			statement.setInt(5, stu.getId());
			int rs=statement.executeUpdate();
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	/**
	 * 通过学生id删除学生信息
	 * @param id
	 * @return
	 */
	public boolean delStuById(int id) {
		connection = new DBHelper().getConn();
		String sql ="delete from student where id=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			int rs=statement.executeUpdate();
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
