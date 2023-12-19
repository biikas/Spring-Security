package com.bikash.springsecurity.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Bikash Shah
 */
@Entity
@Table(name = "ACTIVITY")
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 22)
    private Long id;

    @Column(name="TITLE", nullable = false)
    private String title;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="STATUS")
    private String status;

    @Basic(optional = false)
    @Column(name = "CREATED_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


}
