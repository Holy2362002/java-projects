import java.util.*;
public class SchoolSystemDemo {

	public static void main(String[] args) {
		Student student  = new Student(01,"John",Gender.MALE,GradeLevel.GRADE_9);
		Student student1  = new Student(02,"Sophie",Gender.FEMALE,GradeLevel.GRADE_8);
		Student student2  = new Student(03,"Smith",Gender.MALE,GradeLevel.GRADE_9);

		Teacher teacher = new Teacher(10,"MR.CHE",Gender.MALE,Subject.ENG);
		Teacher teacher1 = new Teacher(11,"Mis.ALLIN",Gender.FEMALE,Subject.PHY);

		Course course = new Course("English Speaking",new ArrayList<>(),new ArrayList<>(),GradeLevel.GRADE_9,5);

		try {
			course.Enrollment(student,teacher);
			course.Enrollment(student1,teacher1);
		}catch(MyException e) {
			System.out.println(e.getMessage());
		}

		course.studentList();
		course.teacherList();

	}
}

class MyException extends RuntimeException {
	MyException(String message) {
		super (message);
	}
}

enum Gender {
	MALE,FEMALE;
}

enum GradeLevel {
	GRADE_6,GRADE_7,GRADE_8,GRADE_9;
}

enum Subject{
	MATH,ENG,PHY,GEO;
}

abstract class Person {
	protected int id;
	protected String name;
	protected Gender gender;

	Person(int id,String name,Gender gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	
}

class Student extends Person {

	private GradeLevel grade;

	Student(int id,String name,Gender gender,GradeLevel grade) {
		super(id,name,gender);
		this.grade = grade;
	}

	public String getName() {
		return name;
	}


}

class Teacher extends Person {

	private Subject subject;

	Teacher (int id,String name,Gender gender,Subject subject) {
		super(id,name,gender);
		this.subject = subject;
	}

	public String getName() {
		return name;
	}
}

class Course {
	private String course_name;
	private List<Student> students;
	private List<Teacher> teachers;
	private GradeLevel gradelevel;
	private int limit ;

	Course(String course_name,List<Student> students,List<Teacher> teachers,GradeLevel gradelevel,int limit) {
		this.course_name = course_name;
		this.students = students;
		this.teachers = teachers;
		this.gradelevel = gradelevel;
		this.limit = limit;
	}

	public void Enrollment(Student student,Teacher teacher) {

		if(students.size() >= limit) {
			throw new MyException("This is Full");
		}

		if(teachers.size() >= 5) {
			throw new MyException("This is full");
		}

		students.add(student);
		teachers.add(teacher);
	}

	public void studentList() {
		for(Student s : students) {
			System.out.println("All of Student list" + s.getName());
		}
	}

	public void teacherList() {
		for(Teacher t : teachers) {
			System.out.println("All of teacher List " + t.getName());
		}
	}


}