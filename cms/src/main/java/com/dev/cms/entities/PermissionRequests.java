package com.dev.cms.entities;

import com.dev.cms.enums.ApprovalStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "permission_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requested_by", nullable = false)
    private User requestedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewed_by")
    private User reviewedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status" ,nullable = false)
    private ApprovalStatus status;

    @Column(name = "comments" ,columnDefinition = "TEXT")
    private String comments;

    @Column(name = "reviewed_at") //
    private LocalDateTime reviewedAt;

    @Column(name = "requested_at", nullable = false)
    private LocalDateTime requestedAt;
}
