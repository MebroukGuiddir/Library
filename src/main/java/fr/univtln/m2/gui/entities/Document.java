package fr.univtln.m2.gui.entities;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "TBL_DOCUMENT")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Builder(builderMethodName = "documentBuilder")
@NoArgsConstructor
@AllArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Document  implements Serializable,SimpleEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "DOCUMENT_ID")
    long id;

    // Validate ISBNs 10 or 13
    @Pattern(regexp = "^(?:ISBN(?:-1[03])?:?●)?(?=[0-9X]{10}$|(?=(?:[0-9]+[-●]){3})↵\n" +
            "[-●0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[-●]){4})[-●0-9]{17}$)↵\n" +
            "(?:97[89][-●]?)?[0-9]{1,5}[-●]?[0-9]+[-●]?[0-9]+[-●]?[0-9X]$")
    @Column(name = "DOCUMENT_ISBN")
    @NotNull
    String ISBN;

    @Column(name = "DOCUMENT_TITLE")
    @NotNull
    String title;

    @Column(name = "DOCUMENT_OVERVIEW")
    @NotNull
    String overview;

    @Column(name = "DOCUMENT_PUBLISHER")
    @NotNull
    String publisher;

    @Temporal(value=TemporalType.DATE)
    @Column(name = "DOCUMENT_PUBLICATION_DATE")
    @Past
    Date publicationDate;

    @Column(name = "DOCUMENT_LANG")
    @NotNull
    String lang;

    @ManyToMany(mappedBy="documents")
    private Set<Author> authors
            = new HashSet<Author>();
}
