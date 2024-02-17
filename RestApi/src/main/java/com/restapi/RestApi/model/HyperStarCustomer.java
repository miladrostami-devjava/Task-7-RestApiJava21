package com.restapi.RestApi.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "hyper_star_customer")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HyperStarCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 @Column(name = "first_name" , nullable = false)
    private String firstName;
 @Column(name = "last_name",nullable = false)
    private String lastName;
 @Column(name = "email",nullable = false)
    private String email;
 @CreationTimestamp
 @Temporal(TemporalType.TIMESTAMP)
 @Column(name = "crated_at" ,nullable = false)
    private Date cratedAt;
 @Column(name = "created_by",nullable = false)
 @CreatedBy
    private String createdBy;
 @UpdateTimestamp
 @Temporal(TemporalType.TIMESTAMP)
 @Column(name = "update_at",nullable = false)
    private Date updateAt;
 @Column(name = "update_by",nullable = false)
 @LastModifiedBy
    private String updateBy;
 @Column(name = "phone_number",nullable = false)
    private String phoneNumber;
 @Column(name = "home_address",nullable = false)
    private String homeAddress;
 @Column(name = "job_address",nullable = false)
    private String jobAddress;
 @Column(name = "grade",nullable = false)
    private Double grade;
 @Column(name = "national_code",nullable = false)
    private String nationalCode;
 @Column(name = "marital_status",nullable = false)
    private String maritalStatus;
 @Column(name = "child_number",nullable = false)
    private Integer childNumber;
 @Column(name = "driving_license",nullable = false)
    private Boolean drivingLicense;
 @Column(name = "health_status", nullable = false)
    private Boolean healthStatus;


}
