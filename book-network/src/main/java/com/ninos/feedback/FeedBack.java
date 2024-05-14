package com.ninos.feedback;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import com.ninos.book.Book;
import com.ninos.common.BaseEntity;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FeedBack extends BaseEntity {

    private Double note;   // 1-5 star
    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


}
