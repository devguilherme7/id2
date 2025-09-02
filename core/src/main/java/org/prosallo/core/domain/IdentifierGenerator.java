package org.prosallo.core.domain;

import java.io.Serializable;

public interface IdentifierGenerator<T extends Serializable> {

    T generate();
}
