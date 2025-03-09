package com.ricodroid.kmp.articleapp.sources.application

import com.ricodroid.kmp.articleapp.sources.data.SourceRaw
import com.ricodroid.kmp.articleapp.sources.data.SourcesRepository

class SourcesUseCase(private val repo: SourcesRepository) {

    suspend fun getSources(): List<Source> {
        val sourcesRaw = repo.getAllSources()

        return mapSources(sourcesRaw)
    }

    private fun mapSources(sourcesRaw: List<SourceRaw>): List<Source> = sourcesRaw.map { raw ->
        Source(
            raw.id,
            raw.name,
            raw.desc,
            mapOrigin(raw),
        )
    }

    private fun mapOrigin(raw: SourceRaw) = "${raw.country} - ${raw.language}"
}