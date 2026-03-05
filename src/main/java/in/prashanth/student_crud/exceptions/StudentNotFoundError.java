package in.prashanth.student_crud.exceptions;

import java.time.LocalDateTime;

public class StudentNotFoundError {
    private LocalDateTime time;
    private int status;
    private String message;

    public StudentNotFoundError(LocalDateTime time,  int status, String message) {
        this.time = time;
        this.message = message;
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
