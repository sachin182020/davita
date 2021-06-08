package com.pms.vital.details.repository;

import org.springframework.stereotype.Repository;

import com.pms.vital.details.model.VitalDetails;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VitalDetailsRepository extends JpaRepository<VitalDetails,String> {

}
