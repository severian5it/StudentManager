package Persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

import Person.CollegeList;
import Person.Lecturer;
import Person.PartTimeLecturer;
import Person.Person;
import Person.Student;

public class FileManager implements Iinsertable,Iquerable{

	private FileWriter fileWriter;
	private String location;
	private String studentFilePath;
	private String lecturerFilePath;
	private String parttimeLecturerFilePath;
	
	public FileManager(String location) {
		super();
		this.location = location;
		this.studentFilePath = location + Student.getFileName();
		this.lecturerFilePath = location + Lecturer.getFileName();
		this.parttimeLecturerFilePath = location + PartTimeLecturer.getFileName();
	}
	
	
	public void insert(Person p)  {
		
		String filePath = this.location + p.getFileNameInsert();
		String stringToAppend = p.getStringInsertFile();
		
		try {		
			fileWriter = new FileWriter(filePath,true);
			fileWriter.write(stringToAppend);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally { 
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch(Exception ex) {
				ex.printStackTrace();
				}
			}
	}
	
	public CollegeList ReturnAll() {
		
		BufferedReader studentReader = null;
		BufferedReader lecturerReader = null;
		BufferedReader parttimeLecturerReader = null;
		
		CollegeList output = new CollegeList();
		
		try {
			String line ="";
			
			studentReader = new BufferedReader( new FileReader(this.studentFilePath));
			
			while ((line = studentReader.readLine())!= null) {
				String fields[] = line.split(",");
				Student s = new Student(fields[0],fields[1],new SimpleDateFormat("yyyy-MM-dd").parse(fields[2]),Integer.parseInt((fields[3])),
							fields[4],new SimpleDateFormat("yyyy-MM-dd").parse(fields[5]),fields[6],Integer.parseInt(fields[7]),fields[8]);
				
				output.addPerson(s);
			}
			
			lecturerReader = new BufferedReader( new FileReader(this.lecturerFilePath));
			
			while ((line = lecturerReader.readLine())!= null) {
				String fields[] = line.split(",");
				Lecturer s = new Lecturer(fields[0],fields[1],new SimpleDateFormat("yyyy-MM-dd").parse(fields[2]),Integer.parseInt((fields[3])),
							fields[4],new SimpleDateFormat("yyyy-MM-dd").parse(fields[5]),fields[6],Double.parseDouble(fields[7]),fields[8]);
				
				output.addPerson(s);
			}
			
			parttimeLecturerReader = new BufferedReader( new FileReader(this.parttimeLecturerFilePath));
			
			while ((line = parttimeLecturerReader.readLine())!= null) {
				String fields[] = line.split(",");
				PartTimeLecturer s = new PartTimeLecturer(fields[0],fields[1],new SimpleDateFormat("yyyy-MM-dd").parse(fields[2]),Integer.parseInt((fields[3])),
							fields[4],new SimpleDateFormat("yyyy-MM-dd").parse(fields[5]),fields[6],Integer.parseInt(fields[7]),fields[8]);
				
				output.addPerson(s);
			}
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally { 
			try {
				studentReader.close();
				lecturerReader.close();
				parttimeLecturerReader.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return output;
	}
}
