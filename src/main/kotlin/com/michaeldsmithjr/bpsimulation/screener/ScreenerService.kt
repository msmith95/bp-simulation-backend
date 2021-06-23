package com.michaeldsmithjr.bpsimulation.screener

import com.michaeldsmithjr.bpsimulation.domain.Domain
import org.springframework.stereotype.Service

@Service
class ScreenerService(
    private val screenerQuestionToDomainRepository: ScreenerQuestionToDomainRepository
) {


    fun processResponse(screenerId: String, response: ScreenerResponse): ScreenerResults {
        val scores = ScreenerScore()
        val domainMapping = screenerQuestionToDomainRepository.findAllById_ScreenerId(screenerId)
        val domainMappingByQuestionId = domainMapping.associateBy { it.id.questionId }

        response.answers.forEach {
            val mapping = domainMappingByQuestionId[it.questionId]
            if (mapping != null) {
                processAnswer(it, mapping.domain, scores)
            }
        }

        return ScreenerResults(determineLevel2Assessments(scores))
    }

    private fun processAnswer(answer: ScreenerAnswer, domain: Domain, scores: ScreenerScore) {
        when (domain) {
            Domain.DEPRESSION -> scores.depression += answer.value
            Domain.MANIA -> scores.mania += answer.value
            Domain.SUBSTANCE_USE -> scores.substanceUse += answer.value
            Domain.ANXIETY -> scores.anxiety += answer.value
        }
    }

    private fun determineLevel2Assessments(scores: ScreenerScore): List<String> {
        val assessments = mutableListOf<String>()

        if (scores.anxiety >=2 || scores.depression >= 2) {
            assessments.add("PHQ-9")
        }

        if (scores.mania >= 2) {
            assessments.add("ASRM")
        }

        if (scores.substanceUse >= 1) {
            assessments.add("ASSIST")
        }

        return assessments
    }
}
