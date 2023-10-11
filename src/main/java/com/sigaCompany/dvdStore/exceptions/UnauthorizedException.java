package com.sigaCompany.dvdStore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Unauthorized exception.
 */
@ResponseStatus (code = HttpStatus.UNAUTHORIZED, reason = "String Un*Authorized")
public class UnauthorizedException  extends  Exception{

}
