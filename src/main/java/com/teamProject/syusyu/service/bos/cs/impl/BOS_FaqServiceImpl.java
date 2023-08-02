package com.teamProject.syusyu.service.bos.cs.impl;

import com.teamProject.syusyu.dao.cs.BOS_FaqDAO;
import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.service.bos.cs.BOS_FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BOS_FaqServiceImpl implements BOS_FaqService {
    BOS_FaqDAO BOSFaqDao;

    @Autowired
    public BOS_FaqServiceImpl(BOS_FaqDAO BOSFaqDao) {
        this.BOSFaqDao = BOSFaqDao;
    }

    @Override
    public int getCount() throws Exception{
        return BOSFaqDao.count();
    }

    @Override
    public int remove(Integer faqNo, Integer regrId) throws Exception{
        return BOSFaqDao.delete(faqNo,regrId);
    }

    @Override
    public int write(FaqDTO faqDtO)throws Exception{
        return BOSFaqDao.insert(faqDtO);
    }

    @Override
    public List<FaqDTO> getList() throws Exception{
        return BOSFaqDao.selectAll();
    }

    @Override
    public FaqDTO read(Integer faqNo) throws Exception{
        FaqDTO faqDto = BOSFaqDao.select(faqNo);
        return faqDto;
    }

    @Override
    public List<FaqDTO>getPage(Map map) throws Exception{
        return BOSFaqDao.selectPage(map);
    }

    @Override
    public int modify(FaqDTO faqDto)throws Exception{
        return BOSFaqDao.update(faqDto);
    }


    @Override
    public List<FaqDTO> getBosSearchSelectPage(SearchCondition sc)throws Exception{
        return BOSFaqDao.BosSearchSelectPage(sc);
    }

    @Override
    public int getBosSearchResultCnt(SearchCondition sc)throws Exception{
        return BOSFaqDao.BosSearchResultCnt(sc);
    }

    @Override
    public FaqDTO getPrevTitle(Integer faqNo) throws Exception{
        return BOSFaqDao.selectPrev(faqNo);
    }

    @Override
    public FaqDTO getNextTitle(Integer faqNo) throws Exception{
        return BOSFaqDao.selectNext(faqNo);
    }

}
