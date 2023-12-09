package com.osipaton.kameleoontrialtask.repository;

import com.osipaton.kameleoontrialtask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
