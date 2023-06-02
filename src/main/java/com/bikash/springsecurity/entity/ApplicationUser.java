package com.bikash.springsecurity.entity;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Bikash Shah
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "application_user")
@Table(name = "APPLICATION_USER")
@Data
public class ApplicationUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 22)
    private Long id;


    @Basic(optional = false)
    @Column(name = "USERNAME", nullable = false, length = 50)
    private String username;

    @Basic(optional = false)
    @Column(name = "PASSWORD", nullable = false, length = 200)
    private String password;

    @Basic(optional = false)
    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @Basic(optional = true)
    @Column(name = "EMAIL_ADDRESS", nullable = true, length = 200)
    private String emailAddress;

    @Basic(optional = false)
    @Column(name = "ACTIVE", nullable = false)
    private char active;

    @Basic(optional = false)
    @Column(name = "CREATED_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

//    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "application_user")
//    @JoinColumn(name = "CREATED_BY", referencedColumnName = "ID", nullable = true)
//    @ManyToOne
//    private ApplicationUser createdBy;

//    @Column(name = "LAST_MODIFIED_DATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "application_user")
//    @JoinColumn(name = "LAST_MODIFIED_BY", referencedColumnName = "ID", nullable = true)
//    @ManyToOne
//    private ApplicationUser lastModifiedBy;
//    @Column(name = "APPROVAL_DATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date approvalDate;
//    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "application_user")
//    @JoinColumn(name = "APPROVED_BY", referencedColumnName = "ID", nullable = true)
//    @ManyToOne
//    private ApplicationUser approvedBy;
//    @Column(name = "LAST_LOGIN_TIME", length = 50)
//    private String lastLogintime;
//    @Column(name = "LOGIN_STATUS")
//    private Integer loginStatus;
//    @Column(name = "DELETED", length = 50)
//    private Character userDeleted;
//    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "application_user")
//    @JoinColumn(name = "DELETED_BY", referencedColumnName = "ID", nullable = true)
//    @ManyToOne
//    private ApplicationUser userDeletedBy;
//    @Column(name = "DELETED_DATE", length = 50)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date userdeletedDate;
//    @Column(name = "BULK_SMS_LIMIT", length = 25)
//    private Integer bulkSmsLimit;
//    @Column(name = "CENTRALIZED_OPERATION_CONTROL", length = 50)
//    private Character centralizedOperationControl;

//    @Column(name = "LAST_PASSWORD_CHANGED", nullable = true)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastPasswordChanged;

//    @Column(name = "REQUEST_ATTEMPT")
//    private Integer requestAttempt;
//    @Column(name = "LOGIN_BLOCKED", nullable = false)
//    private char logingBlocked;
//    @Column(name = "LOGIN_BLOCK_DATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date loginBlockDate;
//    @Column(name = "LOGIN_BLOCK_REMARKS", length = 80)
//    private String loginBlockRemarks;

//    @Column(name = "PASSWORD_FLAG")
//    private String passwordFlag;
//    @Column(name = "MAP_ID")
//    private String mapId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;


    public ApplicationUser() {
    }

    public ApplicationUser(Long id) {
        this.id = id;
    }

    public ApplicationUser(String username, String name, String emailAddress) {
        this.username = username;
        this.name = name;
        this.emailAddress = emailAddress;
    }
}
