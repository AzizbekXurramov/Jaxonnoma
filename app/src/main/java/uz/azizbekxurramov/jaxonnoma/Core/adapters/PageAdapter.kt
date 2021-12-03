package uz.azizbekxurramov.jaxonnoma.Core.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uz.azizbekxurramov.jaxonnoma.Fragmentslar.*

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 8
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return Fragment1()
            }
            1 -> {
                return Fragment2()
            }
            2 -> {
                return Fragment3()
            }

            3 -> {
                return Fragment4()
            }
            4 -> {
                return Fragment5()
            }
            5 -> {
                return Fragment6()
            }
            6 -> {
                return Fragment7()
            }
            7 -> {
                return Fragment8()
            }
            else -> {
                return Fragment1()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "Latest news"
            }
            1 -> {
                return "general"
            }

            2 -> {
                return "technology"
            }

            3 -> {
                return "business"
            }

            4 -> {
                return "sports"
            }

            5 -> {
                return "entertainment"
            }

            6 -> {
                return "health"
            }

            7 -> {
                return "science"
            }

        }
        return super.getPageTitle(position)
    }
}