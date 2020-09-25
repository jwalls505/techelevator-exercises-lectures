package com.techelevator;

public class HomeworkAssignment {
	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;
	
	
	
	public int getEarnedMarks() {
		return earnedMarks;
	}
	public void setEarnedMarks(int marks) {
		this.earnedMarks = marks;
	}
	public int getPossibleMarks() {
		return possibleMarks;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public String getLetterGrade() {
		if((double)(earnedMarks / (double)possibleMarks) >= 0.9) {
			return "A";
			
		} else if ((double)(earnedMarks / (double)possibleMarks) >= .8 && (double)(earnedMarks / (double)possibleMarks) <= .89) {
			return "B";
		}else if ((double)(earnedMarks / (double)(possibleMarks)) >= .7 && (double)(earnedMarks / (double)possibleMarks) <= 0.79) {
			return "C";
		} else if ((double)(earnedMarks / (double)possibleMarks) >= .6 && (double)(earnedMarks / (double)possibleMarks) <= 0.69) {
			return "D";
		}
		return "F";
	}
	
	public HomeworkAssignment( int possibleMarks, String submitterName) {
		this.possibleMarks = possibleMarks;
		this.submitterName = submitterName;
	}
	
}