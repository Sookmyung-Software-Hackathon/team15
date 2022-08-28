package smswh.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter
public class FreeWriting {

    @Id @GeneratedValue
    private Long Id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    private String context;

    private LocalDateTime dateTime;

    private int agreement; // 공감 수

}
