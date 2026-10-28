import java.util.*;
//cd "/Users/manoj/Documents/my project"
//javac "DSA code/manu.java"
//java -cp "DSA code" manu


public class manu {

    // ================= STUDENT CLASS =================

    static class Student {

        private int id;
        private String name;
        private double cgpa;
        private String branch;

        // HashSet stores unique skills
        private HashSet<String> skills;

        Student(int id, String name, double cgpa, String branch) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
            this.branch = branch;
            this.skills = new HashSet<>();
        }

        public void addSkill(String skill) {
            skills.add(skill);
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public String getBranch() {
            return branch;
        }

        public HashSet<String> getSkills() {
            return skills;
        }

        public void displayStudent() {
            System.out.println(
                "ID: " + id +
                ", Name: " + name +
                ", CGPA: " + cgpa +
                ", Branch: " + branch +
                ", Skills: " + skills
            );
        }
    }


    // ================= COMPANY CLASS =================

    static class Company {

        private int companyId;
        private String companyName;
        private double minimumCGPA;

        Company(int companyId, String companyName, double minimumCGPA) {
            this.companyId = companyId;
            this.companyName = companyName;
            this.minimumCGPA = minimumCGPA;
        }

        public int getCompanyId() {
            return companyId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public double getMinimumCGPA() {
            return minimumCGPA;
        }
    }


    // ================= APPLICATION CLASS =================

    static class Application {

        private int studentId;
        private int companyId;

        Application(int studentId, int companyId) {
            this.studentId = studentId;
            this.companyId = companyId;
        }

        public int getStudentId() {
            return studentId;
        }

        public int getCompanyId() {
            return companyId;
        }
    }


    // ================= MAIN DATA STRUCTURES =================

    // ArrayList → stores all students
    static ArrayList<Student> students = new ArrayList<>();

    // HashMap → student ID → Student object
    static HashMap<Integer, Student> studentMap = new HashMap<>();

    // Companies
    static ArrayList<Company> companies = new ArrayList<>();

    // Queue → applications
    static Queue<Application> applicationQueue = new LinkedList<>();


    // ================= ADD STUDENT =================

    static void addStudent(Student student) {

        students.add(student);

        studentMap.put(student.getId(), student);
    }


    // ================= SEARCH STUDENT =================

    static void searchStudent(int id) {

        Student student = studentMap.get(id);

        if (student != null) {
            System.out.println("\nStudent Found:");
            student.displayStudent();
        } else {
            System.out.println("\nStudent not found.");
        }
    }


    // ================= SORT BY CGPA =================

    static void sortByCGPA() {

        students.sort(
            Comparator.comparingDouble(Student::getCgpa).reversed()
        );

        System.out.println("\nStudents sorted by CGPA:");

        for (Student student : students) {
            student.displayStudent();
        }
    }


    // ================= FIND ELIGIBLE STUDENTS =================

    static void findEligibleStudents(Company company) {

        System.out.println(
            "\nEligible students for " +
            company.getCompanyName() +
            ":"
        );

        for (Student student : students) {

            if (student.getCgpa() >= company.getMinimumCGPA()) {

                System.out.println(
                    student.getName() +
                    " - CGPA: " +
                    student.getCgpa()
                );
            }
        }
    }


    // ================= COUNT APPLICATIONS =================

    static void countApplications() {

        System.out.println(
            "\nTotal Applications: " +
            applicationQueue.size()
        );
    }


    // ================= MOST APPLIED COMPANY =================

    static void mostAppliedCompany() {

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (Application application : applicationQueue) {

            int companyId = application.getCompanyId();

            countMap.put(
                companyId,
                countMap.getOrDefault(companyId, 0) + 1
            );
        }

        int mostAppliedCompanyId = -1;
        int maximumApplications = 0;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {

            if (entry.getValue() > maximumApplications) {

                maximumApplications = entry.getValue();

                mostAppliedCompanyId = entry.getKey();
            }
        }

        for (Company company : companies) {

            if (company.getCompanyId() == mostAppliedCompanyId) {

                System.out.println(
                    "\nMost Applied Company: " +
                    company.getCompanyName()
                );

                System.out.println(
                    "Applications: " +
                    maximumApplications
                );
            }
        }
    }


    // ================= SEARCH BY SKILL =================

    static void searchBySkill(String skill) {

        System.out.println(
            "\nStudents with skill: " + skill
        );

        for (Student student : students) {

            if (student.getSkills().contains(skill)) {

                student.displayStudent();
            }
        }
    }


    // ================= FILTER BY CGPA =================

    static void filterByCGPA(double minimumCGPA) {

        System.out.println(
            "\nStudents with CGPA >= " +
            minimumCGPA
        );

        for (Student student : students) {

            if (student.getCgpa() >= minimumCGPA) {

                student.displayStudent();
            }
        }
    }


    // ================= MAIN =================

    public static void main(String[] args) {

        // Create students

        Student s1 = new Student(
            101,
            "Manoj",
            8.5,
            "CSE"
        );

        Student s2 = new Student(
            102,
            "Rahul",
            7.8,
            "ISE"
        );

        Student s3 = new Student(
            103,
            "Kiran",
            9.1,
            "CSE"
        );

        Student s4 = new Student(
            104,
            "Arun",
            7.2,
            "ECE"
        );


        // Add skills

        s1.addSkill("Java");
        s1.addSkill("DSA");
        s1.addSkill("SQL");

        s2.addSkill("Java");
        s2.addSkill("Python");

        s3.addSkill("Java");
        s3.addSkill("DSA");
        s3.addSkill("Spring");

        s4.addSkill("Python");
        s4.addSkill("SQL");


        // Add students

        addStudent(s1);
        addStudent(s2);
        addStudent(s3);
        addStudent(s4);


        // ================= COMPANIES =================

        Company c1 = new Company(
            1,
            "TCS",
            7.0
        );

        Company c2 = new Company(
            2,
            "Infosys",
            7.5
        );

        Company c3 = new Company(
            3,
            "Accenture",
            8.0
        );

        companies.add(c1);
        companies.add(c2);
        companies.add(c3);


        // ================= APPLICATIONS =================

        applicationQueue.add(
            new Application(101, 1)
        );

        applicationQueue.add(
            new Application(102, 1)
        );

        applicationQueue.add(
            new Application(103, 1)
        );

        applicationQueue.add(
            new Application(101, 2)
        );

        applicationQueue.add(
            new Application(103, 2)
        );

        applicationQueue.add(
            new Application(103, 3)
        );


        // ================= TEST OPERATIONS =================

        // 1. Search student
        searchStudent(103);


        // 2. Sort students by CGPA
        sortByCGPA();


        // 3. Find eligible students
        findEligibleStudents(c2);


        // 4. Count applications
        countApplications();


        // 5. Find most applied company
        mostAppliedCompany();


        // 6. Search by skill
        searchBySkill("Java");


        // 7. Filter by CGPA
        filterByCGPA(8.0);
    }
}