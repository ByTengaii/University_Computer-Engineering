import java.util.*;

public abstract class Gradebook {
   // getScore() returns the specified student's score for the specified
   // assignment. NaN is returned if either:
   // - the assignment does not exist in the gradebook, or
   // - the assignment exists but no score exists for the specified student.
   public abstract double getScore(String assignmentName, Integer studentID);

   // setScore() adds or updates a score in the gradebook.
   public abstract void setScore(String assignmentName, Integer studentID, Double score);

   // getAssignmentScores() returns a HashMap that maps a student ID to
   // the student's corresponding score for the specified assignment. An entry
   // exists in the returned map only if a score has been entered with the
   // setScore() function.
   public abstract HashMap<Integer, Double> getAssignmentScores(String assignmentName);

   // getSortedAssignmentNames() returns an ArrayList with all distinct assignment
   // names, sorted in ascending order.
   public abstract ArrayList<String> getSortedAssignmentNames();

   // getSortedStudentIDs() returns an ArrayList with all distinct student IDs,
   // sorted in ascending order.
   public abstract ArrayList<Integer> getSortedStudentIDs();

   // getStudentScores() gets all scores that exist in the gradebook for the 
   // student whose ID matches the method parameter. getStudentScores() 
   // returns a HashMap that maps an assignment name to the student's 
   // corresponding score for that assignment.
   public abstract HashMap<String, Double> getStudentScores(Integer studentID);
}

import java.util.*;

public class CourseGradebook extends Gradebook {
   // Declare any protected fields here (change placeholder field below)
	protected int field;
	
	@Override
	public HashMap<Integer, Double> getAssignmentScores(String assignmentName) {
		// Your code here (remove placeholder line below)
		return new HashMap<Integer, Double>();
	}
	
	@Override
	public double getScore(String assignmentName, Integer studentID) {
		// Your code here
		return Double.NaN;
	}
	
	@Override
	public ArrayList<String> getSortedAssignmentNames() {
		// Your code here (remove placeholder line below)
		return new ArrayList<String>();
	}
	
	@Override
	public ArrayList<Integer> getSortedStudentIDs() {
		// Your code here (remove placeholder line below)
		return new ArrayList<Integer>();
	}

	@Override
	public HashMap<String, Double> getStudentScores(Integer studentID) {
		// Your code here (remove placeholder line below)
		return new HashMap<String, Double>();
	}
	
	@Override
	public void setScore(String assignmentName, Integer studentID, Double score) {
		// Your code here
	}
}

public class LabProgram {
	public static void main(String[] args) {
		boolean result1 = Tests.testGetScoreAndSetScore();
		boolean result2 = Tests.testGetAssignmentScores();
		boolean result3 = Tests.testGetSortedAssignmentNames();
		boolean result4 = Tests.testGetSortedStudentIDs();
		boolean result5 = Tests.testGetStudentScores();
		
		System.out.print("\n" + "Summary:" + "\n");
		System.out.print("testGetScoreAndSetScore(): " + (result1 ? "PASS" : "FAIL") + "\n");
		System.out.print("testGetAssignmentScores(): " + (result2 ? "PASS" : "FAIL") + "\n");
		System.out.print("testGetSortedAssignmentNames(): " + (result3 ? "PASS" : "FAIL") + "\n");
		System.out.print("testGetSortedStudentIDs(): " + (result4 ? "PASS" : "FAIL") + "\n");
		System.out.print("testGetStudentScores(): " + (result5 ? "PASS" : "FAIL") + "\n");
	}
}
