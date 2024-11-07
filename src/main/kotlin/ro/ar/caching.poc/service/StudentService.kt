package ro.ar.caching.poc.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ro.ar.caching.poc.data.Student
import ro.ar.caching.poc.data.StudentRepository
import org.springframework.cache.annotation.Cacheable

@Service
class StudentService(
    @Autowired private val studentRepository: StudentRepository
) {

    fun getStudentByNameNoCache(name: String): Student {
        simulateSlowService()
        return studentRepository.findByName(name) ?: throw Exception("Student not found")
    }

    @Cacheable("students")
    fun getStudentByNameCached(name: String): Student {
        simulateSlowService()
        return studentRepository.findByName(name) ?: throw Exception("Student not found")
    }

    fun simulateSlowService() {
        Thread.sleep(3000)
    }
}