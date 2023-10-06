package kosa.edu.YogitNet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSignupReqDto {

    private String email;
    private String nickname;
    private String password;
    private String phoneNumber;

}
