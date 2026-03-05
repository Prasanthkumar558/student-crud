package in.prashanth.student_crud.controller;

import in.prashanth.student_crud.dto.StudentRequestDTO;
import in.prashanth.student_crud.dto.StudentResponseDTO;
import in.prashanth.student_crud.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @PostMapping
    public StudentResponseDTO  create(@Valid @RequestBody StudentRequestDTO dto){

        return studentService.create(dto);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAll(){
        try{
            List<StudentResponseDTO> list = studentService.readAll();
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
        catch (RuntimeException e){
            if(e.getMessage().equals("NO USERS")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
        throw new RuntimeException();

    }

   @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getById(@PathVariable Long id){
        try {
            StudentResponseDTO dto = studentService.readById(id);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }
        catch (RuntimeException e){
            if(e.getMessage().equals("Student not found")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
        throw new RuntimeException();

   }

   @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> update(@Valid @RequestBody StudentRequestDTO dto, @PathVariable Long id){

        try{
            StudentResponseDTO studentResponseDTO = studentService.update(id,dto);
            return ResponseEntity.status(HttpStatus.OK).body(studentResponseDTO);
        }
        catch (RuntimeException e){
            if(e.getMessage().equals("Student not found")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
        throw new RuntimeException();

   }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            studentService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Student deleted");
        }
        catch (RuntimeException e){
            if(e.getMessage().equals("Student not found")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
            }
        }
        throw new RuntimeException();

   }


}
