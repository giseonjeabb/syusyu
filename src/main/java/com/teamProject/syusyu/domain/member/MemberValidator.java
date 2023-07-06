package com.teamProject.syusyu.domain.member;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator {
    @Override
    // 이 검증기로 검증 가능한 객체인지 알려주는 메서드
    public boolean supports(Class<?> aClass) {
        return MemberDTO.class.equals(aClass);
    }

    @Override
    // 객체를 검증하는 메서드 - target : 검증할 객체, errors : 검증 시 발생한 에러 저장소
    public void validate(Object target, Errors errors) {
        System.out.println("MemberDTOValidator.validate() is called");
        MemberDTO memberDTO = (MemberDTO) target;
        String id = memberDTO.getLginId();

        // MemberDTO객체를 검증한다는 건 이런 것. id가 null인지, 빈문자열인지 검증
        if (id == null || "".equals(id.trim())) {
            errors.rejectValue("id", "required"); // 필수 값인데 저장 안 했다고 에러를 저장
        }
        // 비어있거나 공백 or 탭인 경우 errors 객체에 필드 이름은 id, 에러코드는 required로 해서 저장해라.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");

        if (id == null || id.length() < 5 || id.length() > 12) {
            errors.rejectValue("id", "invalidLength", new String[]{"5", "12"}, null);
        }
    }
}
