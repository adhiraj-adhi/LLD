package com.design.schema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class CourseExam extends BaseModel {
    /*
    * Let us see cardinality of relation between CourseExam and Course:
    * CourseExam : Course
    *     1      :   1   => 1 CourseExam is associated with one Course
    *     M      :   1   => 1 Course can be present in many rows of CourseExam so
    *                       1 Course is associated with many CourseExam
    * => Cardinality - M:1 (ManyToOne)
    * */
    @ManyToOne
    private Course course;

    /*
     * Cardinality of relation between CourseExam and Exam:
     * CourseExam : Exam
     *     1      :   1   => 1 CourseExam is associated with one Exam
     *     M      :   1   => 1 Exam can be present in many rows of CourseExam so
     *                       1 Exam is associated with many CourseExam
     * => Cardinality - M:1 (ManyToOne)
     * */
    @ManyToOne
    private Exam exam;

    /*
    * If we observe, the M side in M:1 relation for above both attribute is CourseExam
    * so, in M side i.e. in course_exam table we will have course_id and exam_id created.
    * Isn't this what we want?
    * */
    private Date dateOfExam;
}
