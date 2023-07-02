package com.teamProject.syusyu.service.cs.impl;

import com.teamProject.syusyu.dao.cs.impl.NoticeDao;
import com.teamProject.syusyu.domain.cs.NoticeDto;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.service.cs.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    NoticeDao noticeDao;

    @Autowired
    public NoticeServiceImpl(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    @Override
    public List<NoticeDto> getSearchResultPage(SearchCondition sc)throws Exception{
        return noticeDao.searchSelectPage(sc);
    }

    @Override
    public int getSearchResultCnt(SearchCondition sc)throws Exception{
        return noticeDao.searchResultCnt(sc);
    }


    @Override
    public int getCount() throws Exception {
        return noticeDao.count();
    }

    @Override
    public int remove(Integer notcNo, String writer) throws Exception {
        return noticeDao.delete(notcNo, writer);
    }

    @Override
    public int write(NoticeDto noticeDto) throws Exception {
        return noticeDao.insert(noticeDto);
    }

    @Override
    public List<NoticeDto> getList() throws Exception {
        System.out.println("NoticeServiceImpl.getList");
        return noticeDao.selectAll();

          }

    @Override
    public NoticeDto read(Integer notcNo) throws Exception {
        NoticeDto noticeDto = noticeDao.select(notcNo);
        noticeDao.increaseViewCnt(notcNo);

        return noticeDto;
    }


    @Override
    public List<NoticeDto> getPage(Map map) throws Exception {
        return noticeDao.selectPage(map);
    }

    @Override
    public int modify(NoticeDto noticeDto) throws Exception {
        return noticeDao.update(noticeDto);
    }

    @Override
   public NoticeDto getPrevTitle(Integer notcNo)throws Exception{
        return noticeDao.selectPrev(notcNo);
    }

    public NoticeDto getNextTitle(Integer notcNo)throws Exception{
        return noticeDao.selectNext(notcNo);
    }
}
