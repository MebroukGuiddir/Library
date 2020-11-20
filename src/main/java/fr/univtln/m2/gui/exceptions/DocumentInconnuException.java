package fr.univtln.m2.gui.exceptions;

public class DocumentInconnuException extends Exception {
    public String documentID;

    public DocumentInconnuException(String documentID) {
        super("Document " + documentID + " inconnu.");
        this.documentID = documentID;
    }
}