//package com.comp.problems;
//import java.util.*;
//
//class Student{
//	private int id;
//	private String fname;
//	private double cgpa;
//	public Student(int id, String fname, double cgpa) {
//		super();
//		this.id = id;
//		this.fname = fname;
//		this.cgpa = cgpa;
//	}
//	public int getId() {
//		return id;
//	}
//	public String getFname() {
//		return fname;
//	}
//	public double getCgpa() {
//		return cgpa;
//	}
//}
//
//class Check implements Comparator<Student> {
//
//    @Override
//    public int compare(Student s1,Student s2){
//        if(s1.getCgpa()>s2.getCgpa()){
//            return -1;
//        }
//        else if(s1.getCgpa()<s2.getCgpa()){
//            return 1;
//        }
//        else{
//            int i=s1.getFname().compareToIgnoreCase(s2.getFname());
//            if(i==0){
//                        if(s1.getId()>s2.getId()){
//                            return 1;
//                        }
//                        else {
//                             return -1;
//                        } 
//            }
//            else return i;
//        }
//
//    }
//}
////Complete the code
//public class Solution
//{
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		int testCases = Integer.parseInt(in.nextLine());
//		
//		List<Student> studentList = new ArrayList<Student>();
//		while(testCases>0){
//			int id = in.nextInt();
//			String fname = in.next();
//			double cgpa = in.nextDouble();
//			
//			Student st = new Student(id, fname, cgpa);
//			studentList.add(st);
//			
//			testCases--;
//		}
//        Collections.sort(studentList,new Check());
//
//      	for(Student st: studentList){
//			System.out.println(st.getFname());
////			System.out.println(st.getFname()+"-"+st.getId());
//
//		}
//	}
//}
//
//
//
