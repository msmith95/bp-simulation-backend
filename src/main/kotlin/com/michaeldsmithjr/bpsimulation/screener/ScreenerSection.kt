package com.michaeldsmithjr.bpsimulation.screener

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.Hibernate
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(schema = "screener", name = "section")
data class ScreenerSection(
    @Id
    @JsonIgnore
    val id: Long,

    @JsonIgnore
    @Column(name = "screener_id")
    val screenerId: String,

    val type: String,

    val title: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(
        schema = "screener",
        name = "answer_option_to_section",
        joinColumns = [
            JoinColumn(name = "section_id")],
        inverseJoinColumns = [
            JoinColumn(name = "answer_id")
        ]
    )
    val answers: List<ScreenerAnswerOption>,

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(
        schema = "screener",
        name = "question_to_section",
        joinColumns = [
            JoinColumn(name = "section_id")],
        inverseJoinColumns = [
            JoinColumn(name = "question_id", referencedColumnName = "")
        ]
    )
    val questions: List<ScreenerQuestion>,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ScreenerSection

        return id == other.id
    }

    override fun hashCode(): Int = 559100733

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , screenerId = $screenerId , type = $type , title = $title )"
    }
}
