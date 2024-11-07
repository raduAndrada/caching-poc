package ro.ar.caching.poc.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ro.ar.caching.poc.data.Student
import ro.ar.caching.poc.service.StudentService

@RestController
@RequestMapping("/students")
class StudentController(
     @Autowired val studentService: StudentService
) {

    @GetMapping("/no-cache")
    fun getStudentsNoCache(@RequestParam name: String): Student {
        return callService({ name, service -> service.getStudentByNameNoCache(name) }, name)

    }

    @GetMapping("/cache")
    fun getStudentsCache(@RequestParam name: String): Student {
        return callService({ name, service -> service.getStudentByNameCached(name) }, name)
    }


    fun callService(f: (String, StudentService) -> Student, name: String): Student {
        val startTime = System.currentTimeMillis()
        val student =  f(name, studentService)
        val endTime = System.currentTimeMillis()
        println("Time taken: ${endTime - startTime} ms")
        return student
    }
}