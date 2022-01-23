package constructor_classes

data class LocatorsTypes constructor(
        val id: String = "id",
        val xpath: String = "xpath"
)

val locatorsTypes = LocatorsTypes()