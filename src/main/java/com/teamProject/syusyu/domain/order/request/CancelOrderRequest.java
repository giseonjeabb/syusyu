package com.teamProject.syusyu.domain.order.request;

import com.teamProject.syusyu.domain.order.OrdClaimDTO;

import java.util.List;

/**
 * 주문 취소 요청 정보를 담는 래퍼 클래스.
 * 주문 취소 서비스에서 요구하는 입력 값들을 필드로 가지고 있다.
 * 이 클래스의 인스턴스는 주문 취소 요청의 본문으로 사용되며, 각 필드는 JSON 키로 매핑된다.
 *
 * @author min
 * @since 2023/07/30
 */
public class CancelOrderRequest {
    private OrdClaimDTO ordClaimDTO; // 주문 클레임 DTO(주문취소에 관련된 정보들을 담고 있다.)Jjkkkk
    private List<Integer> ordDtlNoList; // 주문취소할 주문상세번호 리스트

    public OrdClaimDTO getOrdClaimDTO() {
        return ordClaimDTO;
    }

    public void setOrdClaimDTO(OrdClaimDTO ordClaimDTO) {
        this.ordClaimDTO = ordClaimDTO;
    }

    public List<Integer> getOrdDtlNoList() {
        return ordDtlNoList;
    }

    public void setOrdDtlNoList(List<Integer> ordDtlNoList) {
        this.ordDtlNoList = ordDtlNoList;
    }

    @Override
    public String toString() {
        return "CancelOrderRequest{" +
                "ordClaimDTO=" + ordClaimDTO +
                ", ordDtlNoList=" + ordDtlNoList +
                '}';
    }
}
