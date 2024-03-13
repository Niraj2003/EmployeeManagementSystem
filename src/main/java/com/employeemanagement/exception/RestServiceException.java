package com.employeemanagement.exception;

import com.employeemanagement.enums.ResponseCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestServiceException extends RuntimeException {
    private ResponseCode responseCode;

    /**
	 * @param responseCode
	 */
	public RestServiceException(ResponseCode responseCode) {
		super(responseCode.getMessage());
		this.responseCode = responseCode;
	}
}
