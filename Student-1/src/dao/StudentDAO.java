package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.DBHelper;


public class StudentDAO {
	Connection connection = null;	//数据库链接
	PreparedStatement statement = null;	//用于 实例包含已编译的 SQL 语句
	ResultSet set = null;	//数据库查询结果集
	
	
	public List<Student> getStudentList(){
		List<Student> listStu = new ArrayList<>();
		connection = new DBHelper().getConn();
		String sql ="select * from student";
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
