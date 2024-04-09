package me.approximations.springExample.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@RequiredArgsConstructor
@Getter
public class ApiError {
    private final HttpStatus status;
    private final String message;

    @JsonProperty("status")
    public int getStatus() {
        return status.value();
    }

}
