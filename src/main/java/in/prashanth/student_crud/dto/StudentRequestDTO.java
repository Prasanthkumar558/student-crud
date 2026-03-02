package in.prashanth.student_crud.dto;

public class StudentRequestDTO {

    private String name;
    private String emailId;
    private String course;

    public StudentRequestDTO(String name, String emailId, String course) {
        this.name = name;
        this.emailId = emailId;
        this.course = course;
    }

    public StudentRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
