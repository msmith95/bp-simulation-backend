package com.michaeldsmithjr.bpsimulation.screener

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.Hibernate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "screener", name = "answer_option")
data class ScreenerAnswerOption(
    @Id
    @JsonIgnore
    val id: Long,

    val title: String,

    val value: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ScreenerAnswerOption

        return id == other.id
    }

    override fun hashCode(): Int = 1755857737

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , title = $title , value = $value )"
    }
}
