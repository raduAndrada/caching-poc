package ro.ar.caching.poc.data

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "students")
class Student(
    val name: String,
    val age: Int,
    val gradeAvg: Double,
    @Id @GeneratedValue val id: Long?
)