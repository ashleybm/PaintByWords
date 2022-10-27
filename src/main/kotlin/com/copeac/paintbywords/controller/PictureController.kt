package com.copeac.paintbywords.controller

import com.copeac.paintbywords.model.CreatePicture
import com.copeac.paintbywords.model.Picture
import com.copeac.paintbywords.service.PictureService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("picture")
@RestController
class PictureController(
    val service: PictureService
) {
    @GetMapping
    fun getPicture(): List<Picture> {
        return service.getPictures()
    }

    @GetMapping("/{id}")
    fun getPicture(
        @PathVariable id: String
    ): Picture {
        return service.getPicture(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPicture(
        @RequestBody createPicture: CreatePicture
    ): Picture {
        return service.createPicture(createPicture)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePicture(
        @PathVariable id: String
    ) {
       return service.deletePicture(id)
    }
}