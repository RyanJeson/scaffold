package com.bsnl.common.page.base

import com.bsnl.common.viewmodel.BaseListViewModel


/**
 * @author : LeeZhaoXing
 * @date   : 2020/9/16
 * @desc   : 懒加载列表
 */
abstract class LazyListFragment<T : BaseListViewModel> : BaseListFragment<T>() {
    private var mHasInit = false


    override fun initData() {

    }

    override fun initView() {

    }


    override fun onResume() {
        super.onResume()
        if (!mHasInit) {
            mHasInit = true
            setupListViewDelegate()
            setupLiveDataCallback()
            if(mViewModel.providerData().isNullOrEmpty()) {
                fetchData()
            }
        }
    }


    override fun onDestroyView() {
        mHasInit=false
        super.onDestroyView()
    }

}