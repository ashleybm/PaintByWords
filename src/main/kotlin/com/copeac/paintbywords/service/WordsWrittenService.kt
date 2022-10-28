package com.copeac.paintbywords.service

import com.copeac.paintbywords.model.CreateWordsWritten
import com.copeac.paintbywords.model.WordsWritten
import org.springframework.stereotype.Service

@Service
class WordsWrittenService {
    fun getListWordsWrittenPerUserPerPicture(id: String, pictureId: String): List<WordsWritten> {
        TODO("Not yet implemented")
    }

    fun getUserTotalWordsWrittenPerPicture(id: String, pictureId: String): Int {
        TODO("Not yet implemented")
    }

    fun userAddWordsWritten(id: String, createWordsWritten: CreateWordsWritten): WordsWritten {
        TODO("Not yet implemented")
    }
}