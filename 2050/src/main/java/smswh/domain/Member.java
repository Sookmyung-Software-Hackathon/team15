package smswh.domain;

import lombok.*;
import smswh.account.config.Role;
import smswh.domain.activity.Activity;
import smswh.repository.MemberRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Member {

    private final MemberRepository memberRepository;

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long Id;

    private String loginId;

    private String password;

    @Column(name = "name")
    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Generation generation;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;

    private String nickName;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

//    private List<FreeWriting> myFreeWritings = new ArrayList<>(); 작성 게시글 목록

    @OneToMany(mappedBy = "uploader")
    private List<Activity> uploadActivities = new ArrayList<>();

    @OneToMany
    private List<Activity> appliedActivities = new ArrayList<>();

    public static Member createMember() {

    }

}
