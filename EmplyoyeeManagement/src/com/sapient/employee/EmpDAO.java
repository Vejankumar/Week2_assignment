package com.sapient.employee;

import java.util.ArrayList;

public interface EmpDAO {
	
	public boolean initEmp(Emp e);
	public boolean updateEmp(Emp e);
	public ArrayList<Emp> getEmp();
	public void deleteEmp(String s);
}
