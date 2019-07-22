package com.comp.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


class Student	{
	private int id;
	private String name;
	private double cgpa;
	
	
	
	public Student(int id, String name, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	
}

class PriComp implements Comparator<Student>{

    @Override
    public int compare(Student s1,Student s2){
        if(s1.getCgpa()>s2.getCgpa()){
            return -1;
        }
        else if(s1.getCgpa()<s2.getCgpa()){
            return 1;
        }
        else{
            int i=s1.getName().compareTo(s2.getName());
            if(i==0){
                        if(s1.getId()>s2.getId()){
                            return 1;
                        }
                        else {
                             return -1;
                        } 
            }
            else return i;
        }

    }
	
}


class Priorities	{
	public List<Student> getStudents(List<String> events){
		PriorityQueue<Student> pq = new PriorityQueue<>(new PriComp());
		List<Student> stulist = new ArrayList<Student>();
		for (String str : events) {
			String[] data=str.split(" ");
			if(data[0].equals("ENTER")) {
				pq.add(new Student(Integer.parseInt(data[3]),data[1],Double.parseDouble(data[2])));
			}else if(data[0].equals("SERVED")) {
				pq.poll();
			}
		}
		int si=pq.size();

		for(int i=0; i < si ; i++) {
			
			stulist.add(pq.poll());
		}
		return stulist;
	}
}

public class PriorityQueueq19 {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
