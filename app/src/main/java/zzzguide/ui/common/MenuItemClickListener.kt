package zzzguide.ui.common

interface MenuItemClickListener<T> {

    fun onClick(item: T): Boolean

}