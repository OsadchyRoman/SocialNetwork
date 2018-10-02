package com.epam.training.inner.dao;

import com.epam.training.inner.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long> {
}
