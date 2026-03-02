package in.prashanth.student_crud.service;

import in.prashanth.student_crud.dto.StudentRequestDTO;
import in.prashanth.student_crud.dto.StudentResponseDTO;
import in.prashanth.student_crud.entity.Student;
import in.prashanth.student_crud.mapper.StudentMapper;
import in.prashanth.student_crud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentService(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //CREATE
    public StudentResponseDTO create(StudentRequestDTO studentRequestDTO){

        Student student = mapper.toEntity(studentRequestDTO);

        Student savedStudent = repository.save(student);

        return mapper.toResponse(savedStudent);
    }

    // READ ALL
    public List<StudentResponseDTO> readAll(){

        return repository.findAll().stream().map(mapper::toResponse).toList();

    }

    // READ BY ID
    public StudentResponseDTO readById(Long id){

        Student student = repository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));

        return mapper.toResponse(student);


    }

    //UPDATE
    public StudentResponseDTO update(Long id,StudentRequestDTO studentRequestDTO){

        Student existing = repository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));

        mapper.updateStudentFromDto(studentRequestDTO ,existing);

        Student updated = repository.save(existing);

        return mapper.toResponse(updated);

    }

    // DELETE
    public void deleteById(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new RuntimeException("Student not found");
        }
    }
}
