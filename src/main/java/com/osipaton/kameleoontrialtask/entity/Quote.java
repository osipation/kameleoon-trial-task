package com.osipaton.kameleoontrialtask.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "quote")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy="quote")
    private Set<Vote> votes;

    @Column(nullable = false)
    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
