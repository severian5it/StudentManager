package Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Person.CollegeList;
import Person.Lecturer;
import Person.PartTimeLecturer;
import Person.Person;
import Person.Student;

public class DBManager implements Iinsertable,Iquerable {
	private Connection c = null;
	private Statement stmt = null;

	public DBManager(String Connector) {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.sqlite.JDBC");
			this.c = DriverManager.getConnection(Connector);
			this.stmt = c.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeToDB(String stringToExecute) {
        try {
			stmt.executeUpdate(stringToExecute);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void insert(Person p)  {
		writeToDB(p.getStringInsertDB());
	}
	
	public CollegeList ReturnAll() {
		
		CollegeList output = new CollegeList();
		
		try {
			
			ResultSet rStudents = stmt.executeQuery("select * from students");

			while (rStudents.next()){
				Student s = new Student(rStudents.getString(2),rStudents.getString(3),new SimpleDateFormat("yyyy-MM-dd").parse(rStudents.getString(4)),rStudents.getInt(9),
						rStudents.getString(8),new SimpleDateFormat("yyyy-MM-dd").parse(rStudents.getString(10)),rStudents.getString(5),rStudents.getInt(6),rStudents.getString(7));
			
				output.addPerson(s);
			}
			
			ResultSet rLecturers = stmt.executeQuery("select * from lecturers");
			
			while (rLecturers.next()){
				Lecturer s = new Lecturer(rLecturers.getString(2),rLecturers.getString(3),new SimpleDateFormat("yyyy-MM-dd").parse(rLecturers.getString(4)),rLecturers.getInt(9),
						rLecturers.getString(8),new SimpleDateFormat("yyyy-MM-dd").parse(rLecturers.getString(10)),rLecturers.getString(5),rLecturers.getDouble(6),rLecturers.getString(7));
			
				output.addPerson(s);
			}
			
			ResultSet rPartTimeLecturers = stmt.executeQuery("select * from PartTimeLecturer");
			
			while (rPartTimeLecturers.next()){
				PartTimeLecturer s = new PartTimeLecturer(rPartTimeLecturers.getString(2),rPartTimeLecturers.getString(3),new SimpleDateFormat("yyyy-MM-dd").parse(rPartTimeLecturers.getString(4)),rPartTimeLecturers.getInt(9),
						rPartTimeLecturers.getString(8),new SimpleDateFormat("yyyy-MM-dd").parse(rPartTimeLecturers.getString(10)),rPartTimeLecturers.getString(5),rPartTimeLecturers.getInt(6),rPartTimeLecturers.getString(7));
			
				output.addPerson(s);
			}
			
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public void createStudentTable() {
		try {
			String CreateTable = "Create Table Students"
					+ "( id         INTEGER       PRIMARY KEY AUTOINCREMENT NOT NULL," + 
					"    firstname       VARCHAR (80) NOT NULL," + 
					"    lastname       VARCHAR (80) NOT NULL," + 
					"    dateOfBirth       DATE NOT NULL," + 
					"    studentid VARCHAR (9)   NOT NULL," +
					"    courseyear INTEGER   NOT NULL," +
					"    courseid VARCHAR (9)   NOT NULL," +
					"    emailAddress VARCHAR (80)   NOT NULL," +
					"    mobileNum INTEGER   NOT NULL," +
					"    endDate DATE   NOT NULL)";
			stmt.executeUpdate(CreateTable);
	}	catch (Exception e) {
		System.err.println(e.getClass().getName()+": "+e.getMessage());
		System.exit(0);
		}	
	}
	
	public void createLecturerTable() {
		try {
			String CreateTable = "Create Table Lecturers"
					+ "( id         INTEGER       PRIMARY KEY AUTOINCREMENT NOT NULL," + 
					"    firstname       VARCHAR (80) NOT NULL," + 
					"    lastname       VARCHAR (80) NOT NULL," + 
					"    dateOfBirth       DATE NOT NULL," + 
					"    staffId VARCHAR (9)   NOT NULL," +
					"    salary DOUBLE   NOT NULL," +
					"    jobTitle VARCHAR (80)   NOT NULL," +
					"    emailAddress VARCHAR (80)   NOT NULL," +
					"    mobileNum INTEGER   NOT NULL," +
					"    endDate DATE   NOT NULL)";
			stmt.executeUpdate(CreateTable);
	     }catch (Exception e) {
	    	 System.err.println(e.getClass().getName()+": "+e.getMessage());
	    	 System.exit(0);
		}	
	}	
	
	public void CreatePartTimeLecturerTable() {
		try {
			String CreateTable = "Create Table PartTimeLecturer"
					+ "( id         INTEGER       PRIMARY KEY AUTOINCREMENT NOT NULL," + 
					"    firstname       VARCHAR (80) NOT NULL," + 
					"    lastname       VARCHAR (80) NOT NULL," + 
					"    dateOfBirth       DATE NOT NULL," + 
					"    staffId VARCHAR (9)   NOT NULL," +
					"    nbrHours Integer   NOT NULL," +
					"    LineManager VARCHAR (9)   NOT NULL," +
					"    emailAddress VARCHAR (80)   NOT NULL," +
					"    mobileNum INTEGER   NOT NULL," +
					"    endDate DATE   NOT NULL)";
			stmt.executeUpdate(CreateTable);
		}	catch (Exception e) {
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}	
	}	
}
