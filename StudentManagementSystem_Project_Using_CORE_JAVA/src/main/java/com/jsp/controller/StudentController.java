package com.jsp.controller;

import java.util.ArrayList;

import com.jsp.model.Student;

public class StudentController {
	static  ArrayList<Student> listOfStudent = new ArrayList<Student>();
	public void saveStudent(Student student) {
		for (int i = 0; i < listOfStudent.size(); i++) {
			if((listOfStudent.get(i).getId() != student.getId())) {
				listOfStudent.add(student);
				System.out.println("Student Saved...");
			}
			System.out.println("StudentId already present");	
		}
		
	}
	
	public Student findStudentById(int stuId) {
		for(Student s : listOfStudent) {
			if(s.getId() == stuId) {
			System.out.println(s);
			return s;
		}
	}
		System.out.println("RECORD NOT FOUND");
		return null;
	}
	
	
	/*public static boolean findStudentById2(int studId) {
		for(Student s : listOfStudent) {
			if(s.getId() == studId) {
			
			return true;
		}
	}
		System.out.println("RECORD NOT FOUND");
		return false;
	}
	*/
	/*public void updateStudent(Student student) {
        for (int i = 0; i < listOfStudent.size(); i++) {
            if (listOfStudent.get(i).getId() == student.getId()) {
                listOfStudent.set(i, student);
                System.out.println("Student Updated...");
                return;
            }
        }
        System.out.println("RECORD NOT FOUND");
    }*/
	
	
	
	public void checkStudentValidatinById(int stuId) {
        for (int i = 0; i < listOfStudent.size(); i++) {
            if (listOfStudent.get(i).getId() == stuId) {
                listOfStudent.remove(i);
                System.out.println("Student Deleted...");
                return;
            }
        }
        System.out.println("RECORD NOT FOUND");
    }

	public void updateStudentById(int studId, String newRellationShipStatus) {
		for(Student s:listOfStudent) {
			if(s.getId()==studId) {
				s.setRelationShipStatus(newRellationShipStatus);
				System.out.println(s);
				return;
			}
		}
		System.out.println("Record not found...");
		
	}

	public void deleteStudentById(int deleteId) {
		Student s=findStudentById(deleteId);
		if(s!=null) {
			boolean b= listOfStudent.remove(s);
			if(b==true) {
				System.out.println("Record Deleted...");
				return;
			}
		}
		System.out.println("Record Not Found");
		
	}

	public void findAll() {
		// TODO Auto-generated method stub
		for(Student s:listOfStudent) {
			System.out.println(s);
		}
		
	}


}
