package Person;

import java.util.ArrayList;

public class CollegeList implements Ilistaddable{
	
   private ArrayList<Person> List1 = new ArrayList<Person>();
	
   public void addPerson(Person p1 ) {
	   List1.add(p1);
   }

   public Person getPerson(int n ) {
	   Person ret = List1.get(n);
	   return ret;
   }

   public int size() {
	   return List1.size();
   }
}
