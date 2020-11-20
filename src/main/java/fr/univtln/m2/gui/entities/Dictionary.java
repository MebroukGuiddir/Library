package fr.univtln.m2.gui.entities;

import lombok.*;
import lombok.extern.java.Log;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;


@Data
@Entity(name = "TBL_DICTIONARY")
@NoArgsConstructor
@Log
@ToString(callSuper = true)
public class Dictionary extends Document {

    @Builder(builderMethodName = "dictionaryBuilder")
    public Dictionary(long id, String ISBN, String title, String overview , String publisher, Date publicationDate, String lang , Set authors) {
        super(id,ISBN,title,overview,publisher,publicationDate,lang,authors);

    }

}

