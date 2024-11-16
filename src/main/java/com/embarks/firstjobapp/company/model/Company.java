package com.embarks.firstjobapp.company.model;

import com.embarks.firstjobapp.job.model.Job;
import com.embarks.firstjobapp.review.model.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "companies")

public class Company {
    @Id
    @SequenceGenerator (name = "company_generator_sequence", sequenceName = "company_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE,generator = "company_generator_sequence")
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Job> jobs;

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;
}
