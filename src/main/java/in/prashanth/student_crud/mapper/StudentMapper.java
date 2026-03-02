package in.prashanth.student_crud.mapper;

import ch.qos.logback.core.model.ComponentModel;
import in.prashanth.student_crud.dto.StudentRequestDTO;
import in.prashanth.student_crud.dto.StudentResponseDTO;
import in.prashanth.student_crud.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.Mapping;


@Mapper(componentModel = "spring")

public interface StudentMapper {

    Student toEntity(StudentRequestDTO dto);

    StudentResponseDTO toResponse(Student student);

    void updateStudentFromDto(StudentRequestDTO dto , @MappingTarget Student student);


}
