package remove_user.view_model

import administracion.view_model.UserModel
import org.uqbar.commons.model.annotations.Observable

@Observable
class RemoveUserModel(val user: UserModel) {

    val fullName = user.fullName
}
