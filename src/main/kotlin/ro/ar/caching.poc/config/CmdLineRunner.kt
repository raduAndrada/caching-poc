package ro.ar.caching.poc.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import ro.ar.caching.poc.data.Student
import ro.ar.caching.poc.data.StudentRepository

@Configuration
class CmdLineRunner
    (
    @Autowired val studentRepository: StudentRepository
) : CommandLineRunner {


    override fun run(vararg args: String?) {
        studentRepository.save(Student(name = "Alice", age = 23, gradeAvg = 9.5, id = null))
        studentRepository.save(Student(name = "Bob", age = 38, gradeAvg = 7.21, id = null))
        studentRepository.save(Student(name = "Carol", age = 48, gradeAvg = 8.77, id = null))
        studentRepository.save(Student(name = "David", age = 19, gradeAvg = 6.0, id = null))
        studentRepository.save(Student(name = "Eve", age = 25, gradeAvg = 9.99, id = null))
    }
}