package com.sigaCompany.dvdStore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.UNAUTHORIZED, reason = "String Un*Authorized")
public class UnauthorizedException  extends  Exception{

}
