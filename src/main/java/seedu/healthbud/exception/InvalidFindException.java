package seedu.healthbud.exception;

public class InvalidFindException extends Exception {
    public InvalidFindException() {
        super("Invalid find command - find <meal|workout|water|pb> <keyword>");
    }
}
