package com.douzone.pingpong.controller;

import com.douzone.pingpong.domain.member.Member;
import com.douzone.pingpong.web.SessionConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
<<<<<<< HEAD
		// git TEST...
        // git TEST2 ...33333  권한READ일때
        //wonnnnn2222222222
        //wonnnn
<<<<<<< HEAD
=======

>>>>>>> ad265011e49f3d529c3e6653035ebfc1cfea7366
=======


        //won222222222
>>>>>>> won
        return "home";
        // JIN #1.
        // JIN #2.

        // pull을 안당기고 수정
        // branch 안바꾸고 수정
        // branch 바꾸고 수정
        // 하에서 메인으로 체크아웃 다시수정
    }

}


