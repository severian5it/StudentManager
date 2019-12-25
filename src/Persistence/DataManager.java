package Persistence;

import Person.CollegeList;

public class DataManager {

	public void insert(CollegeList toInsert, Iinsertable InsertManager)  {
		
		for (int i=0; i < toInsert.size(); i++ ) {	
				InsertManager.insert(toInsert.getPerson(i));
		}
	}
	
	public CollegeList  query(Iquerable toQuery) {
		CollegeList ResultSet = toQuery.ReturnAll();
		return ResultSet;
		
	}
}
