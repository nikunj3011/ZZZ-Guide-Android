package zzzguide.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import zzzguide.databinding.LayoutLatestNewsItemBinding
import zzzguide.models.db.News

class LatestNewsListAdapter(
    private val itemClickListener: ((News) -> Unit)?,
    private val bookmarkClickListener: ((News) -> Unit)?
) : DataBoundListAdapter<News, LayoutLatestNewsItemBinding>(
    object : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun createBinding(parent: ViewGroup, viewType: Int): LayoutLatestNewsItemBinding {
        val binding = LayoutLatestNewsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        binding.cardView.setOnClickListener {
            binding.news?.let {
                itemClickListener?.invoke(it)
            }
        }
        binding.btnBookmark.setOnClickListener {
            binding.news?.let {
                bookmarkClickListener?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: LayoutLatestNewsItemBinding, item: News) {
        binding.news = item
    }

}