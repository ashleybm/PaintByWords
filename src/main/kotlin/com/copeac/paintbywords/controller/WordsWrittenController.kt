package com.copeac.paintbywords.controller

import com.copeac.paintbywords.model.CreateWordsWritten
import com.copeac.paintbywords.model.WordsWritten
import com.copeac.paintbywords.service.WordsWrittenService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("user/{id}/picture")
@RestController
class WordsWrittenController(
        val service: WordsWrittenService
) {
    @GetMapping("/{pictureId}")
    fun getListWordsWrittenPerUserPerPicture(
            @PathVariable id: String,
            @PathVariable pictureId: String
    ): List<WordsWritten> {
        return service.getListWordsWrittenPerUserPerPicture(id, pictureId)
    }

    @GetMapping("/{pictureId}/total")
    fun getUserTotalWordsWrittenPerPicture(
        @PathVariable id: String,
        @PathVariable pictureId: String
    ): Int {
        return service.getUserTotalWordsWrittenPerPicture(id, pictureId)
    }

    @PostMapping
    fun userAddWordsWritten(
        @PathVariable id: String,
        @RequestBody createWordsWritten: CreateWordsWritten
    ): WordsWritten {
        return service.userAddWordsWritten(id, createWordsWritten)
    }


}
