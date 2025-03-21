package seedu.healthbud.exception;

public class InvalidFindException extends Exception {
    public InvalidFindException() {
        super("Invalid find command (e.g. find <meal|workout|water|pb> <keyword>)");
    }
}
