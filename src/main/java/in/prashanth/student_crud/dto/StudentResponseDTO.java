package in.prashanth.student_crud.dto;

public class StudentResponseDTO {

    private long id;
    private String name;
    private String emailId;
    private String course;

    public StudentResponseDTO(long id, String name, String emailId, String course) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.course = course;
    }

    public StudentResponseDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
