package inc.aesculapps.hackathon.presentation.other_menu_activity.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.databinding.RecyclerviewitemOthermenulistBinding
import inc.aesculapps.hackathon.presentation.home_activity.utils.ShortCutMenu

class OtherMenuActivityAdapter(
    private val menuList : List<ShortCutMenu>
) : RecyclerView.Adapter<OtherMenuActivityAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: RecyclerviewitemOthermenulistBinding) :
        RecyclerView.ViewHolder(binding.root)


    lateinit var menuClickedCallBack: (Intent?)->Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemOthermenulistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.binding
        val data = menuList[position]

        view.imageView.setImageResource(data.imageSrc)
        view.menuNameText.text = data.name

        view.root.setOnClickListener {
            menuClickedCallBack(data.movingIntent)
        }

    }

    override fun getItemCount(): Int {
        return menuList.size
    }

}