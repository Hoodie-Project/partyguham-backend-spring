package com.partyguham.admin.version;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "version")
@Getter
@Setter
@NoArgsConstructor
public class VersionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String platform; // 'android', 'ios' 등

    @Column(name = "latest_version", length = 20, nullable = false)
    private String latestVersion; // 최신 버전

    @Column(name = "min_required_version", length = 20)
    private String minRequiredVersion; // 최소 필수 버전

    @Column(name = "release_notes", columnDefinition = "TEXT")
    private String releaseNotes; // 릴리즈 노트

    @Column(name = "is_force_update", nullable = false)
    private Boolean isForceUpdate = false; // 강제 업데이트 여부

    @Column(name = "download_url", length = 255)
    private String downloadUrl; // 앱 다운로드 URL
}