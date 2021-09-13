package com.hi.dhl.wl3d.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/7/11
 *     desc  :
 * </pre>
 */

@Parcelize
data class PokemonItemModel(
    var id: String = "",
    val name: String,
    val url: String
) : Parcelable {
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<PokemonItemModel>() {
            override fun areItemsTheSame(
                oldItem: PokemonItemModel,
                newItem: PokemonItemModel
            ): Boolean =
                oldItem.url == newItem.url

            override fun areContentsTheSame(
                oldItem: PokemonItemModel,
                newItem: PokemonItemModel
            ): Boolean =
                oldItem == newItem
        }
    }
}