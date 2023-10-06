package kosa.edu.YogitNet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class FindItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fCategory;
    private Timestamp fDate;
    private String fLocation;
    private String fName;
    private String fPhotoLoc;
    @Column(length = 255)
    private String fContent;
    private short fStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private Member member;

    @CreatedDate
    private Timestamp createDate;
    @LastModifiedDate
    private Timestamp modifiedDate;
}
