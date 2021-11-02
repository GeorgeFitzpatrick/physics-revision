package com.georgefitzpatrick.revision.physics.data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public AbstractEntity() {

    }

    public AbstractEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPersisted() {
        return id != null;
    }

    @Override
    public int hashCode() {
        if (id != null)
            return id.hashCode();

        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractEntity))
            return false;

        AbstractEntity that = (AbstractEntity) obj;
        if (this.id != null)
            return this.id.equals(that.id);

        return super.equals(that);
    }

}