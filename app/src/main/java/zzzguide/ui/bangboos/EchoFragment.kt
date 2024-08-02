package zzzguide.ui.bangboos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import zzzguide.databinding.FragmentEchoBinding
import zzzguide.models.api.bangboo.BangBoosResponseItem
import zzzguide.ui.common.BangbooListAdapter
import zzzguide.util.autoCleared
import java.util.Locale


class EchoFragment : Fragment() {

    var binding by autoCleared<FragmentEchoBinding>()
    private val viewModel by viewModel<BangbooViewModel>()
    private var echosAdapter by autoCleared<BangbooListAdapter>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = FragmentEchoBinding.inflate(
            inflater,
            container,
            false
        )
        binding = dataBinding

        binding.shimmerFrameLayoutEcho.startShimmer()
        binding.echoRecyclerView.setVisibility(View.GONE)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var response = viewModel.BangboosLiveData
        binding.echoRecyclerView.layoutManager = LinearLayoutManager(requireActivity())

        binding.searchEchoView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
        viewModel.viewModelScope.launch {
            initRecyclerView()
            delay(500)
            binding.shimmerFrameLayoutEcho.setVisibility(View.GONE)
            binding.echoRecyclerView.setVisibility(View.VISIBLE)
        }
    }

    private fun filterList(query: String?) {
        if (query != null) {
            viewModel.BangboosLiveData.observe(viewLifecycleOwner) { result ->

                val filteredList = ArrayList<BangBoosResponseItem>()
                for (i in result) {
                    if (i.name.lowercase(Locale.ROOT).contains(query)) {
                        filteredList.add(i)
                    }
                }

                if (filteredList.isEmpty()) {
                    Toast.makeText(requireContext(), "No Data found", Toast.LENGTH_SHORT).show()
                } else {
                    echosAdapter.setFilteredList(filteredList)
                }
            }
        }
    }

    private fun initRecyclerView() {
        viewModel.BangboosLiveData.observe(viewLifecycleOwner) { result ->
            this.echosAdapter = BangbooListAdapter(
                requireContext(),
                result
            ) { selectedItem: BangBoosResponseItem ->
                listItemClicked(selectedItem)
            }
            binding.echoRecyclerView.apply {
                adapter = echosAdapter
                itemAnimator?.changeDuration = 0
            }
        }

    }

    private fun listItemClicked(fruit: BangBoosResponseItem){
        Toast.makeText(
            requireActivity(),
            "Supplier is : ${fruit.name}",
            Toast.LENGTH_LONG
        ).show()
    }
}