package com.example.springsecuritycustom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Student")
public class Student implements UserDetails
{
    @Id
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private boolean isEnabled = true;
    private List<SimpleGrantedAuthority> simpleGrantedAuthorityList =
            new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return simpleGrantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void addAuthorityToUser(List<String> authorityList)
    {
        for(String authority : authorityList)
        {
            simpleGrantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" + authority));
        }
    }
}
