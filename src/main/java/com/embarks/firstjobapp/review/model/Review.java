package com.embarks.firstjobapp.review.model;

import com.embarks.firstjobapp.company.model.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @SequenceGenerator (name = "generator_review_sequence", sequenceName = "review_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "generator_review_sequence")
    @Column(name = "id")
    private Long id;
    private String title;
    private String description;
    private Double rating;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
}
