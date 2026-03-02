package in.prashanth.student_crud.repository;

import in.prashanth.student_crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Long> {

}
