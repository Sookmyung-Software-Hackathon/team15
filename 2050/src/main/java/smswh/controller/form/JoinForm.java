package smswh.controller.form;

import lombok.Getter;
import lombok.Setter;
import smswh.domain.Gender;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class JoinForm {

    @NotEmpty(message = "사용하실 id는 필수 입력 항목입니다.")
    private String loginId;

    @NotEmpty(message = "사용하실 비밀번호는 필수 입력 항목입니다.")
    private String password;

    private String name;

    @NotEmpty(message = "나이는 필수 입력 항목입니다.")
    private int age;

    private Gender gender;

    @NotEmpty(message = "사용하실 닉네임은 필수 입력 항목입니다.")
    private String nickName;

    private String email;

}
