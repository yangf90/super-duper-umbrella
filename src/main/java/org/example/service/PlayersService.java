package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.PageBean;
import org.example.pojo.Players;

import java.util.List;

public interface PlayersService {
    PageBean<Players> select(String pname, Integer cid, Integer currPageNo, Integer pageSize);
    Integer find(String pname,Integer cid);

    int add(Players players);

    int delete(Integer pid);
}
