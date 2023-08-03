package com.teamProject.syusyu.service.fos.cs.impl;

import com.teamProject.syusyu.dao.cs.NoticeDAO;
import com.teamProject.syusyu.domain.cs.NoticeDTO;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.service.fos.cs.F_NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class F_NoticeServiceImpl implements F_NoticeService {

    // DAO 주입시 생성자로 주입 받기!!!
    NoticeDAO noticeDao;

    @Autowired
    public F_NoticeServiceImpl(NoticeDAO noticeDao) {
        this.noticeDao = noticeDao;
    }

    @Override
    public List<NoticeDTO> getSearchResultPage(SearchCondition sc) throws Exception {
        return noticeDao.searchSelectPage(sc);
    }

    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return noticeDao.searchResultCnt(sc);
    }


    @Override
    public int getCount() throws Exception {
        return noticeDao.count();
    }

    @Override
    public int remove(Integer notcNo) throws Exception {
        return noticeDao.delete(notcNo);
    }

    @Override
    public int write(NoticeDTO noticeDTO) throws Exception {
        return noticeDao.insert(noticeDTO);
    }

    @Override
    public List<NoticeDTO> getList() throws Exception {
        System.out.println("NoticeServiceImpl.getList");
        return noticeDao.selectAll();

    }

    @Override
    public NoticeDTO read(Integer notcNo) throws Exception {
        NoticeDTO noticeDto = noticeDao.select(notcNo);
        noticeDao.increaseViewCnt(notcNo);

        return noticeDto;
    }


    @Override
    public List<NoticeDTO> getPage(Map map) throws Exception {
        return noticeDao.selectPage(map);
    }

    @Override
    public int modify(NoticeDTO noticeDTO) throws Exception {
        return noticeDao.update(noticeDTO);
    }

    @Override
    public NoticeDTO getPrevTitle(Integer notcNo) throws Exception {
        return noticeDao.selectPrev(notcNo);
    }

    public NoticeDTO getNextTitle(Integer notcNo) throws Exception {
        return noticeDao.selectNext(notcNo);
    }
}
