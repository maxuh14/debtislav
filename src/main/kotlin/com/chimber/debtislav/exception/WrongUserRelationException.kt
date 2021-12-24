package com.chimber.debtislav.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class WrongUserRelationException(reason: String) : ResponseStatusException(HttpStatus.BAD_REQUEST, reason)
