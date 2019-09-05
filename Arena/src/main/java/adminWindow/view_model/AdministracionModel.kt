package com.unqui_arena.administracion.view_model

import org.uqbar.commons.model.annotations.Observable
import loginwindow.Usuario


@Observable
class AdministracionModel(var usuarios: MutableList<Usuario>) {

    var textoParaFiltroDeBusqueda = ""

}
