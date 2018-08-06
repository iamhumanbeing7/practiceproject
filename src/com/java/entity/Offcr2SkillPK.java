package com.java.entity;

import java.io.Serializable;
import java.util.Objects;

public class Offcr2SkillPK implements Serializable {
    private String offcrId;
    private int skillId;

    public String getOffcrId() {
        return offcrId;
    }

    public void setOffcrId(String offcrId) {
        this.offcrId = offcrId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offcr2SkillPK that = (Offcr2SkillPK) o;
        return skillId == that.skillId &&
                Objects.equals(offcrId, that.offcrId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(offcrId, skillId);
    }
}
