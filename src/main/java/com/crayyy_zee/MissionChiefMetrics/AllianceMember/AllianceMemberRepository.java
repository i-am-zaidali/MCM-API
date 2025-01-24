package com.crayyy_zee.MissionChiefMetrics.AllianceMember;

import com.crayyy_zee.MissionChiefMetrics.AllianceMember.Models.AllianceMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllianceMemberRepository extends JpaRepository<AllianceMember, Integer> {
    Page<AllianceMember> findAllByAllianceId(Integer input, Pageable page);

    Integer countAllByAllianceId(Integer input);


}
