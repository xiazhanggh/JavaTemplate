package com.build.oa.repo;

import com.build.oa.domain.User;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.Cacheable;
import javax.persistence.QueryHint;
import java.util.List;

/**
 * Created by xzhang on 7/14/2017.
 */
public interface UserRepo extends JpaRepository<User,Integer>{

    @QueryHints({@QueryHint(value = "true",name="org.hibernate.cacheable")})
    List<User> findByName(@Param(value = "name") String name);
}
