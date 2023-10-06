package kosa.edu.YogitNet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nickname;
    private String password;
    private String phoneNumber;
    private int reward;
    private int lostCount;
    private int findCount;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<LostItem> lostItemList;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<FindItem> findItemList;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberChatting> memberChattingList;

    @CreatedDate
    private Timestamp createDate;
    @LastModifiedDate
    private Timestamp modifiedDate;

}
