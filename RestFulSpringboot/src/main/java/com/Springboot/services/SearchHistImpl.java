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
        String search_Time   = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        searchHistMapper.insertSearchHist(username, keyword, search_Time);
        
    }

    @Override
    public List<HistSearch> popularSearches() {
        List<HistSearch>  rtnPopluarSearches= searchHistMapper.popularSearches();
        for(int i =0 ; i<rtnPopluarSearches.size() ;i++) {
            System.out.println("키워드"+rtnPopluarSearches.get(i).getKeyword());
            System.out.println("총 검색횧수 :" + rtnPopluarSearches.get(i).getSearchCount());
        }
        return rtnPopluarSearches;
    }

    @Override
    public List<HistSearch> userSearchHist(String username) {
        // TODO Auto-generated method stub
        List<HistSearch>  aa= searchHistMapper.userSearchHist(username);
        return aa;
    }

}
