package com.teamProject.syusyu.service.cs.impl;


import com.teamProject.syusyu.dao.cs.FaqDAO;
import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.service.cs.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FaqServiceImpl implements FaqService {

    FaqDAO faqDao;

    @Autowired
    public FaqServiceImpl(FaqDAO faqDao) {
        this.faqDao = faqDao;
    }

    @Override
    public int getCount() throws Exception{
        return faqDao.count();
    }

    @Override
    public int remove(Integer faqNo, String writer) throws Exception{
        return faqDao.deleteFaq(faqNo,writer);
    }

    @Override
    public int write(FaqDTO faqDtO)throws Exception{
        return faqDao.insertFaq(faqDtO);
    }

    @Override
    public List<FaqDTO> getList() throws Exception{
        System.out.println("FaqServiceImpl.gsetList()");
        return faqDao.selectAll();
    }

    @Override
    public FaqDTO read(Integer faqNo) throws Exception{
        FaqDTO faqDto = faqDao.selectFaq(faqNo);
        return faqDto;
    }

    @Override
    public List<FaqDTO>getPage(Map map) throws Exception{
        return faqDao.selectPage(map);
    }

    @Override
    public int modify(FaqDTO faqDto)throws Exception{
        return faqDao.updateFaq(faqDto);
    }


    @Override
    public List<FaqDTO> getSearchResultPage(SearchCondition sc)throws Exception{
        return faqDao.searchSelectPage(sc);
    }

    @Override
    public int getSearchResultCnt(SearchCondition sc)throws Exception{
        return faqDao.searchResultCnt(sc);
    }

    @Override
    public FaqDTO getPrevTitle(Integer faqNo)throws Exception{
        return faqDao.selectPrevFaq(faqNo);
    }

    @Override
    public FaqDTO getNextTitle(Integer faqNo)throws Exception{
        return faqDao.selectNextFaq(faqNo);
    }


}