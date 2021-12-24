package com.chimber.debtislav.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class UserNotFoundException(reason: String) : ResponseStatusException(HttpStatus.NOT_FOUND, reason)
