package com.build.oa.repo;

import com.build.oa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xzhang on 7/14/2017.
 */
public interface UserRepo extends JpaRepository<User,Integer>{
}
