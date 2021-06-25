package com.michaeldsmithjr.bpsimulation.screener

import com.michaeldsmithjr.bpsimulation.domain.Domain
import org.springframework.stereotype.Service

@Service
class ScreenerService(
    private val screenerQuestionToDomainRepository: ScreenerQuestionToDomainRepository
) {

    /**
     * Processes a response to a screener
     * @param screenerId ID of the screener answered
     * @param response Patient's answers to the questions
     * @return Which Level 2 assessments the patient should take
     */
    fun processResponse(screenerId: String, response: ScreenerResponse): ScreenerResults {
        val scores = ScreenerScores()
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

    /**
     * Processes a specific answer based on the questions domain and increments the associated score
     * @param answer Answer being processed
     * @param domain Domain of the question
     * @param scores Current values of the scores for each domain
     */
    private fun processAnswer(answer: ScreenerAnswer, domain: Domain, scores: ScreenerScores) {
        when (domain) {
            Domain.DEPRESSION -> scores.depression += answer.value
            Domain.MANIA -> scores.mania += answer.value
            Domain.SUBSTANCE_USE -> scores.substanceUse += answer.value
            Domain.ANXIETY -> scores.anxiety += answer.value
        }
    }

    /**
     * Analyzes the patient's scores and determines the Level 2 assessments that should be taken
     * @param scores Patient's scores
     * @return List of Level 2 assessments
     */
    private fun determineLevel2Assessments(scores: ScreenerScores): List<String> {
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
