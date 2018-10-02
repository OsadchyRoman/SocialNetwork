package com.epam.training.inner.dao;

import com.epam.training.inner.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface SettingDao extends JpaRepository<Setting, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Setting s SET s.visionForAnonymous =:visionForAnonymous," +
            "s.visionForNonFriend =:visionForNonFriend, s.visionFriends =:visionFriends," +
            "s.visionPresents =:visionPresents, s.visionGroups =:visionGroups," +
            "s.visionSex =:visionSex, s.visionAge =:visionAge," +
            "s.visionCountryCity =:visionCountryCity  WHERE s.id=:id")
    void update(@Param("id") Long id, @Param("visionForAnonymous") String visionForAnonymous,
                @Param("visionForNonFriend") String visionForNonFriend, @Param("visionFriends") String visionFriends,
                @Param("visionPresents") String visionPresents, @Param("visionGroups") String visionGroups,
                @Param("visionSex") String visionSex, @Param("visionAge") String visionAge,
                @Param("visionCountryCity") String visionCountryCity);
}
