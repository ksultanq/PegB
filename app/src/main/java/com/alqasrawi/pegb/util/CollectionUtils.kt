package com.alqasrawi.pegb.util

object CollectionUtils {

    fun isNullOrEmpty(collection: Collection<*>?): Boolean {
        return collection == null || collection.isEmpty()
    }
}