package Person;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person{
	
	private String studentId;
	private int courseYear;
	private String courseId;
	private static String studentFileName = "students.csv";


   //Constructor
	public Student(String firstname, String lastname, Date dob, 
		int mobileNum,String email, Date edate, String id, 
		int courseY, String courseI) {
		super(firstname,lastname,dob,mobileNum,email,edate);
		this.studentId= id;
		this.courseYear = courseY;
		this.courseId = courseI;	
		
	}

	//Getters and Setters
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public int getCourseYear() {
		return courseYear;
	}
	
	public void setCourseYear(int courseYear) {
		this.courseYear = courseYear;
	}
	
	public String getCourseId() {
		return courseId;
	}
	
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public String getStringInsertDB() {
		String InsertStudent = "Insert into Students(firstname,lastname,dateOfBirth,emailAddress,mobileNum,endDate," +
				"studentid,courseid,courseyear)Values('"+this.getFirstname()+"','"+this.getLastName()+"','"
				+new SimpleDateFormat("yyyy-MM-dd").format(this.getDateOfBirth())+"','"
				+this.getEmailAddress()+"',"+this.getMobileNumber()+",'"+new SimpleDateFormat("yyyy-MM-dd").format(this.getEndDate())
				+"','"+this.getStudentId()+"','"+this.getCourseId()+"',"+this.getCourseYear()+")";
        return InsertStudent;
	}
	
	public String getStringInsertFile() {
		String InsertStudent = this.getFirstname()+","+this.getLastName()+","+new SimpleDateFormat("yyyy-MM-dd").format(this.getDateOfBirth())
			    +","+this.getMobileNumber()+","+this.getEmailAddress()+","+new SimpleDateFormat("yyyy-MM-dd").format(this.getEndDate())
			    + ","+this.getStudentId() +","+this.getCourseYear()+","+this.getCourseId()+"\n";

        return InsertStudent;
	}
	
	public static String getFileName() {
		return studentFileName;
	}
	
	public String getFileNameInsert() {
		return studentFileName;
	}
}
