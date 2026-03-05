package in.prashanth.student_crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<StudentNotFoundError> handler(StudentNotFound ex){
        StudentNotFoundError studentNotFoundError = new StudentNotFoundError(LocalDateTime.now() ,HttpStatus.NOT_FOUND.value() , ex.getMessage());
        return new ResponseEntity<>(studentNotFoundError,HttpStatus.NOT_FOUND);
    }
}
