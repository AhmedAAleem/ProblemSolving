package com.sales.jdbc.service;


import com.sales.jdbc.config.InvoiceConfiguration;
import com.sales.jdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class InvoiceServiceJDBC {

	@Autowired
	private InvoiceConfiguration invoiceConfiguration;

	public List<Student> getStudents() throws Exception {
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Connection myConn = null;
		
		try {
			
			myConn = invoiceConfiguration.dataSource().getConnection();
			
			List<Student> students = new ArrayList<>();
			// create sql statement
			String sql = "select * from student order by invoice_no";

			myStmt = myConn.prepareStatement(sql);

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("Student_ID");
				String name = myRs.getString("student_name");
				String address = myRs.getString("student_address");
				int invoiceNo = myRs.getInt("invoice_no");

				// create new invoice object
				Student student = new Student(id, name, address, invoiceNo);

				// add it to the list of invoices
				students.add(student);
			}

			return students;
		} finally {
			// close JDBC objects
			close( myConn, myStmt, myRs);
		}
	}





		public Student getStudent(int studentId) throws Exception {

		Student theStudent = null;

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			// get connection to database
			myConn = invoiceConfiguration.dataSource().getConnection();

			// create sql to get selected student
			String sql = "select * from student where student_id=?";

			// create prepared statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, studentId);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result set row
			if (myRs.next()) {
				String studentName = myRs.getString("student_name");
				String studentAddress = myRs.getString("student_address");
				int invoiceNo = myRs.getInt("invoice_no");

				// use the studentId during construction
				theStudent = new Student(studentId, studentName, studentAddress, invoiceNo);
			} else {
				throw new Exception("Could not find student id: " + studentId);
			}

			return theStudent;
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}




	public Student updateStudent(Student student , int id) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {

			// get db connection
			myConn = invoiceConfiguration.dataSource().getConnection();


			// create SQL update statement
			String sql ="update student set student_name = ?,student_address= ?, invoice_no =? where student_id = ?;";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, student.getStudentName());
			myStmt.setString(2, student.getStudentAddress());
			myStmt.setInt(3, student.getInvoiceNo());
			myStmt.setInt(4,id);

			myStmt.execute();

		return student;

		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);


		}
	}

	public Student insertStudent(Student student) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = invoiceConfiguration.dataSource().getConnection();

			// create sql for insert
			String sql = "insert into student " + "(student_name, student_address, invoice_no) " + "values (?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set the param values for the student
			myStmt.setString(1, student.getStudentName());
			myStmt.setString(2, student.getStudentAddress());
			myStmt.setInt(3, student.getInvoiceNo());

			// execute sql insert
			myStmt.execute();

		return student;

		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}



	public void deleteStudent(int id) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get connection to database
			myConn = invoiceConfiguration.dataSource().getConnection();

			// create sql to delete student
			String sql = "delete from student where id=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, id);

			// execute sql statement
			myStmt.execute();
		} finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}
	}




	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close(); // doesn't really close it ... just puts back in connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}


//	private void printSQLException(SQLException ex) {
//		for (Throwable e : ex) {
//			if (e instanceof SQLException) {
//				e.printStackTrace(System.err);
//				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//				System.err.println("Message: " + e.getMessage());
//				Throwable t = ex.getCause();
//				while (t != null) {
//					System.out.println("Cause: " + t);
//					t = t.getCause();
//				}
//			}
//		}
//	}


}
