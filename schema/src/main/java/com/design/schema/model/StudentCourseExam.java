package com.design.schema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentCourseExam extends BaseModel { // relation between Student and CourseExam
    /*
     * Let us see cardinality of relation between StudentCourseExam and Student:
     * StudentCourseExam : Student
     *       1           :   1   => 1 StudentCourseExam is associated with one Student
     *       M           :   1   => 1 Student can be present in many rows of StudentCourseExam so
     *                              1 Student is associated with many StudentCourseExam
     * => Cardinality - M:1 (ManyToOne)
     * */
    @ManyToOne
    private Student student;

    /*
     * Cardinality of relation between StudentCourseExam and Student:
     * StudentCourseExam : CourseExam
     *       1           :   1   => 1 StudentCourseExam is associated with one CourseExam
     *       M           :   1   => 1 CourseExam can be present in many rows of StudentCourseExam
     *                              because many Student will give a CourseExam
     *                              so 1 CourseExam is associated with many StudentCourseExam
     * => Cardinality - M:1 (ManyToOne)
     * */
    @ManyToOne
    private CourseExam courseExam;
    private double marks;
}
