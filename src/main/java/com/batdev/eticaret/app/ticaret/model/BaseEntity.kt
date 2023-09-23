package com.batdev.eticaret.app.ticaret.model

import java.time.LocalDateTime

data class BaseEntity(val createdDate: LocalDateTime? = null,
                      val updatedDate: LocalDateTime? = null){

}


