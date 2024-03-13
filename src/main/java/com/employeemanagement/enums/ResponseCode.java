package com.employeemanagement.enums;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {

	EMP_NOT_FOUND(HttpStatus.BAD_REQUEST, "EMP_404", "Employee not found");

	private HttpStatus httpCode;

	private String apiResponseCode;

	private String message;

	private static final Map<String, ResponseCode> lookup = new HashMap<>();

	static {
		for (ResponseCode env : ResponseCode.values()) {
			lookup.put(env.apiResponseCode, env);
		}
	}

	// This method can be used for reverse lookup purpose
	public static ResponseCode get(String apiResponseCode) {
		return lookup.get(apiResponseCode);
	}

    public ProblemDetail getProblemDetail() {
		return getProblemDetail(message);
	}

	public ProblemDetail getProblemDetail(String detail) {
		@SuppressWarnings("null")
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(httpCode, detail);
		pd.setTitle(apiResponseCode);
		return pd;
	}

}