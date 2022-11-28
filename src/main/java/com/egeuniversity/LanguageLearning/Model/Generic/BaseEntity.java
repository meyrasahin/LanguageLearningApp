package com.egeuniversity.LanguageLearning.Model.Generic;

import org.hibernate.Hibernate;

import java.io.Serializable;

public abstract class BaseEntity<K extends Serializable & Comparable<K>, E extends BaseEntity<K, ?>> implements Serializable, Cloneable, Comparable<E> {
    public abstract K getId();

    public abstract void setId(K id);

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }

        if (Hibernate.getClass(object) != Hibernate.getClass(this)) {
            return false;
        }

        BaseEntity<K, E> entity = (BaseEntity<K, E>) object;
        K id = getId();

        if (id == null) {
            return false;
        }

        return id.equals(entity.getId());
    }

    public int compareTo(E o) {
        if (this == o) {
            return 0;
        }
        return this.getId().compareTo(o.getId());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("entity.");
        builder.append(Hibernate.getClass(this).getSimpleName());
        builder.append("<");
        builder.append(getId());
        builder.append("-");
        builder.append(super.toString());
        builder.append(">");

        return builder.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

}
