package com.michaeldsmithjr.bpsimulation.screener

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(schema = "screener", name = "content")
data class ScreenerContent(
    @Id
    @JsonIgnore
    @Column(name = "screener_id")
    val screenerId: String,

    @OneToMany
    @JoinColumn(name = "screener_id", referencedColumnName = "screener_id")
    val sections: List<ScreenerSection>,

    @JsonProperty("display_name")
    val displayName: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ScreenerContent

        return screenerId == other.screenerId
    }

    override fun hashCode(): Int = 532850975

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(screenerId = $screenerId , displayName = $displayName )"
    }
}
