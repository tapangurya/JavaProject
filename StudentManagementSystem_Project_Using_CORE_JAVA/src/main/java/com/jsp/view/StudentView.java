package com.jsp.view;

import java.util.Scanner;
import com.jsp.controller.*;
import com.jsp.model.Student;

public class StudentView {
	static Scanner sc =new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("WELCOME TO SMS APP");
		StudentController controller = new StudentController();
		while(true) 
		{
				System.out.println("ENTER YOUR CHOICE");
				System.out.println("1.save Student");
				System.out.println("2.find Student By Id");
				System.out.println("3.update Student By Id");
				System.out.println("4.delete Student By Id");
				System.out.println("5.findAll");
				System.out.println("6.exit");
				
				int choice=sc.nextInt();
				switch (choice) 
				{
					case 1:
					Student s=getStudentObject();
					
					controller.saveStudent(s);
					break;
					case 2:System.out.println("Enter Student Id");
					int stuId = sc.nextInt();
					controller.findStudentById(stuId);
					break;
					case 3:System.out.println("Enter your Student Id");
					int studId = sc.nextInt();
					
					/*if(controller.findStudentById2(studId)) {
						Student s1= changeStudentObject(studId);
						controller.updateStudent(s1);
					}*/
					 System.out.println("enter new rellationshipSTatus");
					 sc.nextLine();
					 String newRellationShipStatus=sc.nextLine();
					 controller.updateStudentById(studId,newRellationShipStatus);
					break;
					case 4: System.out.println("Enter Student Id to delete");
                    int deleteId = sc.nextInt();
                    controller.deleteStudentById(deleteId);
                    break;
					case 5:
						controller.findAll();
					break;
					case 6:System.out.println("THANK YOU");
					return;
					default:System.out.println("Invalid choice");
					break;
				}
			}
		}
	/*private static Student changeStudentObject(int studId) {
		
		System.out.println("Enter Student Name");
		sc.nextLine();
		String name =sc.nextLine();
		System.out.println("Enter Student Email");
		String email =sc.nextLine();
		System.out.println("Enter Student Password");
		String password = sc.nextLine();
		System.out.println("Enter Student Dob");
		String dob= sc.nextLine();
		System.out.println("Enter Student Address");
		String address = sc.nextLine();
		System.out.println("Enter Student Gender");
		String gender = sc.nextLine();
		System.out.println("Enter Student Mob");
		long mob= sc.nextLong();
		System.out.println("Enter Student relationShipStatus");
		sc.nextLine();
		String relationShipStatus = sc.nextLine();
		Student s = new Student();
		s.setId(studId);
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setAddress(address);
		s.setGender(gender);
		s.setDob(dob);
		s.setMob(mob);
		s.setRelationShipStatus(relationShipStatus);
		return s;
	}
	*/
	
	public static Student getStudentObject() {
		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		System.out.println("Enter Student Name");
		sc.nextLine();
		String name =sc.nextLine();
		System.out.println("Enter Student Email");
		String email =sc.nextLine();
		System.out.println("Enter Student Password");
		String password = sc.nextLine();
		System.out.println("Enter Student Dob");
		String dob= sc.nextLine();
		System.out.println("Enter Student Address");
		String address = sc.nextLine();
		System.out.println("Enter Student Gender");
		String gender = sc.nextLine();
		System.out.println("Enter Student Mob");
		long mob= sc.nextLong();
		System.out.println("Enter Student relationShipStatus");
		sc.nextLine();
		String relationShipStatus = sc.nextLine();
		
		// Create Student object
		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setAddress(address);
		s.setGender(gender);
		s.setDob(dob);
		s.setMob(mob);
		s.setRelationShipStatus(relationShipStatus);
		return s;
		
		
		
	}

}
