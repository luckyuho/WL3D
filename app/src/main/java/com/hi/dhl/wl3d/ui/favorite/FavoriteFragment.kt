package com.hi.dhl.wl3d.ui.favorite

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.hi.dhl.jdatabinding.DataBindingFragment
import com.hi.dhl.wl3d.R
import com.hi.dhl.wl3d.databinding.FragmentBrowserBinding
import com.hi.dhl.wl3d.databinding.FragmentFavoriteBinding
import com.hi.dhl.wl3d.ui.main.MainViewModel
import com.hi.dhl.wl3d.ui.main.PokemonAdapter
import com.hi.dhl.wl3d.ui.main.footer.FooterAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collectLatest

@FlowPreview
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class FavoriteFragment : DataBindingFragment(R.layout.fragment_favorite) {

//    private val mBinding: FragmentFavoriteBinding by binding()
//    //    private val mViewModel: MainViewModel by viewModels()
//    private val mViewModel: MainViewModel by viewModels()
//    private val mPokemonAdapter by lazy { PokemonAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//    private val mBinding: FragmentDetailsBinding by binding()
//    private val mViewModel: DetailViewModel by activityViewModels()
//    private lateinit var mPokemonModel: PokemonItemModel
//    //    private lateinit var mPokemonInfoModel: PokemonInfoModel
//    val mAlbumAdapter: AlbumAdapter by lazy { AlbumAdapter() }


//            mBinding.apply {
//                recyleView.adapter = mPokemonAdapter.withLoadStateFooter(FooterAdapter(mPokemonAdapter))
//                mainViewModel = mViewModel
//                lifecycleOwner = this@FavoriteFragment
//            }
//
//            /**
//             * 分为 数据库 和 网络搜索
//             * 可以运行注释掉的代码，文章链接：https://juejin.cn/post/6854573220457086990
//             */
//            mBinding.layoutHeader.searchView.addTextChangedListener {
//                val result = it.toString()
//                mViewModel.queryParameterForDb(result) // 搜索数据库
////                mViewModel.queryParameterForNetWork(result) // 网络搜索
//            }
//
//            mViewModel.postOfData().observe(viewLifecycleOwner, Observer {
//                mPokemonAdapter.submitData(lifecycle, it)
//                mBinding.swiperRefresh.isEnabled = false
//            })
//
//            lifecycleScope.launchWhenCreated {
//                mPokemonAdapter.loadStateFlow.collectLatest { state ->
//                    mBinding.swiperRefresh.isRefreshing = state.refresh is LoadState.Loading
//                }
//            }
//
//            // 数据库搜索回调监听
//            mViewModel.searchResultForDb.observe(viewLifecycleOwner, Observer {
//                mPokemonAdapter.submitData(lifecycle, it)
//            })
//
//            // 网络搜索回调监听
//            mViewModel.searchResultMockNetWork.observe(viewLifecycleOwner, Observer {
////            mPokemonAdapter.submitData(lifecycle, it)
//            })
        }

        companion object {
            private const val TAG = "MainActivity"
        }

//    }
}