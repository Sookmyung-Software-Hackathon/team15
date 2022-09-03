package smswh.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import smswh.controller.form.JoinForm;
import smswh.controller.form.LoginForm;
import smswh.web.SessionConst;
import smswh.domain.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

//    @GetMapping("/")
//    public String homeLogin(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
//        if(loginMember == null) {
//            return "main";
//        }
//
//        model.addAttribute("member", loginMember);
//        return "main";
//    }

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        // HttpServletRequest의 객체로부터 호출한 메소드와 관련된 데이터를 서버에서 클라이언트에게 전달해 주나봐.
        // 여기서는 .getSession()을 호출했으니까 세션 정보가 반환된 거지.
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
