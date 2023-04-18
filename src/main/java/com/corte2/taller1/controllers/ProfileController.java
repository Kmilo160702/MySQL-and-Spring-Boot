package com.corte2.taller1.controllers;

import com.corte2.taller1.models.Profile;
import com.corte2.taller1.services.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("profile")
public class ProfileController {

    ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    public List<Profile> getAllProfile() {
        return this.profileService.getAllProfileS();
    }

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable("id") long id) {
        return this.profileService.getProfileS(id);
    }

    public Profile getProfileByOuth0Id(String Outh0Id) {
        return this.profileService.getProfileByOuth0IdIs(Outh0Id);
    }

    public Profile createProfile(@RequestBody Profile profile) {
        return this.profileService.createProfileS(profile);
    }

    @PatchMapping("/{id}")
    public Boolean updateProfile(@PathVariable("id") long id, @RequestBody Profile profile) {
        Profile e1 = this.profileService.getProfileS(id);
        if (e1 != null) {
            try {
                return this.profileService.updateProfileS(profile);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean deleteProfile(@PathVariable("id") long id) {
        return this.profileService.deleteProfileS(id);
    }

    public Profile getOrCreateProfile(Map<String, Object> userData) {
        return this.profileService.getOrCreateProfileS(userData);
    }
}
