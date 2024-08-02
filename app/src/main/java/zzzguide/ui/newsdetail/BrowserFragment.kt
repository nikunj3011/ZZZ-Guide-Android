package zzzguide.ui.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import zzzguide.databinding.FragmentBrowserBinding
import zzzguide.ui.common.ClickListener
import zzzguide.util.autoCleared

class BrowserFragment : Fragment() {

    var binding by autoCleared<FragmentBrowserBinding>()

    private val params by navArgs<BrowserFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = FragmentBrowserBinding.inflate(
            inflater,
            container,
            false
        )
        binding = dataBinding
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.webView.loadUrl(params.newsUrl)
        binding.backListener = object : ClickListener {
            override fun onClick() {
                findNavController().navigateUp()
            }
        }
    }

}