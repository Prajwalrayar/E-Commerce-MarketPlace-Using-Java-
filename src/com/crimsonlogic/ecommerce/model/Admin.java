package com.crimsonlogic.ecommerce.model;

import com.crimsonlogic.ecommerce.enums.UserRole;
import com.crimsonlogic.ecommerce.model.abstractclass.User;

import java.time.LocalDate;
import java.util.Objects;

public class Admin extends User {

    private UserRole role;

    public Admin() {
    }

    public Admin(int userId,
                 String name,
                 String email,
                 String phoneNumber,
                 String address,
                 LocalDate registrationDate,
                 String password,
                 UserRole role) {

        super(userId, name, email, phoneNumber, address, registrationDate, password);
        this.role = role;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = UserRole.valueOf(role);
    }

    @Override
    public String toString() {

        return "\n========== ADMIN ==========\n" +
                super.toString() +
                "\nRole : " + role +
                "\n===========================";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Admin))
            return false;

        Admin admin = (Admin) obj;

        return getUserId() == admin.getUserId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }
}
