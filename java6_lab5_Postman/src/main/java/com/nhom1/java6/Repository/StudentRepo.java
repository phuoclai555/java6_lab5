package com.nhom1.java6.Repository;

import com.nhom1.java6.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students,String> {
}
