package smswh.domain.activity;

import lombok.Getter;
import lombok.Setter;
import smswh.domain.Member;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

// 여행, 밥약, 취미 생활, 기타
@Entity
@Getter @Setter
public class Activity {

    @Id @GeneratedValue
    private Long Id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @Column(name = "uploader_id")
    private Member uploader;

    @Column(name = "teacher")
    private String teacher;

    @OneToMany
    private List<Member> applyMembers;

    @Min(2)
    @Column(name = "maxAppliers")
    private int maxAppliers;

    @Column(name = "createdDate")
    private LocalDateTime uploadDateTime;

    @NotNull
    @Column(name = "plannedDateTime")
    private Calendar plannedDateTime;

    @Column(name = "location")
    private String location;

    @NotNull
    @Column(name = "explanation")
    private String explanation;

    @Column(name = "status")
    private ActivityStatus status;

    public void setStatus(ActivityStatus status) {
        this.status = status;
    }

}
