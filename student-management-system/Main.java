 import java.util.*;
 class Student {
    String name,id,section;
    Student(String id,String name,String section)
    {
        this.name=name;
        this.id=id;
        this.section=section;
    }
	 public String toString()
        {
            return  id+" "+name+" "+section;
		}
}
class StudentManager
{
	ArrayList<Student> students=new ArrayList<>();
     public void addStudent(String id,String name,String section)
    {
            students.add(new Student(id,name,section));
			System.out.println("Added successfully.");
    }
    public  void displayInfo()
    {
		if(students.isEmpty())
		{
			System.out.println("No tudents to display");
			return;
		}
        for(Student s:students)
                        {
                            System.out.println(s);
                        }
    }
     public  void searchStudent(String id)
    {
        boolean found=false;
                for(Student s:students)
                    {
                        if(s.id.equals(id))
                        {
                            System.out.println(s);
                            found=true;
                        }
                    }
                    if(!found)
                        System.out.println("Student with "+id+" does not exist");
    }
    public  void updateStudent(String id,String name,String section)
    {
        boolean found=false;
                for(Student s:students)
                    {
                        if(s.id.equals(id))
                        {
                           s.name=name;
                           s.section=section;
                           found=true;
                        }
                    }
                    if(found)
                        System.out.println("Updated successfully");
                    else
                        System.out.println("Student not found");

    }
    public  void deleteStudent(String id)
    {
        Iterator<Student> it = students.iterator();
                boolean found = false;
                    while(it.hasNext())
                    {
                        Student s = it.next();
    
                            if(s.id.equals(id))
                                {
                                    it.remove();   
                                    found = true;
                                }
                    }

                    if(found)
                    {
                         System.out.println("Deleted Successfully");
                    }       
                    else
                    {
                        System.out.println("Student not found");
                    }
    }
    public void getStudentsBySection(String section)
    {
		boolean found=false;
		for(Student s:students)
		{
			if(s.section.equals(section))
			{
				System.out.println(s);
				found=true;
			}
		}
		if(!found)
			System.out.println("No student found in this section");
    }
}
public class Main
{
 public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String id,name,section;
		StudentManager manager=new StudentManager();
        while(true)
        {
            System.out.println("1.Add Student: ");
            System.out.println("2.View Students: ");
            System.out.println("3.Search Student: ");
            System.out.println("4.Update Student: ");
            System.out.println("5.Delete Student: ");
			System.out.println("6.Get students by section: ");
            System.out.println("7.Exit: ");
            System.out.println("Enter your choice: ");
            int op=sc.nextInt();
        switch(op)
        {
            case 1: 
                    System.out.println("Enter id: ");
                    id=sc.next();
					boolean exists=false;
					for(Student s:manager.students)
					{
						if(s.id.equals(id))
						{
							System.out.println("ID already exists.");
							exists=true;
							break;
						}
					}
					if(exists)
						break;
                    System.out.println("Enter name: ");
                    name=sc.next();
                    System.out.println("Enter section: ");
                    section=sc.next();
                    manager.addStudent(id, name, section);
                    break;
            case 2:
                System.out.println("Students info: ");
                    manager.displayInfo();
                    break;
                    
            case 3:
                    System.out.println("Enter id of search student: ");
                    id=sc.next();
                    manager.searchStudent(id);
                    break;
            case 4:
                    System.out.println("Enter the id of student to update");
                    id=sc.next();
					boolean found=false;
					for(Student s:manager.students)
					{
						if(s.id.equals(id))
						{
							found=true;
							break;
						}
					}
					if(!found)
					{
						System.out.println("Student not found");
						break;
					}
                    System.out.println("Name: ");
                     name=sc.next();
                    System.out.println("Section: ");
                     section=sc.next();
                    manager.updateStudent(id,name, section);
                    break;
            case 5:
                
                System.out.println("Enter id to be deleted");
                id=sc.next();
                manager.deleteStudent(id);
                break;
            case 6:System.out.println("Enter the section:");
 					section=sc.next();
					manager.getStudentsBySection(section);
					break;
            case 7:
                System.exit(0);
            default : System.out.println("Invalid option");
                
        }
        }     

    }   
}

