package com.michaeldsmithjr.bpsimulation.screener

import com.michaeldsmithjr.bpsimulation.domain.Domain
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(schema = "screener", name = "question_to_domain")
class ScreenerQuestionToDomain(
    @EmbeddedId
    val id: ScreenerQuestionToDomainId,
    val domain: Domain,
) {
    @Embeddable
    class ScreenerQuestionToDomainId(
        @Column(name = "screener_id")
        val screenerId: String,

        @Column(name = "question_id")
        val questionId: String,
    ): Serializable {

    }
}
