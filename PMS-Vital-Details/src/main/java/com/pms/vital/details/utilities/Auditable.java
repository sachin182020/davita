package com.pms.vital.details.utilities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@SuppressWarnings("hiding")
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<object> {
	
	@CreatedBy
    @Column(nullable = false, updatable = false)
    protected String createdBy;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected Date creationOn;

    @LastModifiedBy
    @Column(nullable = false)
    protected String lastModifiedBy;

    @LastModifiedDate
    @Column(nullable = false)
    protected Date lastModifiedOn;

}
