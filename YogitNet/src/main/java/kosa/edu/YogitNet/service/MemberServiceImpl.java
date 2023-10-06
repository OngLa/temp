package kosa.edu.YogitNet.service;

import kosa.edu.YogitNet.dto.MemberLoginReqDto;
import kosa.edu.YogitNet.dto.MemberSignupReqDto;
import kosa.edu.YogitNet.dto.TokenDto;
import kosa.edu.YogitNet.entity.Member;
import kosa.edu.YogitNet.exception.CustomException;
import kosa.edu.YogitNet.exception.ErrorCode;
import kosa.edu.YogitNet.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MemberSignupReqDto signupMember(MemberSignupReqDto memberSignupReqDto) {

        if(memberRepository.existsByEmail(memberSignupReqDto.getEmail())) {
           throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
        }

        String encodedPassword = passwordEncoder.encode(memberSignupReqDto.getPassword());

        Member member = Member.builder()
                .email(memberSignupReqDto.getEmail())
                .password(encodedPassword)
                .nickname(memberSignupReqDto.getNickname())
                .phoneNumber(memberSignupReqDto.getPhoneNumber())
                .build();

        memberRepository.save(member);

        return memberSignupReqDto;
    }

    @Override
    public TokenDto login(MemberLoginReqDto memberLoginReqDto) {

        Member member = memberRepository.findByEmail(memberLoginReqDto.getEmail())
                .orElseThrow(
                        () -> {
                            throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
                        }
                );

        if(!passwordEncoder.matches(memberLoginReqDto.getPassword(), member.getPassword())) {
            throw new CustomException(ErrorCode.WRONG_PASSWORD);
        }

        return null;
    }
}
