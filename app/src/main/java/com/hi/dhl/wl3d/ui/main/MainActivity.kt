package com.hi.dhl.wl3d.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.paging.LoadState
import com.hi.dhl.jdatabinding.binding
import com.hi.dhl.wl3d.R
import com.hi.dhl.wl3d.databinding.ActivityMainBinding
import com.hi.dhl.wl3d.ui.main.footer.FooterAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collectLatest

@FlowPreview
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//    private val mBinding: ActivityMainBinding by binding()
//    private val mViewModel: MainViewModel by viewModels()
//    private val mPokemonAdapter by lazy { PokemonAdapter() }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_movie, R.id.nav_favorite
        ).build()
//        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.apply {
            navBottom.setupWithNavController(navController)
        }

//    }


//        mBinding.apply {
//            recyleView.adapter = mPokemonAdapter.withLoadStateFooter(FooterAdapter(mPokemonAdapter))
//            mainViewModel = mViewModel
//            lifecycleOwner = this@MainActivity
//        }
//
//        /**
//         * 分为 数据库 和 网络搜索
//         * 可以运行注释掉的代码，文章链接：https://juejin.cn/post/6854573220457086990
//         */
//        mBinding.layoutHeader.searchView.addTextChangedListener {
//            val result = it.toString()
//            mViewModel.queryParameterForDb(result) // 搜索数据库
////                mViewModel.queryParameterForNetWork(result) // 网络搜索
//        }
//
//        mViewModel.postOfData().observe(this, Observer {
//            mPokemonAdapter.submitData(lifecycle, it)
//            mBinding.swiperRefresh.isEnabled = false
//        })
//
//        lifecycleScope.launchWhenCreated {
//            mPokemonAdapter.loadStateFlow.collectLatest { state ->
//                mBinding.swiperRefresh.isRefreshing = state.refresh is LoadState.Loading
//            }
//        }
//
//        // 数据库搜索回调监听
//        mViewModel.searchResultForDb.observe(this, Observer {
//            mPokemonAdapter.submitData(lifecycle, it)
//        })
//
//        // 网络搜索回调监听
//        mViewModel.searchResultMockNetWork.observe(this, Observer {
////            mPokemonAdapter.submitData(lifecycle, it)
//        })
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    /**
     *  callbackFlow 提供了一个简单的回调 Api，并且在关闭的时候，移除注册监听
     *  在很多场景都可以使用，例如定位 locatoinManager#requestSingleUpdate 在 awaitClose 移除掉监听
     */
//    fun AppCompatEditText.addTextChangedListenerFlow(): Flow<String> = callbackFlow {
//        val watch = addTextChangedListener {
//            sendBlocking(it.toString().trim())
//        }
//        addTextChangedListener(watch)
////        awaitClose { removeTextChangedListener(watch) }
//    }
}