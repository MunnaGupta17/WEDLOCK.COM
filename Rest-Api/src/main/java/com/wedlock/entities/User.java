package com.wedlock.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String email;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Photo> photos;
    
    @Column(nullable = false)
    private String gender;
    
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    
    private String religion;
    
    private String caste;
    
    @Column(name = "marital_status")
    private String maritalStatus;
    
    private String education;
    
    private String profession;
    
    private String location;
    
    @ElementCollection
    private List<Integer> RequestedProfiles; // will save the user id's of user to who i have send my profile
    
    @Column(name = "about_me")
    private String aboutMe;
    
    @Column(name = "partner_preferences")
    private String partnerPreferences;
    
    @OneToMany(mappedBy = "user")
    private List<Interest> interestedProfiles;
    
    @Column(name = "profile_picture")
    private String profilePicture;

}
