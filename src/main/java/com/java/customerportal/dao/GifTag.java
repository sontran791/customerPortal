package com.java.customerportal.dao;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class GifTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;
    private String name;

    @OneToMany(mappedBy = "tag")
    private Set<GifTagLink> tagLinks;
}
