package com.sigaCompany.dvdStore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Account exist exception.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Account already exist")
public class AccountExistException extends Exception {
}
