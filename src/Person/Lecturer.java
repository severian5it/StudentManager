package Person;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lecturer extends Person{
	
	private String staffId;
	private Double Salary;
	private String jobTitle;
	private static String lecturerFileName = "lecturers.csv";

	//Constructor
	public Lecturer(String firstname, String lastname, Date dob, 
			Integer mobileNum,String email, Date edate, String id, 
			Double sal, String job) {
		super(firstname,lastname,dob,mobileNum,email,edate);
		this.staffId= id;
		this.Salary = sal;
		this.jobTitle = job;	
	}
	//Getters and Setters
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getStringInsertDB() {
		String InsertLecturer = "Insert into Lecturers(firstname,lastname,dateOfBirth,emailAddress,mobileNum,endDate," +
				"staffId,salary,jobTitle)Values('"+this.getFirstname()+"','"+this.getLastName()+"','"
				+new SimpleDateFormat("yyyy-MM-dd").format(this.getDateOfBirth())+"','"
				+this.getEmailAddress()+"',"+this.getMobileNumber()+",'"+new SimpleDateFormat("yyyy-MM-dd").format(this.getEndDate())
				+"','"+this.getStaffId()+"','"+this.getSalary()+"','"+this.getJobTitle()+"')";;

        return InsertLecturer;
	}
	
	public String getStringInsertFile() {
		String InsertStudent = this.getFirstname()+","+this.getLastName()+","+new SimpleDateFormat("yyyy-MM-dd").format(this.getDateOfBirth())
			    +","+this.getMobileNumber()+","+this.getEmailAddress()+","+new SimpleDateFormat("yyyy-MM-dd").format(this.getEndDate())
			    + ","+this.getStaffId() +","+this.getSalary()+","+this.getJobTitle()+"\n";

        return InsertStudent;
	}
	
	public static String getFileName() {
		return lecturerFileName;
	}
	
	public String getFileNameInsert() {
		return lecturerFileName;
	}
}
