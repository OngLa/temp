package kosa.edu.YogitNet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberLoginReqDto {

    private String email;
    private String password;

}
