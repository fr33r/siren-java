package siren;

/**
 * Identifies the possible HTTP methods.
 * @author jonfreer
 * @since 8/16/17
 */
public enum HttpMethod {

    /**
     * Represents the HTTP DELETE method.
     */
    DELETE("DELETE"),

    /**
     * Represents the HTTP GET method.
     */
    GET("GET"),

    /**
     * Represents the HTTP PATCH method.
     */
    PATCH("PATCH"),

    /**
     * Represents the HTTP POST method.
     */
    POST("POST"),

    /**
     *  Represents the HTTP PUT method.
     */
    PUT("PUT");

    private String method;

    /**
     * Constructs the enum provided the textual representation
     * of the HTTP method.
     * @param method The textual representation of the HTTP method.
     */
    HttpMethod(String method){
        this.method = method;
    }

    /**
     * Retrieves a textual representation of the HTTP method.
     * @return A textual representation of the HTTP method.
     */
    public String toString(){
        return this.method;
    }
}
