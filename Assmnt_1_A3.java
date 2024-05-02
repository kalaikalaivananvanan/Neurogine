public class StoreNotFoundException extends RuntimeException {
    public StoreNotFoundException(String id) {
        super("Store with ID '" + id + "' not found.");
    }
}

public class InvalidStoreDataException extends RuntimeException {
    public InvalidStoreDataException(String message) {
        super(message);
    }
}

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}

public class MissingMandatoryParameterException extends RuntimeException {
    public MissingMandatoryParameterException(String parameterName) {
        super("Missing mandatory parameter: '" + parameterName + "'");
    }
}
