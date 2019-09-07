package removeUserWindow.view_model

import adminWindow.view_model.UserModel
import org.uqbar.commons.model.annotations.Observable
import wallet.User

@Observable
class RemoveUserModel(val user: UserModel) {

    val fullName = user.fullName
}
