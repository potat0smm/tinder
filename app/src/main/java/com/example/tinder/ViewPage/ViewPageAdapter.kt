package com.example.tinder.ViewPage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPageAdapter(list:ArrayList<Fragment>,fragment: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragment,lifecycle){

    private val fragmentList = list

    override fun getItemCount(): Int {
        return fragmentList.size
    }
    override fun getItemViewType(position: Int): Int {
        return SHOW_IMAGE_ON_TOP.takeIf { position % 2 ==0 }?: SHOW_iMAGE_ON_BOTTOM
    }
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
    companion object{
        const val SHOW_IMAGE_ON_TOP = 1
        const val SHOW_iMAGE_ON_BOTTOM = 2
    }
}