
package com.bsnl.sample.pkg.feature.model

import com.bsnl.common.viewmodel.IBaseList

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/7/11
 *     desc  :
 * </pre>
 */

data class ListingResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<ListingData>
) : IBaseList {
    override fun getDataList(): List<Any>? {
        return results
    }

    override fun getTotals(): Int {
        return count
    }
}


data class ListingData(
    val name: String,
    val url: String
) {
    fun getImageUrl(): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://pokeres.bastionbot.org/images/pokemon/$index.png"
    }

    override fun toString(): String {
        return "ListingData(name='$name', url='$url')"
    }


}