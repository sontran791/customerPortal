package com.java.customerportal.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Gif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gifId;
    private Long ownerId;
    private Date importDatetime;
    private Date trendingDatetime;
    private String title;
    private String fixedHeightUrl;
    private Integer fixedHeightWidth;
    private Integer fixedHeightHeight;
    private String fixedHeightSmallStillUrl;
    private Integer fixedHeightSmallStillWidth;
    private Integer fixedHeightSmallStillHeight;
    private String originalUrl;
    private Integer originalWidth;
    private Integer originalHeight;

    @OneToMany(mappedBy = "gif")
    private Set<GifTagLink> tagLinks;
}
