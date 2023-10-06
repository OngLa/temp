package kosa.edu.YogitNet.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kosa.edu.YogitNet.dto.MemberSignupReqDto;
import kosa.edu.YogitNet.exception.ErrorResponse;
import kosa.edu.YogitNet.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원 가입 API", description = "입력된 정보로 회원가입 진행")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = MemberSignupReqDto.class))),
            @ApiResponse(responseCode = "409", description = "데이터가 이미 존재합니다", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PostMapping("/signup")
    public ResponseEntity<MemberSignupReqDto> signup(@RequestBody MemberSignupReqDto memberSignupReqDto) {
        memberService.signupMember(memberSignupReqDto);
        return new ResponseEntity<>(memberSignupReqDto, HttpStatus.OK);
    }

}
