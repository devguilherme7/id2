package org.prosallo.core.domain;


public abstract class AggregateRoot {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
