package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.miit.goszakupki.models.Authority;
import ru.miit.goszakupki.models.Duty;
import ru.miit.goszakupki.models.Organization;
import ru.miit.goszakupki.models.Position;

import java.util.List;

@Schema(name = "Профиль пользователя")
public class UserDTO {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private String number;
    private String email;
    private String password;
    private String role;
    private Boolean isLegalEntity;
    private Organization organization;
    private Position position;
    private List<Duty> dutyList;
    private List<Authority> authorities;

    public UserDTO(Long id, String surname, String name, String patronymic, String number, String email, String password, String role, Boolean isLegalEntity, Organization organization, Position position, List<Duty> dutyList, List<Authority> authorities) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.number = number;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isLegalEntity = isLegalEntity;
        this.organization = organization;
        this.position = position;
        this.dutyList = dutyList;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getLegalEntity() {
        return isLegalEntity;
    }

    public void setLegalEntity(Boolean legalEntity) {
        isLegalEntity = legalEntity;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Duty> getDutyList() {
        return dutyList;
    }

    public void setDutyList(List<Duty> dutyList) {
        this.dutyList = dutyList;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
