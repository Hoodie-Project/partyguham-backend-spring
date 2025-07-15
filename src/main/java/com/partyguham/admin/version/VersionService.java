package com.partyguham.admin.version;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VersionService {

    private final VersionRepository versionRepository;

    public VersionEntity create(VersionEntity version) {
        return versionRepository.save(version);
    }

    public Page<VersionEntity> getAll(Pageable pageable) {
        return versionRepository.findAll(pageable);
    }

    public Optional<VersionEntity> getById(Long id) {
        return versionRepository.findById(id);
    }

    public VersionEntity update(Long id, VersionEntity updated) {
        VersionEntity version = versionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 버전이 존재하지 않습니다: " + id));
        version.setPlatform(updated.getPlatform());
        version.setLatestVersion(updated.getLatestVersion());
        version.setMinRequiredVersion(updated.getMinRequiredVersion());
        version.setReleaseNotes(updated.getReleaseNotes());
        version.setIsForceUpdate(updated.getIsForceUpdate());
        version.setDownloadUrl(updated.getDownloadUrl());
        return versionRepository.save(version);
    }

    public void delete(Long id) {
        versionRepository.deleteById(id);
    }
}