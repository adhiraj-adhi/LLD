package com.design.schema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentCourse extends BaseModel {
    /*
     * Let us see cardinality of relation between StudentCourse and Student:
     * StudentCourse : Student
     *     1         :   1   => 1 StudentCourse is associated with one Student
     *     M         :   1   => 1 Student can be present in many rows of StudentCourse i.e.
     *                          1 Student can enroll to different course
     *                          1 Student is associated with many StudentCourse
     * => Cardinality - M:1 (ManyToOne)
     * */
    @ManyToOne
    private Student student;

    /*
     * Cardinality of relation between StudentCourse and Course:
     * StudentCourse : Course
     *     1         :   1   => 1 StudentCourse is associated with one Course
     *     M         :   1   => 1 Course can be present in many rows of StudentCourse i.e.
     *                          1 Course can be enrolled by different Students
     *                          1 Course is associated with many StudentCourse
     * => Cardinality - M:1 (ManyToOne)
     * */
    @ManyToOne
    private Course course;
}
