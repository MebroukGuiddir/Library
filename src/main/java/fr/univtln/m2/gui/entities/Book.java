package fr.univtln.m2.gui.entities;

import lombok.*;
import lombok.extern.java.Log;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;


@Data
@Entity(name = "TBL_Book")
@NoArgsConstructor
@Log
@ToString(callSuper = true)
public class Book extends Document {

    @NotNull
    BookCategory category;
    @Builder(builderMethodName = "bookBuilder")
    public Book(long id, String ISBN, String title, String overview , String publisher, Date publicationDate, String lang, Set authors  ) {
        super(id,ISBN,title,overview,publisher,publicationDate,lang,authors);

    }

    public enum BookCategory {
        ARTS, CUISINE, GASTRONOMIE, ÉCONOMIE, DROIT, HISTOIRE, TECHNOLOGIE,
        LITTERATURE, FICTION, PHILOSOPHIE, POLITIQUE, RELIGION, VOYAGES, SCIENCE, ROMANC,
    }

}
