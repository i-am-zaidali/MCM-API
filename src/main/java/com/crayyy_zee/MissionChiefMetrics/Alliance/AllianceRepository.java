package com.crayyy_zee.MissionChiefMetrics.Alliance;

import com.crayyy_zee.MissionChiefMetrics.Alliance.Models.Alliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllianceRepository extends JpaRepository<Alliance, Integer> {
}
