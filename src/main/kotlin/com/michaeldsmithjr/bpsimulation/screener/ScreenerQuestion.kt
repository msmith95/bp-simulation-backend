package com.michaeldsmithjr.bpsimulation.screener

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.Hibernate
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(schema = "screener", name = "question")
data class ScreenerQuestion(
    @Id
    val questionId: String,

    val title: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ScreenerQuestion

        return questionId == other.questionId
    }

    override fun hashCode(): Int = 1636593731

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(questionId = $questionId , title = $title )"
    }

}
