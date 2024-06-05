package com.manbo.homepage.dto;

import com.manbo.homepage.entity.Member;
import com.manbo.homepage.entity.MemberPreference;
import com.manbo.homepage.entity.Trail;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberPreferenceDTO {

    private Long preferenceId;
    private Member member;
    private Trail trailId;

    public static MemberPreferenceDTO toSaveDTO(MemberPreference memberPreference) {
        MemberPreferenceDTO memberPreferenceDTO = MemberPreferenceDTO.builder()
                .member(memberPreference.getMember())
                .trailId(memberPreference.getTrailId())
                .build();
        
        return memberPreferenceDTO;
    }
}
