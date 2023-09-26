package com.fiap.eventSpot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @FutureOrPresent
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @NotBlank
    private String location;

    @ManyToMany(mappedBy = "attendedEvents")
    private Set<User> participants = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;




}
