package com.project.postcredit.dao;
import com.project.postcredit.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataDao extends JpaRepository<UserData, Integer> {

    @Query(value="SELECT password FROM user_data WHERE user_name=:username", nativeQuery = true)
    String findByUserName(@Param("username") String username);


}
