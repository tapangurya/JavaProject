package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Student;

public class StudentController {

	public void saveStudent(Student student) 
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","postgres","root");
			PreparedStatement pstmt = con.prepareStatement("insert into student values (?,?,?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3,student.getEmail());
			pstmt.setString(4,student.getPassword());
			pstmt.setString(5,student.getDob());
			pstmt.setString(6,student.getAddress());
			pstmt.setString(7,student.getGender());
			pstmt.setLong(8,student.getMob());
			pstmt.setString(9, student.getRelationShipStatus());
			int n =pstmt.executeUpdate();
			if(n!=0) {
				System.out.println(n +" Student record insertted...");
			}
			else {
				System.out.println(n+"");
			}
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	public void findStudentById(int stuId) {
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","postgres","root");
			PreparedStatement pstmt = con.prepareStatement("select * from student where id = ?");
			pstmt.setInt(1, stuId);
							ResultSet rs=pstmt.executeQuery();
							boolean b = rs.next();
							if(!b)
							{
							System.out.println("Record not found");
							}
							else
							{
								System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)
								+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getLong(8)+" "+rs.getString(9));
							}
			
			con.close();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	public void updateStudentById(int studId, String newRellationShipStatus) {
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","postgres","root");
			PreparedStatement pstmt = con.prepareStatement("update  student set relationshipstatus=?  where id = ?");
			pstmt.setString(1, newRellationShipStatus);
			pstmt.setInt(2, studId);
			int n = pstmt.executeUpdate();	
			if(n!=0)
			{
				System.out.println(n + " recored Updated");
			}
			else {
				System.out.println("Record Not found");
			}
			con.close();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	public void deleteStudentById(int deleteId) {
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","postgres","root");
			PreparedStatement pstmt = con.prepareStatement("delete from student where id =?");
			  pstmt.setInt(1,deleteId);
			  int n = pstmt.executeUpdate();
			  if(n!=0)
				{
					System.out.println(n + " Deleted successfull..");
				}
				else {
					System.out.println("Record Not found");
				}
				con.close();
			
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	public void findAll() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","postgres","root");
			PreparedStatement pstmt = con.prepareStatement("select * from student");
			
							ResultSet rs=pstmt.executeQuery();
							boolean b = rs.next();
							if(!b)
							{
							System.out.println("Record not found");
							}
							else
							{
								do {
									System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)
									+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getLong(8)+" "+rs.getString(9));
								} while (b = rs.next());
							}
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
