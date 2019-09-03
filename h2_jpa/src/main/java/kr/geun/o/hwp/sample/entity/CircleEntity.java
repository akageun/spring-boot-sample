package kr.geun.o.hwp.sample.entity;

import kr.geun.o.hwp.sample.type.ColorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * CircleEntity
 *
 * @author akageun
 * @since 2019-09-03
 */
@Getter
@Entity
@Table(name = "circle")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CircleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ColorType colorType;

    private int size;

}
