package Person;
import java.util.Date;

public abstract class Person {
	
	private String firstname;
	private String lastName;
	private Date dateOfBirth;
	private String emailAddress;
	private int mobileNumber;
	private Date endDate;
	private String filePath;
    //Constructor
	public Person(String firstname, String lastname, Date dob, 
			int mobileNum,String email, Date edate){
		this.firstname=firstname;
		this.lastName=lastname;
		this.dateOfBirth = dob;
		this.emailAddress = email;
		this.mobileNumber = mobileNum;
		this.endDate = edate;
	}
	//Getters and Setters
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String studentFilePath) {
		this.filePath = studentFilePath;
	}
	
	public String getStringInsertDB() {
		return null;
	}
	
	public String getStringInsertFile() {
		return null;
	}
	
	public static String getFileName() {
		return null;
	}
	
	public String getFileNameInsert() {
		return null;
	}
}	
