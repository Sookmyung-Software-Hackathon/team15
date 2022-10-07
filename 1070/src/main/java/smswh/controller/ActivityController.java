package smswh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import smswh.domain.Member;
import smswh.domain.activity.Activity;
import smswh.repository.ActivityRepository;
import smswh.web.ScriptUtils;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static smswh.web.ScriptUtils.alertAndMovePage;
import static smswh.web.SessionConst.*;
import static smswh.domain.activity.ActivityStatus.SCHEDULED;

@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping(method = RequestMethod.POST)
public class ActivityController {

    private final ActivityRepository activityRepository;

    @GetMapping("/activitylist")
    public String list() {
        return "activityList";
    }


    @GetMapping("/post")
    public String post() {
        return "newActivity.html";
    }

    @PostMapping("/activities/new")
    public String create(@SessionAttribute(name = LOGIN_MEMBER, required = false) Member loginMember, ActivityForm form, HttpServletResponse response ) throws IOException {
        if(loginMember == null) {
            alertAndMovePage(response, "글을 작성하시려면 먼저 로그인해주세요.", "/login");
            return null;
        }

        Activity activity = new Activity();
        activity.setTitle(form.getTitle());
        activity.setExplanation(form.getExplanation());

        return "activityList";

    }

    @PostMapping ("deleteActivity.html") // activityInfo에서 삭제 버튼 클릭하면 여기로 링크.
    public String delete(@SessionAttribute(name = LOGIN_MEMBER, required = false) Member loginMember, Activity activity, HttpServletResponse response) throws IOException {
        // 글을 삭제하려는 사람과 작성자가 같아야 삭제가 가능함...
        if(loginMember != activity.getUploader()) {
            ScriptUtils.alertAndBackPage(response, "작성자만 삭제 가능합니다.");
        }
        activityRepository.remove(activity);
        return "/activitylist";
    }

    @PostMapping("acceptApply.html") // 신청 버튼 누르면 여기로 이동함
    public String applyActivity(@SessionAttribute(name = LOGIN_MEMBER, required = false) Member loginMember, Activity activity, HttpServletResponse response) throws IOException {

        // 이미 신청한 회원인 경우
        if(activity.getApplyMembers().contains(loginMember))    ScriptUtils.alertAndBackPage(response, "이미 신청하셨습니다.");
        // 인원이 초과된 경우
        if(activity.getStatus().equals(SCHEDULED))  ScriptUtils.alertAndBackPage(response, "신청 가능 인원이 초과되었습니다.");

        activityRepository.add(activity, loginMember);

        return "/activitylist";
    }

    @PostMapping

}
