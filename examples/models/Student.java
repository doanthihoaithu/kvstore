package models;

import java.util.Random;

public class Student {

    public static final String [] firstnames = {"00","James","Mary","John","Patricia","Robert","Linda","Michael","Barbara","William","Elizabeth","David","Jennifer","Richard","Maria","Charles","Susan","Joseph","Margaret","Thomas","Dorothy","Christopher","Lisa","Daniel","Nancy","Paul","Karen","Mark","Betty","Donald","Helen","George","Sandra","Kenneth","Donna","Steven","Carol","Edward","Ruth","Brian","Sharon","Ronald","Michelle","Anthony","Laura","Kevin","Sarah","Jason","Kimberly","Matthew","Deborah","Gary","Jessica","Timothy","Shirley","Jose","Cynthia","Larry","Angela","Jeffrey","Melissa","Frank","Brenda","Scott","Amy","Eric","Anna","Stephen","Rebecca","Andrew","Virginia","Raymond","Kathleen","Gregory","Pamela","Joshua","Martha","Jerry","Debra","Dennis","Amanda","Walter","Stephanie","Patrick","Carolyn","Peter","Christine","Harold","Marie","Douglas","Janet","Henry","Catherine","Carl","Frances","Arthur","Ann","Ryan","Joyce","Roger","Diane"};
    public static final String [] lastnames = {"00","Smith","Johnson","Williams","Jones","Brown","Davis","Miller","Wilson","Moore","Taylor","Anderson","Thomas","Jackson","White","Harris","Martin","Thompson","Garcia","Martinez","Robinson","Clark","Rodriguez","Lewis","Lee","Walker","Hall","Allen","Young","Hernandez","King","Wright","Lopez","Hill","Scott","Green","Adams","Baker","Gonzalez","Nelson","Carter","Mitchell","Perez","Roberts","Turner","Phillips","Campbell","Parker","Evans","Edwards","Collins","Stewart","Sanchez","Morris","Rogers","Reed","Cook","Morgan","Bell","Murphy","Bailey","Rivera","Cooper","Richardson","Cox","Howard","Ward","Torres","Peterson","Gray","Ramirez","James","Watson","Brooks","Kelly","Sanders","Price","Bennett","Wood","Barnes","Ross","Henderson","Coleman","Jenkins","Perry","Powell","Long","Patterson","Hughes","Flores","Washington","Butler","Simmons","Foster","Gonzales","Bryant","Alexander","Russell","Griffin","Diaz","Hayes"};
    private int studentId;
    private String firstName;
    private String lastName;
    private int age;
    private int countryId;
    public static final int maxAge = 30;
    public static final int minAge =  5;


    public void setRandomInfor() {
        Random r = new Random();
        int max = firstnames.length-1;
        int min = 1;
        int i = r.nextInt((max-min)+1) + min;
        this.setFirstName(firstnames[i]);
        i = r.nextInt((max-min)+1) + min;
        this.setLastName(lastnames[i]);
        int countryId = Country.getRanDom();
        this.setCountryId(countryId);
        int age = r.nextInt(maxAge-minAge+1) + minAge;
        this.setAge(age);
    };

    public Student(int studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void main(String[] args) {
        System.out.println(firstnames.length);
        System.out.println(lastnames.length);
        Student student = new Student();
        student.setRandomInfor();
        System.out.println(student.firstName);
        System.out.println(student.lastName);
        System.out.println(student.getCountryId());
    }
}
