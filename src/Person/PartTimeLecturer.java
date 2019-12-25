package Person;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PartTimeLecturer extends Person {
	
	private String staffId;
	private int nbrHours;
	private String lineManager;
	private static String PartTimelecturerFilePath = "parttimers.csv";

	//Constructor
	public PartTimeLecturer(String firstname, String lastname, Date dob, 
			int mobileNum,String email, Date edate, String id, 
			Integer hours, String man) {
		super(firstname,lastname,dob,mobileNum,email,edate);
		this.staffId= id;
		this.nbrHours = hours;
		this.lineManager = man;	
	}

	//Getters and Setters
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public int getNbrHours() {
		return nbrHours;
	}

	public void setNbrHours(int nbrHours) {
		this.nbrHours = nbrHours;
	}

	public String getLineManager() {
		return lineManager;
	}

	public void setLineManager(String lineManager) {
		this.lineManager = lineManager;
	}
	
	public String getStringInsertDB() {
		String InsertPartTimeLecturer = "Insert into PartTimeLecturer(firstname,lastname,dateOfBirth,emailAddress,mobileNum,endDate," +
				"staffid,nbrHours,LineManager)Values('"+this.getFirstname()+"','"+this.getLastName()+"','"
				+new SimpleDateFormat("yyyy-MM-dd").format(this.getDateOfBirth())+"','"
				+this.getEmailAddress()+"',"+this.getMobileNumber()+",'"+new SimpleDateFormat("yyyy-MM-dd").format(this.getEndDate())+"','"
				+this.getStaffId()+"','"+this.getNbrHours()+"','"+this.getLineManager()+"')";

        return InsertPartTimeLecturer;
	}

	public String getStringInsertFile() {
		String InsertStudent = this.getFirstname()+","+this.getLastName()+","+new SimpleDateFormat("yyyy-MM-dd").format(this.getDateOfBirth())
			    +","+this.getMobileNumber()+","+this.getEmailAddress()+","+new SimpleDateFormat("yyyy-MM-dd").format(this.getEndDate())
			    + ","+this.getStaffId() +","+this.getNbrHours()+","+this.getLineManager()+"\n";

        return InsertStudent;
	}
	
	public static String getFileName() {
		return PartTimelecturerFilePath;
	}
	
	public String getFileNameInsert() {
		return PartTimelecturerFilePath;
	}
}
