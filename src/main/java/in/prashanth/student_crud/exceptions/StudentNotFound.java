package in.prashanth.student_crud.exceptions;

public class StudentNotFound extends RuntimeException{
    public StudentNotFound(String message) {
        super(message);
    }
}
