package smswh.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smswh.domain.FreeWriting;
import smswh.repository.FreeWritingRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinBoard {

    private final FreeWritingRepository freeWritingRepository;

    public void uploadNewWriting(FreeWriting freeWriting) {
        freeWritingRepository.save(freeWriting);
    }

    public void deleteWriting(FreeWriting freeWriting) {
        freeWritingRepository.delete(freeWriting);
    }

    // 검색
    // 수정
    // 내가 쓴 글만 보기



}
