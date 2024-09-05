package com.mint.subject.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mint.subject.entity.SubjectInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectInfoMapper extends BaseMapper<SubjectInfo> {
    List<SubjectInfo> queryPage(@Param("subjectInfo") SubjectInfo subjectInfo,
                                @Param("categoryId") Long categoryId,
                                @Param("labelId") Long labelId,
                                @Param("start") Integer start,
                                @Param("pageSize") Integer pageSize);
}
