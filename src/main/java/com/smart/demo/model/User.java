package com.smart.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sec_user",uniqueConstraints= {@UniqueConstraint(name = User.UNIC_USER_NAME,columnNames={"userName"})})
public class User {
    public final static String UNIC_USER_NAME =  "uniq_userSEC";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username")
    public String userName;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "f_user_role", nullable = false, foreignKey = @ForeignKey(name = "fk_user2role"))
    private Role role;

    @Setter(AccessLevel.NONE)
    @Column(name = "f_user_role", nullable = false, insertable = false, updatable = false)
    private Long roleId;
}
