package com.Springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.mapper.SearchHistMapper;
import com.Springboot.vo.HistSearch;

@Service
public class SearchHistImpl implements SearchHistSerivce{

    @Autowired
    SearchHistMapper searchHistMapper;
    @Override
    public void insertSearchHist(String username, String keyword) {
        searchHistMapper.insertSearchHist(username, keyword);
        
    }

    @Override
    public List<HistSearch> popularSearches() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int histCount() {
        // TODO Auto-generated method stub
        int aa = searchHistMapper.histCount();
        return aa;
    }

    @Override
    public HistSearch LastHist() {
        // TODO Auto-generated method stub
        HistSearch  aa= searchHistMapper.LastHist();
        return aa;
    }

}
