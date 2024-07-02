package org.emo.repository;

import org.emo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    EmployeeEntity findByFirstName(String firstName);
}
