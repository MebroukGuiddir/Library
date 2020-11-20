package fr.univtln.m2.gui.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity(name = "TBL_AUTHOR")
@Data
@Builder(builderMethodName = "authorBuilder")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author  implements Serializable,SimpleEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    long id;

    @Column(name = "AUTHOR_BIOGRAPHY")
    @NotNull
    String biography;

    @Column(name = "AUTHOR_FIRST_NAME")
    @NotNull
    String firstName;

    @Column(name = "AUTHOR_LAST_NAME")
    @NotNull
    String lastName;

    @Column(name = "AUTHOR_BIRTH_DATE")
    @Temporal(value=TemporalType.DATE)
    @Past
    Date birthDate;

    @ManyToMany
    @JoinTable(name="DOCUMENT_AUTHOR",
            joinColumns = { @JoinColumn(name = "AUTHOR_ID") },
            inverseJoinColumns = { @JoinColumn(name = "DOCUMENT_ID") })
    private Set<Document> compositions;

}
