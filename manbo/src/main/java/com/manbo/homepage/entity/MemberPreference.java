package com.manbo.homepage.entity;

import lombok.*;

import com.manbo.homepage.dto.MemberPreferenceDTO;

import jakarta.persistence.*;

@Entity
@Data
@Builder
@Table(name = "member_preference")
@NoArgsConstructor
@AllArgsConstructor
public class MemberPreference extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preference_id")
    private Long preferenceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mid", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trail_id", nullable = false)
    private Trail trailId;
    
    public static MemberPreference toSaveEntity(MemberPreferenceDTO memberPreferenceDTO) {
        return MemberPreference.builder()
                .member(memberPreferenceDTO.getMember())
                .trailId(memberPreferenceDTO.getTrailId())
                .build();
    }

    public static MemberPreference toUpdateEntity(MemberPreferenceDTO memberPreferenceDTO) {
        return MemberPreference.builder()
                .preferenceId(memberPreferenceDTO.getPreferenceId())
                .member(memberPreferenceDTO.getMember())
                .trailId(memberPreferenceDTO.getTrailId())
                .build();
    }
}
