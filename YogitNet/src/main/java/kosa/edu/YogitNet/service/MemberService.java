package kosa.edu.YogitNet.service;

import kosa.edu.YogitNet.dto.MemberLoginReqDto;
import kosa.edu.YogitNet.dto.MemberSignupReqDto;
import kosa.edu.YogitNet.dto.TokenDto;

public interface MemberService {

    MemberSignupReqDto signupMember(MemberSignupReqDto memberSignupReqDto);

    TokenDto login(MemberLoginReqDto memberLoginReqDto);

}
