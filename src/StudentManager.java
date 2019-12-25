import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Persistence.DBManager;
import Persistence.DataManager;
import Persistence.FileManager;
import Person.CollegeList;
import Person.Lecturer;
import Person.PartTimeLecturer;
import Person.Person;
import Person.Student;

public class StudentManager {
	
	public static void main(String[] args) {

	    //ArrayList to insert
		CollegeList CollegeRegistration = new CollegeList();
	
		Person P1 = new Student("Bilbo","Baggings",parseDate("2890-09-22"),123456,
				"bilbo@gmail.com",parseDate("3012-12-31"),"D1",2018,"D265");
		
		Person P4 = new Lecturer("Saruman","TheWhite",parseDate("1000-01-01"),234567,"saruman@gmail.com",
				parseDate("3012-12-31"),"D4",1000.5,"Wizard");
		
		Person P2 = new Lecturer("Gandalf","TheGrey",parseDate("1000-01-01"),234567,"gandalf@gmail.com",
				parseDate("3012-12-31"),"D2",1000.5,"Wizard");
	
		Person P3 = new PartTimeLecturer("Aragorn","Arathorn son",parseDate("2700-06-30"),345678,
				"aragorn@gmail.com",parseDate("3012-12-31"),"D3",40,"D2");
		
		CollegeRegistration.addPerson(P1);
		CollegeRegistration.addPerson(P3);
		CollegeRegistration.addPerson(P4);
		CollegeRegistration.addPerson(P2);
		
		//Data Manager consuming different data persistence manager
		DataManager dm = new DataManager();
		
		FileManager fm = new FileManager("/Users/pierluca/eclipse-workspace/DitStudentManager/src/");
		
		DBManager db = new DBManager("jdbc:sqlite:studentsDB:sqlite");
		
		// create tables to insert in db, uncomment only on first run.
		db.createLecturerTable();
		db.CreatePartTimeLecturerTable();
		db.createStudentTable();
		
		dm.insert(CollegeRegistration,db);//use alternatively db or fm
		
		CollegeList Output = dm.query(db);//use alternatively db or fm
		
		SendMail("DIT closed because of Weather",Output);
		
		PrintAttendant(Output);
	}

	public static Date parseDate(String date) {
	    try {
	        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	    } catch (ParseException e) {
	        return null;
	    }
	}
	
	public static void SendMail(String Message,CollegeList mailList) {
	    for (int i = 0; i < mailList.size(); i++) {
			System.out.println(Message+" sent to: "+mailList.getPerson(i).getEmailAddress());
		}
	}
	
	public static void PrintAttendant(CollegeList attendance) {
		System.out.println("List of DIT attendants:");
	    for (int i = 0; i < attendance.size(); i++) {
			System.out.println(attendance.getPerson(i).getFirstname()+" "
	                   +attendance.getPerson(i).getLastName()+" ");
		}
	}
}


