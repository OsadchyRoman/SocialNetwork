package com.epam.training.inner.dao;

import com.epam.training.inner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserDao extends JpaRepository<User, Long> {
    User findByLogin(String string);

    User findById(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.name =:name , u.surname =:surname , u.middleName =:middleName ," +
           "u.birthday =:birthday, u.sex =:sex, u.countryCityBirth =:countryCityBirth, u.password =:password WHERE u.id =:id")
    void update(@Param("id") Long id, @Param("name") String name, @Param("surname") String surname,
                @Param("middleName") String middleName, @Param("birthday") String birthday,
                @Param("sex") String sex, @Param("countryCityBirth") String countryCityBirth,
                @Param("password") String password);
}
