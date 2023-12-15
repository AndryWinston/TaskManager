package com.alexeykalitin.taskmanager.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TaskId")
    private int id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private Status status;
    @Enumerated(EnumType.STRING)
    @Column(name = "Priority")
    private Priority priority;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AuthorId")
    private Executor authorId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ExecutorId")
    private Executor executorId;
    @Column(name = "Comments")
    private String comments;

}
