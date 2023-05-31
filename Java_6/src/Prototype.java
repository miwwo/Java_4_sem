class Education implements Cloneable {
    private String degree;
    private String major;
    private String school;
    private int year;

    public Education(String degree, String major, String school, int year) {
        this.degree = degree;
        this.major = major;
        this.school = school;
        this.year = year;
    }

    public String getDegree() {
        return degree;
    }

    public String getMajor() {
        return major;
    }

    public String getSchool() {
        return school;
    }

    public int getYear() {
        return year;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Education{" +
                "degree='" + degree + '\'' +
                ", major='" + major + '\'' +
                ", school='" + school + '\'' +
                ", year=" + year +
                '}';
    }
}

class Resume implements Cloneable {
    private String name;
    private String email;
    private Education education;

    public Resume(String name, String email, Education education) {
        this.name = name;
        this.email = email;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Education getEducation() {
        return education;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Resume clonedResume = (Resume) super.clone();
        clonedResume.education = (Education) education.clone();
        return clonedResume;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", education=" + education +
                '}';
    }
}

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Education education = new Education("Bachelor's", "Computer Science", "Harvard", 2020);
        Resume originalResume = new Resume("John Doe", "johndoe@email.com", education);

        Resume clonedResume = (Resume) originalResume.clone();
        System.out.println("Original Resume: " + originalResume);
        System.out.println("Cloned Resume: " + clonedResume);

        System.out.println();

        originalResume.setName("Jane Smith");
        originalResume.setEmail("janesmith@email.com");
        originalResume.getEducation().setSchool("MIT");
        originalResume.getEducation().setYear(2022);

        System.out.println("Original Resume after modification: " + originalResume);
        System.out.println("Cloned Resume after modification: " + clonedResume);
    }
}
