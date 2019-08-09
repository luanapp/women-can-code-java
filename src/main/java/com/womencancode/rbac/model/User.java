package com.womencancode.rbac.model;

import com.mongodb.lang.NonNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseModel {

    private String name;
    private String lastName;

    @NonNull
    private String username;

    @NonNull
    private String email;
    private LocalDate birthDate;

    @DBRef
    private Role role;

    @Builder
    public User(String id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, String name,
                String lastName, String username, String email, LocalDate birthDate, Role role) {
        super(id, createdDate, lastModifiedDate);
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.birthDate = birthDate;
        this.role = role;
    }
}
