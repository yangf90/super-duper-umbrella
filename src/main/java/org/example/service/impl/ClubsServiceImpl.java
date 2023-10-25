package org.example.service.impl;

import org.example.mapper.ClubsMapper;
import org.example.pojo.Clubs;
import org.example.service.ClubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubsServiceImpl implements ClubsService {
    @Autowired
    private ClubsMapper clubsMapper;
    @Cacheable("SpringBoot09")
    @Override
    public List<Clubs> selectTiao() {
        return clubsMapper.selectTiao();
    }
}
