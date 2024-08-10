package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.CourseDetails;

public interface CourseRepo extends JpaRepository<CourseDetails, Integer> {

}
