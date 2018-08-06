package com.java.entity;

import java.util.Objects;

public class Skill {
    private int skillId;
    private String skillcategory;
    private String skill;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillcategory() {
        return skillcategory;
    }

    public void setSkillcategory(String skillcategory) {
        this.skillcategory = skillcategory;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill that = (Skill) o;
        return skillId == that.skillId &&
                Objects.equals(skillcategory, that.skillcategory) &&
                Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {

        return Objects.hash(skillId, skillcategory, skill);
    }
}
