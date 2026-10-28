public class student {
    private int id;
    private String name;
    private String emali;
    private double cgpa;
    private String branch;

    // Constructor
    public student(int id,String name,String emali,double cgpa,String branch){
        this.id=id;
        this.name= name;
        this.emali=emali;
        this.cgpa=cgpa;
        this.branch=branch;

    }
    public int getId(){
        return id;
        
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return emali;
    }

    public double getCgpa(){
        return cgpa;
    }

    public String getBranch(){
        return branch;
    }

    public void displayStudent() {
        System.out.println("student id:" + id);
        System.out.println("student name:" + name);
        System.out.println("student email:" + emali);
        System.out.println("student cgpa:" + cgpa);
        System.out.println("student branch:" + branch);
    }
}
