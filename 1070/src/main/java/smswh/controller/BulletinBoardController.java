package smswh.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import smswh.domain.FreeWriting;
import smswh.domain.Member;
import smswh.web.ScriptUtils;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static smswh.web.SessionConst.LOGIN_MEMBER;

@Controller
@Getter
public class BulletinBoardController {
    @RequestMapping(value = "newWriting.html", method = RequestMethod.POST)
    public String uploadWriting(@SessionAttribute(name = LOGIN_MEMBER) Member loginMember, FreeWriting freeWriting, HttpServletResponse response) throws IOException {
        if(loginMember == null) {
            ScriptUtils.alertAndMovePage(response, "글을 작성하려면 로그인이 필요합니다.", "");

        }
    }



}
