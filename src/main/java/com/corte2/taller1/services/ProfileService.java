package com.corte2.taller1.services;

import com.corte2.taller1.DAO.IProfileRepository;
import com.corte2.taller1.models.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProfileService implements IProfileService {

    IProfileRepository profileRepository;

    public ProfileService(IProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAllProfileS() {
        return this.profileRepository.findAll();
    }

    @Override
    public Profile getProfileS(long id) {
        return this.profileRepository.findById(id);
    }

    @Override
    public Profile createProfileS(Profile profile) {
        return this.profileRepository.save(profile);
    }

    @Override
    public Boolean updateProfileS(Profile profile) {
        try {
            this.profileRepository.save(profile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean deleteProfileS(long id) {
        try {
            this.profileRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Profile getProfileByOuth0IdIs(String Outh0Id) {
        return this.profileRepository.findByOuth0IdIs(Outh0Id);
    }

    @Override
    public Profile getProfileByEmailS(String email) {
        return this.profileRepository.findByEmail(email);
    }

    public Profile getOrCreateProfileS(Map<String, Object> userData) {
        String email = (String) userData.get("email");
        Profile user = getProfileByEmailS(email);

        if (user == null) {
            String name = (String) userData.get("name");
            String nickname = (String) userData.get("nickname");
            String email1 = (String) userData.get("email");

            Profile newUser = new Profile(name, nickname, email1);
            return createProfileS(newUser);

        }

        return user;
    }
}
