package taewan.SBadmin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import taewan.SBadmin.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member save(Member member);
    void deleteByMemberId(Long memberId);
    Slice<Member> findSliceBy(Pageable pageable);
    Member findMemberByMemberId(long memberId);
    long count();
}
