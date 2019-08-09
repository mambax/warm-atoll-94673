package ch.abbts.swt.jedis;

import ch.abbts.swt.jedis.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {}