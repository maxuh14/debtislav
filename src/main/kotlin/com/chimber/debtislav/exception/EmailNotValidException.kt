package com.chimber.debtislav.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class EmailNotValidException : ResponseStatusException(HttpStatus.BAD_REQUEST)
