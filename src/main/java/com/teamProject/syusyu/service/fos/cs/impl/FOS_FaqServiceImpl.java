package com.teamProject.syusyu.service.fos.cs.impl;


import com.teamProject.syusyu.dao.cs.FOS_FaqDAO;
import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.FaqSearchCondition;
import com.teamProject.syusyu.service.fos.cs.FOS_FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FOS_FaqServiceImpl implements FOS_FaqService {

    FOS_FaqDAO FOSFaqDao;

    @Autowired
    public FOS_FaqServiceImpl(FOS_FaqDAO FOSFaqDao) {
        this.FOSFaqDao = FOSFaqDao;
    }

    @Override
    public int getCount() throws Exception{
        return FOSFaqDao.count();
    }

    @Override
    public int remove(Integer faqNo, String writer) throws Exception{
        return FOSFaqDao.delete(faqNo,writer);
    }

    @Override
    public int write(FaqDTO faqDtO)throws Exception{
        return FOSFaqDao.insert(faqDtO);
    }

    @Override
    public List<FaqDTO> getList() throws Exception{
        System.out.println("FaqServiceImpl.getList()");
        return FOSFaqDao.selectAll();
    }

    @Override
    public FaqDTO read(Integer faqNo) throws Exception{
        FaqDTO faqDto = FOSFaqDao.select(faqNo);
        return faqDto;
    }

    @Override
    public List<FaqDTO>getPage(Map map) throws Exception{
        return FOSFaqDao.selectPage(map);
    }

    @Override
    public int modify(FaqDTO faqDto)throws Exception{
        return FOSFaqDao.update(faqDto);
    }

    @Override
    public int getFosSearchResultCnt(FaqSearchCondition fsc)throws Exception{
        return FOSFaqDao.FosSearchResultCnt(fsc);
    }

    @Override
    public List<FaqDTO> getFosSearchSelectPage(FaqSearchCondition fsc)throws Exception{
        return FOSFaqDao.FosSearchSelectPage(fsc);
    }


    @Override
    public FaqDTO getPrevTitle(Integer faqNo) throws Exception {
        return FOSFaqDao.selectPrev(faqNo);
    }

    @Override
    public FaqDTO getNextTitle(Integer faqNo) throws Exception {
        return FOSFaqDao.selectNext(faqNo);
    }



}
