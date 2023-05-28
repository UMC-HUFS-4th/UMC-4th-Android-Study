import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dev.viewpager.CircleFragment
import com.dev.viewpager.Test1Fragment
import com.dev.viewpager.Test2Fragment


class ImageAdapter(fragmentActivity: CircleFragment) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Test1Fragment()
            1 -> Test2Fragment()
            else->Test2Fragment()
        }
    }
    override fun getItemCount(): Int =2

}