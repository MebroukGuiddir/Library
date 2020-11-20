package fr.univtln.m2.gui.dao;

import fr.univtln.m2.gui.entities.Document;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class DocumentDAO extends AbstractDAO<Document> {
}
