package com.douzone.pingpong.controller.api.dto.member;

import com.douzone.pingpong.domain.member.MemberStatus;
import lombok.Data;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UpdateMemberRequest {
    private String name;
    private MultipartFile avatar;
    private MemberStatus status;

}
