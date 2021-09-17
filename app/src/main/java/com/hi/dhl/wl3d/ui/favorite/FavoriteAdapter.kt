package com.hi.dhl.wl3d.ui.favorite

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.paging.PagingDataAdapter
import com.hi.dhl.jdatabinding.DataBindingViewHolder
import com.hi.dhl.jdatabinding.dowithTry
import com.hi.dhl.wl3d.R
import com.hi.dhl.wl3d.databinding.RecycleItemPokemonBinding
import com.hi.dhl.wl3d.model.PokemonItemModel
import com.hi.dhl.wl3d.ui.browser.BrowserAdapter

class FavoriteAdapter(private val listener : OnItemClickListener):
    PagingDataAdapter<PokemonItemModel, FavoriteAdapter.FavoriteViewModel>(PokemonItemModel.diffCallback) {

    override fun onBindViewHolder(holder: FavoriteViewModel, position: Int) {
        dowithTry {
            val data = getItem(position)
            Log.d("showargsvindview", data.toString())
            data?.let {
                holder.bindData(data, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewModel {
        val view = inflateView(parent, R.layout.recycle_item_pokemon)
        return FavoriteViewModel(view)
    }

    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return layoutInflater.inflate(viewType, viewGroup, false)
    }

    interface OnItemClickListener {
        fun onItemClick(movie: PokemonItemModel)
    }

    inner class FavoriteViewModel(view: View) : DataBindingViewHolder<PokemonItemModel>(view) {
        private val mBinding: RecycleItemPokemonBinding by viewHolderBinding(view)

        override fun bindData(data: PokemonItemModel, position: Int) {

            mBinding.root.setOnClickListener {
                listener.onItemClick(data)
            }

            mBinding.apply {
                data.id = "#${position + 1}"
                pokemon = data
                executePendingBindings()
            }
        }

    }


}