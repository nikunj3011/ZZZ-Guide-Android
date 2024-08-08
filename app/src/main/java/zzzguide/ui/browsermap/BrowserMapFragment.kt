package zzzguide.ui.browsermap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import zzzguide.databinding.FragmentBrowserMapBinding


class BrowserMapFragment : Fragment() {
    private lateinit var binding: FragmentBrowserMapBinding
//    private val viewModel by viewModel<CharacterViewModel>()
//    private var characterAdapter by autoCleared<CharacterListAdapter>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = FragmentBrowserMapBinding.inflate(
            inflater,
            container,
            false
        )
//        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wuthering.gg/map"))
//        startActivity(browserIntent)
        binding = dataBinding
        binding.webViewMap.webViewClient = WebViewClient()
        binding.webViewMap.settings.javaScriptEnabled = true
//        binding.webViewMap.loadUrl("https://wuthering.gg/map")
        binding.webViewMap.loadUrl("https://act.hoyolab.com/zzz/event/e20240601-guide-c0k2vt/index.html#/")
        return binding.root
    }
}