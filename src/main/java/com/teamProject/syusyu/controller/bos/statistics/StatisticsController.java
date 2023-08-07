package com.teamProject.syusyu.controller.bos.statistics;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.service.bos.statistics.StatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(ViewPath.BOS)
public class StatisticsController {
    private final StatisticsService service;

    public StatisticsController(StatisticsService service) {
        this.service = service;
    }

    /**
     * 관리자 메인 대시보드에 보여줄 통계 데이터를 조회한다.
     *
     * @return ResponseEntity, 대시보드 통계 데이터와 HTTP 응답 상태를 포함
     * @author min
     * @since 2023/08/06
     */
    @ResponseBody
    @GetMapping("dashboard/statistics")
    public ResponseEntity<Map<String, Object>> getDashBoardStatistics() {
        Map<String, Object> dashBoardStatistics = null;

        try {
            dashBoardStatistics = service.getDashBoardStatistics();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(dashBoardStatistics, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(dashBoardStatistics, HttpStatus.OK);
    }
}
