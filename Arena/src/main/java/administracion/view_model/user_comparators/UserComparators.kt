package administracion.view_model.user_comparators

object UserComparators {

    val all = listOf(
        ByFirstNameComparator(),
        ByLastNameComparator(),
        ByEmailComparator(),
        ByAccountBalanceComparator()
    )

}