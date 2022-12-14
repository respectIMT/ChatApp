package imt.respect.chatapp8.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import imt.respect.chatapp8.databinding.ItemRvBinding
import imt.respect.chatapp8.models.User

class UserAdapter(var list:List<User>) : RecyclerView.Adapter<UserAdapter.Vh>() {
    inner class Vh(var itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(user:User, position: Int){
            itemRvBinding.tvName.text = user.displayName
            Picasso.get().load(user.imageLink).into(itemRvBinding.imageItem)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)

    }
    override fun getItemCount(): Int {
        return list.size

    }
}