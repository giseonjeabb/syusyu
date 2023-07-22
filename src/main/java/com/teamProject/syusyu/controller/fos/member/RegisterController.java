package com.teamProject.syusyu.controller.fos.member;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.member.MemberDTO;
import com.teamProject.syusyu.domain.member.MemberValidator;
import com.teamProject.syusyu.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    MemberService memberService;

    @InitBinder
    public void toDate(WebDataBinder binder) {
        // UserValidator를 생성해서 WebDataBinder에 등록
        binder.setValidator(new MemberValidator()); // UserValidator를 WebDataBinder의 로컬 validator(현재 컨트롤러 내에서만 사용 가능)로 등록
        List<Validator> validatorList = binder.getValidators(); // validator 등록된 거 확인
        System.out.println("validatorList = " + validatorList);
    }

    @GetMapping("/add")
    public String registerForm() {
        return ViewPath.FOS_MEMBER + "registerForm";
    }

    /*
    * 회원가입
    * 메서드명 : register
    * 매개변수 :
    * 반환타입 :
    * */
    @PostMapping("/add")
    @ResponseBody
    public String register(@RequestBody MemberDTO memberDTO) {
        try {
            boolean result = memberService.register(memberDTO);

            if (!result)
                throw new Exception("register failed");

            return "success";

        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
