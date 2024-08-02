package zzzguide.binding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import zzzguide.ui.character.CharacterFragment
import zzzguide.ui.bangboos.EchoFragment
import zzzguide.ui.homedata.HomeDataFragment
import zzzguide.ui.wengines.WeaponFragment

class HomeViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeDataFragment()
            1 -> CharacterFragment()
            2 -> EchoFragment()
            3 -> WeaponFragment()
            else -> CharacterFragment()
        }
    }

}