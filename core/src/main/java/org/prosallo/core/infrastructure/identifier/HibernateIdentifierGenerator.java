package org.prosallo.core.infrastructure.identifier;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.prosallo.core.domain.IdentifierGenerator;

public class HibernateIdentifierGenerator implements org.hibernate.id.IdentifierGenerator {

    private final IdentifierGenerator<Long> identifierGenerator = new TsidIdentifierGenerator();

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        return identifierGenerator.generate();
    }
}
