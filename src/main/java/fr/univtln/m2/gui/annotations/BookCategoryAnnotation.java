package fr.univtln.m2.gui.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BookCategoryAnnotation {
    MesValeurs value();

    enum MesValeurs {
        ARTS, CUISINE, GASTRONOMIE, ÉCONOMIE, DROIT, HISTOIRE, TECHNOLOGIE,
        LITTERATURE, FICTION, PHILOSOPHIE, POLITIQUE, RELIGION, VOYAGES, SCIENCE, ROMANC,
    }

}
