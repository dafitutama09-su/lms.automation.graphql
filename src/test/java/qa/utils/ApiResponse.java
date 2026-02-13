package qa.utils;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ApiResponse<T> {

    private final int statusCode;
    private final Headers headers;
    private final T body;
    private final Response rawResponse;

    public ApiResponse(int statusCode, Headers headers, T body) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
        this.rawResponse = null;
    }


    public ApiResponse(
            int statusCode,
            Headers headers,
            T body,
            Response rawResponse
    ) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
        this.rawResponse = rawResponse;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Headers getResponseHeaders() {
        return headers;
    }

    public T getResponseBody() {
        return body;
    }

    public Response getRawResponse() {
        return rawResponse;
    }
}
