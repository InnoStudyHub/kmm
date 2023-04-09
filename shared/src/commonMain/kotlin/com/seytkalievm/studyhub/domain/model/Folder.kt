package com.seytkalievm.studyhub.domain.model

data class Folder(
    val id: Int,
    val name: String
) {

    companion object {
        fun fromJson(json: Map<String, Any?>): Folder {
            return Folder(json["folder_id"] as Int, json["folder_name"] as String)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Folder) {
            return false
        }
        return this.id == other.id
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        return result
    }
}