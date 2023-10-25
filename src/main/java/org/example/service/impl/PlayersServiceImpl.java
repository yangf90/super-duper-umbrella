package org.example.service.impl;

import org.example.mapper.PlayersMapper;
import org.example.pojo.PageBean;
import org.example.pojo.Players;
import org.example.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersServiceImpl implements PlayersService {
    @Autowired
    private PlayersMapper playersMapper;
    @Override
    public PageBean<Players> select(String pname, Integer cid, Integer currPageNo, Integer pageSize) {
        PageBean<Players> pageBean = new PageBean<Players>();
        pageBean.setCurrPageNo(currPageNo);
        Integer total = find(pname, cid);
        pageBean.setTotalCount(total);
        Integer totalPageCount = total%2==0?total/2:total/2+1;
        pageBean.setTotalPageCount(totalPageCount);
        List<Players> list = playersMapper.select(pname,cid,(currPageNo-1)*2,2);
        pageBean.setLists(list);
        return pageBean;
    }

    @Override
    public Integer find(String pname, Integer cid) {
        return playersMapper.find(pname, cid);
    }

    @Override
    public int add(Players players) {
        return playersMapper.add(players);
    }

    @Override
    public int delete(Integer pid) {
        return playersMapper.delete(pid);
    }

}
