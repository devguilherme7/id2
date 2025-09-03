package org.prosallo.core.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.Optional;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AbstractAuditableEntity extends AbstractPersistableEntity
        implements Auditable<String, Long, LocalDateTime> {

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    @NonNull
    public Optional<String> getCreatedBy() {
        return Optional.ofNullable(createdBy);
    }

    @Override
    public void setCreatedBy(@NonNull String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    @NonNull
    public Optional<LocalDateTime> getCreatedDate() {
        return Optional.ofNullable(createdAt);
    }

    @Override
    public void setCreatedDate(@NonNull LocalDateTime creationDate) {
        this.createdAt = creationDate;
    }

    @Override
    @NonNull
    public Optional<String> getLastModifiedBy() {
        return Optional.ofNullable(updatedBy);
    }

    @Override
    public void setLastModifiedBy(@NonNull String lastModifiedBy) {
        this.updatedBy = lastModifiedBy;
    }

    @Override
    @NonNull
    public Optional<LocalDateTime> getLastModifiedDate() {
        return Optional.ofNullable(updatedAt);
    }

    @Override
    public void setLastModifiedDate(@NonNull LocalDateTime lastModifiedDate) {
        this.updatedAt = lastModifiedDate;
    }
}
