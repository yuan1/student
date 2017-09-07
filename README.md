# 基于Servlet+JSP的学生信息管理系统的开发
## 开发简介

- Servlet（Server Applet），全称Java Servlet，未有中文译文。是用Java编写的服务器端程序。其主要功能在于交互式地浏览和修改数据，生成动态Web内容。狭义的Servlet是指Java语言实现的一个接口，广义的Servlet是指任何实现了这个Servlet接口的类，一般情况下，人们将Servlet理解为后者。
- Servlet运行于支持Java的应用服务器中。从实现上讲，Servlet可以响应任何类型的请求，但绝大多数情况下Servlet只用来扩展基于HTTP协议的Web服务器。
- 最早支持Servlet标准的是JavaSoft的Java Web Server。此后，一些其它的基于Java的Web服务器开始支持标准的Servlet。

- JSP（全称JavaServer Pages）是由Sun Microsystems公司倡导和许多公司参与共同创建的一种使软件开发者可以响应客户端请求，而动态生成HTML、XML或其他格式文档的Web网页的技术标准。JSP技术是以Java语言作为脚本语言的，JSP网页为整个服务器端的Java库单元提供了一个接口来服务于HTTP的应用程序。
- JSP使Java代码和特定的预定义动作可以嵌入到静态页面中。JSP句法增加了被称为JSP动作的XML标签，它们用来调用内建功能。另外，可以创建JSP标签库，然后像使用标准HTML或XML标签一样使用它们。标签库提供了一种和平台无关的扩展服务器性能的方法。
- JSP被JSP编译器编译成Java Servlets。一个JSP编译器可以把JSP编译成JAVA代码写的servlet然后再由JAVA编译器来编译成机器码，也可以直接编译成二进制码。

- MySQL原本是一个开放源代码的关系数据库管理系统，原开发者为瑞典的MySQL AB公司，该公司于2008年被昇阳微系统（Sun Microsystems）收购。2009年，甲骨文公司（Oracle）收购昇阳微系统公司，MySQL成为Oracle旗下产品。
- MySQL在过去由于性能高、成本低、可靠性好，已经成为最流行的开源数据库，因此被广泛地应用在Internet上的中小型网站中。随着MySQL的不断成熟，它也逐渐用于更多大规模网站和应用，比如维基百科、Google和Facebook等网站。非常流行的开源软件组合LAMP中的“M”指的就是MySQL。
- 但被甲骨文公司收购后，Oracle大幅调涨MySQL商业版的售价，且甲骨文公司不再支持另一个自由软件项目OpenSolaris的发展，因此导致自由软件社区们对于Oracle是否还会持续支持MySQL社区版（MySQL之中唯一的免费版本）有所隐忧，MySQL的创始人麦克尔·维德纽斯以MySQL为基础，成立分支计划MariaDB。而原先一些使用MySQL的开源软件逐渐转向MariaDB或其它的数据库。例如维基百科已于2013年正式宣布将从MySQL迁移到MariaDB数据库[2]。

- Bootstrap是一组用于网站和网络应用程序开发的开源前端（所谓“前端”，指的是展现给最终用户的界面。与之对应的“后端”是在服务器上面运行的代码）框架，包括HTML、CSS及JavaScript的框架，提供字体排印、窗体、按钮、导航及其他各种组件及Javascript扩展，旨在使动态网页和Web应用的开发更加容易。
- Bootstrap是GitHub上面被标记为“Starred”次数排名第二最多的项目。Starred次数超过105,000，而分支次数超过了47,000次。[2]

## 操纵数据库主要代码
```
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
```


