package com.lssjzmn.dao;

import com.lssjzmn.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface UserRoleDaoMapper {

    List<UserRole> findAllUserRoles(@Param("role") String role);

}
