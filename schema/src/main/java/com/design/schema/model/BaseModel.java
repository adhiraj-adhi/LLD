package com.design.schema.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
/* @MappedSuperclass - Declares a class which is not itself an entity, but whose
   mappings are inherited by the entities which extend it. */
@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {
    // we made class abstract because it is not an entity and should never be instantiated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
    * Note: In real, we try to use UUID as type instead of long so that our id is
    * not guessable. Long id can expose: number of users and order of creation
    * */

    @CreatedDate
    /* @CreatedDate - Declares a field as the one representing the date the entity
       containing the field was created.
     */
    private Date createdAt;
    @LastModifiedDate
    /* @LastModifiedDate - Declares a field as the one representing the date the entity
       containing the field was recently modified.
     */
    private Date lastModifiedAt;

    /*
    * After using @CreatedDate and @LastModifiedDate we are in no need of manual handling
    * of createdAt and lastModifiedAt [will be done by Spring Boot to be precise it will
    * be done by Spring Data JPA Auditing based on the OS clock of the machine where the
    * application is running (which may or may not be same as OS on which DB is running)
    * and will be consistent].
    * */
}
