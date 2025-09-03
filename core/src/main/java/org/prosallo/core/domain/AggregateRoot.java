package org.prosallo.core.domain;

import lombok.Getter;
import lombok.Setter;

public abstract class AggregateRoot {

    @Getter
    @Setter
    private Long id;
}
