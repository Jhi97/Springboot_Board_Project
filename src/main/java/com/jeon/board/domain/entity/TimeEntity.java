package com.jeon.board.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 테이블로 매핑하지 않고, 자식클래스에게 매핑 정보를 상속하기 위한 어노테이션
@EntityListeners(AuditingEntityListener.class) // JPA에게 Entity는 시간값을 자동으로 넣어주는 Auditing 기능을 사용한다는 것을 알림
public abstract class TimeEntity {
    @CreatedDate // Entity가 처음 저장될 때 생성일을 주입하는 어노테이션
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate // Entity가 수정될 때 수정 일자를 주입하는 어노테이션
    private LocalDateTime modifiedDate;
}
