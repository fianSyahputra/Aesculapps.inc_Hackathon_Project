package inc.aesculapps.hackathon.presentation.home_activity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.databinding.RecyclerviewitemMenushortcutBinding
import inc.aesculapps.hackathon.presentation.home_activity.utils.ShortCutMenu

class MenuShortcutAdapter(
    private val menuList: List<ShortCutMenu>
) : RecyclerView.Adapter<MenuShortcutAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: RecyclerviewitemMenushortcutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemMenushortcutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            imageView.setImageResource(menuList[position].imageSrc)
            menuNameText.text = menuList[position].name
            root.setOnClickListener {
                if (menuList[position].movingIntent != null){
                    it.context.startActivity(menuList[position].movingIntent)
                }
                else {
                    Toast.makeText(it.context,"To Be Implemented", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

}