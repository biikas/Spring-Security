package com.bikash.springsecurity.repository;

import com.bikash.springsecurity.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Long> {
}
