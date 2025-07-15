package com.partyguham.admin.version;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<VersionEntity, Long> {
}