package com.sapient.employee;

public class Emp{
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", project=" + project + ", age=" + age + ", psw=" + psw + ", role="
				+ role ;
	}
	private int id;
	private String name;
	private String project;
	private int age;
	private String psw;
	private String role;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String i) {
		this.psw = i;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
}
