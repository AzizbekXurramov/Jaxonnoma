package uz.azizbekxurramov.jaxonnoma.Core.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT


import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterPagerView(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager,
        BEHAVIOR_SET_USER_VISIBLE_HINT) {

var fragments:ArrayList<Fragment> = ArrayList()
var titles:ArrayList<String> = ArrayList()

fun SetFragment( frags : ArrayList<Fragment>, title:ArrayList<String>){

    fragments.addAll(frags)
    titles.addAll(title)
    notifyDataSetChanged()
}

    override fun getCount(): Int {

        if (fragments!=null){
            return fragments.size
        }
        return 0
    }


    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

}