package com.epam.valevach.final_project.entity;

import java.util.Objects;

public class Department {
    private String depName;
    private String depPosition;
    private int depId;

    public Department() {
    }

    public Department(String depName, String depPosition, int depId) {
        this.depName = depName;
        this.depPosition = depPosition;
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepPosition() {
        return depPosition;
    }

    public void setDepPosition(String depPosition) {
        this.depPosition = depPosition;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return depId == that.depId && depName.equals(that.depName) && depPosition.equals(that.depPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depName, depPosition, depId);
    }

    @Override
    public String toString() {
        return "Department{" +
                "depName='" + depName + '\'' +
                ", depPosition='" + depPosition + '\'' +
                ", depId=" + depId +
                '}';
    }
}
