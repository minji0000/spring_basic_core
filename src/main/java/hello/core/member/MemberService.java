package hello.core.member;

// 회원가입과 조회 기능을 하는 서비스
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
