package com.teamProject.syusyu.service.cs.impl;

import com.teamProject.syusyu.dao.cs.InqryDAO;
import com.teamProject.syusyu.domain.cs.InqryDTO;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.service.cs.InqryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
public class InqryServiceImpl implements InqryService {

    @Autowired
    InqryDAO inqryDAO;

    @Autowired
    public InqryServiceImpl(InqryDAO InqryDAO) {
        this.inqryDAO = InqryDAO;
    }

    @Override
    public int getCount() throws Exception {
        return inqryDAO.count();
    }

    @Override
    public int remove(Integer inqry_no, String regrId) throws Exception {
        System.out.println("inqry_no = " + inqry_no);
        System.out.println("regrId = " + regrId);
        return inqryDAO.delete(inqry_no, regrId);
    }

    @Override
    public int write(InqryDTO inqryDTO) throws Exception {
        return inqryDAO.insert(inqryDTO);
    }

    @Override
    public List<InqryDTO> getList() throws Exception {
        return null;
    }

    @Override
    public InqryDTO read(Integer inqryNo) throws Exception {
        InqryDTO inqryDTO = inqryDAO.select(inqryNo);

        return inqryDTO;
    }


    @Override
    public List<InqryDTO> getPage(Map map) throws Exception {
        return inqryDAO.selectPage(map);
    }

    @Override
    public int modify(InqryDTO inqryDTO) throws Exception {
        return inqryDAO.update(inqryDTO);
    }

    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return 0;
    }

    @Override
    public List<InqryDTO> getSearchResultPage(SearchCondition sc) throws Exception {
        return null;
    }
}
