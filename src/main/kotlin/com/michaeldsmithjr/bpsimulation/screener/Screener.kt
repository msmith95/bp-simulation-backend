package com.michaeldsmithjr.bpsimulation.screener

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(schema = "screener", name = "screener")
data class Screener(
    @Id
    val id: String,

    val name: String,

    val disorder: String,

    @JsonProperty("full_name")
    @Column(name = "full_name")
    val fullName: String,

    @OneToOne
    @JoinColumn(name = "screener_id", referencedColumnName = "screener_id")
    val content: ScreenerContent
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Screener

        return id == other.id
    }

    override fun hashCode(): Int = 136875518

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , disorder = $disorder , fullName = $fullName , content = $content )"
    }
}
