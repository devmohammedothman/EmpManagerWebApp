package com.channelit.empManager.model;

public class PassType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee emp1 = new Employee();
		
		emp1.setUsername("employee 1");
		
		Employee emp2 = new Employee();
		
		emp2.setUsername("employee 2");
		
		PassType classObject = new PassType();
		
		classObject.passByRef(emp1,emp2);
		
		System.out.println("Employee 1 "+ emp1.getUsername());
		System.out.println("Employee 2 "+ emp2.getUsername());

	}
	
	public void passByRef(Employee emp1 , Employee emp2)
	{
		Employee temp = new Employee();
		
		//temp = emp1;
		
		emp1 = emp2;
		
		//emp2 = temp;
		
		emp2.setUsername("passed by Ref");
	}

}
