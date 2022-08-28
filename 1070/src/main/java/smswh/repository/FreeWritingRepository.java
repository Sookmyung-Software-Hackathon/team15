package smswh.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import smswh.domain.FreeWriting;

import javax.persistence.EntityManager;

@Repository
@Getter
@RequiredArgsConstructor
public class FreeWritingRepository {

    private final EntityManager em;

    public void save(FreeWriting freeWriting) {
        em.persist(freeWriting);
    }

    public void delete(FreeWriting freeWriting) {
        em.remove(freeWriting);
    }

    public void update(FreeWriting freeWriting) {
        FreeWriting findWriting = em.find(FreeWriting.class, freeWriting.getId());

    }

    public FreeWriting findOne(Long id) {
        return em.find(FreeWriting.class, id);
    }
}
