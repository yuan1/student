package cn.javayuan.model;

/**
 * @author 李明元
 *
 * @email:limingyuan1996@outlook.com
 *
 */
public class Student {
	private int id;
	private String num;
	private String name;
	private String major;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", num=" + num + ", name=" + name + ", major=" + major
				+ ", phone=" + phone + "]";
	}
	
}
