package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Clubs;

import java.util.List;

@Mapper
public interface ClubsMapper {
    @Select("select * from clubs")
    List<Clubs> selectTiao();
}
