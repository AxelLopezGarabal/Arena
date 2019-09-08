package administracion.view

import com.unqui_arena.Widgets
import org.uqbar.arena.kotlin.extensions.asHorizontal
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Panel

class SearchPanel : Panel {

    constructor(
            container: Panel,
            labelText: String,
            propertyName: String,
            textBoxWidth: Int) : super(container)
    {
        this with {
            asHorizontal()
            Widgets.icon(it, "searchIconPath")
            Widgets.label(it, labelText)
            Widgets.textBox(it, propertyName).setWidth(textBoxWidth)
        }
    }

}