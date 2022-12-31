package ru.job4j.pojo;

import java.util.Date;
import java.util.Objects;

public class License {

    private String owner;
    private String model;
    private String code;
    private Date created;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        License license = (License) obj;
        return Objects.equals(this.code, license.code)
                && Objects.equals(this.model, license.model)
                && Objects.equals(this.owner, license.owner)
                && Objects.equals(this.created, license.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, model, owner, created);
    }
}
