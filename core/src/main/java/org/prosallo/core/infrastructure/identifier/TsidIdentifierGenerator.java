package org.prosallo.core.infrastructure.identifier;

import com.github.f4b6a3.tsid.TsidCreator;
import org.prosallo.core.domain.IdentifierGenerator;
import org.springframework.stereotype.Component;

@Component
public class TsidIdentifierGenerator implements IdentifierGenerator<Long> {

    @Override
    public Long generate() {
        return TsidCreator.getTsid().toLong();
    }
}
