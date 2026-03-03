package in.prashanth.student_crud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StudentRequestDTO {

    @NotBlank(message = "Name should not be null")
    @Size(min = 3,max = 255,message = "Check your Character length")
    private String name;
    @Email(message = "Enter a valid email")
    private String emailId;
    @NotNull
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
