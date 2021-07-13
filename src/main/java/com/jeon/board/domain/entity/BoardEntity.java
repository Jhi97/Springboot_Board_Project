package com.jeon.board.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;

@Getter // 모든 필드에 getter를 자동으로 생성해주는 어노테이션
@Entity // 객체를 테이블과 매핑할 엔티티라고 JPA에 알려주는 역할 (엔티티 매핑), @Entity가 붙은 클래스는 JPA가 관리, 엔티티 클래스라 부름
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터가 없는 생성자를 추가하는 어노테이션
@Table(name = "board") // 엔티티 클래스와 매핑되는 테이블 정보를 명시하는 어노테이션, 생략 시 Entity 이름이 자동 매핑
public class BoardEntity extends TimeEntity{

    @Id // 테이블의 기본 키임을 명시하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키로 대체키를 사용할 때, 기본키 값 생성 전략을 명시
    private Long id;

    @Column(length = 10, nullable = false) // 컬럼 매핑
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder // 빌더 패턴 클래스를 생성해주는 어노테이션 유사 @Setter
    public BoardEntity(Long id, String writer, String title, String content) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
