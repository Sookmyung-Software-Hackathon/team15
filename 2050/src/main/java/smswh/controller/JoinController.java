package smswh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import smswh.controller.form.JoinForm;
import smswh.domain.Member;
import smswh.repository.MemberRepository;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final MemberRepository memberRepository;

    @GetMapping("/join2050")
    private String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join2050")
    private String join(Model model) {
        Model newAccountModel = model.addAttribute("joinForm", new JoinForm());

        Member newMember = Member.createMember();
        return "redirect:/";
    }

}
