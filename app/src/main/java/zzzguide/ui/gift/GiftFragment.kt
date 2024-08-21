package zzzguide.ui.gift

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import zzzguide.R
import zzzguide.databinding.FragmentBrowserMapBinding
import zzzguide.databinding.FragmentGiftBinding

class GiftFragment : Fragment() {

    private val InterAd = "ca-app-pub-8299128249632072/4935781534"
    private var mInterstitialAd: InterstitialAd? = null
    private lateinit var binding: FragmentGiftBinding
    //    private val viewModel by viewModel<CharacterViewModel>()
//    private var characterAdapter by autoCleared<CharacterListAdapter>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(requireContext(), InterAd, adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
//                Log.d(TAG, adError?.toString())
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d(ContentValues.TAG, "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })
        val dataBinding = FragmentGiftBinding.inflate(
            inflater,
            container,
            false
        )
//        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wuthering.gg/map"))
//        startActivity(browserIntent)
        binding = dataBinding
        binding.textViewsadas.text = "ss"
        return binding.root
    }


    override fun onDestroy() {
        showAd()
        super.onDestroy()
    }

    private fun showAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(requireActivity())
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.")
        }
    }
}