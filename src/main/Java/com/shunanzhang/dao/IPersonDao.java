package com.shunanzhang.dao;

import com.shunanzhang.entity.PersonInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPersonDao {
    PersonInfo queryPersonInfoById(long personId);

    int insertPersonInfo(PersonInfo personInfo);

    int updatePersonInfo(PersonInfo personInfo);

    int deletePersonInfo(long personId);

    List<PersonInfo> getPersonInfoList(@Param("personCondition") PersonInfo personInfo,
                                       @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
}
