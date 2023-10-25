package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Players;

import java.util.List;

@Mapper
public interface PlayersMapper {
    List<Players> select(@Param("pname")String pname,@Param("cid")Integer cid,@Param("currPageNo")Integer currPageNo,@Param("pageSize")Integer pageSize);
    Integer find(@Param("pname")String pname,@Param("cid")Integer cid);

    int add(Players players);

    int delete(Integer pid);
}
