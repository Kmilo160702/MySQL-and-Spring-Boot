package com.corte2.taller1.DAO;

import com.corte2.taller1.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<Profile, Long> {
    Profile findById(long Id);

    Profile findByEmail(String email);

    Profile findByNickname(String nickname);

    Profile findByOuth0IdIs(String Outh0Id);

}
